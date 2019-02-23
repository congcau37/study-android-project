package com.example.x.usingtherecyclerview.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.x.usingtherecyclerview.R;
import com.example.x.usingtherecyclerview.model.StudentModel;

import java.util.ArrayList;

/* Created by X on 11/29/2017.
* */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<StudentModel> mData;

    public StudentAdapter(Context mContext, ArrayList<StudentModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.custom_items_student, parent, false));
    }

    @Override
    public void onBindViewHolder(StudentAdapter.ViewHolder holder, int position) {
        holder.txtName.setText(mData.get(position).getName());
        holder.txtAge.setText(String.valueOf(mData.get(position).getAge()));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtName, txtAge;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mContext, mData.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
        }
    }
}
