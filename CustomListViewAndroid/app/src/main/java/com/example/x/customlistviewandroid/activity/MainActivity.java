package com.example.x.customlistviewandroid.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.x.customlistviewandroid.adapter.MusicAdapter;
import com.example.x.customlistviewandroid.model.MusicModel;
import com.example.x.customlistviewandroid.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //BƯỚC 1: KÉO THẢ VÀ ÁNH XẠ LISTVIEW

    //BƯỚC 2: TẠO DỮ LIỆU CHO LISTVIEW
    private ArrayList<MusicModel> mData;

    //BƯỚC 3: TỰ TẠO GIAO DIỆN CHO DÒNG CỦA LISTVIEW

    //BƯỚC 4: TỰ VIẾT ADAPTER CỦA RIÊNG MÌNH

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lvMusic = findViewById(R.id.lvMusic);
        mData = new ArrayList<>();
        mData.add(new MusicModel("Mot con vit", "Duong Anh Tuan"));
        mData.add(new MusicModel("Be Len Ba", "Duong Anh Tuan"));
        mData.add(new MusicModel("Trai Dat Nay La Cua Chung Minh", "Duong Anh Tuan"));
        mData.add(new MusicModel("Mot con vit", "Duong Anh Tuan"));
        mData.add(new MusicModel("Be Len Ba", "Duong Anh Tuan"));
        mData.add(new MusicModel("Trai Dat Nay La Cua Chung Minh", "Duong Anh Tuan"));
        mData.add(new MusicModel("Mot con vit", "Duong Anh Tuan"));
        mData.add(new MusicModel("Be Len Ba", "Duong Anh Tuan"));
        mData.add(new MusicModel("Trai Dat Nay La Cua Chung Minh", "Duong Anh Tuan"));
        mData.add(new MusicModel("Mot con vit", "Duong Anh Tuan"));
        mData.add(new MusicModel("Be Len Ba", "Duong Anh Tuan"));
        mData.add(new MusicModel("Trai Dat Nay La Cua Chung Minh", "Duong Anh Tuan"));

        MusicAdapter adapter = new MusicAdapter(MainActivity.this, mData);
        lvMusic.setAdapter(adapter);


    }
}
