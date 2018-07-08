package com.example.e_commerceappui.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.e_commerceappui.R;

/**
 * Created by xandsoft on 7/1/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private int[] imageUrls;
    private Context context;

    public ViewPagerAdapter(int[] imageUrls, Context context) {
        this.imageUrls = imageUrls;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageUrls.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (FrameLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater singleSlideLayout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View singleSlideView = singleSlideLayout.inflate(R.layout.layout_single_slide, container, false);

        ImageView imageView = singleSlideView.findViewById(R.id.single_slide_img);
        TextView sliderTItle = singleSlideView.findViewById(R.id.slide_title);
        Button slideButton = singleSlideView.findViewById(R.id.slide_button);


        imageView.setImageResource(imageUrls[position]);

        // Adding layout into ViewGroup
        container.addView(singleSlideView);

        return singleSlideView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
