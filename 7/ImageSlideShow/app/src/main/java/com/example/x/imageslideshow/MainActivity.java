package com.example.x.imageslideshow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.x.imageslideshow.model.ImageModel;

public class MainActivity extends AppCompatActivity {
    private ImageView imgBackground;
    private TextView txtDescription;
    private ImageModel[] mData;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        imgBackground = findViewById(R.id.imgBackground);
        txtDescription = findViewById(R.id.txt_description);
        mData = new ImageModel[3];
        mData[0] = new ImageModel(R.drawable.index1, "Index1");
        mData[1] = new ImageModel(R.drawable.index2, "Index2");
        mData[2] = new ImageModel(R.drawable.index3, "Index3");
        imgBackground.setImageResource(mData[position].getIdImage());
        txtDescription.setText(mData[position].getDescription());
    }

    public void changeImage(View view) {
        switch (view.getId()) {
            case R.id.btnNext:
                if (position == mData.length - 1)
                    position = 0;
                else
                    position++;
                imgBackground.setImageResource(mData[position].getIdImage());
                txtDescription.setText(mData[position].getDescription());
                break;
            case R.id.btnPrevious:
                if (position == 0)
                    position = mData.length - 1;
                else
                    position--;
                imgBackground.setImageResource(mData[position].getIdImage());
                txtDescription.setText(mData[position].getDescription());
                break;
        }
    }
}
