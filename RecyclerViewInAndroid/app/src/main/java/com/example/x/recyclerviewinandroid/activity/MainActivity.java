package com.example.x.recyclerviewinandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.x.recyclerviewinandroid.R;
import com.example.x.recyclerviewinandroid.adapter.StudentAdapter;
import com.example.x.recyclerviewinandroid.model.StudentModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //BƯỚC 1: KÉO THẢ VÀ ÁNH XẠ RECYCLER VIEW
    //BƯỚC 2: TẠO DỮ LIỆU
    //BƯỚC 3: TỰ TẠO GIAO DIỆN DO CHÍNH MÌNH TỰ THIẾT KẾ
    //BƯỚC 4: TỰ VIẾT FILE ADAPTER
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //reflection recyclerview
        RecyclerView rvStudent = findViewById(R.id.rvStudent);
        //
        //init data
        ArrayList<StudentModel> mData = new ArrayList<>();
        mData.add(new StudentModel("Nguyen Van A", 28));
        mData.add(new StudentModel("Nguyen Van B", 28));
        mData.add(new StudentModel("Nguyen Van C", 28));
        mData.add(new StudentModel("Nguyen Van D", 28));
        mData.add(new StudentModel("Nguyen Van E", 28));
        mData.add(new StudentModel("Nguyen Van F", 28));
        mData.add(new StudentModel("Nguyen Van G", 28));
        mData.add(new StudentModel("Nguyen Van H", 28));
        mData.add(new StudentModel("Nguyen Van I", 28));
        mData.add(new StudentModel("Nguyen Van J", 28));
        mData.add(new StudentModel("Nguyen Van K", 28));
        mData.add(new StudentModel("Nguyen Van L", 28));
        mData.add(new StudentModel("Nguyen Van M", 28));
        mData.add(new StudentModel("Nguyen Van N", 28));
        //
        StudentAdapter mAdapter = new StudentAdapter(this, mData);
        rvStudent.setLayoutManager(new LinearLayoutManager(this));
//        rvStudent.setLayoutManager(new GridLayoutManager(this, 2));
        rvStudent.setAdapter(mAdapter);
    }
}
