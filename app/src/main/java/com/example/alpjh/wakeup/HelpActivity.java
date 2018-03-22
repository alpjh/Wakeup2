package com.example.alpjh.wakeup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HelpActivity extends AppCompatActivity {

    ImageButton hBtnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        hBtnOk = (ImageButton)findViewById(R.id.help_imgb_ok) ;

        hBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HelpActivity.this, StartActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.topin_activity, R.anim.downout_activity);

                finish();

            }
        });


    }
}
