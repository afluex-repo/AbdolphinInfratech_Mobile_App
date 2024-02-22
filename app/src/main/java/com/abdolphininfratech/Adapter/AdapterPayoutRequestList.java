package com.abdolphininfratech.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Model.responsePayoutRequestList.Lstpayout;
import com.abdolphininfratech.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPayoutRequestList extends RecyclerView.Adapter<AdapterPayoutRequestList.ViewHolder> {



    private List<Lstpayout> models;
    private Context context;

    public AdapterPayoutRequestList(List<Lstpayout> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_payout_request, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvReqLoginId.setText(models.get(i).getRequestID());
        viewHolder.tvReqFirstname.setText(models.get(i).getFirstName());
        viewHolder.tvReqRequestedDate.setText(models.get(i).getClosingDate());
        viewHolder.tvReqAmount.setText(models.get(i).getGrossAmount());
        viewHolder.tvReqStatus.setText(models.get(i).getStatus());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_req_loginId)
        TextView tvReqLoginId;
        @BindView(R.id.tv_req_firstname)
        TextView tvReqFirstname;
        @BindView(R.id.tv_req_requested_date)
        TextView tvReqRequestedDate;
        @BindView(R.id.tv_req_amount)
        TextView tvReqAmount;
        @BindView(R.id.tv_req_status)
        TextView tvReqStatus;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
