package com.abdolphininfratech.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Adapter.AdapterUserReword;
import com.abdolphininfratech.Model.responseUserReword.ResponseUserReword;
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

public class UserReword extends BaseFragment {


    private Unbinder unbinder;

    @BindView(R.id.recyclerview1)
    RecyclerView recyclerview1;
    BottomSheetDialog searchDialog;

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
        JsonObject object = new JsonObject();
        object.addProperty("UserID", PreferencesManager.getInstance(context).getUserId());
        LoggerUtil.logItem(object);
        Call<ResponseUserReword> call = apiServices.getUserReword(object);
        call.enqueue(new Callback<ResponseUserReword>() {
            @Override
            public void onResponse(Call<ResponseUserReword> call, Response<ResponseUserReword> response) {
                hideLoading();
                LoggerUtil.logItem(response.body());
                if(response.body().getLstreward()!=null && response.body().getLstreward().size()>0){
                    AdapterUserReword adapter = new AdapterUserReword(response.body().getLstreward(), getContext());
                    recyclerview1.setAdapter(adapter);

                }else{

                }


            }

            @Override
            public void onFailure(Call<ResponseUserReword> call, Throwable t) {
                hideLoading();
            }

        });
    }


}
