package com.example.x.androidasynctaskwithjsonparsing.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.x.androidasynctaskwithjsonparsing.R;
import com.example.x.androidasynctaskwithjsonparsing.model.ProductModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(ProductModel productModel) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle bd = new Bundle();
        bd.putSerializable("product", productModel);
        detailFragment.setArguments(bd);
        return detailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imgProduct1 = view.findViewById(R.id.imgProduct1);
        TextView txtNameProduct1 = view.findViewById(R.id.txtNameProduct1);
        TextView txtPriceProduct1 = view.findViewById(R.id.txtPriceProduct1);
        Bundle bd = getArguments();
        if (bd != null) {
            ProductModel product = (ProductModel) bd.getSerializable("product");
            Glide.with(getActivity())
                    .load(product.getAnh_sanpham())
                    .centerCrop()
                    .into(imgProduct1);
            txtNameProduct1.setText(product.getTen_sanpham());
            txtPriceProduct1.setText(String.valueOf(product.getGia_sanpham()));
        }
    }
}
