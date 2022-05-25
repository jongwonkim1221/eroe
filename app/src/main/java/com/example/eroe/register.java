package com.example.eroe;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.namespace.R;

import org.json.JSONException;
import org.json.JSONObject;

public class register extends AppCompatActivity {
    ImageButton logo_bt, notice_bt, profile_bt, menu_bt;
    TextView modify_txt, id_txt, password_txt, passwordc_txt, name_txt, birth_txt, gender_txt, phonenum_txt, email_txt, address_txt;
    EditText id_editxt, password_editxt, passwordc_editxt, name_editxt, birth_editxt, phonenum_editxt, email_editxt, address_editxt;
    Button check_bt, join_bt;
    RadioButton male_bt, female_bt;
    View.OnClickListener cl;
    Intent i, j, k, l, m;
    String userid, userpassword, username, userbirth, userphonenum, useremail, useraddress;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.register);

        logo_bt = (ImageButton) findViewById(R.id.logo_bt);
        notice_bt = (ImageButton) findViewById(R.id.notice_bt);
        profile_bt = (ImageButton) findViewById(R.id.profile_bt);
        menu_bt = (ImageButton) findViewById(R.id.menu_bt);
        modify_txt = (TextView) findViewById(R.id.modify_txt);
        id_txt = (TextView) findViewById(R.id.id_txt);
        password_txt = (TextView) findViewById(R.id.password_txt);
        passwordc_txt = (TextView) findViewById(R.id.passwordc_txt);
        name_txt = (TextView) findViewById(R.id.name_txt);
        birth_txt = (TextView) findViewById(R.id.birth_txt);
        gender_txt = (TextView) findViewById(R.id.gender_txt);
        phonenum_txt = (TextView) findViewById(R.id.phonenum_txt);
        email_txt = (TextView) findViewById(R.id.email_txt);
        address_txt = (TextView) findViewById(R.id.address_txt);
        id_editxt = (EditText) findViewById(R.id.id_editxt);
        password_editxt = (EditText) findViewById(R.id.password_editxt);
        passwordc_editxt = (EditText) findViewById(R.id.passwordc_editxt);
        name_editxt = (EditText) findViewById(R.id.name_editxt);
        birth_editxt = (EditText) findViewById(R.id.birth_editxt);
        phonenum_editxt = (EditText) findViewById(R.id.phonenum_editxt);
        email_editxt = (EditText) findViewById(R.id.email_editxt);
        address_editxt = (EditText) findViewById(R.id.address_editxt);
        check_bt = (Button) findViewById(R.id.check_bt);
        join_bt = (Button) findViewById(R.id.join_bt);
        male_bt = (RadioButton) findViewById(R.id.male_bt);
        female_bt = (RadioButton) findViewById(R.id.female_bt);

        // 아이디 값 찾아주기
        id_editxt = findViewById(R.id.id_editxt);
        password_editxt = findViewById(R.id.password_editxt);
        name_editxt = findViewById(R.id.name_editxt);
        birth_editxt = findViewById(R.id.birth_editxt);

        // 회원가입 버튼 클릭 시 수행
        join_bt = findViewById(R.id.join_bt);
        join_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
                String userID = id_editxt.getText().toString();
                String userPass = password_editxt.getText().toString();
                String userName =name_editxt.getText().toString();
                int userAge = Integer.parseInt(birth_editxt.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { // 회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(),"회원 등록에 성공하였습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(register.this, login_page.class);
                                startActivity(intent);
                            } else { // 회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(),"회원 등록에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                // 서버로 Volley를 이용해서 요청을 함.
                register_request registerRequest = new register_request(userID,userPass,userName,userAge, responseListener);
                RequestQueue queue = Volley.newRequestQueue(register.this);
                queue.add(registerRequest);

            }
        });

    }
}
