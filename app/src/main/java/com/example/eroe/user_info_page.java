package com.example.eroe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class user_info_page extends AppCompatActivity {

    ImageButton logo_bt, notice_bt, profile_bt, menu_bt, photo_bt;
    Button modify_bt, logout_bt;
    TextView parent_txt;
    View.OnClickListener cl;
    Intent i, j, k, l, m, n;


    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.my_page);

        logo_bt = (ImageButton) findViewById(R.id.logo_bt);
        notice_bt = (ImageButton) findViewById(R.id.notice_bt);
        profile_bt = (ImageButton) findViewById(R.id.profile_bt);
        menu_bt = (ImageButton) findViewById(R.id.menu_bt);
        photo_bt = (ImageButton) findViewById(R.id.photo_bt);
        modify_bt = (Button) findViewById(R.id.modify_bt);
        logout_bt = (Button) findViewById(R.id.logout_bt);
        parent_txt = (TextView) findViewById(R.id.parent_txt);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.logo_bt:
                        i = new Intent(getApplicationContext(), MainActivity.class);
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
                    case R.id.modify_bt:
                        m = new Intent(getApplicationContext(), user_info_modify_page.class);
                        startActivity(m);
                        break;
                    case R.id.logout_bt:
                        n = new Intent(getApplicationContext(),login_page.class);
                        startActivity(n);
                        Toast.makeText(getApplicationContext(), "로그아웃 되었습니다.", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };
        logo_bt.setOnClickListener(cl);
        notice_bt.setOnClickListener(cl);
        profile_bt.setOnClickListener(cl);
        menu_bt.setOnClickListener(cl);
        modify_bt.setOnClickListener(cl);
        logout_bt.setOnClickListener(cl);
    }
}
