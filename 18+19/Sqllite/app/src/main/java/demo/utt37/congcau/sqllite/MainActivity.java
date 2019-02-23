package demo.utt37.congcau.sqllite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import demo.utt37.congcau.sqllite.database.Database;

public class MainActivity extends AppCompatActivity {
    Database database;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new Database(this, "users_manager_sqlite", null, 1);

        database.QueryDatabade("CREATE TABLE IF NOT EXITS users(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARHAR(200),pass VARHAR(200))");

        database.QueryDatabade("INSERT INTO user VALUES(null,'vietpro','123456')");

        Cursor data = database.GetDatabase("SELECT * FROM users");
        while (data.moveToNext()) {
            String NoiDung = data.getString(1);
            Toast.makeText(this, NoiDung, Toast.LENGTH_SHORT);
        }
    }
}
