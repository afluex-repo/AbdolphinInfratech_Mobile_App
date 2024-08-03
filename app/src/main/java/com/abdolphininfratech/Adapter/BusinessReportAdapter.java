package com.abdolphininfratech.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import com.abdolphininfratech.Model.BusinessReport.LstBusinessReport;
import com.abdolphininfratech.R;
import java.util.List;


public class BusinessReportAdapter extends RecyclerView.Adapter<BusinessReportAdapter.ViewHolder> {
    private List<LstBusinessReport> mList;
    private Context context;

    public BusinessReportAdapter(List<LstBusinessReport> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public BusinessReportAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.associate_business_layout, parent, false);
        return new ViewHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull BusinessReportAdapter.ViewHolder holder, int position) {
        LstBusinessReport lstBusinessReport = mList.get(position);
        holder.UserLoginId.setText(lstBusinessReport.getUserLoginId());
        holder.LoginId.setText(lstBusinessReport.getLoginId());
        holder.DirectMemberJoining.setText(lstBusinessReport.getDirectMemberJoining());
        holder.TotalAllotmentAmount.setText(lstBusinessReport.getTotalAllotmentAmount());
        holder.TeamBusiness.setText(lstBusinessReport.getTeamBusiness());
        holder.TeamMemberJoining.setText(lstBusinessReport.getTeamMemberJoining());

//        holder.print.setOnClickListener(v -> {
//            Intent intent = new Intent(context, PrintVisitorListActivity.class);
//            intent.putExtra("PK_VisitorId", lstBusinessReport.getpK_VisitorID());
//            context.startActivity(intent);
//        });
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView UserLoginId;
        public TextView LoginId,TeamMemberJoining;
        public TextView DirectMemberJoining;
        public TextView TotalAllotmentAmount;
        public TextView TeamBusiness;
        public AppCompatButton print;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            UserLoginId = itemView.findViewById(R.id.UserLoginId);
            LoginId = itemView.findViewById(R.id.LoginId);
            DirectMemberJoining = itemView.findViewById(R.id.DirectMemberJoining);
            TotalAllotmentAmount = itemView.findViewById(R.id.TotalAllotmentAmount);
            TeamBusiness = itemView.findViewById(R.id.TeamBusiness);
            TeamMemberJoining = itemView.findViewById(R.id.TeamMemberJoining);
            print = itemView.findViewById(R.id.print);
        }
    }
}
