package com.example.eroe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.namespace.R;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;


public class location extends AppCompatActivity {

    ImageButton logo_bt, notice_bt, profile_bt, menu_bt, profile_bt3, imageButton;
    TextView textView5, textView6;
    ImageView imageView;
    Button button, button5, button6, button7;
    View.OnClickListener cl;
    Intent i, j, k, l, m, n, o, p, q, r;

    MapView mapview;
    RelativeLayout mapViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);

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

        mapview = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapview);

        /*마커 추가*/
        //마커 찍기
        MapPoint MARKER_POINT1 = MapPoint.mapPointWithGeoCoord(37.5666805, 126.9784147);
        // 마커 아이콘 추가하는 함수
        MapPOIItem marker1 = new MapPOIItem();
        // 클릭 했을 때 나오는 호출 값
        marker1.setItemName("현재 위치");
        // 왜 있는지 잘 모르겠음
        marker1.setTag(0);
        // 좌표를 입력받아 현 위치로 출력
        marker1.setMapPoint(MARKER_POINT1);
        //  (클릭 전)기본으로 제공하는 BluePin 마커 모양의 색.
        marker1.setMarkerType(MapPOIItem.MarkerType.RedPin);
        // (클릭 후) 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
        // 지도화면 위에 추가되는 아이콘을 추가하기 위한 호출(말풍선 모양)
        mapview.addPOIItem(marker1);

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
                    case R.id.profile_bt3:
                        m = new Intent(getApplicationContext(), user_info_page.class);
                        startActivity(m);
                        break;
                    case R.id.imageButton:
                        n = new Intent(getApplicationContext(), declaration_page.class);
                        startActivity(n);
                        break;
                    case R.id.button:
                        o = new Intent(getApplicationContext(), location.class);
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