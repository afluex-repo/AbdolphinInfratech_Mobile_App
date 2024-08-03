package com.abdolphininfratech.Fragment;
import static android.content.ContentValues.TAG;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.abdolphininfratech.Adapter.DownBusinessAdapter;
import com.abdolphininfratech.Model.DownlineBusinessReport.LstDownBusiness;
import com.abdolphininfratech.Model.DownlineBusinessReport.ResDownlineBusinessReport;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.constants.BaseFragment;
import com.abdolphininfratech.databinding.FragmentDownbusinessReportBinding;
import com.abdolphininfratech.retrofit.ApiServices;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DownbusinessReportFragment extends BaseFragment {
    FragmentDownbusinessReportBinding binding;
    private DownBusinessAdapter adapter;
    private List<LstDownBusiness> lstDownBusinesses;
    private ApiServices apiServices;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentDownbusinessReportBinding.inflate(getLayoutInflater());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://abdolphininfratech.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiServices = retrofit.create(ApiServices.class);

        initview();
        onclicklistener();
        return binding.getRoot();
    }

    private void onclicklistener() {

    }

    private void initview() {
        lstDownBusinesses = new ArrayList<>();
        binding.doenbusinessRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new DownBusinessAdapter(lstDownBusinesses, getContext());
        binding.doenbusinessRecyclerview.setAdapter(adapter);
        DownlineData();
    }

    public void DownlineData() {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("LoginID", PreferencesManager.getInstance(getContext()).getLoginId());
        LoggerUtil.logItem(object);
        Call<ResDownlineBusinessReport> call = apiServices.getDownBusinessReport(object);
        call.enqueue(new Callback<ResDownlineBusinessReport>() {
            @Override
            public void onResponse(Call<ResDownlineBusinessReport> call, Response<ResDownlineBusinessReport> response) {
                if (response.isSuccessful() && response.body() != null) {
                    hideLoading();
                    ResDownlineBusinessReport resVisitorList = response.body();
                    LoggerUtil.logItem(resVisitorList);
                    Log.d(TAG, "Data response: " + response.body());
                    lstDownBusinesses.clear();
                    if (resVisitorList.getLstDownBusiness() != null) {
                        lstDownBusinesses.addAll(resVisitorList.getLstDownBusiness());
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e(TAG, "Response Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<ResDownlineBusinessReport> call, Throwable t) {
                Log.e(TAG, "Network Failure: " + t.getMessage());
            }
        });
    }
}