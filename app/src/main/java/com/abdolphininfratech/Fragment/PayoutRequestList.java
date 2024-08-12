package com.abdolphininfratech.Fragment;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.abdolphininfratech.Adapter.AdapterPayoutRequestList;
import com.abdolphininfratech.Model.responsePayoutRequestList.ResponsePayoutRequestList;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.common.NetworkUtils;
import com.abdolphininfratech.common.Utils;
import com.abdolphininfratech.constants.BaseFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.JsonObject;
import java.util.Calendar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PayoutRequestList extends BaseFragment {
    @BindView(R.id.tv_from_date)
    EditText tvFromDate;
    @BindView(R.id.tv_to_date)
    EditText tvToDate;
    @BindView(R.id.btn_search)
    ImageView btnSearch;
    private Unbinder unbinder;
    @BindView(R.id.recyclerview1)
    RecyclerView recyclerview1;
    BottomSheetDialog searchDialog;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payout_ledger, container, false);
        unbinder = ButterKnife.bind(this, view);

        recyclerview1.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview1.setLayoutManager(layoutManager);

        if (NetworkUtils.getConnectivityStatus(context) != 0)
            getData();
        else showMessage(R.string.alert_internet);

        return view;
    }

    public void getData() {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("LoginId", PreferencesManager.getInstance(context).getLoginId());
        LoggerUtil.logItem(object);
        Call<ResponsePayoutRequestList> call = apiServices.getPayoutRequestReportList(object);
        call.enqueue(new Callback<ResponsePayoutRequestList>() {
            @Override
            public void onResponse(Call<ResponsePayoutRequestList> call, Response<ResponsePayoutRequestList> response) {
                hideLoading();
                LoggerUtil.logItem(response.body());
                if (response.body().getMessage().equalsIgnoreCase("Record Found !")) {
                    AdapterPayoutRequestList adapter = new AdapterPayoutRequestList(response.body().getLstpayout(), getContext());
                    recyclerview1.setAdapter(adapter);
                } else showMessage(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ResponsePayoutRequestList> call, Throwable t) {
                hideLoading();
            }

        });
    }


    public void getDataSearch(String startdate, String endDate, String status) {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("LoginId", PreferencesManager.getInstance(context).getLoginId());
        object.addProperty("FromDate",startdate);
        object.addProperty("ToDate",endDate);
        object.addProperty("Status",status);
        LoggerUtil.logItem(object);
        Call<ResponsePayoutRequestList> call = apiServices.getPayoutRequestReportList(object);
        call.enqueue(new Callback<ResponsePayoutRequestList>() {
            @Override
            public void onResponse(Call<ResponsePayoutRequestList> call, Response<ResponsePayoutRequestList> response) {
                hideLoading();
                LoggerUtil.logItem(response.body());
                if (response.body().getMessage().equalsIgnoreCase("Record Found !")) {
                    AdapterPayoutRequestList adapter = new AdapterPayoutRequestList(response.body().getLstpayout(), getContext());
                    recyclerview1.setAdapter(adapter);
                    recyclerview1.setVisibility(View.VISIBLE);
                } else {
                    recyclerview1.setVisibility(View.GONE);
                    showMessage(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponsePayoutRequestList> call, Throwable t) {
                hideLoading();
            }

        });
    }

    @OnClick(R.id.btn_search)
    public void onViewClicked() {
        searchhDialog();
    }

    String leg = "", status = "";

    private void searchhDialog() {
        searchDialog = new BottomSheetDialog(context);
        View sheetView = context.getLayoutInflater().inflate(R.layout.dilog_payout_request_list, null);
        searchDialog.setContentView(sheetView);
        leg = "null";
        status = "null";
        TextView tv_start_date = sheetView.findViewById(R.id.tv_start_date);
        TextView tv_end_date = sheetView.findViewById(R.id.tv_end_date);
        TextView tv_status = sheetView.findViewById(R.id.tv_status);
        Button btn_cancel = sheetView.findViewById(R.id.btn_cancel);
        Button btn_search = sheetView.findViewById(R.id.btn_search);
        btn_cancel.setOnClickListener(v -> {
            searchDialog.dismiss();
        });

        tv_start_date.setOnClickListener(v -> {
            datePicker(tv_start_date);
            tv_end_date.setText("");
        });

        tv_end_date.setOnClickListener(v -> {
            if (tv_start_date.getText().toString().equalsIgnoreCase(""))
                showMessage("Select Start Date");
            else
                datePicker(tv_end_date);
        });

        tv_status.setOnClickListener(v -> {
            PopupMenu popup_sidemenu = new PopupMenu(context, tv_status);
            popup_sidemenu.getMenuInflater().inflate(R.menu.menu_status_flter, popup_sidemenu.getMenu());
            popup_sidemenu.setOnMenuItemClickListener(item -> {
                if (item.getTitle().equals("All"))
                    status = "null";
                else if (item.getTitle().equals("Active"))
                    status = "P";
                else if (item.getTitle().equals("InActive"))
                    status = "T";
                else if (item.getTitle().equals("Blocked"))
                    status = "B";
                tv_status.setText(item.getTitle());
                return true;
            });
            popup_sidemenu.show();
        });

        btn_search.setOnClickListener(v -> {
            searchDialog.dismiss();
            getDataSearch(tv_start_date.getText().toString().trim(),
                    tv_end_date.getText().toString().trim(),
                    status);
        });

        searchDialog.setCancelable(false);
        searchDialog.setCanceledOnTouchOutside(false);
        searchDialog.show();
    }

    private void datePicker(final TextView et) {
        Calendar cal = Calendar.getInstance();
        int mYear, mMonth, mDay;

        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, (view, year, monthOfYear, dayOfMonth) -> {
            et.setText(Utils.changeDateFormat(dayOfMonth, monthOfYear, year));
        }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate(cal.getTimeInMillis());
        datePickerDialog.show();
    }
}
