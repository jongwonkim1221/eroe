package com.example.eroe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.namespace.R;

import org.json.JSONException;
import org.json.JSONObject;


public class login_page extends AppCompatActivity {
    ImageView menu_bt, notice_bt, profile_bt, logo_bt;
    EditText input_id, input_pw;
    TextView login_txt, id_txt, password_txt;
    Button find_id, find_pw, login_bt, signup_bt;
    View.OnClickListener cl;
    Intent i, j, k, l,a,m;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        menu_bt = (ImageView) findViewById(R.id.menu_bt);
        notice_bt = (ImageView) findViewById(R.id.notice_bt);
        profile_bt = (ImageView) findViewById(R.id.profile_bt);
        logo_bt = (ImageView) findViewById(R.id.logo_bt);
        input_id = (EditText) findViewById(R.id.input_id);
        input_pw = (EditText) findViewById(R.id.input_pw);
        login_txt = (TextView) findViewById(R.id.login_txt);
        id_txt = (TextView) findViewById(R.id.id_txt);
        password_txt = (TextView) findViewById(R.id.password_txt);
        find_id = (Button) findViewById(R.id.find_id);
        find_pw = (Button) findViewById(R.id.find_pw);
        login_bt = (Button) findViewById(R.id.login_bt);
        signup_bt = (Button) findViewById(R.id.signup_bt);

        input_id = findViewById(R.id.input_id);
        input_pw = findViewById(R.id.input_pw);
        login_bt = findViewById(R.id.login_bt);
        signup_bt = findViewById(R.id.signup_bt);



        // 회원가입 버튼을 클릭 시 수행
        signup_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login_page.this, register.class);
                startActivity(intent);
            }
        });

        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
                String userID = input_id.getText().toString();
                String userPass = input_pw.getText().toString();
//
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            // TODO : 인코딩 문제때문에 한글 DB인 경우 로그인 불가
                            System.out.println("sungbeom" + response);
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { // 로그인에 성공한 경우
                                String userID = jsonObject.getString("userID");
                                String userPass = jsonObject.getString("userPassword");

                                Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                intent.putExtra("userID", userID);
                                intent.putExtra("userPass", userPass);
                                startActivity(intent);
                            } else { // 로그인에 실패한 경우
                                Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                login_request_page loginRequest = new login_request_page(userID, userPass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(login_page.this);
                queue.add(loginRequest);
            }
        });


                find_id.setOnClickListener(new View.OnClickListener() {
                     @Override
                    public void onClick(View view) {
                     Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                find_pw.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });


            }

        });
    find_id.setOnClickListener(cl);
    signup_bt.setOnClickListener(cl);
    login_bt.setOnClickListener(cl);
    find_pw.setOnClickListener(cl);
    }

        }


