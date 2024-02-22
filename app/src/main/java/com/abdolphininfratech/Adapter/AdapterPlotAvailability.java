package com.abdolphininfratech.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.abdolphininfratech.Model.responsePlotAvability.LstPlot;
import com.abdolphininfratech.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterPlotAvailability extends RecyclerView.Adapter<AdapterPlotAvailability.ViewHolder> {


    private List<LstPlot> models;
    private Context context;

    public AdapterPlotAvailability(List<LstPlot> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_plot_availability, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
       viewHolder.tvPlotNumber.setText(models.get(i).getPlotnumber());
        viewHolder.tvPlotArea.setText(models.get(i).getPlotArea());
        viewHolder.tvSectorName.setText(models.get(i).getSectorName());
        viewHolder.tvBlockName.setText(models.get(i).getBlockName());
        viewHolder.layout.setBackgroundColor(Color.parseColor(models.get(i).getColorCSS().trim()));

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_plot_number)
        TextView tvPlotNumber;
        @BindView(R.id.tv_Plot_Area)
        TextView tvPlotArea;
        @BindView(R.id.tv_sector_name)
        TextView tvSectorName;
        @BindView(R.id.tv_block_name)
        TextView tvBlockName;
        @BindView(R.id.layout)
        LinearLayout layout;
        @BindView(R.id.card_item)
        CardView cardItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);



        }
    }
}
