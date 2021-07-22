package com.example.bottonnav;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentPage2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPage2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentPage2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPage2.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentPage2 newInstance(String param1, String param2) {
        FragmentPage2 fragment = new FragmentPage2();
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

    private ArrayAdapter gradeAdapter;
    private Spinner gradeSpinner;
    private ArrayAdapter colleAdapter;
    private Spinner colleSpinner;

    private String allorchoo;

    @Override
    public void onActivityCreated(Bundle b){
        super.onActivityCreated(b);
        final RadioGroup ragroup = (RadioGroup) getView().findViewById(R.id.ragroup);
        gradeSpinner = (Spinner) getView().findViewById(R.id.grade);
        colleSpinner = (Spinner) getView().findViewById(R.id.coll);

        ragroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i){
                RadioButton rab=(RadioButton) getView().findViewById(i);
                allorchoo=rab.getText().toString();

                if (allorchoo.equals("선택")) {
                   gradeAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.grade, android.R.layout.simple_dropdown_item_1line);
                    gradeSpinner.setAdapter(gradeAdapter);

                    colleAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.colle, android.R.layout.simple_dropdown_item_1line);
                    colleSpinner.setAdapter(colleAdapter);
                }
            }
        });

        Button search = (Button)getView().findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new BackgroundTask().execute();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page2, container, false);
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            try {
                target = "http://fourhae.dothome.co.kr/Event.php?eventGrade="+ URLEncoder.encode(gradeSpinner.getSelectedItem().toString(), "UTF-8")
                        +URLEncoder.encode(colleSpinner.getSelectedItem().toString(), "UTF-8");

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine())!= null){
                    stringBuilder.append(temp+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate();
        }

        @Override
        protected void onPostExecute(String result) {
            try{
                AlertDialog dialog;
                AlertDialog.Builder builder = new AlertDialog.Builder(FragmentPage2.this.getContext());
                dialog = builder.setMessage(result).setPositiveButton("확인", null).create();
                dialog.show();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}