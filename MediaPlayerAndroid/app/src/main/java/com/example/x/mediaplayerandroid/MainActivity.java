package com.example.x.mediaplayerandroid;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView txtMaxTime, txtCurrentPosition;
    private MediaPlayer mediaPlayer;
    private Button btnPause, btnStart;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    private void initControls() {
        handler = new Handler();
        seekBar = findViewById(R.id.seekBar);
        txtMaxTime = findViewById(R.id.txtMaxTime);
        txtCurrentPosition = findViewById(R.id.txtCurrentPosition);
        btnStart = findViewById(R.id.btnStart);
        btnPause = findViewById(R.id.btnPause);
        btnPause.setEnabled(false);
        seekBar.setClickable(false);
        int songId = getRawResIdByName("choemgananhthemchutnua");
        int dpId = getRawResIdByName("anhnangcuaanh");
        mediaPlayer = MediaPlayer.create(this, songId);
        mediaPlayer = MediaPlayer.create(this, dpId);
    }

    public void handleMedia(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                int duration = this.mediaPlayer.getDuration();

                int currentPosition = this.mediaPlayer.getCurrentPosition();
                if (currentPosition == 0) {
                    seekBar.setMax(duration);
                    String maxTimeString = this.millisecondsToString(duration);
                    txtMaxTime.setText(maxTimeString);
                } else if (currentPosition == duration) {
                    this.mediaPlayer.reset();
                }
                this.mediaPlayer.start();

                UpdateSeekBarThread updateSeekBarThread = new UpdateSeekBarThread();
                handler.postDelayed(updateSeekBarThread, 50);

                btnPause.setEnabled(true);
                btnStart.setEnabled(false);
                break;
            case R.id.btnRewind:
                int curent = mediaPlayer.getCurrentPosition();
                int SUBTRACT_TIME = 5000;
                if(curent - SUBTRACT_TIME > 0 )  {
                    mediaPlayer.seekTo(curent - SUBTRACT_TIME);
                }
                break;
            case R.id.btnPause:
                mediaPlayer.pause();
                btnPause.setEnabled(false);
                btnStart.setEnabled(true);
                break;
            case R.id.btnFastfoward:
                int current2 = mediaPlayer.getCurrentPosition();
                int dur = mediaPlayer.getDuration();
                int ADD_TIME = 5000;
                if(current2 + ADD_TIME < dur)  {
                    mediaPlayer.seekTo(current2 + ADD_TIME);
                }
                break;
        }
    }

    class UpdateSeekBarThread implements Runnable {

        public void run() {
            int currentPosition = mediaPlayer.getCurrentPosition();
            String currentPositionStr = millisecondsToString(currentPosition);
            txtCurrentPosition.setText(currentPositionStr);
            seekBar.setProgress(currentPosition);
            handler.postDelayed(this, 50);
        }
    }

    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();
        return getResources().getIdentifier(resName, "raw", pkgName);
    }

    private String millisecondsToString(int milliseconds) {
        long minutes = TimeUnit.MILLISECONDS.toMinutes((long) milliseconds);
        long seconds = TimeUnit.MILLISECONDS.toSeconds((long) milliseconds);
        return minutes + ":" + seconds;
    }


}
