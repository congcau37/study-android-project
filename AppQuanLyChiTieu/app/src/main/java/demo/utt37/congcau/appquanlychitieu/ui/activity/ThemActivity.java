package demo.utt37.congcau.appquanlychitieu.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import demo.utt37.congcau.appquanlychitieu.R;
import demo.utt37.congcau.appquanlychitieu.database.QuanLiChiTieuDataBase;
import demo.utt37.congcau.appquanlychitieu.database.quanlychitieuDAO;
import demo.utt37.congcau.appquanlychitieu.database.quanlychitieuDTO;

public class ThemActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private Button btnThemGiaoDich, btnLuuGiaoDich;
    private RadioGroup rg;
    private EditText edtSoTien, edtNgay, edtThang, edtLyDo;
    private int loaiGiaoDich;
    private quanlychitieuDAO quanlychitieuD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them);
        initControls();
        initEvents();
    }

    public void initControls() {

        btnLuuGiaoDich = (Button) findViewById(R.id.btnLuu);
        btnThemGiaoDich = (Button) findViewById(R.id.btnThemGiaoDich);
        edtLyDo = (EditText) findViewById(R.id.edtLyDo);
        edtNgay = (EditText) findViewById(R.id.edtNgay);
        edtThang = (EditText) findViewById(R.id.edtThang);
        edtSoTien = (EditText) findViewById(R.id.edtSoTien);
        rg = (RadioGroup) findViewById(R.id.rdgThuChi);
        quanlychitieuD = new quanlychitieuDAO(ThemActivity.this);
        quanlychitieuD.open();
    }

    public void initEvents() {
        btnThemGiaoDich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        btnLuuGiaoDich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtNgay.getText().equals("") || edtThang.getText().equals("") || edtLyDo.getText().equals("") || edtSoTien.getText().equals("")){
                    Toast.makeText(ThemActivity.this,"Khong Duoc Bo Trong",Toast.LENGTH_SHORT).show();
                }else {
                quanlychitieuDTO a = new quanlychitieuDTO();
                a.setSotien(Integer.parseInt(edtSoTien.getText().toString()));
                a.setNgay(Integer.parseInt(edtNgay.getText().toString()));
                a.setThang(Integer.parseInt(edtThang.getText().toString()));
                a.setNoidung((edtLyDo.getText().toString()));
                a.setLoaigiaodich(loaiGiaoDich);
                if (loaiGiaoDich == 1) {

                    a.setSodu(QuanLiChiTieuDataBase.TONGSOTIEN + a.getSotien());
                } else if (loaiGiaoDich == 0) {
                    a.setSodu(QuanLiChiTieuDataBase.TONGSOTIEN - a.getSotien());

                }
                if (quanlychitieuD.themGiaoDich(a) == true) {

                    Toast.makeText(ThemActivity.this, "Them Thanh Cong!!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ThemActivity.this, "Them That Bai!!!", Toast.LENGTH_SHORT).show();
                }
            }}
        });
        rg.setOnCheckedChangeListener(ThemActivity.this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.rdbChi) {
            loaiGiaoDich = 0;
            Toast.makeText(ThemActivity.this, "Khoan Chi", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.rdbThu) {
            Toast.makeText(ThemActivity.this, "Khoan Thu", Toast.LENGTH_SHORT).show();
            loaiGiaoDich = 1;
        }
    }


}
