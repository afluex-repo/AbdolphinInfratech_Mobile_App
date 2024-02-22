package com.abdolphininfratech.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Model.responseLedger.Lstpayment;
import com.abdolphininfratech.Model.responsePayoutLedger.Lstpayoutledger;
import com.abdolphininfratech.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterLedger extends RecyclerView.Adapter<AdapterLedger.ViewHolder> {



    private List<Lstpayment> models;
    private Context context;

    public AdapterLedger(List<Lstpayment> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_ledger, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
     viewHolder.tvInstallmentDate.setText(models.get(i).getInstallmentDate());
     viewHolder.tvInstallmentAmount.setText(models.get(i).getInstallmentAmount());
     viewHolder.tvPaidAmount.setText(models.get(i).getPaidAmount());
     viewHolder.tvDueAmount.setText(models.get(i).getDueAmount());
     viewHolder.tvPaymrntDate.setText(models.get(i).getPaymentDate());
     viewHolder.tvPaymentMode.setText(models.get(i).getPaymentMode());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_installment_date)
        TextView tvInstallmentDate;
        @BindView(R.id.tv_installment_Amount)
        TextView tvInstallmentAmount;
        @BindView(R.id.tv_paid_amount)
        TextView tvPaidAmount;
        @BindView(R.id.tv_paymrnt_date)
        TextView tvPaymrntDate;
        @BindView(R.id.tv_due_amount)
        TextView tvDueAmount;
        @BindView(R.id.tv_payment_mode)
        TextView tvPaymentMode;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
