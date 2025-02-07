package com.abdolphininfratech.Fragment;
import static android.content.ContentValues.TAG;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.abdolphininfratech.Activity.ContainerActivity;
import com.abdolphininfratech.Adapter.AssociateDownlineAdapter;
import com.abdolphininfratech.Model.AssociateDownline.LstAssociateDownLine;
import com.abdolphininfratech.Model.AssociateDownline.ResponseAssociateDownline;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.common.Utils;
import com.abdolphininfratech.constants.BaseFragment;
import com.abdolphininfratech.databinding.FragmentAssociateSelfDownlineReportBinding;
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


public class AssociateSelfDownlineReportFragment extends BaseFragment {
    FragmentAssociateSelfDownlineReportBinding binding;
    private AssociateDownlineAdapter adapter;
    private List<LstAssociateDownLine> lstAssociateDownLines;
    BottomSheetDialog searchDialog;
    private ApiServices apiServices;


    private final OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {
            if (getParentFragmentManager().getBackStackEntryCount() > 0) {
                getParentFragmentManager().popBackStack();
            } else {
                Intent intent = new Intent(getActivity(), ContainerActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding= FragmentAssociateSelfDownlineReportBinding.inflate(getLayoutInflater());
        initview();
        onclicklistener();
        return binding.getRoot();

    }

    private void onclicklistener() {
      //  binding.btnSearch.setOnClickListener(v -> searchhDialog());
    }

    private void initview() {
        lstAssociateDownLines = new ArrayList<>();
        binding.associatedownlinerecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AssociateDownlineAdapter(lstAssociateDownLines,getContext());
        binding.associatedownlinerecyclerview.setAdapter(adapter);
        getData();
    }

    public void getData() {
        showLoading();
        JsonObject object = new JsonObject();
        String userId = PreferencesManager.getInstance(getContext()) != null ? PreferencesManager.getInstance(getContext()).getUserId() : "";
        String loginId = PreferencesManager.getInstance(getContext()) != null ? PreferencesManager.getInstance(getContext()).getLoginId() : "";
        object.addProperty("AssociateID", userId);
        object.addProperty("LoginId", loginId);
        Log.d("RequestObject", object.toString());
        LoggerUtil.logItem(object);
        ApiServices apiServices = RetrofitClient.getClient("https://abdolphininfratech.com/").create(ApiServices.class);
        Call<ResponseAssociateDownline> call = apiServices.getAssociatedownline(object);
        call.enqueue(new Callback<ResponseAssociateDownline>() {
            @Override
            public void onResponse(Call<ResponseAssociateDownline> call, Response<ResponseAssociateDownline> response) {
                hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    ResponseAssociateDownline responseAssociateDownline = response.body();
                    LoggerUtil.logItem(responseAssociateDownline);
                    Log.d("data response:", "" + response.body());
                    if ("0".equals(responseAssociateDownline.getStatus())) {
                        Log.d("Success", "Data fetched successfully: " + responseAssociateDownline.getMessage());
                        showSuccessMessage(responseAssociateDownline.getMessage());
                        lstAssociateDownLines.clear();
                        if (responseAssociateDownline.getLstAssociateDownLine() != null) {
                            lstAssociateDownLines.addAll(responseAssociateDownline.getLstAssociateDownLine());
                        }
                        adapter.notifyDataSetChanged();
                    } else {
                        Log.e(TAG, "Error: " + responseAssociateDownline.getMessage());
                        showError(responseAssociateDownline.getMessage());
                    }
                } else {
                    Log.e(TAG, "Response Error: " + response.message() + " | Code: " + response.code());
                    showError("Something went wrong. Please try again.");
                }
            }
            @Override
            public void onFailure(Call<ResponseAssociateDownline> call, Throwable t) {
                hideLoading();
                Log.e(TAG, "Network Failure: " + t.getMessage());
                showError("Network request failed. Please check your connection.");
            }
        });
    }


    private void showSuccessMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
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
//            getDataSearch(tv_start_date.getText().toString().trim(),
//                    tv_end_date.getText().toString().trim(),et_CustomerName.getText().toString(),et_PlotNumber.getText().toString(),et_BookingNumber.getText().toString(),et_mobile.getText().toString(),downlineState);
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