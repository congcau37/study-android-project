package demo.utt37.congcau.appquanlychitieu.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import demo.utt37.congcau.appquanlychitieu.R;
import demo.utt37.congcau.appquanlychitieu.database.quanlychitieuDAO;
import demo.utt37.congcau.appquanlychitieu.database.quanlychitieuDTO;


public class MainActivity extends AppCompatActivity {

    private quanlychitieuDAO quanlichitieuDAO;
    private quanlychitieuDTO quanlichitieuDTO;
    private Button btnThem,btnThongKe,btnGioiThieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initEvents();
        quanlichitieuDAO = new quanlychitieuDAO(MainActivity.this);
        Toast.makeText(MainActivity.this,"CREATE",Toast.LENGTH_SHORT).show();
        quanlichitieuDAO.open();
        Toast.makeText(MainActivity.this,"OPEN",Toast.LENGTH_SHORT).show();
    }

    public void initControls(){

        btnGioiThieu = (Button) findViewById(R.id.btn_GioiThieu);
        btnThem      = (Button) findViewById(R.id.btn_Them);
        btnThongKe   = (Button) findViewById(R.id.btn_ThongKe);
    }
    public void initEvents(){

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,ThemActivity.class));
            }
        });
        btnThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,ThongKeActivity.class));
            }
        });
        btnGioiThieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,GioiThieuActivity.class));
            }
        });
    }
}
