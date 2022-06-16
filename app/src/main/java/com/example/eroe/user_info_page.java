package com.example.eroe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.namespace.R;

public class user_info_page extends AppCompatActivity {

    ImageButton logo_bt, notice_bt, profile_bt, menu_bt, photo_bt;
    Button bt1, bt2, bt3, bt4;
    TextView parent_txt, txt1, txt2, txt3, txt4;
    ImageView iv1, iv2;
    View.OnClickListener cl;
    Intent i, j, k, l, m, n, o, p;


    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.user_info_page);

        logo_bt = (ImageButton) findViewById(R.id.logo_bt);
        notice_bt = (ImageButton) findViewById(R.id.notice_bt);
        profile_bt = (ImageButton) findViewById(R.id.profile_bt);
        menu_bt = (ImageButton) findViewById(R.id.menu_bt);
        photo_bt = (ImageButton) findViewById(R.id.photo_bt);
        iv1 = (ImageView) findViewById(R.id.imageView1);
        txt1 = (TextView) findViewById(R.id.textView1);
        txt2 = (TextView) findViewById(R.id.textView2);
        txt3 = (TextView) findViewById(R.id.textView3);
        txt4 = (TextView) findViewById(R.id.textView4);
        bt1 = (Button) findViewById(R.id.button1);
        bt2 = (Button) findViewById(R.id.button2);
        parent_txt = (TextView) findViewById(R.id.parent_txt);

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
                    case R.id.button1:
                        m = new Intent(getApplicationContext(), location.class);
                        startActivity(m);
                        break;
                    case R.id.button2:
                        n = new Intent(getApplicationContext(), setting_page.class);
                        startActivity(n);
                        break;

                }
            }
        };
        logo_bt.setOnClickListener(cl);
        notice_bt.setOnClickListener(cl);
        profile_bt.setOnClickListener(cl);
        menu_bt.setOnClickListener(cl);
        bt1.setOnClickListener(cl);
        bt2.setOnClickListener(cl);
        bt3.setOnClickListener(cl);
        bt4.setOnClickListener(cl);
    }
}
