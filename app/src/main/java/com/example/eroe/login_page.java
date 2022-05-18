package com.example.eroe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class login_page extends AppCompatActivity {
    ImageView menu_bt, notice_bt, profile_bt, logo_bt;
    EditText input_id, input_pw;
    TextView login_txt, id_txt, password_txt;
    Button find_id, find_pw, login_bt, signup_bt;
    View.OnClickListener cl;
    Intent i, j, k, l;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        menu_bt = (ImageView) findViewById(R.id.menu_bt);
        notice_bt = (ImageView) findViewById(R.id.notice_bt);
        profile_bt = (ImageView) findViewById(R.id.profile_bt);
        logo_bt = (ImageView) findViewById(R.id.logo_bt);
        input_id = (EditText) findViewById(R.id.input_id);
        input_pw = (EditText) findViewById(R.id.input_pw);
        login_txt = (TextView) findViewById(R.id.login_txt);
        id_txt = (TextView) findViewById(R.id.id_txt);
        password_txt = (TextView) findViewById(R.id.password_txt);
        find_id = (Button) findViewById(R.id.find_id);
        find_pw = (Button) findViewById(R.id.find_pw);
        login_bt = (Button) findViewById(R.id.login_bt);
        signup_bt = (Button) findViewById(R.id.signup_bt);

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.menu_bt:
                        i = new Intent(getApplicationContext(), menu_page.class);
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
                    case R.id.logo_bt:
                        l = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(l);
                        break;
                }

            }
        };

        menu_bt.setOnClickListener(cl);
        notice_bt.setOnClickListener(cl);
        profile_bt.setOnClickListener(cl);
        logo_bt.setOnClickListener(cl);
        find_id.setOnClickListener(cl);
        find_pw.setOnClickListener(cl);
        login_bt.setOnClickListener(cl);
        signup_bt.setOnClickListener(cl);

    }
}