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

import com.abdolphininfratech.Activity.PrintDownBusinessActivity;
import com.abdolphininfratech.Model.GetDownLineBusinessById.LstViewBussiness;
import com.abdolphininfratech.R;
import java.util.List;

public class BusinessDevelopemntAdapter extends RecyclerView.Adapter<BusinessDevelopemntAdapter.ViewHolder> {
    private List<LstViewBussiness> mList;
    private Context context;

    public BusinessDevelopemntAdapter(List<LstViewBussiness> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public BusinessDevelopemntAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.business_development_layout, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull BusinessDevelopemntAdapter.ViewHolder holder, int position) {
        LstViewBussiness lstViewBussiness = mList.get(position);
        holder.site.setText(lstViewBussiness.getName());
        holder.AssociateID.setText(lstViewBussiness.getLoginId());
        holder.AssociateName.setText(lstViewBussiness.getBusiness());


//        holder.print.setOnClickListener(v -> {
//            Intent intent = new Intent(context, PrintDownBusinessActivity.class);
//            intent.putExtra("Fk_UserId", lstViewBussiness.getLoginId());
//            context.startActivity(intent);
//        });

    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
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
