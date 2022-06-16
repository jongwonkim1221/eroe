package com.example.eroe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.namespace.R;

public class menu_page extends AppCompatActivity {

    ImageButton logo_bt, notice_bt, profile_bt, menu_bt;
    Button menu1, menu2, menu3, menu4;
    View.OnClickListener cl;
    Intent i, j, k, l, m, n, o, p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_page);

        logo_bt = (ImageButton) findViewById(R.id.logo_bt);
        notice_bt = (ImageButton) findViewById(R.id.notice_bt);
        profile_bt = (ImageButton) findViewById(R.id.profile_bt);
        menu_bt = (ImageButton) findViewById(R.id.menu_bt);
        menu1 = (Button) findViewById(R.id.menu1);
        menu2 = (Button) findViewById(R.id.menu2);
        menu3 = (Button) findViewById(R.id.menu3);
        menu4 = (Button) findViewById(R.id.menu4);

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
                    case R.id.menu1:
                        m = new Intent(getApplicationContext(), my_page.class);
                        startActivity(m);
                        break;
                    case R.id.menu2:
                        n = new Intent(getApplicationContext(), user_info_page.class);
                        startActivity(n);
                        break;
                    case R.id.menu3:
                        o = new Intent(getApplicationContext(), declaration_page.class);
                        startActivity(o);
                        break;
                    case R.id.menu4:
                        p = new Intent(getApplicationContext(), setting_page.class);
                        startActivity(p);
                        break;
                }
            }
        };
        logo_bt.setOnClickListener(cl);
        notice_bt.setOnClickListener(cl);
        profile_bt.setOnClickListener(cl);
        menu_bt.setOnClickListener(cl);
        menu1.setOnClickListener(cl);
        menu2.setOnClickListener(cl);
        menu3.setOnClickListener(cl);
        menu4.setOnClickListener(cl);
    }
}