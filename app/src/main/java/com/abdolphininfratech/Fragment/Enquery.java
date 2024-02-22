package com.abdolphininfratech.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Activity.ContainerActivity;
import com.abdolphininfratech.Adapter.AdapterEnquiry;
import com.abdolphininfratech.Adapter.AdapterPayoutDetails;
import com.abdolphininfratech.Model.responseEnquiry.ResponseEnquriy;
import com.abdolphininfratech.Model.responseEnquryList.ResponsEnqueryList;
import com.abdolphininfratech.Model.responsePayoutDetails.ResponsePayoutDetails;
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

public class Enquery extends BaseFragment {


    @BindView(R.id.tv_Name)
    EditText tvName;
    @BindView(R.id.tv_Details)
    EditText tvDetails;
    @BindView(R.id.btn_save)
    Button btnSave;
    @BindView(R.id.recyclerview1)
    RecyclerView recyclerview1;
    private Unbinder unbinder;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.enquery, container, false);
        unbinder = ButterKnife.bind(this, view);

        recyclerview1.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview1.setLayoutManager(layoutManager);
        getDataSearch();


        return view;
    }

    public void getData() {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("AddedBy", PreferencesManager.getInstance(context).getUserId());
        object.addProperty("Name",tvName.getText().toString().trim());
        object.addProperty("Details",tvDetails.getText().toString().trim());
        LoggerUtil.logItem(object);
        Call<ResponseEnquriy> call = apiServices.getEnquiry(object);
        call.enqueue(new Callback<ResponseEnquriy>() {
            @Override
            public void onResponse(Call<ResponseEnquriy> call, Response<ResponseEnquriy> response) {
                hideLoading();
                LoggerUtil.logItem(response.body());
                    if (response.body().getSuccessMessage().equalsIgnoreCase("Enquiry saved successfully")) {
                        showMessage(response.body().getSuccessMessage());
                        goToActivity(ContainerActivity.class, null);

                    }else showMessage(response.body().getErrorMessage());

            }

            @Override
            public void onFailure(Call<ResponseEnquriy> call, Throwable t) {
                hideLoading();
            }

        });
    }

    public void getDataSearch() {
        showLoading();
        JsonObject object = new JsonObject();

        LoggerUtil.logItem(object);
        Call<ResponsEnqueryList> call = apiServices.getEnquriyList(object);
        call.enqueue(new Callback<ResponsEnqueryList>() {
            @Override
            public void onResponse(Call<ResponsEnqueryList> call, Response<ResponsEnqueryList> response) {
                hideLoading();
                LoggerUtil.logItem(response.body());


                AdapterEnquiry adapter = new AdapterEnquiry(response.body().getLstBlock1(), getContext());
                recyclerview1.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResponsEnqueryList> call, Throwable t) {
                hideLoading();
            }

        });
    }

    @OnClick(R.id.btn_save)
    public void onClick() {
        if (NetworkUtils.getConnectivityStatus(context) != 0)
           getData();
        else showMessage(R.string.alert_internet);    }
}
