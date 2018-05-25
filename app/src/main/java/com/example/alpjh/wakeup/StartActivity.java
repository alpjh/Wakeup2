package com.example.alpjh.wakeup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;


public class StartActivity extends AppCompatActivity implements View.OnClickListener {


    //파이어베이스 객체 선언
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    //유저아이디
    private static String userID;

    ImageButton sBtnStart, sBtnHelp, sBtnSetting;
    EditText sETid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //버튼들 설정
        sBtnStart = (ImageButton)findViewById(R.id.start_imgb_start);
        sBtnHelp = (ImageButton)findViewById(R.id.start_imgb_help);
        sBtnSetting = (ImageButton)findViewById(R.id.start_imgb_setting);
        sETid = (EditText)findViewById(R.id.start_et_id);

        sBtnStart.setOnClickListener(this);
        sBtnHelp.setOnClickListener(this);
        sBtnSetting.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            //스타트버튼 클릭시
            case R.id.start_imgb_start :
                //유저아이디를 받아온다
                userID = sETid.getText().toString();
                //받아온 아이디가 ""일경우 default로 설정해줌
                if (userID.equals("")) {
                    userID = "default";
                }

                //아이디와 0을 서버에 업로드한다
                databaseReference.child(userID).setValue(0);
                //스토리 액티비티로 넘어감
                Intent story_intent = new Intent(StartActivity.this, StoryActivity.class);
                startActivity(story_intent);
                //액티비티 전환시 애니메이션 적용
                overridePendingTransition(R.anim.rightin_activity, R.anim.leftout_activity);
                //finish();
                break;

            case R.id.start_imgb_help :
                Intent help_intent = new Intent(StartActivity.this, HelpActivity.class);
                startActivity(help_intent);
                //액티비티 전환시 애니메이션 적용
                overridePendingTransition(R.anim.downin_activity, R.anim.topout_activity);
                finish();
                break;

            case R.id.start_imgb_setting :
                Intent setting_intent = new Intent(StartActivity.this, SettingActivity.class);
                startActivity(setting_intent);
                //액티비티 전환시 애니메이션 적용
                overridePendingTransition(R.anim.leftin_activity, R.anim.rightout_activity);
                finish();
                break;
        }
    }

    public static String getUserID (){
        return userID;
    }

}
