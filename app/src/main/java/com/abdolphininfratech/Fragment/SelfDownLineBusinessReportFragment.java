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
import com.abdolphininfratech.Adapter.SelfDownlineBusinessaDAPTER;
import com.abdolphininfratech.Model.SelfDownlineBusinessReport.LstSelfDownlineBusiness;
import com.abdolphininfratech.Model.SelfDownlineBusinessReport.ResSelfDownlineBusinessReport;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.common.Utils;
import com.abdolphininfratech.constants.BaseFragment;
import com.abdolphininfratech.databinding.FragmentSelfDownLineBusinessReportBinding;
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


public class SelfDownLineBusinessReportFragment extends BaseFragment {
    FragmentSelfDownLineBusinessReportBinding binding;
    private SelfDownlineBusinessaDAPTER adapter;
    private List<LstSelfDownlineBusiness> lstSelfDownlineBusinesses;
    BottomSheetDialog searchDialog;
    private ApiServices apiServices;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentSelfDownLineBusinessReportBinding.inflate(getLayoutInflater());
        apiServices = RetrofitClient.getClient("https://abdolphininfratech.com/").create(ApiServices.class);
       initview();
       onclicklistener();
        return binding.getRoot();

    }

    private void onclicklistener() {
        binding.btnSearch.setOnClickListener(v -> searchhDialog());
    }

    private void initview() {
        lstSelfDownlineBusinesses = new ArrayList<>();
       binding.selddownlineAdapter.setLayoutManager(new LinearLayoutManager(getContext()));
       adapter = new SelfDownlineBusinessaDAPTER(lstSelfDownlineBusinesses,getContext());
        binding.selddownlineAdapter.setAdapter(adapter);
       getData();

    }

    public void getData() {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("LoginId", PreferencesManager.getInstance(getContext()).getLoginId());//
        LoggerUtil.logItem(object);
        Call<ResSelfDownlineBusinessReport> call = apiServices.getselfdownlinebusiness(object);
        call.enqueue(new Callback<ResSelfDownlineBusinessReport>() {
            @Override
            public void onResponse(Call<ResSelfDownlineBusinessReport> call, Response<ResSelfDownlineBusinessReport> response) {
                if (response.isSuccessful() && response.body() != null) {
                    hideLoading();
                    ResSelfDownlineBusinessReport resSelfDownlineBusinessReport = response.body();
                    LoggerUtil.logItem(resSelfDownlineBusinessReport);
                    Log.d("data response:",""+response.body());
                    lstSelfDownlineBusinesses.clear();
                    if (resSelfDownlineBusinessReport.getLstSelfDownlineBusiness() != null) {
                        lstSelfDownlineBusinesses.addAll(resSelfDownlineBusinessReport.getLstSelfDownlineBusiness());
                    }
                    adapter.notifyDataSetChanged();

                } else {
                    Log.e(TAG, "Response Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResSelfDownlineBusinessReport> call, Throwable t) {
                Log.e(TAG, "Network Failure: " + t.getMessage());
            }
        });
    }



    public void getDataSearch(String startDate, String endDate, String CustomerName, String PlotNumber, String BookingNumber, String Mobile,  int downline) {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("LoginID", PreferencesManager.getInstance(getContext()).getLoginId());
        object.addProperty("SiteID", PreferencesManager.getInstance(getContext()).getSiteId());
        object.addProperty("SectorID", PreferencesManager.getInstance(getContext()).getSectorId());
        object.addProperty("BlockID", PreferencesManager.getInstance(getContext()).getBlockId());
        object.addProperty("CustomerLoginID", PreferencesManager.getInstance(getContext()).getCustomerId());
        object.addProperty("FromDate", startDate);
        object.addProperty("ToDate", endDate);
        object.addProperty("CustomerName", CustomerName);
        object.addProperty("PlotNumber", PlotNumber);
        object.addProperty("BookingNumber", BookingNumber);
        object.addProperty("Mobile", Mobile);
        object.addProperty("Downline",downline );



        LoggerUtil.logItem(object);
        Log.d("req data",""+object);

        Call<ResSelfDownlineBusinessReport> call = apiServices.getselfdownlinebusiness(object);
        call.enqueue(new Callback<ResSelfDownlineBusinessReport>() {
            @Override
            public void onResponse(Call<ResSelfDownlineBusinessReport> call, Response<ResSelfDownlineBusinessReport> response) {
                hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    LoggerUtil.logItem(response.body());
                    lstSelfDownlineBusinesses.clear();
                    if (response.body().getLstSelfDownlineBusiness() != null) {
                        lstSelfDownlineBusinesses.addAll(response.body().getLstSelfDownlineBusiness());
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e(TAG, "Response Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResSelfDownlineBusinessReport> call, Throwable t) {
                hideLoading();
                Log.e(TAG, "Network Failure: " + t.getMessage());
            }
        });
    }

    private void searchhDialog() {
        searchDialog = new BottomSheetDialog(getContext());
        View sheetView = getActivity().getLayoutInflater().inflate(R.layout.self_downline_dialog, null);
        searchDialog.setContentView(sheetView);
        TextView tv_start_date = sheetView.findViewById(R.id.tv_start_date);
        TextView tv_end_date = sheetView.findViewById(R.id.tv_end_date);
        EditText et_payout_number = sheetView.findViewById(R.id.et_payout_number);
        EditText et_CustomerName = sheetView.findViewById(R.id.et_CustomerName);
        EditText et_PlotNumber = sheetView.findViewById(R.id.et_PlotNumber);
        EditText et_BookingNumber = sheetView.findViewById(R.id.et_BookingNumber);
        EditText et_mobile = sheetView.findViewById(R.id.et_mobile);
        CheckBox downline = sheetView.findViewById(R.id.downline);
        Button btn_cancel = sheetView.findViewById(R.id.btn_cancel);
        Button btn_search = sheetView.findViewById(R.id.btn_search);
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
                    tv_end_date.getText().toString().trim(),et_CustomerName.getText().toString(),et_PlotNumber.getText().toString(),et_BookingNumber.getText().toString(),et_mobile.getText().toString(),downlineState);
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