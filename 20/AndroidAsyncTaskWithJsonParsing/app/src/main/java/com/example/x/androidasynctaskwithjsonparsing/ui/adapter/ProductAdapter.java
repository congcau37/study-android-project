package com.example.x.androidasynctaskwithjsonparsing.ui.adapter;

/* Created by X on 12/6/2017.
* */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.x.androidasynctaskwithjsonparsing.R;
import com.example.x.androidasynctaskwithjsonparsing.model.ProductModel;
import com.example.x.androidasynctaskwithjsonparsing.ui.activity.MainActivity;
import com.example.x.androidasynctaskwithjsonparsing.ui.fragment.DetailFragment;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<ProductModel> mData;

    public ProductAdapter(Context mContext, ArrayList<ProductModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.custom_item_product, parent, false));
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        holder.txtNameProduct.setText(mData.get(position).getTen_sanpham());
        holder.txtPriceProduct.setText(String.valueOf(mData.get(position).getGia_sanpham()));
        Glide.with(mContext)
                .load(mData.get(position).getAnh_sanpham())
                .into(holder.imgProduct);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgProduct;
        TextView txtNameProduct, txtPriceProduct;

        public ViewHolder(View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.imgProduct);
            txtNameProduct = itemView.findViewById(R.id.txtNameProduct);
            txtPriceProduct = itemView.findViewById(R.id.txtPriceProduct);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            ((MainActivity) mContext).nextFragment(R.id.myLayout, DetailFragment.newInstance(mData.get(getAdapterPosition())));
        }
    }
}
