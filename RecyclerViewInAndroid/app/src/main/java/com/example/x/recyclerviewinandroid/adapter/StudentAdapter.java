package com.example.x.recyclerviewinandroid.adapter;


/* Created by X on 11/8/2017.
 * */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.x.recyclerviewinandroid.R;
import com.example.x.recyclerviewinandroid.model.StudentModel;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<StudentModel> mData;

    public StudentAdapter(Context mContext, ArrayList<StudentModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    //dùng để kết nối giao diện
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.custom_items_student, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    //viết code cho view
    @Override
    public void onBindViewHolder(StudentAdapter.ViewHolder holder, int position) {
        StudentModel studentModel = mData.get(position);
        holder.mTxtName.setText(studentModel.getName());
        holder.mTxtAge.setText(String.valueOf(studentModel.getAge()));
    }

    //trả về số dòng ( số phần tử của recycler view)
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTxtName, mTxtAge;

        public ViewHolder(View itemView) {
            super(itemView);
            mTxtName = itemView.findViewById(R.id.txtName);
            mTxtAge = itemView.findViewById(R.id.txtAge);
        }
    }
}
