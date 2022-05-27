package com.example.eroe;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class register_request extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://dbconnect.iptime.org/Register.php";
    private Map<String, String> map;
    //private Map<String, String>parameters;

    public register_request(String userID, String userphonenum, String useraddress, int useremail, int userpassword, String username, int userbirth, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("username", username);
        map.put("userID", userID);
        map.put("useraddress", useraddress);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}