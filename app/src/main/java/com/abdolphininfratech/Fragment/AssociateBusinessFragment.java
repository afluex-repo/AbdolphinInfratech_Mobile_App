package com.abdolphininfratech.Fragment;
import static android.content.ContentValues.TAG;
import android.app.DatePickerDialog;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.abdolphininfratech.Adapter.BusinessReportAdapter;
import com.abdolphininfratech.Model.BusinessReport.LstBusinessReport;
import com.abdolphininfratech.Model.BusinessReport.ResBusinessReport;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.common.Utils;
import com.abdolphininfratech.constants.BaseFragment;
import com.abdolphininfratech.databinding.FragmentAssociateBusinessBinding;
import com.abdolphininfratech.retrofit.ApiServices;
import com.abdolphininfratech.retrofit.RetrofitClient;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AssociateBusinessFragment extends BaseFragment {
    FragmentAssociateBusinessBinding binding;
    private BusinessReportAdapter adapter;
    private List<LstBusinessReport> lstBusinessReports;
    BottomSheetDialog searchDialog;
    private ApiServices apiServices;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding=FragmentAssociateBusinessBinding.inflate(getLayoutInflater());
        apiServices = RetrofitClient.getClient("https://abdolphininfratech.com/").create(ApiServices.class);
      initview();
      onclicklistener();
        return binding.getRoot();

    }

    private void onclicklistener() {
        binding.btnSearch.setOnClickListener(v -> searchhDialog());
    }

    private void initview() {
        lstBusinessReports = new ArrayList<>();
        binding.businessRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new BusinessReportAdapter(lstBusinessReports,getContext());
        binding.businessRecyclerview.setAdapter(adapter);
        getBusinessReport();

    }

    public void getBusinessReport() {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("LoginId", PreferencesManager.getInstance(getContext()).getLoginId());
        LoggerUtil.logItem(object);
        Call<ResBusinessReport> call = apiServices.getBusinessReport(object);
        call.enqueue(new Callback<ResBusinessReport>() {
            @Override
            public void onResponse(Call<ResBusinessReport> call, Response<ResBusinessReport> response) {
                if (response.isSuccessful() && response.body() != null) {
                    hideLoading();
                    ResBusinessReport resBusinessReport = response.body();
                    LoggerUtil.logItem(resBusinessReport);
                    Log.d("data response:",""+response.body());
                    lstBusinessReports.clear();
                    if (resBusinessReport.getLstBusinessReport() != null) {
                        lstBusinessReports.addAll(resBusinessReport.getLstBusinessReport());
                    }
                    adapter.notifyDataSetChanged();

                } else {
                    Log.e(TAG, "Response Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResBusinessReport> call, Throwable t) {
                Log.e(TAG, "Network Failure: " + t.getMessage());
            }
        });
    }


    public void getDataSearch(String startDate, String endDate) {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("LoginID", PreferencesManager.getInstance(getContext()).getLoginId());
        object.addProperty("FromDate", startDate);
        object.addProperty("ToDate", endDate);

        LoggerUtil.logItem(object);
        Log.d("req data",""+object);

        Call<ResBusinessReport> call = apiServices.getBusinessReport(object);
        call.enqueue(new Callback<ResBusinessReport>() {
            @Override
            public void onResponse(Call<ResBusinessReport> call, Response<ResBusinessReport> response) {
                hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    LoggerUtil.logItem(response.body());
                    lstBusinessReports.clear();
                    if (response.body().getLstBusinessReport() != null) {
                        lstBusinessReports.addAll(response.body().getLstBusinessReport());
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e(TAG, "Response Error: " + response.message());
                }
            }
            @Override
            public void onFailure(Call<ResBusinessReport> call, Throwable t) {
                hideLoading();
                Log.e(TAG, "Network Failure: " + t.getMessage());
            }
        });
    }

    private void searchhDialog() {
        searchDialog = new BottomSheetDialog(getContext());
        View sheetView = getActivity().getLayoutInflater().inflate(R.layout.visitor_dialog, null);
        searchDialog.setContentView(sheetView);
        TextView tv_start_date = sheetView.findViewById(R.id.tv_start_date);
        TextView tv_end_date = sheetView.findViewById(R.id.tv_end_date);
        EditText et_payout_number = sheetView.findViewById(R.id.et_payout_number);
        Button btn_cancel = sheetView.findViewById(R.id.btn_cancel);
        Button btn_search = sheetView.findViewById(R.id.btn_search);
        CheckBox downline = sheetView.findViewById(R.id.downline);
        btn_cancel.setOnClickListener(v -> searchDialog.dismiss());

        tv_start_date.setOnClickListener(v -> {
            datePicker(tv_start_date);
            tv_end_date.setText("");
        });

        tv_end_date.setOnClickListener(v -> {
            if (tv_start_date.getText().toString().equalsIgnoreCase("")) {
                showMessage("Select Start Date");
            } else {
                datePicker(tv_end_date);
            }
        });

        btn_search.setOnClickListener(v -> {
            searchDialog.dismiss();
            int downlineState = downline.isChecked() ? 1 : 0;
            getDataSearch(tv_start_date.getText().toString().trim(),
                    tv_end_date.getText().toString().trim());
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

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year, monthOfYear, dayOfMonth) -> {
            et.setText(Utils.changeDateFormat(dayOfMonth, monthOfYear, year));
        }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate(cal.getTimeInMillis());
        datePickerDialog.show();
    }
}