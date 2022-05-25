package com.example.eroe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class user_info_modify_page extends AppCompatActivity {

    ImageButton logo_bt, notice_bt, profile_bt, menu_bt;
    TextView modify_txt, name_txt, birth_txt, gender_txt, phonenum_txt, address_txt;
    EditText name_editxt, birth_editxt, phonenum_editxt, address_editxt;
    Button storage_bt;
    View.OnClickListener cl;
    Intent i, j, k, l, m;

    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.user_info_modify_page);

        logo_bt = (ImageButton) findViewById(R.id.logo_bt);
        notice_bt = (ImageButton) findViewById(R.id.notice_bt);
        profile_bt = (ImageButton) findViewById(R.id.profile_bt);
        menu_bt = (ImageButton) findViewById(R.id.menu_bt);
        modify_txt = (TextView) findViewById(R.id.modify_txt);
        name_txt = (TextView) findViewById(R.id.name_txt);
        birth_txt = (TextView) findViewById(R.id.birth_txt);
        gender_txt = (TextView) findViewById(R.id.gender_txt);
        phonenum_txt = (TextView) findViewById(R.id.phonenum_txt);
        address_txt = (TextView) findViewById(R.id.address_txt);
        name_editxt = (EditText) findViewById(R.id.name_editxt);
        birth_editxt = (EditText) findViewById(R.id.birth_editxt);
        phonenum_editxt = (EditText) findViewById(R.id.phonenum_editxt);
        address_editxt = (EditText) findViewById(R.id.address_editxt);
        storage_bt = (Button) findViewById(R.id.storage_bt);

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
                    case R.id.storage_bt:
                        m = new Intent(getApplicationContext(), user_info_page.class);
                        startActivity(m);
                        Toast.makeText(getApplicationContext(), "사용자 정보 수정이 완료 되었습니다.", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };
        logo_bt.setOnClickListener(cl);
        notice_bt.setOnClickListener(cl);
        profile_bt.setOnClickListener(cl);
        menu_bt.setOnClickListener(cl);
        storage_bt.setOnClickListener(cl);
    }
}
