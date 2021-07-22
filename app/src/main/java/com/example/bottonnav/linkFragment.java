package com.example.bottonnav;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link linkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class linkFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public linkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment linkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static linkFragment newInstance(String param1, String param2) {
        linkFragment fragment = new linkFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private Button btn_web1, btn_web2, btn_web3, btn_web4, btn_web5, btn_web6;
    private String url;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //setContentView(R.layout.activity_web_view);

        btn_web1 = (Button)getView().findViewById(R.id.btn_web1);
        btn_web2 = (Button)getView().findViewById(R.id.btn_web2);
        btn_web3 = (Button)getView().findViewById(R.id.btn_web3);
        btn_web4 = (Button)getView().findViewById(R.id.btn_web4);
        btn_web5 = (Button)getView().findViewById(R.id.btn_web5);
        btn_web6 = (Button)getView().findViewById(R.id.btn_web6);


        btn_web1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                //Toast.makeText(getApplicationContext(), "!", Toast.LENGTH_LONG).show();
                url = "https://www.knu.ac.kr/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        btn_web2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                url = "https://my.knu.ac.kr/stpo/comm/support/loginPortal/loginForm.action?redirUrl=%2Fstpo%2Fstpo%2Fmain%2Fmain.action";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        btn_web3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                url = "http://kyungpook.kr/wbbs/wbbs/bbs/btin/list.action?bbs_cde=1&menu_idx=67";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        btn_web4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                url = "http://kyungpook.kr/wbbs/wbbs/bbs/btin/list.action?bbs_cde=11&menu_idx=73";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        btn_web5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                url = "http://kyungpook.kr/wbbs/wbbs/bbs/btin/list.action?bbs_cde=12&menu_idx=74";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });

        btn_web6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                url = "https://ssw.knu.ac.kr/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_link, container, false);
    }
}