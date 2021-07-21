package com.example.bottonnav;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_reg_id, et_reg_pw, et_reg_name, et_reg_major, et_reg_grade;
    private Button btn_assign, btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 아이디 값 찾아주기
        et_reg_id = findViewById(R.id.et_reg_id);
        et_reg_pw = findViewById(R.id.et_reg_pw);
        et_reg_name = findViewById(R.id.et_reg_name);
        et_reg_major = findViewById(R.id.et_reg_major);
        et_reg_grade = findViewById(R.id.et_reg_grade);

        btn_assign = findViewById(R.id.btn_assign);
        btn_cancel = findViewById(R.id.btn_cancel);

        btn_cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        // 회원가입 확인 버튼 클릭시 수행
        btn_assign.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //현재 입력되어 있는 것을 가져온다
                String userID = et_reg_id.getText().toString();
                String userName = et_reg_name.getText().toString();
                String userPassword = et_reg_pw.getText().toString();
                String userMajor = et_reg_major.getText().toString();
                int userGrade = Integer.parseInt(et_reg_grade.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "회원 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else{
                                Toast.makeText(getApplicationContext(), "회원 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                // 서버로 volley를 이용하여 요청을 함.
                RegisterRequest registerRequest = new RegisterRequest(userID, userName, userPassword, userMajor, userGrade, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);

            }
        });


    }
}
