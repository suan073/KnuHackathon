package com.example.bottonnav;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    //구현 완료
    private EditText et_id, et_pw;
    private Button btn_login, btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_pw);

        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener(){
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                /*String userID = et_id.getText().toString();
                String userPw = et_pw.getText().toString();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                String userID = jsonObject.getString("userID");
                                String userPw = jsonObject.getString("userPassword");

                                Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show();

                                intent.putExtra("userID",userID);
                                intent.putExtra("userPassword",userPw);
                                startActivity(intent);
                            } else{
                                Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(userID, userPw, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);

            }
        });
    }
}