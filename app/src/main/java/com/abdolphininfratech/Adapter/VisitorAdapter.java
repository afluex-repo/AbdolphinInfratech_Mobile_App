package com.abdolphininfratech.Adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Activity.PrintVisitorListActivity;
import com.abdolphininfratech.Model.VisitorList.Lstvisitor;
import com.abdolphininfratech.R;

import java.util.List;


public class VisitorAdapter extends RecyclerView.Adapter<VisitorAdapter.ViewHolder> {
    private List<Lstvisitor> mList;
    private Context context;

    public VisitorAdapter(Context context, List<Lstvisitor> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public VisitorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.visotor_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VisitorAdapter.ViewHolder holder, int position) {
        Lstvisitor lstvisitor = mList.get(position);
        holder.site.setText(lstvisitor.getAssociateLoginID());
        holder.AssociateID.setText(lstvisitor.getpK_VisitorID());
        holder.AssociateName.setText(lstvisitor.getAssociateName());
        holder.amount.setText(lstvisitor.getSiteName());
        holder.visitDate.setText(lstvisitor.getVisitDate());
        holder.Amount.setText(lstvisitor.getAmount());


        holder.print.setOnClickListener(v -> {
            Intent intent = new Intent(context, PrintVisitorListActivity.class);
            intent.putExtra("PK_VisitorId", lstvisitor.getpK_VisitorID());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView site,Amount;
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
            Amount = itemView.findViewById(R.id.Amount);
        }
    }
}
