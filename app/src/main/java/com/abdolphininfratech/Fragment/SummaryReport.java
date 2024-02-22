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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Adapter.AdapterPayoutDetails;
import com.abdolphininfratech.Adapter.AdapterPayoutLedger;
import com.abdolphininfratech.Adapter.AdapterSummaryReport;
import com.abdolphininfratech.Model.Block.LstBlock;
import com.abdolphininfratech.Model.Block.ResponseBlock;
import com.abdolphininfratech.Model.Sector.LstSector;
import com.abdolphininfratech.Model.Sector.ResponseSector;
import com.abdolphininfratech.Model.Site.Lstsite;
import com.abdolphininfratech.Model.Site.ResponseSite;
import com.abdolphininfratech.Model.SiteType.Lstsitetype;
import com.abdolphininfratech.Model.SiteType.ResponseSiteType;
import com.abdolphininfratech.Model.responsePayoutDetails.ResponsePayoutDetails;
import com.abdolphininfratech.Model.responsePayoutLedger.ResponsePayoutLedger;
import com.abdolphininfratech.Model.responseSummsryReport.ResponseSummaryReport;
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

public class SummaryReport extends BaseFragment {

    @BindView(R.id.tv_from_date)
    EditText tvFromDate;
    @BindView(R.id.tv_to_date)
    EditText tvToDate;
    @BindView(R.id.btn_search)
    ImageView btnSearch;
    private Unbinder unbinder;
    private  TextView tvSelectSite, tvSector, tvBlock, tvSiteType;
   // private ArrayList<String> SelectSite, SelectSector, SelectBlock, SelectSiteType;
    //String PK_SectorID, PK_SiteID, PK_BlockID, PK_SiteType;
    @BindView(R.id.recyclerview1)
    RecyclerView recyclerview1;
    BottomSheetDialog searchDialog;
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
        JsonObject object = new JsonObject();
        object.addProperty("AssociateID", PreferencesManager.getInstance(context).getLoginId());
        LoggerUtil.logItem(object);
        Call<ResponseSummaryReport> call = apiServices.getSummaryReport(object);
        call.enqueue(new Callback<ResponseSummaryReport>() {
            @Override
            public void onResponse(Call<ResponseSummaryReport> call, Response<ResponseSummaryReport> response) {
                hideLoading();
                LoggerUtil.logItem(response.body());
                if (response.body().getMessage().equalsIgnoreCase("Record Found !")) {
                    AdapterSummaryReport adapter = new AdapterSummaryReport(response.body().getLstSummary(), getContext());
                    recyclerview1.setAdapter(adapter);
                }
                else showMessage(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ResponseSummaryReport> call, Throwable t) {
                hideLoading();
            }

        });
    }

    public void getDataSearch(String startDate, String endDate, String siteid,String sectorid, String blockid,String isdownline,String booking_number,String plotnumber,String customername,String contact) {
        showLoading();

        JsonObject object = new JsonObject();
        object.addProperty("AssociateID", PreferencesManager.getInstance(context).getLoginId());

         object.addProperty("Downline",isdownline);
        object.addProperty("PlotNumber",plotnumber);
        //object.addProperty("AssociateID",customerid);

        object.addProperty("CustomerName",customername);
        object.addProperty("Mobile",contact);
        object.addProperty("FromDate",startDate);
                object.addProperty("ToDate",endDate);
                object.addProperty("SiteID",sectorid);
                object.addProperty("SectorID",sectorid);
               object.addProperty("BlockID",blockid);
               object.addProperty("UserId", PreferencesManager.getInstance(context).getUserId());
        LoggerUtil.logItem(object);
        Call<ResponseSummaryReport> call = apiServices.getSummaryReport(object);
        call.enqueue(new Callback<ResponseSummaryReport>() {
            @Override
            public void onResponse(Call<ResponseSummaryReport> call, Response<ResponseSummaryReport> response) {
                hideLoading();
                LoggerUtil.logItem(response.body());
                if (response.body().getMessage().equalsIgnoreCase("Record Found !")) {
                    AdapterSummaryReport adapter = new AdapterSummaryReport(response.body().getLstSummary(), getContext());
                    recyclerview1.setAdapter(adapter);
                    recyclerview1.setVisibility(View.VISIBLE);

                }
                else   recyclerview1.setVisibility(View.GONE);

                showMessage(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ResponseSummaryReport> call, Throwable t) {
                hideLoading();
            }

        });
    }


    @OnClick(R.id.btn_search)
    public void onViewClicked() {
        searchhDialog();
    }
    String isdownline="";

    private void searchhDialog() {
        searchDialog = new BottomSheetDialog(context);
        View sheetView = context.getLayoutInflater().inflate(R.layout.dilog_summary_report, null);
        searchDialog.setContentView(sheetView);
        TextView tv_start_date = sheetView.findViewById(R.id.tv_start_date);
        TextView tv_end_date = sheetView.findViewById(R.id.tv_end_date);
        tvSector = sheetView.findViewById(R.id.tv_sector);
        tvBlock = sheetView.findViewById(R.id.select_block);
        CheckBox checkBox=sheetView.findViewById(R.id.checkBox);
        EditText booking_number=sheetView.findViewById(R.id.et_booking_number);
        EditText etCustomerid=sheetView.findViewById(R.id.etCustomerId);
        EditText etPlotNumber=sheetView.findViewById(R.id.et_plot_number);
        EditText etCustomerName=sheetView.findViewById(R.id.et_customer_name);
        EditText etConatct=sheetView.findViewById(R.id.et_mobile_no);
        tvSelectSite=sheetView.findViewById(R.id.tv_select_site);
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
        //  SelectSite = new ArrayList<String>();
        //  SelectSector = new ArrayList<String>();
        // SelectBlock = new ArrayList<String>();
        // SelectSiteType=new ArrayList<String>();
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
                    selectSectorid = lstSectors.get(position).getPKSectorID();

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

      /*  tvSelectSite.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(getContext(), i+"", Toast.LENGTH_SHORT).show();
                int a = adapterView.getSelectedItemPosition();
                // Toast.makeText(context,a+ "", Toast.LENGTH_SHORT).show();
                getSelectSite1(a);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        tvSector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(getContext(), i+"", Toast.LENGTH_SHORT).show();
                int a = adapterView.getSelectedItemPosition();
                // Toast.makeText(context,a+ "", Toast.LENGTH_SHORT).show();
                getSelectSector1(a);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        tvBlock.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Toast.makeText(getContext(), i+"", Toast.LENGTH_SHORT).show();

                int a = adapterView.getSelectedItemPosition();
                //Toast.makeText(context,a+ "", Toast.LENGTH_SHORT).show();
                getSelectBlock1(a);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked())
                {
                    isdownline="1";
                }
                else
                {
                    isdownline="0";
                }

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
                    tv_end_date.getText().toString().trim(),selectSiteid,selectSectorid,selectBlockid,isdownline,booking_number.getText().toString().trim(),
                    etPlotNumber.getText().toString().trim(),etCustomerName.getText().toString().trim(),
                    etConatct.getText().toString().trim());
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
        //object.addProperty("SiteID",selectSiteid);
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
