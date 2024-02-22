package com.abdolphininfratech.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.abdolphininfratech.Model.ResponsePayoutRequest;
import com.abdolphininfratech.Model.ResponseSavePayout;
import com.abdolphininfratech.Model.responsePayoutLedger.ResponsePayoutLedger;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.common.NetworkUtils;
import com.abdolphininfratech.constants.BaseFragment;
import com.google.gson.JsonObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PayoutRequest extends BaseFragment {


    @BindView(R.id.tv_amount)
    TextView tvAmount;
    @BindView(R.id.et_balance)
    EditText etBalance;
    @BindView(R.id.tvStatus)
    TextView tvStatus;
    @BindView(R.id.btn_save)
    Button btnsave;
    private Unbinder unbinder;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.payout_details, container, false);
        unbinder = ButterKnife.bind(this, view);


        if (NetworkUtils.getConnectivityStatus(context) != 0)
            getData();
        else showMessage(R.string.alert_internet);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (etBalance.getText().toString().trim().length() != 0) {
                        UpdateData();
                    }else showMessage("Enter Amount!");
                }

        });
        return view;
    }

    public void getData() {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("UserID", PreferencesManager.getInstance(context).getUserId());
        LoggerUtil.logItem(object);
        Call<ResponsePayoutRequest> call = apiServices.getPayoutRequest(object);
        call.enqueue(new Callback<ResponsePayoutRequest>() {
            @Override
            public void onResponse(Call<ResponsePayoutRequest> call, Response<ResponsePayoutRequest> response) {
                hideLoading();
                LoggerUtil.logItem(response.body());
                tvAmount.setText(response.body().getBalance());

            }

            @Override
            public void onFailure(Call<ResponsePayoutRequest> call, Throwable t) {
                hideLoading();
            }

        });
    }
    public void UpdateData() {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("UserID", PreferencesManager.getInstance(context).getUserId());
        object.addProperty("Amount",etBalance.getText().toString().trim());
        LoggerUtil.logItem(object);
        Call<ResponseSavePayout> call = apiServices.SavePayout(object);
        call.enqueue(new Callback<ResponseSavePayout>() {
            @Override
            public void onResponse(Call<ResponseSavePayout> call, Response<ResponseSavePayout> response) {
                hideLoading();

                if (response.body().getStatus().equalsIgnoreCase("1")) {
                    tvStatus.setText(response.body().getErrorMessage());
                    etBalance.getText().clear();
                }else
                {
                    etBalance.getText().clear();

                    tvStatus.setText(response.body().getSuccessMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseSavePayout> call, Throwable t) {
                hideLoading();
            }

        });
    }

}
