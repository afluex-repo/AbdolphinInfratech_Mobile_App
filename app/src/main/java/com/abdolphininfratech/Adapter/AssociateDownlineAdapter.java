package com.abdolphininfratech.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.abdolphininfratech.Model.AssociateDownline.LstAssociateDownLine;
import com.abdolphininfratech.R;
import java.util.List;


public class AssociateDownlineAdapter extends RecyclerView.Adapter<AssociateDownlineAdapter.ViewHolder> {
    private List<LstAssociateDownLine> mList;
    private Context context;

    public AssociateDownlineAdapter(List<LstAssociateDownLine> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public AssociateDownlineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.asssociatedownline_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssociateDownlineAdapter.ViewHolder holder, int position) {
        LstAssociateDownLine lstSelfDownlineBusiness = mList.get(position);
        holder.LoginDetails.setText(lstSelfDownlineBusiness.getLoginDetails());
        holder.TotalBusiness.setText(lstSelfDownlineBusiness.getTotalBusiness());
        holder.TeamBusinessname.setText(lstSelfDownlineBusiness.getTeamBusinessAmount());
        holder.DirectMember.setText(lstSelfDownlineBusiness.getDirectMemberJoining());
        holder.TeamMemberJoining.setText(lstSelfDownlineBusiness.getTeamMemberJoining());
        holder.Income.setText(lstSelfDownlineBusiness.getIncome());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView LoginDetails,TotalBusiness,TeamBusinessname,DirectMember,TeamMemberJoining,Income;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            LoginDetails = itemView.findViewById(R.id.LoginDetails);
            TotalBusiness = itemView.findViewById(R.id.TotalBusiness);
            TeamBusinessname = itemView.findViewById(R.id.TeamBusinessname);
            DirectMember = itemView.findViewById(R.id.DirectMember);
            TeamMemberJoining = itemView.findViewById(R.id.TeamMemberJoining);
            Income = itemView.findViewById(R.id.Income);
        }
    }
}
