package com.abdolphininfratech.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import com.abdolphininfratech.Model.SelfDownlineBusinessReport.LstSelfDownlineBusiness;
import com.abdolphininfratech.R;
import java.util.List;


public class SelfDownlineBusinessaDAPTER extends RecyclerView.Adapter<SelfDownlineBusinessaDAPTER.ViewHolder> {
    private List<LstSelfDownlineBusiness> mList;
    private Context context;

    public SelfDownlineBusinessaDAPTER(List<LstSelfDownlineBusiness> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public SelfDownlineBusinessaDAPTER.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.self_downline_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelfDownlineBusinessaDAPTER.ViewHolder holder, int position) {
        LstSelfDownlineBusiness lstSelfDownlineBusiness = mList.get(position);
        holder.bookingid.setText(lstSelfDownlineBusiness.getpK_BookingId());
        holder.CustomerID.setText(lstSelfDownlineBusiness.getCustomerID());
        holder.CustomerName.setText(lstSelfDownlineBusiness.getCustomerName());
        holder.AssociateID.setText(lstSelfDownlineBusiness.getAssociateID());
        holder.AssociateName.setText(lstSelfDownlineBusiness.getAssociateName());

        holder.branchName.setText(lstSelfDownlineBusiness.getBranchName());
        holder.PaidAmount.setText(lstSelfDownlineBusiness.getPaidAmount());
        holder.PaymentDate.setText(lstSelfDownlineBusiness.getPaymentDate());
        holder.PlotAmount.setText(lstSelfDownlineBusiness.getPlotAmount());
        holder.PlotNumber.setText(lstSelfDownlineBusiness.getPlotNumber());
        holder.Balance.setText(lstSelfDownlineBusiness.getBalance());
        holder.Discount.setText(lstSelfDownlineBusiness.getDiscount());
        holder.BookingNumber.setText(lstSelfDownlineBusiness.getBookingNumber());

//        holder.print.setOnClickListener(v -> {
//            Intent intent = new Intent(context, PrintVisitorListActivity.class);
//            intent.putExtra("PK_VisitorId", lstSelfDownlineBusiness.getpK_VisitorID());
//            context.startActivity(intent);
//        });
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView bookingid;
        public TextView CustomerID,branchName,PaidAmount,PaymentDate,PlotAmount,PlotNumber,Balance,Discount,BookingNumber;
        public TextView CustomerName;
        public TextView AssociateID;
        public TextView AssociateName;
        public AppCompatButton print;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookingid = itemView.findViewById(R.id.bookingid);
            CustomerID = itemView.findViewById(R.id.CustomerID);
            CustomerName = itemView.findViewById(R.id.CustomerName);
            AssociateID = itemView.findViewById(R.id.AssociateID);
            AssociateName = itemView.findViewById(R.id.AssociateName);
            branchName = itemView.findViewById(R.id.branchName);
            PaidAmount = itemView.findViewById(R.id.PaidAmount);
            PaymentDate = itemView.findViewById(R.id.PaymentDate);
            PlotAmount = itemView.findViewById(R.id.PlotAmount);
            PlotNumber = itemView.findViewById(R.id.PlotNumber);
            Balance = itemView.findViewById(R.id.Balance);
            Discount = itemView.findViewById(R.id.Discount);
            BookingNumber = itemView.findViewById(R.id.BookingNumber);
            print = itemView.findViewById(R.id.print);
        }
    }
}
