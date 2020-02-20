package com.example.volumeui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    SeekBar sk;
    Button  loud,quiet,mute;
    boolean muted =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// i don't know why it must put in the front

        sk  =  findViewById(R.id.seekBar);
        loud = findViewById(R.id.loud);
        quiet = findViewById(R.id.quiet);
        mute = findViewById(R.id.mute);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Barvalue",progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //https://www.cnblogs.com/thuai/archive/2011/12/12/2299971.html
        //https://a0924xxx.pixnet.net/blog/post/77743415
        loud.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){

                    Log.d("down","down");
                    loud.setBackgroundResource(R.drawable.louder_pressed);
                    sk.setProgress(sk.getProgress()+10);
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {

                    Log.d("up","up");
                    loud.setBackgroundResource(R.drawable.louder);


                }
                return false;
            }
        });

        quiet.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){  //按下的時候

                    Log.d("down","down");
                    quiet.setBackgroundResource(R.drawable.quiet_pressed);
                    sk.setProgress(sk.getProgress()-10);

                }

                if (event.getAction() == MotionEvent.ACTION_UP) {  //起來的時候

                    Log.d("up","up");
                    quiet.setBackgroundResource(R.drawable.quiet);

                }
                return false;
            }
        });

        mute.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){  //按下的時候

                    Log.d("down","down");
                    mute.setBackgroundResource(R.drawable.mute_pressed);

                }

                if (event.getAction() == MotionEvent.ACTION_UP) {  //起來的時候

                    Log.d("up","up");
                    muted = !muted;
                    if(muted){
                        mute.setBackgroundResource(R.drawable.muted_active);
                    }
                    else {
                        mute.setBackgroundResource(R.drawable.mute);
                    }

                }
                return false;
            }
        });
        /*        mute.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                muted = !muted;
                if(muted){
                    mute.setBackgroundResource(R.drawable.);
                }
            }
        });*/
    }
}
