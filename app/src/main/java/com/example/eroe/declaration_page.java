package com.example.eroe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class declaration_page extends AppCompatActivity {

    ImageButton logo_bt, notice_bt, profile_bt, menu_bt, police_dec, embluance_dec;
    View.OnClickListener cl;
    Intent i, j, k, l;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.declaration_page);

        logo_bt = (ImageButton) findViewById(R.id.logo_bt);
        notice_bt = (ImageButton) findViewById(R.id.notice_bt);
        profile_bt = (ImageButton) findViewById(R.id.profile_bt);
        menu_bt = (ImageButton) findViewById(R.id.menu_bt);
        police_dec = (ImageButton) findViewById(R.id.police_dec);
        embluance_dec = (ImageButton) findViewById(R.id.embluance_dec);

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
                    case R.id.police_dec:
                        Intent pIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:112"));
                        startActivity(pIntent);
                        break;
                    case R.id.embluance_dec:
                        Intent eIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:119"));
                        startActivity(eIntent);
                        break;
                }
            }
        };
        logo_bt.setOnClickListener(cl);
        notice_bt.setOnClickListener(cl);
        profile_bt.setOnClickListener(cl);
        menu_bt.setOnClickListener(cl);
        police_dec.setOnClickListener(cl);
        embluance_dec.setOnClickListener(cl);
    }
}
