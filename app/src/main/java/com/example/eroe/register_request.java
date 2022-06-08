package com.example.eroe;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class register_request extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://dbconnect.iptime.org/register.php";
    private Map<String, String> map;
    //private Map<String, String>parameters;


    public register_request(String User_ID, String User_Phonenum, String User_Address, int User_Email, int User_Password, String User_Name, int User_Birth, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("username", User_Name);
        map.put("userID", User_ID);
        map.put("useraddress", User_Address);

    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}