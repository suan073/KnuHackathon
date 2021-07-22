package com.example.bottonnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class LinkActivity extends AppCompatActivity {

    private Button btn_web1, btn_web2, btn_web3, btn_web4, btn_web5, btn_web6;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        btn_web1 = findViewById(R.id.btn_web1);
        btn_web2 = findViewById(R.id.btn_web2);
        btn_web3 = findViewById(R.id.btn_web3);
        btn_web4 = findViewById(R.id.btn_web4);
        btn_web5 = findViewById(R.id.btn_web5);
        btn_web6 = findViewById(R.id.btn_web6);


        btn_web1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                url = "https://www.knu.ac.kr/";
                Intent intent = new Intent(LinkActivity.this, webView.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        btn_web2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                url = "https://my.knu.ac.kr/stpo/comm/support/loginPortal/loginForm.action?redirUrl=%2Fstpo%2Fstpo%2Fmain%2Fmain.action";
                Intent intent = new Intent(LinkActivity.this, webView.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        btn_web3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                url = "http://kyungpook.kr/wbbs/wbbs/bbs/btin/list.action?bbs_cde=1&menu_idx=67";
                Intent intent = new Intent(LinkActivity.this, webView.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        btn_web4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                url = "http://kyungpook.kr/wbbs/wbbs/bbs/btin/list.action?bbs_cde=11&menu_idx=73";
                Intent intent = new Intent(LinkActivity.this, webView.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        btn_web5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                url = "http://kyungpook.kr/wbbs/wbbs/bbs/btin/list.action?bbs_cde=12&menu_idx=74";
                Intent intent = new Intent(LinkActivity.this, webView.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        btn_web6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                url = "https://ssw.knu.ac.kr/";
                Intent intent = new Intent(LinkActivity.this, webView.class);
                startActivity(intent);
            }
        });
    }
}