package com.example.bottonnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class SettingActivity extends AppCompatActivity {

    private TextView tv_set_id;
    private EditText et_set_pw, et_set_name, et_set_major, et_set_grade;
    private Button btn_save, btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        tv_set_id = findViewById(R.id.tv_set_id);
        et_set_pw = findViewById(R.id.et_set_pw);
        et_set_name = findViewById(R.id.et_set_name);
        et_set_major = findViewById(R.id.et_set_major);
        et_set_grade = findViewById(R.id.et_set_grade);

        btn_save = findViewById(R.id.btn_save);
        btn_cancel = findViewById(R.id.btn_cancel);
/*

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPw = intent.getStringExtra("userPw");
        String userName = intent.getStringExtra("userName");
        String userMajor = intent.getStringExtra("userMajor");
        int userGrade = Integer.parseInt(intent.getStringExtra("userGrade"));
        tv_set_id.setText(userID);
        et_set_pw.setText(userPw);
        et_set_pw.setText(userName);
        et_set_name.setText(userName);
        et_set_major.setText(userMajor);
        et_set_grade.setText(userGrade);

        btn_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String userName = et_set_name.getText().toString();
                String userPw = et_set_pw.getText().toString();
                String userMajor = et_set_major.getText().toString();
                int userGrade = Integer.parseInt(et_set_grade.getText().toString());


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "개인정보 수정에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else{
                                Toast.makeText(getApplicationContext(), "개인정보 수정에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(userID, userName, userPw, userMajor, userGrade, responseListener);
                RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                queue.add(registerRequest);

            }
        });
*/
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}