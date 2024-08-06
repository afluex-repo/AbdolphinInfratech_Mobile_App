package com.abdolphininfratech.Fragment;
import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.abdolphininfratech.Adapter.AdvancePamentAdapter;
import com.abdolphininfratech.Model.AdvancePaymentList.LstAdvancePayment;
import com.abdolphininfratech.Model.AdvancePaymentList.ResAdvancePaymentList;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.constants.BaseFragment;
import com.abdolphininfratech.databinding.FragmentAdvancePaymentListBinding;
import com.abdolphininfratech.retrofit.ApiServices;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AdvancePaymentListFragment extends BaseFragment {
    private FragmentAdvancePaymentListBinding binding;
    private AdvancePamentAdapter adapter;
    private List<LstAdvancePayment> lstAdvancePayments;
    private ApiServices apiServices;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAdvancePaymentListBinding.inflate(inflater, container, false);

        // Initialize Retrofit and ApiServices here
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://abdolphininfratech.com/")  // Replace with your API base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiServices = retrofit.create(ApiServices.class);

        initview();
        onclickListener();
        return binding.getRoot();
    }

    private void onclickListener() {
        // Your onClickListeners here
    }

    private void initview() {
        lstAdvancePayments = new ArrayList<>();
        binding.advancepaymentRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AdvancePamentAdapter(lstAdvancePayments, getContext());
        binding.advancepaymentRecyclerview.setAdapter(adapter);
        getData();
    }

    public void getData() {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("LoginID", PreferencesManager.getInstance(getContext()).getLoginId());
        LoggerUtil.logItem(object);
        Call<ResAdvancePaymentList> call = apiServices.getAdavncePaymentList(object);
        call.enqueue(new Callback<ResAdvancePaymentList>() {
            @Override
            public void onResponse(Call<ResAdvancePaymentList> call, Response<ResAdvancePaymentList> response) {
                if (response.isSuccessful() && response.body() != null) {
                    hideLoading();
                    ResAdvancePaymentList resVisitorList = response.body();
                    LoggerUtil.logItem(resVisitorList);
                    Log.d(TAG, "Data response: " + response.body());
                    lstAdvancePayments.clear();
                    if (resVisitorList.getLstAdvancePayment() != null) {
                        lstAdvancePayments.addAll(resVisitorList.getLstAdvancePayment());
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e(TAG, "Response Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResAdvancePaymentList> call, Throwable t) {
                Log.e(TAG, "Network Failure: " + t.getMessage());
            }
        });
    }
}
