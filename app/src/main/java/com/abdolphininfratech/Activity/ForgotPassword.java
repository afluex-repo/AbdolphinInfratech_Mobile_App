package com.abdolphininfratech.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abdolphininfratech.Model.ResponseForgotPassword;
import com.abdolphininfratech.Model.responseLogin.ResponseLogin;
import com.abdolphininfratech.R;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.common.NetworkUtils;
import com.abdolphininfratech.constants.BaseActivity;
import com.google.gson.JsonObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPassword extends BaseActivity {

    @BindView(R.id.et_Username)
    EditText etUsername;

    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.et_phone)
    EditText etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);
        ButterKnife.bind(this);
    }


    private void getLogin() {
        showLoading();
        hideKeyboard();
        JsonObject object = new JsonObject();
        object.addProperty("LoginID",etUsername.getText().toString().trim());
        object.addProperty("Contact",etPhone.getText().toString().trim());

        LoggerUtil.logItem(object);

        Call<ResponseForgotPassword> call = apiServices.getForgotPassword(object);
        call.enqueue(new Callback<ResponseForgotPassword>() {
            @Override
            public void onResponse(Call<ResponseForgotPassword> call, Response<ResponseForgotPassword> response) {

                hideLoading();
                if (response.body().getStatus().equalsIgnoreCase("0")) {

                    goToActivityWithFinish(context, ContainerActivity.class, null);
                    showMessage(response.body().getSuccessMessage());
                } else showMessage(response.body().getErrorMessage());
            }

            @Override
            public void onFailure(Call<ResponseForgotPassword> call, Throwable t) {
                hideLoading();
            }

        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    private boolean validate() {
        if (etUsername.getText().toString().trim().length() == 0) {
            etUsername.setError("Enter Username");
            return false;
        } else if (etPhone.getText().toString().trim().length() == 0) {
            etPhone.setError("Enter Contact");
            return false;
        }
        return true;
    }


    @OnClick(R.id.btn_submit)
    public void onClick() {
        if (NetworkUtils.getConnectivityStatus(context) != 0) {
            if (validate())
                getLogin();
        } else showMessage(R.string.alert_internet);
    }
}
