package com.abdolphininfratech.Fragment;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abdolphininfratech.Adapter.BusinessDevelopemntAdapter;
import com.abdolphininfratech.Model.GetDownLineBusinessById.LstViewBussiness;
import com.abdolphininfratech.Model.GetDownLineBusinessById.ResGetDownLineBusinessById;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.constants.BaseFragment;
import com.abdolphininfratech.databinding.FragmentBusinessDevelopmentBinding;
import com.abdolphininfratech.retrofit.ApiServices;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BusinessDevelopmentFragment extends BaseFragment {
    private FragmentBusinessDevelopmentBinding binding;
    private BusinessDevelopemntAdapter adapter;
    private List<LstViewBussiness> lstViewBussinesses;
    private ApiServices apiServices;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment using the inflater
        binding = FragmentBusinessDevelopmentBinding.inflate(inflater, container, false);

        // Initialize Retrofit and ApiServices
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://abdolphininfratech.com/") // Ensure this URL ends with a trailing slash
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiServices = retrofit.create(ApiServices.class);

        // Initialize views and set up click listeners
        initview();
        onclicklistner();

        return binding.getRoot();
    }

    private void onclicklistner() {
        // Implement any click listeners here if needed
    }

    private void initview() {
        lstViewBussinesses = new ArrayList<>();
        binding.gerdownRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new BusinessDevelopemntAdapter(lstViewBussinesses, getContext());
        binding.gerdownRecyclerview.setAdapter(adapter);

        // Retrieve data passed to the fragment
        if (getArguments() != null && getArguments().containsKey("Fk_UserId")) {
            String visitorId = getArguments().getString("Fk_UserId");
            GetBusinessData(visitorId);
        }
    }

    public void GetBusinessData(String id) {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("Fk_UserId", Integer.parseInt(id));
        LoggerUtil.logItem(object);
        Log.d("req data: ", "" + object);

        Call<ResGetDownLineBusinessById> call = apiServices.getdownBusiness(object);
        call.enqueue(new Callback<ResGetDownLineBusinessById>() {
            @Override
            public void onResponse(Call<ResGetDownLineBusinessById> call, Response<ResGetDownLineBusinessById> response) {
                if (response.isSuccessful() && response.body() != null) {
                    hideLoading();
                    ResGetDownLineBusinessById resVisitorList = response.body();
                    LoggerUtil.logItem(resVisitorList);
                    Log.d(TAG, "Data response: " + response.body());
                    lstViewBussinesses.clear();
                    if (resVisitorList.getLstViewBussiness() != null) {
                        lstViewBussinesses.addAll(resVisitorList.getLstViewBussiness());
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e(TAG, "Response Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResGetDownLineBusinessById> call, Throwable t) {
                Log.e(TAG, "Network Failure: " + t.getMessage());
            }
        });
    }
}
