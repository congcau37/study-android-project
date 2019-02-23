package demo.utt37.congcau.appquanlychitieu.ui.activity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import demo.utt37.congcau.appquanlychitieu.R;
import demo.utt37.congcau.appquanlychitieu.database.quanlychitieuDAO;
import demo.utt37.congcau.appquanlychitieu.database.quanlychitieuDTO;
import demo.utt37.congcau.appquanlychitieu.ui.adapter.ListQLCTAdapter;

public class ThongKeActivity extends AppCompatActivity {

    private TextView txtNgay,txtThang,txtNoidung,txtSoTien,txtSoDu,txtLoaiGiaoDich;
    private EditText edtNgay,edtThang;
    private Button btnThongKeGiaoDich,btnXemGiaoDich;
    private ListView lv;
     ListQLCTAdapter listQLCTAdapter;
     ArrayList<quanlychitieuDTO> arrayQLCT = new ArrayList<quanlychitieuDTO>();
     quanlychitieuDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        initControls();
        initEvents();

    }
    public void initControls(){

        dao = new quanlychitieuDAO(this);
        dao.open();;
        btnThongKeGiaoDich = (Button) findViewById(R.id.btnThonngKeGiaoDich);
        btnXemGiaoDich     = (Button) findViewById(R.id.btnXemGiaoDich);
        txtLoaiGiaoDich    = (TextView) findViewById(R.id.txtLoaiGiaooDich);
        edtNgay            = (EditText)findViewById(R.id.edtNgay);
        edtThang           = (EditText) findViewById(R.id.edtThang);
        lv                 = (ListView) findViewById(R.id.lvQLCT);

    }

    public void initEvents(){
        btnXemGiaoDich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int ngays = Integer.parseInt(edtNgay.getText().toString());
                int thangs = Integer.parseInt(edtThang.getText().toString());
                arrayQLCT = quanlychitieuDAO.layDuLieu(ngays,thangs);
                listQLCTAdapter = new ListQLCTAdapter(ThongKeActivity.this,R.layout.custom_listview_qlct,arrayQLCT);
                lv.setAdapter(listQLCTAdapter);

            }
        });
    }


}
