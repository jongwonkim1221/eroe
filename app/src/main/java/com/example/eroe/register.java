package com.example.eroe;



import androidx.appcompat.app.AlertDialog;
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
    boolean validate = false;
    AlertDialog dialog;
    Intent intent;

    //시발
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
        passwordc_editxt = findViewById(R.id.passwordc_editxt);
        phonenum_editxt = findViewById(R.id.phonenum_editxt);
        email_editxt = findViewById(R.id.email_editxt);
        address_editxt = findViewById(R.id.address_editxt);
        //아이디 중복확인 버튼 클릭 시 수행
        check_bt = findViewById(R.id.check_bt);
        check_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User_ID = id_editxt.getText().toString();
                if(validate)
                {
                    return;
                }
                if(User_ID.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                    dialog = builder.setMessage("아이디를 입력하세요.")
                            .setPositiveButton("확인",null)
                            .create();
                            dialog.show();
                            return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                                dialog = builder.setMessage("사용 불가능한 아이디 입니다.")
                                        .setPositiveButton("확인",null)
                                        .create();
                                dialog.show();
                                id_editxt.setEnabled(false);
                                validate = true;
                                check_bt.setText("확인");
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                                dialog = builder.setMessage("사용 가능한 아이디 입니다.")
                                        .setPositiveButton("확인",null)
                                        .create();
                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                validate_request validate_request=new validate_request(User_ID,responseListener);
                RequestQueue queue= Volley.newRequestQueue(register.this);
                queue.add(validate_request);
            }
        });

        // 회원가입 버튼 클릭 시 수행
        join_bt = findViewById(R.id.join_bt);
        join_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
                String User_ID = id_editxt.getText().toString();
                int User_Password = Integer.parseInt(password_editxt.getText().toString());
                String User_Name = name_editxt.getText().toString();
                String User_Password = password_editxt.getText().toString();
                String User_Name =name_editxt.getText().toString();
                int User_Birth = Integer.parseInt(birth_editxt.getText().toString());
                int User_Phonenum = Integer.parseInt(phonenum_editxt.getText().toString());
                String User_Email = email_editxt.getText().toString();
                String User_Address = address_editxt.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { // 회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(),"회원 등록에 성공하였습니다.",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(register.this, login_page.class);
                                startActivity(intent);
                            } else { // 회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(),"회원 등록에 실패하였습니다.",Toast.LENGTH_LONG).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                // 서버로 Volley를 이용해서 요청을 함.
                register_request registerRequest = new register_request(User_ID,User_Password,User_Name,User_Birth,User_Phonenum,User_Email,User_Address, responseListener);
                RequestQueue queue = Volley.newRequestQueue(register.this);
                queue.add(registerRequest);

            }
        });



    }
}
