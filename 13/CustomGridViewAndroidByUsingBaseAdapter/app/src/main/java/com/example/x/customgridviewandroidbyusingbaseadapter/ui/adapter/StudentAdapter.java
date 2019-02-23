package com.example.x.customgridviewandroidbyusingbaseadapter.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.x.customgridviewandroidbyusingbaseadapter.R;
import com.example.x.customgridviewandroidbyusingbaseadapter.model.StudentModel;

import java.util.ArrayList;

/* Created by X on 11/28/2017.
* */

public class StudentAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<StudentModel> mData;

    public StudentAdapter(Context mContext, ArrayList<StudentModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.custom_items_student, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtName.setText(mData.get(position).getName());
        viewHolder.txtAge.setText(String.valueOf(mData.get(position).getAge()));
        return convertView;
    }

    private class ViewHolder {
        TextView txtName, txtAge;

        public ViewHolder(View view) {
            txtName = view.findViewById(R.id.txtName);
            txtAge = view.findViewById(R.id.txtAge);
        }
    }
}
