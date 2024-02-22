package com.abdolphininfratech.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Model.responseBookingDetails.Lstbooking;
import com.abdolphininfratech.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterBookingDetails extends RecyclerView.Adapter<AdapterBookingDetails.ViewHolder> {



    private List<Lstbooking> models;
    private Context context;

    public AdapterBookingDetails(List<Lstbooking> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_booking_details, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
     viewHolder.tvBranchName.setText(models.get(i).getBranchName());
     viewHolder.tvBookingNo.setText(models.get(i).getBookingNumber());
     viewHolder.tvBookingDate.setText(models.get(i).getBookingDate());
     viewHolder.tvPlotDetails.setText(models.get(i).getPlotNumber());
     viewHolder.tvPaymentPlan.setText(models.get(i).getPaymentPlanID());
     viewHolder.tvCustomerDetail.setText(models.get(i).getCustomerName()+"("+models.get(i).getCustomerLoginID()+")");
     viewHolder.tvAffiliateId.setText(models.get(i).getAssociateLoginID());
     viewHolder.tvPlotAmt.setText(models.get(i).getPlotAmount());
     viewHolder.tvPlc.setText(models.get(i).getPKPLCCharge());
     viewHolder.tvNetAmnt.setText(models.get(i).getNetPlotAmount());
     viewHolder.tvPaidAmt.setText(models.get(i).getPaidAmount());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_branch_name)
        TextView tvBranchName;
        @BindView(R.id.tv_booking_no)
        TextView tvBookingNo;
        @BindView(R.id.tv_booking_date)
        TextView tvBookingDate;
        @BindView(R.id.tv_plot_details)
        TextView tvPlotDetails;
        @BindView(R.id.tv_payment_plan)
        TextView tvPaymentPlan;
        @BindView(R.id.tv_customer_detail)
        TextView tvCustomerDetail;
        @BindView(R.id.tv_affiliate_id)
        TextView tvAffiliateId;
        @BindView(R.id.tv_plot_amt)
        TextView tvPlotAmt;
        @BindView(R.id.tv_plc)
        TextView tvPlc;
        @BindView(R.id.tv_net_amnt)
        TextView tvNetAmnt;
        @BindView(R.id.tv_paid_amt)
        TextView tvPaidAmt;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
