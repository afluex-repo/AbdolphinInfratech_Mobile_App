package com.abdolphininfratech.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Fragment.AssociateTree;
import com.abdolphininfratech.Interface.AssociateTreeInterface;
import com.abdolphininfratech.Model.responseAssociateTree.Lstdownline;
import com.abdolphininfratech.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterAssociateTree extends RecyclerView.Adapter<AdapterAssociateTree.ViewHolder> {


    private List<Lstdownline> models;
    private Context context;
    private AssociateTreeInterface associateTreeInterface;

    public AdapterAssociateTree(List<Lstdownline> models, Context context, AssociateTreeInterface associateTreeInterface) {
        this.models = models;
        this.context = context;
        this.associateTreeInterface = associateTreeInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_associate_tree, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvStatus.setText(models.get(i).getStatus());
        viewHolder.tvLoginId.setText(models.get(i).getLoginId());
        viewHolder.tvActivestatus.setText(models.get(i).getActiveStatus());
        viewHolder.tvStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                associateTreeInterface.getAssociate(models.get(i).getLoginId(), models.get(i).getFkUserId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_status)
        TextView tvStatus;
        @BindView(R.id.tv_loginId)
        TextView tvLoginId;
        @BindView(R.id.tv_activestatus)
        TextView tvActivestatus;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);


        }
    }

}
