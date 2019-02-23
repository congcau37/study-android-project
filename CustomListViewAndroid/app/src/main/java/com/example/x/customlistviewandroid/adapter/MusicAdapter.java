package com.example.x.customlistviewandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.x.customlistviewandroid.R;
import com.example.x.customlistviewandroid.model.MusicModel;

import java.util.ArrayList;

/**
 * Created by X on 11/6/2017.
 **/

public class MusicAdapter extends BaseAdapter {
    private ArrayList<MusicModel> mData;
    private Context mContext;

    public MusicAdapter(Context mContext, ArrayList<MusicModel> mData) {
        this.mData = mData;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //NẾU CÓ MỘT FILE GIAO DIỆN TẠO Ở BÊN NGOÀI
        //THÌ PHẢI CHỨA TRONG MỘT ĐỐI TƯỢNG CÓ KIỂU LÀ VIEW
        //MUỐN ĐƯA ĐƯỢC CÁI GIAO DIỆN VÀO TRONG ĐỐI TƯỢNG CÓ KIỂU LÀ VIEW
        //Ở BÊN TRÊN THÌ PHẢI TẠO MỘT ĐỐI TƯỢNG CÓ KIỂU LÀ LAYOUTINFLATER
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.custom_items_music, viewGroup, false);
        return null;
    }
}
