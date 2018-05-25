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

    //생성자
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

    //쓰레드를 시작하는 메서드
    public void testStart() {

        health = 20;
        isSleep = true;
        isDead = false;

        second = new TimerTask() {

            @Override
            public void run() {
                Log.i("Test", "Timer start");
                //Update 호출
                Update();
                //깨어있을경우 점수상승, 체력감소
                if(!isSleep) {
                    GameActivity.classScore+=3;
                    health--;
                    sleep_timer--;
                }else { // 자고있을경우 점수 감소, 체력 증가
                    if(GameActivity.classScore>0)
                        GameActivity.classScore-=2;
                    if(health<20)
                        health++;
                }
            }
        };
        //1초마다 갱신
        Timer timer = new Timer();
        timer.schedule(second, 0, 1000);

    }

    protected void Update() {
        //쓰레드를 업데이트하는 메서드
        Runnable updater = new Runnable() {
            public void run() {
                GameActivity.totalScore.setText(GameActivity.classScore + "/200");
                //쓰레드를 죽이는 조건
                if(GameActivity.classScore >= 100) {
                    second.cancel();
                    GameActivity.totalScore.setText("CLEAR!");
                    GameActivity.gameClear = true;
                }
                //체력이 많을경우 초록색, 적을경우 주황색으로 표시함
                if (health > 10)
                    health_img.setImageResource(R.drawable.full);
                else
                    health_img.setImageResource(R.drawable.danger);
                if(sleep_timer == 0) {
                    imgReturn(btn);
                }
                //체력이 0이되면 쓰레드를 멈춘다.
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

    //쓰레드를 멈추는 메서드
    public void killThread() {
        second.cancel();
    }

    //쓰레드가 연결된 뷰의 이미지를 바꿈.
    private void imgChange(ImageButton tmpBtn) {
        tmpBtn.setImageResource(R.drawable.wakeup);
        Random random = new Random();
        sleep_timer = random.nextInt(10)+1;
        this.isSleep = false;
    }

    //이미지를 원래되로 되돌리는데 사용할 메서드
    private void imgReturn(ImageButton tmpBtn) {
        tmpBtn.setImageResource(R.drawable.sleep);
        this.isSleep = true;
    }



}
