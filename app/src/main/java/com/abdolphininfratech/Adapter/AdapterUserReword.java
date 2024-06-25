package com.abdolphininfratech.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Model.responseUserReword.Lstreward;
import com.abdolphininfratech.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterUserReword extends RecyclerView.Adapter<AdapterUserReword.ViewHolder> {



    private List<Lstreward> models;
    private Context context;

    public AdapterUserReword(List<Lstreward> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_user_reword, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        //inpt = inpt.replace(".", "");
        Picasso.get().load("https://abdolphininfratech.com/"+models.get(i).getRewardImage().replaceAll("../../","")).into(viewHolder.rewordImg);

        viewHolder.tvStatus.setText(models.get(i).getStatus());
        viewHolder.tvQuelifyDate.setText(models.get(i).getQualifyDate());
        viewHolder.tvRewordName.setText(models.get(i).getRewardName());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.reword_img)
        ImageView rewordImg;
        @BindView(R.id.tv_reword_name)
        TextView tvRewordName;
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.tv_quelify_date)
        TextView tvQuelifyDate;
        @BindView(R.id.tv_action)
        TextView tvAction;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }
}
