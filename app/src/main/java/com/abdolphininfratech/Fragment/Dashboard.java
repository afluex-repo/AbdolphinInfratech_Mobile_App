package com.abdolphininfratech.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.abdolphininfratech.Activity.ContainerActivity;
import com.abdolphininfratech.Activity.UserRewardActivity;
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
    @BindView(R.id.slider)
    SliderView sliderView;
    @BindView(R.id.userReward)
    CardView userReward;
    @BindView(R.id.TDSAmount)
    TextView TDSAmount;
    @BindView(R.id.userreward)
    TextView userreward;


    private int[] yValues =new int[4];
    private String[] xValues = new String[4];
    ArrayList<Lstnewsdetail> lstnewsdetails;

    public static final int[] MY_COLORS = {
         Color.BLUE,
            Color.MAGENTA,
            Color.RED,
            Color.GREEN
    };

    private final OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {
            if (getParentFragmentManager().getBackStackEntryCount() > 0) {
                getParentFragmentManager().popBackStack();
            } else {
                Intent intent = new Intent(getActivity(), ContainerActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard, container, false);
        unbinder = ButterKnife.bind(this, view);

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), onBackPressedCallback);

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
                if (e == null)
                    return;

                Toast.makeText(getContext(),
                        xValues[e.getXIndex()] + " is " + e.getVal() + "", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected() {

            }
        });
        userReward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loadFragment(new UserReword());
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
                        SelfBusiness.setText(response.body().getLstassociate().get(0).getSelfBusiness());
                        TotalBooking.setText(response.body().getLstassociate().get(0).getTotalBooking());
                        TeamBusiness.setText(response.body().getLstassociate().get(0).getTeamBusiness());
                        SelfBooking.setText(response.body().getLstassociate().get(0).getSelfBooking());
                        TeamBooking.setText(response.body().getLstassociate().get(0).getTeamBooking());
                        TotalRegistry.setText(response.body().getLstassociate().get(0).getTotalregistry());
                        SelfRegistry.setText(response.body().getLstassociate().get(0).getSelfRegistry());
                        TeamRegistry.setText(response.body().getLstassociate().get(0).getTeamRegistry());
                        TDSAmount.setText(response.body().getLstassociate().get(0).getTotalTDS());
                        userreward.setText(response.body().getLstassociate().get(0).getUserRewards());
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
        PieData data = new PieData(xVals, dataSet);

        data.setValueFormatter(new MyValueFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);

        chart1.setData(data);
        chart1.highlightValues(null);

        chart1.invalidate();

        chart1.animateXY(1400, 1400);

        Legend l = chart1.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);


    }
    public class MyValueFormatter implements ValueFormatter {

        private DecimalFormat mFormat;

        public MyValueFormatter() {
            mFormat = new DecimalFormat("###,###,##0");
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return mFormat.format(value) + "";
        }

    }

    private void loadList() {
        //getting the progressbar
        String url = "https://abdolphininfratech.com/WebAPI/GetGraphDetailsOfPlot?LoginId="+PreferencesManager.getInstance(context).getLoginId();
        Log.d("url", ""+url);
        System.out.println(""+url);
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();

                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray heroArray = obj.getJSONArray("lstdata");
                    for (int i = 0; i < heroArray.length(); i++) {
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
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }


    private void getNews() {
        JsonObject object = new JsonObject();
        object.addProperty("AssociateID", PreferencesManager.getInstance(context).getUserId());
        LoggerUtil.logItem(object);
        Call<ResponseNews> call = apiServices.getNews(object);
        call.enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                try {
                    LoggerUtil.logItem(response.body());
                    if (response.body().getStatus().equalsIgnoreCase("0")) {
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


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }
}
