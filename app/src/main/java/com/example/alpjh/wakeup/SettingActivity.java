package com.example.alpjh.wakeup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SettingActivity extends AppCompatActivity {

    ImageButton sBtnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sBtnOk = (ImageButton)findViewById(R.id.setting_imgb_ok) ;

        sBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SettingActivity.this, StartActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.rightin_activity, R.anim.leftout_activity);

                finish();
                //overridePendingTransition(R.anim.rightin_activity, R.anim.leftout_activity);

            }
        });

    }
}
