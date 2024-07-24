package com.abdolphininfratech.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.abdolphininfratech.Model.responseSummsryReport.LstSummary;
import com.abdolphininfratech.R;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;


public class AdapterSummaryReport extends RecyclerView.Adapter<AdapterSummaryReport.ViewHolder> {
    private List<LstSummary> models;
    private Context context;

    public AdapterSummaryReport(List<LstSummary> models, Context context) {
        this.models = models;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_summary_report, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tvBranchName.setText(models.get(i).getBranchName());
        viewHolder.tvBookingNumber.setText(models.get(i).getBookingNumber());
        viewHolder.tvCustomerInfo.setText(models.get(i).getCustomerName());
        viewHolder.tvPlot.setText(models.get(i).getPlotNumber());
        viewHolder.tvActualPlotAmount.setText(models.get(i).getAmount());
        viewHolder.tvNetPlotAmount.setText(models.get(i).getPlotAmount());
        viewHolder.tvBalanceAmount.setText(models.get(i).getBalance());
        viewHolder.tvPaymentDate.setText(models.get(i).getPaymentDate());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_branch_name)
        TextView tvBranchName;
        @BindView(R.id.tv_booking_number)
        TextView tvBookingNumber;
        @BindView(R.id.tv_affiliate_info)
        TextView tvAffiliateInfo;
        @BindView(R.id.tv_customer_info)
        TextView tvCustomerInfo;
        @BindView(R.id.tv_plot)
        TextView tvPlot;
        @BindView(R.id.tv_actual_plot_amount)
        TextView tvActualPlotAmount;
        @BindView(R.id.tv_net_Plot_amount)
        TextView tvNetPlotAmount;
        @BindView(R.id.tv_balance_amount)
        TextView tvBalanceAmount;
        @BindView(R.id.tv_payment_date)
        TextView tvPaymentDate;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
