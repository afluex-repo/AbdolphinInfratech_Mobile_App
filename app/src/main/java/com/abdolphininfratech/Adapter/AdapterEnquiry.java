package com.abdolphininfratech.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Model.responseEnquryList.LstBlock1;
import com.abdolphininfratech.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterEnquiry extends RecyclerView.Adapter<AdapterEnquiry.ViewHolder> {



    private List<LstBlock1> models;
    private Context context;

    public AdapterEnquiry(List<LstBlock1> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_enquery, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

      viewHolder.tvName.setText(models.get(i).getName());
      viewHolder.tvName.setText(models.get(i).getDetails());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_details)
        TextView tvDetails;
        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
