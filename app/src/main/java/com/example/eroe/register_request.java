package com.example.eroe;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class register_request extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://116.45.105.122/register.php";
    private Map<String, String> map;
    //private Map<String, String>parameters;


    public register_request(String User_ID, String User_Password, String User_Name,String User_Birth, String User_Phonenum, String User_Email, String User_Address, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();

        map.put("User_ID", User_ID);
        map.put("User_Password", User_Password);
        map.put("User_Name", User_Name);
        map.put("User_Birth", User_Birth);
        map.put("User_Phonenum", User_Phonenum);
        map.put("User_Email", User_Email);
        map.put("User_Address", User_Address);

    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}