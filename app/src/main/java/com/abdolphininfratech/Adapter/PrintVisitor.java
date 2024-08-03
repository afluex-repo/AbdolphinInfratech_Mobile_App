package com.abdolphininfratech.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.abdolphininfratech.Model.PrintVisitorList.Visitorlst;
import com.abdolphininfratech.R;
import java.util.List;


public class PrintVisitor extends RecyclerView.Adapter<PrintVisitor.ViewHolder> {
    private List<Visitorlst> mList;

    public PrintVisitor(List<Visitorlst> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public PrintVisitor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.print_visitor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PrintVisitor.ViewHolder holder, int position) {
        Visitorlst visitorlst = mList.get(position);
        holder.site.setText(visitorlst.getCustomerName());
        holder.AssociateID.setText(visitorlst.getMobile());
        holder.AssociateName.setText(visitorlst.getAddress());

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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            site = itemView.findViewById(R.id.site);
            AssociateID = itemView.findViewById(R.id.AssociateID);
            AssociateName = itemView.findViewById(R.id.AssociateName);
            amount = itemView.findViewById(R.id.amount);
            visitDate = itemView.findViewById(R.id.visitDate);
        }
    }
}
