package com.abdolphininfratech.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.abdolphininfratech.Model.responseDownline.Lstdownline;
import com.abdolphininfratech.R;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;


public class AdapterDownline extends RecyclerView.Adapter<AdapterDownline.ViewHolder> {

    private List<Lstdownline> models;
    private Context context;

    public AdapterDownline(List<Lstdownline> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_downline, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tvAffiliate.setText(models.get(i).getAssociateID());
        viewHolder.tvAffiliateName.setText(models.get(i).getAssociateName());
        viewHolder.tvRankName.setText(models.get(i).getDesignationName());
        viewHolder.tvRank.setText(models.get(i).getPercentage());
        viewHolder.tvMobileNumber.setText(models.get(i).getContact());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_affiliate)
        TextView tvAffiliate;
        @BindView(R.id.tv_affiliate_name)
        TextView tvAffiliateName;
        @BindView(R.id.tv_rank_name)
        TextView tvRankName;
        @BindView(R.id.tv_rank)
        TextView tvRank;
        @BindView(R.id.tv_mobile_number)
        TextView tvMobileNumber;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
