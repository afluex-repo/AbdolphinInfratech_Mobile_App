package com.abdolphininfratech.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Adapter.AdapterAssociateTree;
import com.abdolphininfratech.Adapter.AdapterBookingDetails;
import com.abdolphininfratech.Interface.AssociateTreeInterface;
import com.abdolphininfratech.Model.request.RequestBookingDetails;
import com.abdolphininfratech.Model.responseAssociateTree.ResponseAssociateTree;
import com.abdolphininfratech.Model.responseBookingDetails.ResponseBookingDetails;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.common.NetworkUtils;
import com.abdolphininfratech.constants.BaseFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.JsonObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AssociateTree extends BaseFragment implements AssociateTreeInterface {


    private Unbinder unbinder;

    @BindView(R.id.recyclerview1)
    RecyclerView recyclerview1;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_donline, container, false);
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
        JsonObject object=new JsonObject();
        object.addProperty("UserId",PreferencesManager.getInstance(context).getUserId());
        object.addProperty("LoginId",PreferencesManager.getInstance(context).getLoginId());

        LoggerUtil.logItem(object);
        Call<ResponseAssociateTree> call = apiServices.getAssociateTree(object);
        call.enqueue(new Callback<ResponseAssociateTree>() {
            @Override
            public void onResponse(Call<ResponseAssociateTree> call, Response<ResponseAssociateTree> response) {
                hideLoading();
                LoggerUtil.logItem(response.body());

                AdapterAssociateTree adapter = new AdapterAssociateTree(response.body().getLstdownline(), getContext(),AssociateTree.this);
                recyclerview1.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResponseAssociateTree> call, Throwable t) {
                hideLoading();
            }

        });
    }

    @Override
    public void getAssociate(String logind, String pk_userId) {
        getGoDown(pk_userId,logind);

    }

    public void getGoDown(String userid,String loginid) {
        showLoading();
        JsonObject object=new JsonObject();
        object.addProperty("AssociateID",userid);
        object.addProperty("LoginId",loginid);

        LoggerUtil.logItem(object);
        Call<ResponseAssociateTree> call = apiServices.getAssociateTree(object);
        call.enqueue(new Callback<ResponseAssociateTree>() {
            @Override
            public void onResponse(Call<ResponseAssociateTree> call, Response<ResponseAssociateTree> response) {
                hideLoading();
                LoggerUtil.logItem(response.body());

                AdapterAssociateTree adapter = new AdapterAssociateTree(response.body().getLstdownline(), getContext(),AssociateTree.this);
                recyclerview1.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResponseAssociateTree> call, Throwable t) {
                hideLoading();
            }

        });
    }

}
