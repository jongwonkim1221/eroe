package com.example.eroe;



import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response;
import java.util.HashMap;
import java.util.Map;

public class login_request_page  extends StringRequest {


// 서버 URL 설정 ( PHP 파일 연동 )
final static private String URL = "http://dbconnect.iptime.org/phpmyadmin//login.php";
private Map<String, String> map;


public login_request_page(String userID, String userPassword, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword", userPassword);

        }

@Override
protected Map<String, String> getParams() throws AuthFailureError {
        return map;
}
        };