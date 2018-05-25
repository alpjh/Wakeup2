package com.example.alpjh.wakeup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alpjh.wakeup.storydata.Prologue;

import java.util.ArrayList;

public class StoryActivity extends AppCompatActivity implements View.OnClickListener {

    //스토리와 그림을 저장할 어레이리스트 선언
    public static ArrayList<String> story = new ArrayList<>();
    public static ArrayList<Integer> ill = new ArrayList<>();

    private TextView btn;
    public int sCounter = 0;
    private ImageView cha;
    private ImageView cha2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        //뷰 연결
        btn = (TextView)findViewById(R.id.button2);
        btn = (Button)findViewById(R.id.button2);
        cha = (ImageView)findViewById(R.id.imageView);
        cha2 = (ImageView)findViewById(R.id.imageView2);

        btn.setOnClickListener(this);

        //스토리데이터 안에 있는 자료 객체선언
        Prologue prologue = new Prologue();

        //객체를 어레이리스트에 넣는 메서드 실행
        prologue.illSet();
        prologue.storySet();

        //캐릭터 초기 뷰 설정
        cha.setVisibility(View.GONE);
        cha2.setVisibility(View.VISIBLE);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button2 :
                //버튼 클릭시 스토리 진행하도록 설정
                if(sCounter<story.size()) {

                    btn.setText(story.get(sCounter));

                    if(ill.get(sCounter) == 0) {
                        cha.setVisibility(View.GONE);
                        cha2.setVisibility(View.VISIBLE);
                    } else {
                        cha.setVisibility(View.VISIBLE);
                        cha2.setVisibility(View.GONE);
                    }

                    sCounter++;

                }
                else {
                    Intent game_intent = new Intent(StoryActivity.this, GameActivity.class);
                    startActivity(game_intent);
                    overridePendingTransition(R.anim.rightin_activity, R.anim.leftout_activity);
                    finish();
                }
                break;

        }
    }
}
