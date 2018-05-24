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


    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    private static String userID;

    ImageButton sBtnStart, sBtnHelp, sBtnSetting;
    EditText sETid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

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
            case R.id.start_imgb_start :

                userID = sETid.getText().toString();
                if (userID.equals("")) {
                    userID = "default";
                }

                databaseReference.child(userID).setValue(0);
                Intent story_intent = new Intent(StartActivity.this, StoryActivity.class);
                startActivity(story_intent);
                overridePendingTransition(R.anim.rightin_activity, R.anim.leftout_activity);
                //finish();
                break;

            case R.id.start_imgb_help :
                Intent help_intent = new Intent(StartActivity.this, HelpActivity.class);
                startActivity(help_intent);
                overridePendingTransition(R.anim.downin_activity, R.anim.topout_activity);
                finish();
                break;

            case R.id.start_imgb_setting :
                Intent setting_intent = new Intent(StartActivity.this, SettingActivity.class);
                startActivity(setting_intent);
                overridePendingTransition(R.anim.leftin_activity, R.anim.rightout_activity);
                finish();
                break;
        }
    }

    public static String getUserID (){
        return userID;
    }

}
