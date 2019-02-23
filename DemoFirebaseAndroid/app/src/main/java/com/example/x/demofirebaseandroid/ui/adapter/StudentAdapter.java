package com.example.x.demofirebaseandroid.ui.adapter;

/* Created by X on 11/22/2017.
* */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.x.demofirebaseandroid.R;
import com.example.x.demofirebaseandroid.model.StudentModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<StudentModel> mData;
    private DatabaseReference mDatabase;

    public StudentAdapter(Context mContext, ArrayList<StudentModel> mData, DatabaseReference mDatabase) {
        this.mContext = mContext;
        this.mData = mData;
        this.mDatabase = mDatabase;
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
        public void onClick(View view) {
            int position = getAdapterPosition();
            String key = mData.get(position).getKey();
            mDatabase.child("Student").child(key).removeValue();
            mData.remove(mData.get(position));
            notifyDataSetChanged();
            //mDatabase.child("Student").child(key).setValue(new Object);
        }
    }
}
