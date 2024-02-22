package com.abdolphininfratech.Fragment;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Adapter.SliderAdapter;
import com.abdolphininfratech.Model.responseDashboard.ResponseDashboard;
import com.abdolphininfratech.Model.responseNews.Lstnewsdetail;
import com.abdolphininfratech.Model.responseNews.ResponseNews;
import com.abdolphininfratech.R;
import com.abdolphininfratech.app.PreferencesManager;
import com.abdolphininfratech.common.LoggerUtil;
import com.abdolphininfratech.common.NetworkUtils;
import com.abdolphininfratech.constants.BaseFragment;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.gson.JsonObject;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends BaseFragment {

    Unbinder unbinder;

    @BindView(R.id.Total_Associates)
    TextView TotalAssociates;

    @BindView(R.id.txt_heading)
    TextView txt_heading;

    @BindView(R.id.Total_Active_Id)
    TextView TotalActiveId;


    @BindView(R.id.Self_Business)
    TextView SelfBusiness;
    @BindView(R.id.Team_Business)
    TextView TeamBusiness;
    @BindView(R.id.Total_Booking)
    TextView TotalBooking;
    @BindView(R.id.Self_Booking)
    TextView SelfBooking;
    @BindView(R.id.Team_Booking)
    TextView TeamBooking;
    @BindView(R.id.Total_Registry)
    TextView TotalRegistry;
    @BindView(R.id.Self_Registry)
    TextView SelfRegistry;
    @BindView(R.id.Team_Registry)
    TextView TeamRegistry;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.container3)
    LinearLayout container3;
    @BindView(R.id.chart1)
    PieChart chart1;
//    @BindView(R.id.et_headline)
//    TextView etHeadline;
//    @BindView(R.id.view_news)
//    TextView viewNews;

    @BindView(R.id.slider)
    SliderView sliderView;
    private int[] yValues =new int[4];
    private String[] xValues = new String[4];

    ArrayList<Lstnewsdetail> lstnewsdetails;
    //,
