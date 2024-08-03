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
import com.abdolphininfratech.Fragment.BusinessDevelopmentFragment;
import com.abdolphininfratech.Model.DownlineBusinessReport.LstDownBusiness;
import com.abdolphininfratech.R;
import java.util.List;


public class DownBusinessAdapter extends RecyclerView.Adapter<DownBusinessAdapter.ViewHolder> {
    private List<LstDownBusiness> mList;
    private Context context;

    public DownBusinessAdapter(List<LstDownBusiness> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.down_business_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LstDownBusiness lstDownBusiness = mList.get(position);
        holder.site.setText(lstDownBusiness.getLoginId());
        holder.AssociateID.setText(lstDownBusiness.getFk_UserId());
        holder.AssociateName.setText(lstDownBusiness.getTotalAllotmentAmount());

        holder.print.setOnClickListener(v -> {
            Intent intent = new Intent(context, PrintDownBusinessActivity.class);
            intent.putExtra("Fk_UserId", lstDownBusiness.getFk_UserId());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView site;
        public TextView AssociateID;
        public TextView AssociateName;
        public AppCompatButton print;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            site = itemView.findViewById(R.id.site);
            AssociateID = itemView.findViewById(R.id.AssociateID);
            AssociateName = itemView.findViewById(R.id.AssociateName);
            print = itemView.findViewById(R.id.print);
        }
    }
}
