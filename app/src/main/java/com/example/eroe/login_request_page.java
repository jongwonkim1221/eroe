package com.example.eroe;



import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response;
import java.util.HashMap;
import java.util.Map;

public class login_request_page  extends StringRequest {


// 서버 URL 설정 ( PHP 파일 연동 )
final static private String URL = "116.45.105.122/login.php";
private Map<String, String> map;


public login_request_page(String User_ID, String User_Password, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("User_ID",User_ID);
        map.put("User_Password", User_Password);

        }

@Override
protected Map<String, String> getParams() throws AuthFailureError {
        return map;
}
        };