package com.abdolphininfratech.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import com.abdolphininfratech.Model.AdvancePaymentList.LstAdvancePayment;
import com.abdolphininfratech.R;
import java.util.List;


public class AdvancePamentAdapter extends RecyclerView.Adapter<AdvancePamentAdapter.ViewHolder> {
    private List<LstAdvancePayment> mList;
    private Context context;


    public AdvancePamentAdapter(List<LstAdvancePayment> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.advance_payment_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LstAdvancePayment lstAdvancePayment = mList.get(position);
        holder.site.setText(lstAdvancePayment.getLoginID());
        holder.AssociateID.setText(lstAdvancePayment.getName());
        holder.AssociateName.setText(lstAdvancePayment.getAmount());
        holder.amount.setText(lstAdvancePayment.getPaymentDate());
        // holder.visitDate.setText(lstAdvancePayment.getVisitDate());
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView site;
        public TextView AssociateID;
        public TextView AssociateName;
        public TextView amount;
        public TextView visitDate;
        public AppCompatButton print;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            site = itemView.findViewById(R.id.site);
            AssociateID = itemView.findViewById(R.id.AssociateID);
            AssociateName = itemView.findViewById(R.id.AssociateName);
            amount = itemView.findViewById(R.id.amount);
            visitDate = itemView.findViewById(R.id.visitDate);
            print = itemView.findViewById(R.id.print);
        }
    }
}
