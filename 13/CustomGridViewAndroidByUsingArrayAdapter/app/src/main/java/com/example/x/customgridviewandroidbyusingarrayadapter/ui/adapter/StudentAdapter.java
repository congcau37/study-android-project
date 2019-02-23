package com.example.x.customgridviewandroidbyusingarrayadapter.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.x.customgridviewandroidbyusingarrayadapter.R;
import com.example.x.customgridviewandroidbyusingarrayadapter.model.StudentModel;

import java.util.ArrayList;

/* Created by X on 11/28/2017.
* */

public class StudentAdapter extends ArrayAdapter<StudentModel> {
    public StudentAdapter(@NonNull Context context, ArrayList<StudentModel> mData) {
        super(context, 0, mData);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_item_students, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtName.setText(getItem(position).getName());
        viewHolder.txtAge.setText(String.valueOf(getItem(position).getAge()));
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
