package com.example.eroe;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class location_request extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://116.45.105.122/register.php";
    private Map<String, String> map;
    //private Map<String, String>parameters;


    public location_request(String member_number, String beacon_number, String member_latitude,String member_longtitude, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();

        map.put("member_number", member_number);
        map.put("beacon_number", beacon_number);
        map.put("member_latitude", member_latitude);
        map.put("member_longtitude", member_longtitude);

    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}
