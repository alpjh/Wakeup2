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

        btn = (TextView)findViewById(R.id.button2);
        btn = (Button)findViewById(R.id.button2);
        cha = (ImageView)findViewById(R.id.imageView);
        cha2 = (ImageView)findViewById(R.id.imageView2);

        btn.setOnClickListener(this);

        Prologue prologue = new Prologue();

        prologue.illSet();
        prologue.storySet();

        cha.setVisibility(View.GONE);
        cha2.setVisibility(View.VISIBLE);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button2 :
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