//
    // colors for different sections in pieChart
    public static  final int[] MY_COLORS = {
            Color.rgb(78,105,226),  Color.rgb(255,0,0), Color.rgb(219,60,55), Color.rgb(0,101,0)
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard, container, false);
        unbinder = ButterKnife.bind(this, view);
        lstnewsdetails=new ArrayList<>();


        if (NetworkUtils.getConnectivityStatus(context) != 0) {
            getData();
            getNews();
        } else showMessage(R.string.alert_internet);
        chart1.setDescription("");
        chart1.setDrawHoleEnabled(false);
        chart1.setRotationEnabled(true);
        loadList();

        chart1.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                // display msg when value selected
                if (e == null)
                    return;

                Toast.makeText(getContext(),
                        xValues[e.getXIndex()] + " is " + e.getVal() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        return view;
    }


    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    private void getData() {
        showLoading();

        Log.e("AssociateId", PreferencesManager.getInstance(context).getUserId());
        JsonObject object = new JsonObject();
        object.addProperty("AssociateID", PreferencesManager.getInstance(context).getUserId());
        LoggerUtil.logItem(object);

        Call<ResponseDashboard> call = apiServices.getDashboard(object);
        call.enqueue(new Callback<ResponseDashboard>() {
            @Override
            public void onResponse(Call<ResponseDashboard> call, Response<ResponseDashboard> response) {
                hideLoading();
                try {
                    LoggerUtil.logItem(response.body());
                    if (response.body().getStatus().equalsIgnoreCase("0")) {
                        TotalAssociates.setText(response.body().getLstassociate().get(0).getTotalAssociate());
                        TotalActiveId.setText(response.body().getLstassociate().get(0).getTotalActiveId());
                        //TotalBusiness.setText(response.body().getLstassociate().get(0).getTotalBusiness());
                        SelfBusiness.setText(response.body().getLstassociate().get(0).getSelfBusiness());
                        TotalBooking.setText(response.body().getLstassociate().get(0).getTotalBooking());
                        TeamBusiness.setText(response.body().getLstassociate().get(0).getTeamBusiness());
                        SelfBooking.setText(response.body().getLstassociate().get(0).getSelfBooking());
                        TeamBooking.setText(response.body().getLstassociate().get(0).getTeamBooking());
                        TotalRegistry.setText(response.body().getLstassociate().get(0).getTotalregistry());
                        SelfRegistry.setText(response.body().getLstassociate().get(0).getSelfRegistry());
                        TeamRegistry.setText(response.body().getLstassociate().get(0).getTeamRegistry());
                        txt_heading.setText("Hello!! "+response.body().getName());

                    } else showMessage(response.body().getErrorMessage());
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<ResponseDashboard> call, Throwable t) {
                hideLoading();
            }
        });
    }
    public void setDataForPieChart() {
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < yValues.length; i++)
            yVals1.add(new Entry(yValues[i], i));

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < xValues.length; i++)
            xVals.add(xValues[i]);

        // create pieDataSet
        PieDataSet dataSet = new PieDataSet(yVals1, "");
        dataSet.setSliceSpace(4);
        dataSet.setSelectionShift(4);

        // adding colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        // Added My Own colors
        for (int c : MY_COLORS)
            colors.add(c);


        dataSet.setColors(colors);

        //  create pie data object and set xValues and yValues and set it to the pieChart
        PieData data = new PieData(xVals, dataSet);
        //   data.setValueFormatter(new DefaultValueFormatter());
        //   data.setValueFormatter(new PercentFormatter());

        data.setValueFormatter(new MyValueFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);

        chart1.setData(data);

        // undo all highlights
        chart1.highlightValues(null);

        // refresh/update pie chart
        chart1.invalidate();

        // animate piechart
        chart1.animateXY(1400, 1400);


        // Legends to show on bottom of the graph
        Legend l = chart1.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);
    }


    public class MyValueFormatter implements ValueFormatter {

        private DecimalFormat mFormat;

        public MyValueFormatter() {
            mFormat = new DecimalFormat("###,###,##0"); // use one decimal if needed
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            // write your logic here
            return mFormat.format(value) + ""; // e.g. append a dollar-sign
        }

    }

    private void loadList() {
        //getting the progressbar
        String url = "https://abdolphininfratech.com/WebAPI/GetGraphDetailsOfPlot?LoginId="+PreferencesManager.getInstance(context).getLoginId();
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);

        progressDialog.show();
        //making the progressbar visible


        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();


                try {
                    //getting the whole json object from the response
                    JSONObject obj = new JSONObject(response);

                    //we have the array named hero inside the object
                    //so here we are getting that json array
                    JSONArray heroArray = obj.getJSONArray("lstdata");

                    //now looping through all the elements of the json array
                    for (int i = 0; i < heroArray.length(); i++) {
                        //getting the json object of the particular index inside the array
                        JSONObject heroObject = heroArray.getJSONObject(i);
                        String t = heroObject.get("Title").toString();
                        JSONArray jsonArray = heroObject.getJSONArray("lstgraphdetails");
                        for (int j = 0; j < jsonArray.length(); j++) {
                            yValues = new int[]{Integer.parseInt(jsonArray.getJSONObject(0).get("Total").toString()),
                                    Integer.parseInt(jsonArray.getJSONObject(1).get("Total").toString()),
                                    Integer.parseInt(jsonArray.getJSONObject(2).get("Total").toString()), Integer.parseInt(jsonArray.getJSONObject(3).get("Total").toString())};
                            xValues = new String[]{jsonArray.getJSONObject(0).get("Status").toString(),
                                    jsonArray.getJSONObject(1).get("Status").toString(),
                                    jsonArray.getJSONObject(2).get("Status").toString()
                                    , jsonArray.getJSONObject(3).get("Status").toString()};

                        }
                        setDataForPieChart();
                    }

                    //creating custom adapter object
                          /*  ListViewAdapter adapter = new ListViewAdapter(heroList, getApplicationContext());

                            //adding the adapter to listview
                            listView.setAdapter(adapter);*/

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        } );
        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        //adding the string request to request queue
        requestQueue.add(stringRequest);
    }
    private void getNews() {
      //  showLoading();
        JsonObject object = new JsonObject();
        object.addProperty("AssociateID", PreferencesManager.getInstance(context).getUserId());
        LoggerUtil.logItem(object);

        Call<ResponseNews> call = apiServices.getNews(object);
//        lstnewsdetails=new ArrayList<>();
        call.enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                //hideLoading();
                try {
                    LoggerUtil.logItem(response.body());
                    if (response.body().getStatus().equalsIgnoreCase("0")) {

//                        etHeadline.setText(response.body().getLstnewsdetail().get(0).getNewsHeading());
                        lstnewsdetails=new ArrayList<>(response.body().getLstnewsdetail());
                        SliderAdapter sliderAdapter=new SliderAdapter(getActivity(),lstnewsdetails);
                        sliderView.setSliderAdapter(sliderAdapter);


                    } else showMessage(response.body().getErrorMessage());
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {
                //hideLoading();
            }
        });
    }
}
