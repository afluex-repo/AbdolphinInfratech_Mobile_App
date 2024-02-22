package com.abdolphininfratech.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Model.responseDownline.Lstdownline;
import com.abdolphininfratech.Model.responseUnpaidIncome.Lstunpaid;
import com.abdolphininfratech.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterUnpaidIncome extends RecyclerView.Adapter<AdapterUnpaidIncome.ViewHolder> {


    private List<Lstunpaid> models;
    private Context context;

    public AdapterUnpaidIncome(List<Lstunpaid> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_unpaid_income, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tvCloasingDate.setText(models.get(i).getFromDate());
        viewHolder.tvFromId.setText(models.get(i).getFromID());
        viewHolder.tvFromName.setText(models.get(i).getFromName());
        viewHolder.tvToId.setText(models.get(i).getToID());
        viewHolder.tvToName.setText(models.get(i).getToName());
        viewHolder.tvBusinessAmount.setText(models.get(i).getAmount());
        viewHolder.tvDifferencePercentage.setText(models.get(i).getDifferencePercentage());
        viewHolder.tvIncome.setText(models.get(i).getIncome());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_cloasing_date)
        TextView tvCloasingDate;
        @BindView(R.id.tv_from_id)
        TextView tvFromId;
        @BindView(R.id.tv_from_name)
        TextView tvFromName;
        @BindView(R.id.tv_to_id)
        TextView tvToId;
        @BindView(R.id.tv_to_name)
        TextView tvToName;
        @BindView(R.id.tv_business_amount)
        TextView tvBusinessAmount;
        @BindView(R.id.tv_difference_percentage)
        TextView tvDifferencePercentage;
        @BindView(R.id.tv_income)
        TextView tvIncome;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
