package com.example.eroe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.namespace.R;

import net.daum.mf.map.api.MapView;


public class MainActivity extends AppCompatActivity {

    ImageButton logo_bt, notice_bt, profile_bt, menu_bt, profile_bt3, imageButton;
    TextView textView5, textView6;
    ImageView imageView;
    Button button, button5, button6, button7;
    View.OnClickListener cl;
    Intent i, j, k, l, m, n, o, p, q, r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo_bt = (ImageButton) findViewById(R.id.logo_bt);
        notice_bt = (ImageButton) findViewById(R.id.notice_bt);
        profile_bt = (ImageButton) findViewById(R.id.profile_bt);
        menu_bt = (ImageButton) findViewById(R.id.menu_bt);
        profile_bt3 = (ImageButton) findViewById(R.id.profile_bt3);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        imageView = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.button);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);

        MapView mapview;
        mapview = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapview);

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
                    case R.id.profile_bt3:
                        m = new Intent(getApplicationContext(), user_info_page.class);
                        startActivity(m);
                        break;
                    case R.id.imageButton:
                        n = new Intent(getApplicationContext(), declaration_page.class);
                        startActivity(n);
                        break;
                    case R.id.button:
                        o = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(o);
                        break;
                    case R.id.button5:
                        p = new Intent(getApplicationContext(), user_info_modify_page.class);
                        startActivity(p);
                        break;
                    case R.id.button6:
                        q = new Intent(getApplicationContext(), declaration_page.class);
                        startActivity(q);
                        break;
                    case R.id.button7:
                        r = new Intent(getApplicationContext(), user_add_page.class);
                        startActivity(r);
                        //Toast.makeText(getApplicationContext(), "사용자 추가가 완료 되었습니다.", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };
        logo_bt.setOnClickListener(cl);
        notice_bt.setOnClickListener(cl);
        profile_bt.setOnClickListener(cl);
        menu_bt.setOnClickListener(cl);
        profile_bt3.setOnClickListener(cl);
        imageButton.setOnClickListener(cl);
        button.setOnClickListener(cl);
        button5.setOnClickListener(cl);
        button6.setOnClickListener(cl);
        button7.setOnClickListener(cl);
    }
}




//네이티브 키 값 : b9db38bdcbe294d8902eb53180f04402