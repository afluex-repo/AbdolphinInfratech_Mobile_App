package com.abdolphininfratech.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.abdolphininfratech.Model.responseLogin.ResponseLogin;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
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

public class Login extends BaseActivity {
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.txt_login)
    TextView txtLogin;
    @BindView(R.id.et_Username)
    EditText etUsername;
    @BindView(R.id.et_Password)
    EditText etPassword;
    @BindView(R.id.tv_forgot_password)
    TextView tvForgotPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_gotoRegister)
    TextView tvGotoRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);
    }


    private void getLogin() {
        showLoading();
        hideKeyboard();
        JsonObject requestLogin = new JsonObject();
        requestLogin.addProperty("LoginId", etUsername.getText().toString().trim());
        requestLogin.addProperty("Password", etPassword.getText().toString().trim());

        LoggerUtil.logItem(requestLogin);

        Call<ResponseLogin> call = apiServices.getLogin(requestLogin);
        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {

                hideLoading();
                if (response.body().getStatus().equalsIgnoreCase("0")) {
                    PreferencesManager.getInstance(context).setUserId(response.body().getPkUserId());
                    PreferencesManager.getInstance(context).setFull_Name(response.body().getFullName());
                    PreferencesManager.getInstance(context).setUserType(response.body().getUserType());
                    PreferencesManager.getInstance(context).setProfilePic(response.body().getProfilePic());
                    PreferencesManager.getInstance(context).setLoginId(response.body().getLoginId());
                    goToActivityWithFinish(context, ContainerActivity.class, null);
                    showMessage(response.body().getSuccessMessage());
                } else {
                    Log.e("Messge242",response.body().getErrorMessage());
                    showMessage(response.body().getErrorMessage());
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
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
        } else if (etPassword.getText().toString().trim().length() == 0) {
            etPassword.setError("Enter Password");
            return false;
        }
        return true;
    }

    @OnClick({R.id.tv_forgot_password, R.id.btn_login, R.id.tv_gotoRegister})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_forgot_password:
                goToActivity(context,ForgotPassword.class,null);
                break;
            case R.id.btn_login:
                if (NetworkUtils.getConnectivityStatus(context) != 0) {
                    if (validate())
                        getLogin();
                } else showMessage(R.string.alert_internet);
                break;
            case R.id.tv_gotoRegister:
                break;
        }
    }
}
