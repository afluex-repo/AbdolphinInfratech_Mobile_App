package com.abdolphininfratech.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.abdolphininfratech.Model.ResponseUpdateProfile;
import com.abdolphininfratech.Model.ResponseViewProfile;
import com.abdolphininfratech.Model.request.RequestUpdateProfile;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.constants.BaseActivity;
import com.google.gson.JsonObject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfile extends BaseActivity {


    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
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
    EditText tvEmail;
    @BindView(R.id.tv_panNo)
    EditText tvPanNo;
    @BindView(R.id.tv_pincode)
    EditText tvPincode;
    @BindView(R.id.tv_state)
    TextView tvState;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.cardview1)
    RelativeLayout cardview1;
    @BindView(R.id.tv_account_number)
    EditText tvAccountNumber;
    @BindView(R.id.tv_bank_name)
    EditText tvBankName;
    @BindView(R.id.tv_branch_name)
    EditText tvBranchName;
    @BindView(R.id.tv_ifsc)
    EditText tvIfsc;
    @BindView(R.id.tv_adharno)
    EditText tvAdharno;
    @BindView(R.id.tv_address)
    EditText tvAddress;
    @BindView(R.id.btn_update)
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
        ButterKnife.bind(this);
        tvTitle.setText("Edit Profile");
        getData();
    }



    private void getData() {
        showLoading();
        hideKeyboard();
        JsonObject object = new JsonObject();

        LoggerUtil.logItem(object);

        Call<ResponseViewProfile> call = apiServices.getViewProfile(object);
        call.enqueue(new Callback<ResponseViewProfile>() {
            @Override
            public void onResponse(Call<ResponseViewProfile> call, Response<ResponseViewProfile> response) {
                hideLoading();
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
    private void getUpdateProfile() {
        showLoading();
        RequestUpdateProfile object = new RequestUpdateProfile();
        object.setUserID(PreferencesManager.getInstance(context).getUserId());


        object.setEmail(tvEmail.getText().toString().trim());
        object.setPanNo(tvPanNo.getText().toString().trim());
        object.setPincode(tvPincode.getText().toString().trim());
        object.setCity(tvCity.getText().toString().trim());
        object.setState(tvState.getText().toString().trim());
        object.setBankAccountNo(tvAccountNumber.getText().toString().trim());
        object.setBankName(tvBankName.getText().toString().trim());
        object.setBankBranch(tvBranchName.getText().toString().trim());
        object.setIFSCCode(tvIfsc.getText().toString().trim());



        LoggerUtil.logItem(object);

        Call<ResponseUpdateProfile> call = apiServices.getUpdateProfile(object);
        call.enqueue(new Callback<ResponseUpdateProfile>() {
            @Override
            public void onResponse(Call<ResponseUpdateProfile> call, Response<ResponseUpdateProfile> response) {
                hideLoading();

                    showMessage(response.body().getSuccessMessage());
                    onBackPressed();


            }

            @Override
            public void onFailure(Call<ResponseUpdateProfile> call, Throwable t) {
                hideLoading();
            }

        });
    }

    @OnClick({R.id.img_back, R.id.img, R.id.img_member, R.id.btn_update})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                onBackPressed();
                break;
            case R.id.img:
                break;
            case R.id.img_member:
                break;
            case R.id.btn_update:
                getUpdateProfile();
                break;
        }
    }
}
