package com.abdolphininfratech.Activity;
import static android.content.ContentValues.TAG;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.abdolphininfratech.Adapter.BusinessDevelopemntAdapter;
import com.abdolphininfratech.Model.GetDownLineBusinessById.LstViewBussiness;
import com.abdolphininfratech.Model.GetDownLineBusinessById.ResGetDownLineBusinessById;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.constants.BaseActivity;
import com.abdolphininfratech.databinding.ActivityPrintDownBusinessBinding;
import com.abdolphininfratech.retrofit.ApiServices;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PrintDownBusinessActivity extends BaseActivity {
ActivityPrintDownBusinessBinding binding;
    private BusinessDevelopemntAdapter adapter;
    private List<LstViewBussiness> lstViewBussinesses;
    private ApiServices apiServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityPrintDownBusinessBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://abdolphininfratech.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiServices = retrofit.create(ApiServices.class);
        initview();
        onclicklistener();
    }

    private void onclicklistener() {

    }



    private void initview() {
        lstViewBussinesses = new ArrayList<>();
        binding.gerdownRecyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter = new BusinessDevelopemntAdapter(lstViewBussinesses, getApplicationContext());
        binding.gerdownRecyclerview.setAdapter(adapter);


        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("Fk_UserId")) {
            String visitorId = intent.getStringExtra("Fk_UserId");
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