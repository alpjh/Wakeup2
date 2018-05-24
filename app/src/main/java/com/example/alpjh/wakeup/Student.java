package com.example.alpjh.wakeup;

import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Student extends AppCompatActivity {

    private ImageButton btn;
    private TimerTask second;
    private final Handler handler = new Handler();
    private ImageView health_img;
    public int sleep_timer;
    public int health;
    public boolean isSleep;
    public boolean isDead;

    public Student(ImageView health_img, ImageButton image) {

        this.health_img = health_img;
        this.btn =image;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDead) {
                    imgChange(btn);
                }
            }
        });
    }

    public void testStart() {

        health = 20;
        isSleep = true;
        isDead = false;

        second = new TimerTask() {

            @Override
            public void run() {
                Log.i("Test", "Timer start");

                Update();
                if(!isSleep) {
                    GameActivity.classScore+=3;
                    health--;
                    sleep_timer--;
                }else {
                    if(GameActivity.classScore>0)
                        GameActivity.classScore-=2;
                    if(health<20)
                        health++;
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(second, 0, 1000);

    }

    protected void Update() {
        Runnable updater = new Runnable() {
            public void run() {
                GameActivity.totalScore.setText(GameActivity.classScore + "/200");

                if(GameActivity.classScore >= 100) {
                    second.cancel();
                    GameActivity.totalScore.setText("CLEAR!");
                    GameActivity.gameClear = true;
                }
                //health_text.setText(health + "");
                if (health > 10)
                    health_img.setImageResource(R.drawable.full);
                else
                    health_img.setImageResource(R.drawable.danger);
                if(sleep_timer == 0) {
                    imgReturn(btn);
                }
                if(health == 0) {
                    isDead = true;
                    //health_text.setText("DeadBono");
                    btn.setImageResource(R.drawable.sleep);
                    second.cancel();
                }
            }
        };
        handler.post(updater);
    }

    public void killThread() {
        second.cancel();
    }

    private void imgChange(ImageButton tmpBtn) {
        tmpBtn.setImageResource(R.drawable.wakeup);
        Random random = new Random();
        sleep_timer = random.nextInt(10)+1;
        this.isSleep = false;
    }

    private void imgReturn(ImageButton tmpBtn) {
        tmpBtn.setImageResource(R.drawable.sleep);
        this.isSleep = true;
    }



}
