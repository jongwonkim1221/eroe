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
    EditText id_editxt, password_editxt, passwc, name_editxt, birth_editxt, phonenum_editxt, email_editxt, address_editxt;
    Button check_bt, join_bt;
    RadioButton male_bt, female_bt;
    boolean validate = false;
    AlertDialog dialog;
    Intent intent;


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
        passwc = (EditText) findViewById(R.id.passwc);
        name_editxt = (EditText) findViewById(R.id.name_editxt);
        birth_editxt = (EditText) findViewById(R.id.birth_editxt);
        phonenum_editxt = (EditText) findViewById(R.id.phonenum_editxt);
        email_editxt = (EditText) findViewById(R.id.email_editxt);
        address_editxt = (EditText) findViewById(R.id.address_editxt);
        check_bt = (Button) findViewById(R.id.check_bt);
        join_bt = (Button) findViewById(R.id.join_bt);
        male_bt = (RadioButton) findViewById(R.id.male_bt);
        female_bt = (RadioButton) findViewById(R.id.female_bt);

        // ????????? ??? ????????????
        id_editxt = findViewById(R.id.id_editxt);
        password_editxt = findViewById(R.id.password_editxt);
        name_editxt = findViewById(R.id.name_editxt);
        birth_editxt = findViewById(R.id.birth_editxt);
        passwc = findViewById(R.id.passwc);
        phonenum_editxt = findViewById(R.id.phonenum_editxt);
        email_editxt = findViewById(R.id.email_editxt);
        address_editxt = findViewById(R.id.address_editxt);
        //????????? ???????????? ?????? ?????? ??? ??????
        check_bt = findViewById(R.id.check_bt);
        check_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User_ID = id_editxt.getText().toString();
                if(validate) {
                    return;
                }
                if(User_ID.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                    dialog = builder.setMessage("???????????? ???????????????.").setPositiveButton("??????",null).create();
                            dialog.show();
                            return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                                dialog = builder.setMessage("?????? ????????? ??????????????????.").setPositiveButton("??????",null).create();
                                dialog.show();
                                id_editxt.setEnabled(false);
                                validate = true;
                                //check_bt.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                                dialog = builder.setMessage("?????? ???????????? ????????? ?????????.")
                                        .setNegativeButton("??????",null)
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

        // ???????????? ?????? ?????? ??? ??????
        join_bt = findViewById(R.id.join_bt);
        join_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText??? ?????? ?????????????????? ?????? get(????????????)?????????.
                final String User_ID = id_editxt.getText().toString();
                final String User_Password = password_editxt.getText().toString();
                final String User_Name = name_editxt.getText().toString();
                final String User_Birth = birth_editxt.getText().toString();
                final String User_Phonenum = phonenum_editxt.getText().toString();
                final String User_Email = email_editxt.getText().toString();
                final String User_Address = address_editxt.getText().toString();
                final String passwc = passwordc_txt.getText().toString();


                //????????? ???????????? ????????? ??????
                if (!validate) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                    dialog = builder.setMessage("????????? ???????????? ????????? ???????????????.").setNegativeButton("??????", null).create();
                    dialog.show();
                    return;
                }

                //??? ???????????? ?????? ????????? ??????
                if (User_ID.equals("") || User_Password.equals("") || User_Name.equals("") || User_Birth.equals("") || User_Phonenum.equals("") || User_Email.equals("") || User_Address.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                    dialog = builder.setMessage("?????? ??????????????????.").setNegativeButton("??????", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            //???????????? ?????????
                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                                builder.setMessage("?????? ????????? ??????????????????.")
                                        .setPositiveButton("??????", null)
                                        .create()
                                        .show();
                                Intent intent = new Intent(register.this, login_page.class);
                                register.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                                builder.setMessage("?????? ????????? ??????????????????.")
                                        .setNegativeButton("?????? ??????", null)
                                        .create()
                                        .show();
                            }
                        }


                         catch (JSONException e)
                         {
                            e.printStackTrace();
                        }

                    }
                };

                //????????? Volley??? ???????????? ??????
                register_request registerRequest = new register_request( User_ID, User_Password, User_Name,User_Birth,User_Phonenum,User_Email,User_Address, responseListener);
                RequestQueue queue = Volley.newRequestQueue( register.this );
                queue.add( registerRequest );
            }
        });
    }
}


//
//                Response.Listener<String> responseListener = new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            JSONObject jsonObject = new JSONObject(response);
//                            boolean success = jsonObject.getBoolean("success");
//                            if (success) { // ??????????????? ????????? ??????
//                                Toast.makeText(getApplicationContext(),"?????? ????????? ?????????????????????.",Toast.LENGTH_LONG).show();
//                                Intent intent = new Intent(register.this, login_page.class);
//                                startActivity(intent);
//                            } else { // ??????????????? ????????? ??????
//                                Toast.makeText(getApplicationContext(),"?????? ????????? ?????????????????????.",Toast.LENGTH_LONG).show();
//                                return;
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                };
//                // ????????? Volley??? ???????????? ????????? ???.
//                register_request registerRequest = new register_request(User_ID,User_Password,User_Name,User_Birth,User_Phonenum,User_Email,User_Address, responseListener);
//                RequestQueue queue = Volley.newRequestQueue(register.this);
//                queue.add(registerRequest);
//
//            }
//        });
//
//
//
//    }
//}
