package com.abdolphininfratech.Fragment;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.abdolphininfratech.Adapter.AdapterPayoutLedger;
import com.abdolphininfratech.Model.responsePayoutLedger.ResponsePayoutLedger;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.common.NetworkUtils;
import com.abdolphininfratech.common.Utils;
import com.abdolphininfratech.constants.BaseFragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.JsonObject;
import java.util.Calendar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PayoutLedger extends BaseFragment {

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
        Call<ResponsePayoutLedger> call = apiServices.getPayoutLedger(object);
        call.enqueue(new Callback<ResponsePayoutLedger>() {
            @Override
            public void onResponse(Call<ResponsePayoutLedger> call, Response<ResponsePayoutLedger> response) {
                hideLoading();
                LoggerUtil.logItem(response.body());

                   AdapterPayoutLedger adapter = new AdapterPayoutLedger(response.body().getLstpayoutledger(), getContext());
                   recyclerview1.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ResponsePayoutLedger> call, Throwable t) {
                hideLoading();
            }

        });
    }



    private void datePicker(final TextView et) {
        Calendar cal = Calendar.getInstance();
        int mYear, mMonth, mDay;

        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, (view, year, monthOfYear, dayOfMonth) -> {
            et.setText(Utils.changeDateFormat(dayOfMonth, monthOfYear, year));
        }, mYear, mMonth, mDay);
        datePickerDialog.getDatePicker().setMaxDate(cal.getTimeInMillis());
        datePickerDialog.show();
    }
}
