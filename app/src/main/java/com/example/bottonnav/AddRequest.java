package com.example.bottonnav;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AddRequest extends StringRequest {
    //구현 완료
    // 서버 url 설정 (php 파일 연동)
    final static private String URL = "http://fourhae.dothome.co.kr/EventAdd.php";
    private Map<String, String> map;


    public AddRequest(String userID, int eventNum, Response.Listener<String> listener){
        super(Method.POST, URL,listener,null);

        map = new HashMap<>();
        map.put("userID",userID);
        map.put("userGrade",eventNum+"");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}