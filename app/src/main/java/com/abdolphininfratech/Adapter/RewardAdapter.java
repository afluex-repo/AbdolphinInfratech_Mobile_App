package com.abdolphininfratech.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Model.UserRewardModel;
import com.abdolphininfratech.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class RewardAdapter extends RecyclerView.Adapter<RewardAdapter.ViewHolder> { // Corrected the class name to RewardAdapter
    private List<UserRewardModel> userRewardModels;
    private Context context;

    public RewardAdapter(List<UserRewardModel> userRewardModels, Context context) {
        this.userRewardModels = userRewardModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RewardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_reward, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RewardAdapter.ViewHolder holder, int position) {
        UserRewardModel currentItem = userRewardModels.get(position);

        // Binding data from the model to the views in the ViewHolder
        holder.Reward.setText(currentItem.getReward());
        holder.Target.setText(currentItem.getTarget());
        holder.status.setText(currentItem.getStatus());

        // Loading image using Glide
        Glide.with(context)
                .load(currentItem.getImage()) // Make sure currentItem.getImage() returns a valid image URL or resource
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return userRewardModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView Reward, Target, status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Find views by their IDs
            image = itemView.findViewById(R.id.image);
            Reward = itemView.findViewById(R.id.Reward);
            Target = itemView.findViewById(R.id.Target);
            status = itemView.findViewById(R.id.status);
        }
    }
}
