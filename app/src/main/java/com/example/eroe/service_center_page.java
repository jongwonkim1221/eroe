package com.example.eroe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.namespace.R;

public class service_center_page extends AppCompatActivity {

    ImageButton logo_bt, notice_bt, profile_bt, menu_bt;
    Button qna_bt, inquiry_bt, call_bt;
    TextView customer_txt;
    View.OnClickListener cl;
    Intent i, j, k, l, m, n, o;


    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.service_center_page);

        logo_bt = (ImageButton) findViewById(R.id.logo_bt);
        notice_bt = (ImageButton) findViewById(R.id.notice_bt);
        profile_bt = (ImageButton) findViewById(R.id.profile_bt);
        menu_bt = (ImageButton) findViewById(R.id.menu_bt);
        qna_bt = (Button) findViewById(R.id.qna_bt);
        inquiry_bt = (Button) findViewById(R.id.inquiry_bt);
        call_bt = (Button) findViewById(R.id.call_bt);
        customer_txt = (TextView) findViewById(R.id.customer_txt);

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
                    case R.id. qna_bt:
                        m = new Intent(getApplicationContext(),qna_page.class);
                        startActivity(m);
                        break;
                    case R.id.inquiry_bt:
                        n = new Intent(getApplicationContext(),inquiry_page.class);
                        startActivity(n);
                        break;
                    case R.id.call_bt:
                        Intent cIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:02-1688-0000"));
                        startActivity(cIntent);
                }
            }
        };

        logo_bt.setOnClickListener(cl);
        notice_bt.setOnClickListener(cl);
        profile_bt.setOnClickListener(cl);
        menu_bt.setOnClickListener(cl);
        qna_bt.setOnClickListener(cl);
        inquiry_bt.setOnClickListener(cl);
        call_bt.setOnClickListener(cl);
    }
}
