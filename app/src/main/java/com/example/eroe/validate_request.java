package com.example.eroe;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class validate_request extends StringRequest {
    //서버 url 설정(php파일 연동)
    final static  private String URL="http://116.45.105.122/validate.php";
    private Map<String,String> map;

    public validate_request(String User_ID, Response.Listener<String>listener){
        super(Method.POST,URL,listener,null);

        map=new HashMap<>();
        map.put("User_ID",User_ID);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
