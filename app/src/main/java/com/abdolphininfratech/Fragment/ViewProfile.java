package com.abdolphininfratech.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.abdolphininfratech.Activity.EditProfile;
import com.abdolphininfratech.Model.ResponseViewProfile;
import com.abdolphininfratech.Model.responseDashboard.ResponseDashboard;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.common.NetworkUtils;
import com.abdolphininfratech.constants.BaseFragment;
import com.google.gson.JsonObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewProfile extends BaseFragment {

    Unbinder unbinder;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.img_member)
    ImageView imgMember;
    @BindView(R.id.tv_branch)
    TextView tvBranch;
    @BindView(R.id.tv_Sponsor_id)
    TextView tvSponsorId;
    @BindView(R.id.tv_Designation)
    TextView tvDesignation;
    @BindView(R.id.tv_firestName)
    TextView tvFirestName;
    @BindView(R.id.tv_Contact)
    TextView tvContact;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.tv_panNo)
    TextView tvPanNo;
    @BindView(R.id.tv_pincode)
    TextView tvPincode;
    @BindView(R.id.tv_state)
    TextView tvState;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.tv_account_number)
    TextView tvAccountNumber;
    @BindView(R.id.tv_bank_name)
    TextView tvBankName;
    @BindView(R.id.tv_branch_name)
    TextView tvBranchName;
    @BindView(R.id.tv_ifsc)
    TextView tvIfsc;
    @BindView(R.id.tv_adharno)
    TextView tvAdharno;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.btn_update)
    Button btnUpdate;

//
    // colors for different sections in pieChart

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_profile, container, false);
        unbinder = ButterKnife.bind(this, view);


        if (NetworkUtils.getConnectivityStatus(context) != 0) {
            getData();
        } else showMessage(R.string.alert_internet);

        return view;
    }


    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    private void getData() {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("UserID", PreferencesManager.getInstance(context).getUserId());
        LoggerUtil.logItem(object);

        Call<ResponseViewProfile> call = apiServices.getViewProfile(object);
        call.enqueue(new Callback<ResponseViewProfile>() {
            @Override
            public void onResponse(Call<ResponseViewProfile> call, Response<ResponseViewProfile> response) {
                hideLoading();
                    LoggerUtil.logItem(response.body());
                      tvBranch.setText(response.body().getBranchName());
                      tvSponsorId.setText(response.body().getSponsorID());
                      tvDesignation.setText(response.body().getDesignationName());
                      tvFirestName.setText(response.body().getFirstName());
                      tvContact.setText(response.body().getContact());
                      tvEmail.setText(response.body().getEmail());
                      tvPanNo.setText(response.body().getPanNo());
                      tvPincode.setText(response.body().getPincode());
                      tvState.setText(response.body().getState());
                      tvCity.setText(response.body().getCity());
                      tvAccountNumber.setText(response.body().getBankAccountNo());
                      tvBankName.setText(response.body().getBankName());
                      tvBranchName.setText(response.body().getBankBranch());
                      tvIfsc.setText(response.body().getIFSCCode());
                      tvAddress.setText(response.body().getAddress());
                      tvAdharno.setText(response.body().getAdharNumber());

                }

            @Override
            public void onFailure(Call<ResponseViewProfile> call, Throwable t) {
                hideLoading();
            }
        });
    }

    @OnClick(R.id.btn_update)
    public void onClick() {
        goToActivity(EditProfile.class,null);
    }
}
