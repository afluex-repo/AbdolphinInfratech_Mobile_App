package com.abdolphininfratech.Activity;
import static android.content.ContentValues.TAG;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.abdolphininfratech.Adapter.PrintVisitor;
import com.abdolphininfratech.Model.PrintVisitorList.ResPrintVisitorList;
import com.abdolphininfratech.Model.PrintVisitorList.Visitorlst;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.constants.BaseActivity;
import com.abdolphininfratech.databinding.ActivityPrintVisitorListBinding;
import com.abdolphininfratech.retrofit.ApiServices;
import com.abdolphininfratech.retrofit.RetrofitClient;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrintVisitorListActivity extends BaseActivity {
    ActivityPrintVisitorListBinding binding;
    private List<Visitorlst> lstvisitors;
    private PrintVisitor adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrintVisitorListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initview();
        onclicklisner();
    }

    private void onclicklisner() {

    }

    private void initview() {
        lstvisitors = new ArrayList<>();
        adapter = new PrintVisitor(lstvisitors);
        binding.printrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.printrecyclerview.setAdapter(adapter);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("PK_VisitorId")) {
            String visitorId = intent.getStringExtra("PK_VisitorId");
            PrintData(visitorId);
        }

    }

    public void PrintData(String id ) {
        showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("PK_VisitorId",Integer.parseInt(id));
        LoggerUtil.logItem(object);
        Log.d("req datsa: ",""+object);
        ApiServices apiService = RetrofitClient.getClient("https://abdolphininfratech.com/").create(ApiServices.class);
        Call<ResPrintVisitorList> call = apiService.getprintVisitor(object);
        call.enqueue(new Callback<ResPrintVisitorList>() {
            @Override
            public void onResponse(Call<ResPrintVisitorList> call, Response<ResPrintVisitorList> response) {
                int statusCode = response.code(); // Get the HTTP status code
                Log.d(TAG, "HTTP Status Code: " + statusCode);
                if (response.isSuccessful() && response.body() != null) {
                    hideLoading();
                    ResPrintVisitorList resVisitorList = response.body();
                    LoggerUtil.logItem(resVisitorList);
                    String apiStatus = resVisitorList.getStatus();
                    String apiMessage = resVisitorList.getMessage();

                    Log.d(TAG, "API Status: " + apiStatus);
                    Log.d(TAG, "API Message: " + apiMessage);
                    lstvisitors.clear();
                    lstvisitors.addAll(resVisitorList.getVisitorlst());
                    adapter.notifyDataSetChanged();

//                    if ("success".equalsIgnoreCase(apiStatus)) {
//                        if (resVisitorList.getVisitorlst() != null) {
//                            lstvisitors.clear();
//                            lstvisitors.addAll(resVisitorList.getVisitorlst());
//                            adapter.notifyDataSetChanged();
//                        }
//                    } else {
//                        Log.e(TAG, "API Error Message: " + apiMessage);
//                    }
                } else {
                    Log.e(TAG, "Response Error: " + response.message());

                    switch (statusCode) {
                        case 404:
                            Log.e(TAG, "Error: Resource not found.");
                            break;
                        case 500:
                            Log.e(TAG, "Error: Server error.");
                            break;
                        default:
                            Log.e(TAG, "Error: Unexpected status code.");
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<ResPrintVisitorList> call, Throwable t) {
                Log.e(TAG, "Network Failure: " + t.getMessage());
            }
        });
    }

}
