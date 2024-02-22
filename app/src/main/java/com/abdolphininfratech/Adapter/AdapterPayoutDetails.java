package com.abdolphininfratech.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Model.responsePayoutDetails.Lstpayout;
import com.abdolphininfratech.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPayoutDetails extends RecyclerView.Adapter<AdapterPayoutDetails.ViewHolder> {


    private List<Lstpayout> models;
    private Context context;

    public AdapterPayoutDetails(List<Lstpayout> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_payout_details, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

      viewHolder.tvCloasingDate.setText(models.get(i).getClosingDate());
      viewHolder.tvPayoutId.setText(models.get(i).getPayOutNo());
      viewHolder.tvLoginId.setText(models.get(i).getAssociateLoginID());
      viewHolder.tvFirstName.setText(models.get(i).getFirstName());
      viewHolder.tvGrossAmount.setText(models.get(i).getGrossAmount());
      viewHolder.tvProcessing.setText(models.get(i).getProcessing());
      viewHolder.tvNetamount.setText(models.get(i).getNetAmount());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_cloasing_date)
        TextView tvCloasingDate;
        @BindView(R.id.tv_payout_id)
        TextView tvPayoutId;
        @BindView(R.id.tv_login_id)
        TextView tvLoginId;
        @BindView(R.id.tv_First_name)
        TextView tvFirstName;
        @BindView(R.id.tv_gross_amount)
        TextView tvGrossAmount;
        @BindView(R.id.tv_processing)
        TextView tvProcessing;
        @BindView(R.id.tv_netamount)
        TextView tvNetamount;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
