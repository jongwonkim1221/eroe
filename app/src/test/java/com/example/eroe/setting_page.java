package com.example.eroe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class setting_page extends AppCompatActivity {

    EditText ed_setting;
    ImageButton imageButton_eroe ;
    Button bt_announcement, bt_versioninfo,bt_alarm,bt_servicecenter;
    View.OnClickListener cl;
    Intent i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ed_setting = (EditText) findViewById(R.id.ed_setting);
        imageButton_eroe = (ImageButton) findViewById(R.id.imageButton_eroe);

        bt_announcement = (Button) findViewById(R.id.bt_announcement);
        bt_versioninfo = (Button) findViewById(R.id.bt_vesioninfo);
        bt_alarm = (Button) findViewById(R.id.bt_alarm);
        bt_servicecenter = (Button) findViewById(R.id.bt_servicecenter);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId( )) {
                    case R.id.bt_announcement:


                        break;

                    case R.id.bt_servicecenter:
                        i = new Intent(getApplicationContext(),setting_servicecenter.class);
                        startActivity(i);
                        break;

                }
            }
        };

        imageButton_eroe.setOnClickListener(cl);
        bt_announcement.setOnClickListener(cl);
        bt_versioninfo.setOnClickListener(cl);
        bt_alarm.setOnClickListener(cl);
        bt_servicecenter.setOnClickListener(cl);

    }
}



