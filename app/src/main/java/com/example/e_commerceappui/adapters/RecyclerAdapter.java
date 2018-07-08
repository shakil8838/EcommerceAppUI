package com.example.e_commerceappui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.e_commerceappui.R;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewHolder> {

    private Context context;

    private int[] productImages = {
            R.drawable.product_image1,
            R.drawable.product_image2,
            R.drawable.product_image3,
            R.drawable.product_image4
    };

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridLayoutView = layoutInflater.inflate(R.layout.layout_single_product_item, parent, false);

        return new MyViewHolder(gridLayoutView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.productImage.setImageResource(productImages[position]);

    }

    @Override
    public int getItemCount() {
        return productImages.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView productTitle;
        TextView productPrice;

        public MyViewHolder(View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_title);
            productPrice = itemView.findViewById(R.id.product_price);
        }
    }
}
