package com.example.eroe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.namespace.R;

public class setting_page extends AppCompatActivity {

    ImageButton logo_bt, notice_bt, profile_bt, menu_bt;
    Button sn, vi, sc;
    Switch sw;
    View.OnClickListener cl;
    Intent i, j, k, l, m, n;
    int nChecked = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_page);

        logo_bt = (ImageButton) findViewById(R.id.logo_bt);
        notice_bt = (ImageButton) findViewById(R.id.notice_bt);
        profile_bt = (ImageButton) findViewById(R.id.profile_bt);
        menu_bt = (ImageButton) findViewById(R.id.menu_bt);
        sn = (Button) findViewById(R.id.setting_notice);
        vi = (Button) findViewById(R.id.version_info);
        sc = (Button) findViewById(R.id.service_center);
        sw = (Switch) findViewById(R.id.switch1);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // switch가 체크된 경우
                    nChecked = 1;
                } else {
                    // switch가 체크되지 않은 경우
                    nChecked = 0;
                }
            }
        });

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.logo_bt:
                        i = new Intent(getApplicationContext(), location.class);
                        startActivity(i);
                        break;
                    case R.id.notice_bt:
                        j = new Intent(getApplicationContext(), notice_page.class);
                        startActivity(j);
                        break;
                    case R.id.profile_bt:
                        k = new Intent(getApplicationContext(), my_page.class);
                        startActivity(k);
                        break;
                    case R.id.menu_bt:
                        l = new Intent(getApplicationContext(), menu_page.class);
                        startActivity(l);
                        break;
                    case R.id.setting_notice:
                        m = new Intent(getApplicationContext(), location.class);
                        startActivity(m);
                        break;
                    case R.id.version_info:
                        n = new Intent(getApplicationContext(), location.class);
                        startActivity(n);
                        break;
                    case R.id.service_center:
                        n = new Intent(getApplicationContext(), service_center_page.class);
                        startActivity(n);
                        break;
                }
            }
        };
        logo_bt.setOnClickListener(cl);
        notice_bt.setOnClickListener(cl);
        profile_bt.setOnClickListener(cl);
        menu_bt.setOnClickListener(cl);
        sn.setOnClickListener(cl);
        vi.setOnClickListener(cl);
        sc.setOnClickListener(cl);
    }
}
