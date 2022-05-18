package com.example.eroe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class join_membership_page extends AppCompatActivity {

    ImageButton logo_bt, notice_bt, profile_bt, menu_bt;
    TextView modify_txt, id_txt, password_txt, passwordc_txt, name_txt, birth_txt, gender_txt, phonenum_txt, email_txt, address_txt;
    EditText id_editxt, password_editxt, passwordc_editxt, name_editxt, birth_editxt, phonenum_editxt, email_editxt, address_editxt;
    Button check_bt, join_bt;
    RadioButton male_bt, female_bt;
    View.OnClickListener cl;
    Intent i, j, k, l, m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_membership_page);

        logo_bt = (ImageButton) findViewById(R.id.logo_bt);
        notice_bt = (ImageButton) findViewById(R.id.notice_bt);
        profile_bt = (ImageButton) findViewById(R.id.profile_bt);
        menu_bt = (ImageButton) findViewById(R.id.menu_bt);
        modify_txt = (TextView) findViewById(R.id.modify_txt);
        id_txt = (TextView) findViewById(R.id.id_txt);
        password_txt = (TextView) findViewById(R.id.password_txt);
        passwordc_txt = (TextView) findViewById(R.id.passwordc_txt);
        name_txt = (TextView) findViewById(R.id.name_txt);
        birth_txt = (TextView) findViewById(R.id.birth_txt);
        gender_txt = (TextView) findViewById(R.id.gender_txt);
        phonenum_txt = (TextView) findViewById(R.id.phonenum_txt);
        email_txt = (TextView) findViewById(R.id.email_txt);
        address_txt = (TextView) findViewById(R.id.address_txt);
        id_editxt = (EditText) findViewById(R.id.id_editxt);
        password_editxt = (EditText) findViewById(R.id.password_editxt);
        passwordc_editxt = (EditText) findViewById(R.id.passwordc_editxt);
        name_editxt = (EditText) findViewById(R.id.name_editxt);
        birth_editxt = (EditText) findViewById(R.id.birth_editxt);
        phonenum_editxt = (EditText) findViewById(R.id.phonenum_editxt);
        email_editxt = (EditText) findViewById(R.id.email_editxt);
        address_editxt = (EditText) findViewById(R.id.address_editxt);
        check_bt = (Button) findViewById(R.id.check_bt);
        join_bt = (Button) findViewById(R.id.join_bt);
        male_bt = (RadioButton) findViewById(R.id.male_bt);
        female_bt = (RadioButton) findViewById(R.id.female_bt);

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
                        l = new Intent(getApplicationContext(), menu.class);
                        startActivity(l);
                        break;
                    case R.id.check_bt:
                        Toast.makeText(getApplicationContext(), "사용 가능한 아이디 입니다.", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), "사용이 불가능한 아이디 입니다.", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.join_bt:
                        m = new Intent(getApplicationContext(),login_page.class);
                        startActivity(m);
                        Toast.makeText(getApplicationContext(), "회원가입이 완료 되었습니다.", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };


        logo_bt.setOnClickListener(cl);
        notice_bt.setOnClickListener(cl);
        profile_bt.setOnClickListener(cl);
        menu_bt.setOnClickListener(cl);
        check_bt.setOnClickListener(cl);
        join_bt.setOnClickListener(cl);

    }
}
