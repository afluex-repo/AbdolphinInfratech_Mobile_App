package com.abdolphininfratech.Adapter;

import static android.os.Build.VERSION_CODES.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abdolphininfratech.Model.responseNews.Lstnewsdetail;
import com.abdolphininfratech.R;
import com.bumptech.glide.Glide;

import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterViewHolder> {

    // list for storing urls of images.
    private Context context;
    private final ArrayList<Lstnewsdetail> mSliderItems;

    // Constructor


    public SliderAdapter(Context context, ArrayList<Lstnewsdetail> mSliderItems) {
        this.context = context;
        this.mSliderItems = mSliderItems;
    }

    // We are inflating the slider_layout
    // inside on Create View Holder method.
    @Override
    public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(com.abdolphininfratech.R.layout.slider_layout, null);
        return new SliderAdapterViewHolder(inflate);
    }

    // Inside on bind view holder we will
    // set data to item of Slider View.
    @Override
    public void onBindViewHolder(SliderAdapterViewHolder viewHolder, final int position) {

        final Lstnewsdetail sliderItem = mSliderItems.get(position);

        // Glide is use to load image
        // from url in your imageview.
        Log.e("Lang",context.getSharedPreferences("UserDetails",Context.MODE_PRIVATE).getString("Language","hi"));

//        if(context.getSharedPreferences("UserDetails",Context.MODE_PRIVATE).getString("Language","hi").equals("en")){
//            Glide.with(viewHolder.itemView)
//                    .load(sliderItem.getUrl())
//                    .fitCenter()
//                    .into(viewHolder.imageViewBackground);
//        }else{
//            Glide.with(viewHolder.itemView)
//                    .load(sliderItem.getUrlHindi())
//                    .fitCenter()
//                    .into(viewHolder.imageViewBackground);
//        }
        viewHolder.imageViewBackground.setText(sliderItem.getNewsHeading());
        viewHolder.txt_message.setText(sliderItem.getNewsBody());



    }

    // this method will return
    // the count of our list.
    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    static class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
        // Adapter class for initializing
        // the views of our slider view.
        View itemView;
        TextView imageViewBackground;
        TextView txt_message;

        public SliderAdapterViewHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(com.abdolphininfratech.R.id.myimage);
            txt_message=itemView.findViewById(com.abdolphininfratech.R.id.txt_message);
            this.itemView = itemView;
        }
    }
}
