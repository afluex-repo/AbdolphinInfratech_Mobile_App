package com.abdolphininfratech.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Model.responsePayoutLedger.Lstpayoutledger;
import com.abdolphininfratech.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPayoutLedger extends RecyclerView.Adapter<AdapterPayoutLedger.ViewHolder> {

    private List<Lstpayoutledger> models;
    private Context context;

    public AdapterPayoutLedger(List<Lstpayoutledger> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adopter_payout_ledger, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

viewHolder.tvTransactionDate.setText(models.get(i).getTransactionDate());
viewHolder.tvNarration.setText(models.get(i).getNarration());
viewHolder.tvCreditAmount.setText(models.get(i).getCredit());
viewHolder.tvDebit.setText(models.get(i).getDebit());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_transaction_date)
        TextView tvTransactionDate;
        @BindView(R.id.tv_narration)
        TextView tvNarration;
        @BindView(R.id.tv_credit_amount)
        TextView tvCreditAmount;
        @BindView(R.id.tv_debit)
        TextView tvDebit;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
