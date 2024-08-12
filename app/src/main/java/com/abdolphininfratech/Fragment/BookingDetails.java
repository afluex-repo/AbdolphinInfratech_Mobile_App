package com.abdolphininfratech.Fragment;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Adapter.AdapterBookingDetails;
import com.abdolphininfratech.Adapter.AdapterPayoutLedger;
import com.abdolphininfratech.Model.Block.LstBlock;
import com.abdolphininfratech.Model.Block.ResponseBlock;
import com.abdolphininfratech.Model.Sector.LstSector;
import com.abdolphininfratech.Model.Sector.ResponseSector;
import com.abdolphininfratech.Model.Site.Lstsite;
import com.abdolphininfratech.Model.Site.ResponseSite;
import com.abdolphininfratech.Model.request.RequestBookingDetails;
import com.abdolphininfratech.Model.responseBookingDetails.ResponseBookingDetails;
import com.abdolphininfratech.Model.responsePayoutLedger.ResponsePayoutLedger;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.common.NetworkUtils;
import com.abdolphininfratech.common.Utils;
import com.abdolphininfratech.constants.BaseFragment;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingDetails extends BaseFragment {
    @BindView(R.id.btn_search)
    ImageView btnSearch;
    private Unbinder unbinder;
    @BindView(R.id.recyclerview1)
    RecyclerView recyclerview1;
    BottomSheetDialog searchDialog;
    TextView tvSelectSite, tvSector, tvBlock, tvSiteType;
    private ArrayList<String> SelectSite, SelectSector, SelectBlock, SelectSiteType;
   // String PK_SectorID, PK_SiteID, PK_BlockID, PK_SiteType;
    private String selectSiteid="",selectSiteTypeid="",selectSectorid="",selectBlockid="";
    private PopupMenu sitepopupmenu,sectorMenu,blockMenu;
    private List<Lstsite> lstsites;
    private List<LstSector> lstSectors;
    private List<LstBlock> lstBlocks;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payout_ledger, container, false);
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
        RequestBookingDetails object = new RequestBookingDetails();
        object.setLoginId(PreferencesManager.getInstance(context).getLoginId());

        LoggerUtil.logItem(object);
        Call<ResponseBookingDetails> call = apiServices.getBookingDetails(object);
        call.enqueue(new Callback<ResponseBookingDetails>() {
            @Override
            public void onResponse(Call<ResponseBookingDetails> call, Response<ResponseBookingDetails> response) {
                hideLoading();
                LoggerUtil.logItem(response.body());
                if (response.body().getMessage().equalsIgnoreCase("Record Found.")) {

                    AdapterBookingDetails adapter = new AdapterBookingDetails(response.body().getLstbooking(), getContext());
                    recyclerview1.setAdapter(adapter);
                }else showMessage(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ResponseBookingDetails> call, Throwable t) {
                hideLoading();
            }

        });
    }
    public void getDataSearch(String startDate,String endDate,String bookingNo,String associateid,String customerid,String plotnumber,String siteid,String sctorid,String blockid ) {
        showLoading();
        RequestBookingDetails object = new RequestBookingDetails();
        object.setLoginId(PreferencesManager.getInstance(context).getLoginId());
        object.setFromDate(startDate);
        object.setToDate(endDate);
        object.setBookingNumber(bookingNo);
        object.setLoginId(associateid);
        object.setPlotNumber(plotnumber);
        object.setSiteID(siteid);
        object.setSectorID(sctorid);
        object.setBlockID(blockid);

        LoggerUtil.logItem(object);
        Call<ResponseBookingDetails> call = apiServices.getBookingDetails(object);
        call.enqueue(new Callback<ResponseBookingDetails>() {
            @Override
            public void onResponse(Call<ResponseBookingDetails> call, Response<ResponseBookingDetails> response) {
                hideLoading();
                LoggerUtil.logItem(response.body());

                if (response.body().getMessage().equalsIgnoreCase("Record Found.")) {
                    AdapterBookingDetails adapter = new AdapterBookingDetails(response.body().getLstbooking(), getContext());
                    recyclerview1.setAdapter(adapter);
                    recyclerview1.setVisibility(View.VISIBLE);
                }
                else  recyclerview1.setVisibility(View.GONE);
                    showMessage(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ResponseBookingDetails> call, Throwable t) {
                hideLoading();
            }

        });
    }
    @OnClick(R.id.btn_search)
    public void onViewClicked() {
        searchhDialog();
    }
    private void searchhDialog() {
        searchDialog = new BottomSheetDialog(context);
        View sheetView = context.getLayoutInflater().inflate(R.layout.dilog_booking_details, null);
        searchDialog.setContentView(sheetView);
        TextView tv_start_date = sheetView.findViewById(R.id.tv_start_date);
        TextView tv_end_date = sheetView.findViewById(R.id.tv_end_date);
         tvSelectSite=sheetView.findViewById(R.id.tv_select_site);
         tvSector=sheetView.findViewById(R.id.tv_sector);
         tvBlock=sheetView.findViewById(R.id.select_block);
        EditText etBooking_number=sheetView.findViewById(R.id.et_booking_number);
        EditText etAssociate_id=sheetView.findViewById(R.id.tv_Associate_Id);
        EditText etCustomerId=sheetView.findViewById(R.id.etCustomerId);
        EditText etPlotNumber=sheetView.findViewById(R.id.et_plot_number);
        Button btn_cancel = sheetView.findViewById(R.id.btn_cancel);
        Button btn_search = sheetView.findViewById(R.id.btn_search);
        //getPackage();
        lstsites = new ArrayList<>();
        lstSectors=new ArrayList<>();
        lstBlocks=new ArrayList<>();
        sitepopupmenu = new PopupMenu(context, tvSelectSite);
        //   siteTypeMenu = new PopupMenu(context, tvSiteType);
        sectorMenu = new PopupMenu(context, tvSector);
        blockMenu = new PopupMenu(context, tvBlock);
        //getPackage();
        getPackage();
        tvSelectSite.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sectorMenu.getMenu().clear();
            }

            @Override
            public void afterTextChanged(Editable s) {
                new Handler().postDelayed(new
                                                  Runnable() {
                                                      @Override
                                                      public void run() {
                                                          getSector();
                                                      }
                                                  },2);

            }
        });
        tvSector.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                blockMenu.getMenu().clear();
            }

            @Override
            public void afterTextChanged(Editable s) {
                new Handler().postDelayed(new
                                                  Runnable() {
                                                      @Override
                                                      public void run() {
                                                          getBlock();                                                      }
                                                  },2);

            }
        });
        tvSelectSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sitepopupmenu.setOnMenuItemClickListener(item -> {
                    int position = item.getOrder();
                    tvSelectSite.setText(lstsites.get(position).getSiteName());
                    selectSiteid=lstsites.get(position).getPKSiteID();


                    //  getSector();
                    //  packageMenu = lstPackages.get(position).getProductName();
                    return true;
                });
                sitepopupmenu.show();
            }
        });



        tvSector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sectorMenu.setOnMenuItemClickListener(item -> {
                    int position = item.getOrder();
                    tvSector.setText(lstSectors.get(position).getSectorName());
                    selectSiteid = lstSectors.get(position).getPKSectorID();

                    //  packageMenu = lstPackages.get(position).getProductName();
                    return true;
                });
                sectorMenu.show();

            }


        });

        tvBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blockMenu.setOnMenuItemClickListener(item -> {
                    int position = item.getOrder();
                    tvBlock.setText(lstBlocks.get(position).getBlockName());
                    selectBlockid=lstBlocks.get(position).getPKBlockID();
                    //  packageMenu = lstPackages.get(position).getProductName();
                    return true;
                });
                blockMenu.show();
            }
        });
        btn_cancel.setOnClickListener(v -> {
            searchDialog.dismiss();
        });

        tv_start_date.setOnClickListener(v -> {
            datePicker(tv_start_date);
            tv_end_date.setText("");
        });

        tv_end_date.setOnClickListener(v -> {
            if (tv_start_date.getText().toString().equalsIgnoreCase(""))
                showMessage("Select Start Date");
            else
                datePicker(tv_end_date);
        });



        btn_search.setOnClickListener(v -> {
            searchDialog.dismiss();
            getDataSearch(tv_start_date.getText().toString().trim(),
                    tv_end_date.getText().toString().trim(),
                    etBooking_number.getText().toString().trim(),
                    etAssociate_id.getText().toString().trim(),etPlotNumber.getText().toString().trim(),etCustomerId.getText().toString().trim()
            ,selectSiteid,selectBlockid,selectSectorid);
        });

        searchDialog.setCancelable(false);
        searchDialog.setCanceledOnTouchOutside(false);
        searchDialog.show();
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

    public void getPackage() {

        Call<ResponseSite> call = apiServices.getSite();
        call.enqueue(new Callback<ResponseSite>() {
            @Override
            public void onResponse(Call<ResponseSite> call, Response<ResponseSite> response) {

                hideLoading();
                if (response.body().getStatus().equalsIgnoreCase("0")) {

                    lstsites=response.body().getLstsite();


                    for (int i = 0; i < lstsites.size(); i++) {

                        sitepopupmenu.getMenu().add(0, 0, i,lstsites.get(i).getSiteName());
                        selectSiteid=response.body().getLstsite().get(i).getPKSiteID();



                    }

                }else
                    showMessage(response.body().getErrorMessage());

            }

            @Override
            public void onFailure(Call<ResponseSite> call, Throwable t) {
                hideLoading();

            }
        });
    }
    public void getSector() {
        JsonObject object=new JsonObject();
        object.addProperty("SiteID",selectSiteid);
        //  Toast.makeText(context, selectSiteid+"", Toast.LENGTH_SHORT).show();
        LoggerUtil.logItem(object);
        Call<ResponseSector> call = apiServices.getSector(object);
        call.enqueue(new Callback<ResponseSector>() {
            @Override
            public void onResponse(Call<ResponseSector> call, Response<ResponseSector> response) {

                hideLoading();
                if (response.body().getStatus().equalsIgnoreCase("0")) {
                    // tvPackageDollor.setText(response.body().getLstPackage().get(0).getProductName());
                    lstSectors=response.body().getLstsite();

                    // Toast.makeText(ReInvestment.this, response+"", Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < lstSectors.size(); i++) {

                        selectSectorid=response.body().getLstsite().get(i).getPKSectorID();

                        sectorMenu.getMenu().add(0, 0, i,lstSectors.get(i).getSectorName());



                        //showMessage(response.body().getStatus());
                    }
                    //showMessage(response.body().getMessage());
                }else
                    showMessage(response.body().getErrorMessage());

            }

            @Override
            public void onFailure(Call<ResponseSector> call, Throwable t) {
                hideLoading();
                // Toast.makeText(ReInvestment.this,t+ "", Toast.LENGTH_SHORT).show();
            }

        });
    }
    public void getBlock() {

        JsonObject object=new JsonObject();
        object.addProperty("SiteID",selectSiteid);
        object.addProperty("SectorID",selectSectorid);
        LoggerUtil.logItem(object);
        Call<ResponseBlock> call = apiServices.getBlock(object);
        call.enqueue(new Callback<ResponseBlock>() {
            @Override
            public void onResponse(Call<ResponseBlock> call, Response<ResponseBlock> response) {

                hideLoading();
                if (response.body().getStatus().equalsIgnoreCase("0")) {
                    // tvPackageDollor.setText(response.body().getLstPackage().get(0).getProductName());
                    lstBlocks=response.body().getLstBlock();

                    // Toast.makeText(ReInvestment.this, response+"", Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < lstBlocks.size(); i++) {
                        blockMenu.getMenu().add(0, 0, i,lstBlocks.get(i).getBlockName());
                        selectBlockid=response.body().getLstBlock().get(i).getPKBlockID();
                        //  showMessage(response.body().getStatus());
                    }
                    //showMessage(response.body().getMessage());
                }else
                    showMessage(response.body().getErrorMessage());

            }

            @Override
            public void onFailure(Call<ResponseBlock> call, Throwable t) {
                hideLoading();
                // Toast.makeText(ReInvestment.this,t+ "", Toast.LENGTH_SHORT).show();
            }

        });
    }
}
