package com.example.bottonnav;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calendarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public calendarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment calendarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static calendarFragment newInstance(String param1, String param2) {
        calendarFragment fragment = new calendarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private CalendarView cv;
    private int theDay, theMonth;
    private ListView listView;
    private EventListAdapter adapter;
    private List<DayEventList> dayEventLists;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        cv = (CalendarView) getView().findViewById(R.id.cv);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //String date = (month+1) + "/" + dayOfMonth + "/" + year;

                theDay = dayOfMonth;
                theMonth = month;

                //Toast.makeText(getApplicationContext(), date, Toast.LENGTH_LONG).show();
            }
        });


        listView = (ListView)getView().findViewById(R.id.listview);
        dayEventLists = new ArrayList<DayEventList>();
        adapter = new EventListAdapter(getContext().getApplicationContext(), dayEventLists);
        listView.setAdapter(adapter);
*/

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    /*
    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);





    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }
    /*
    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            try {
                target = "";

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
                dayEventLists.clear();
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                String userID;
                int count = 0;
                int eventNum;
                String eventName;
                String eventType;
                int eResStartMonth;
                int eResEndMonth;
                int eResStartDay;
                int eResEndDay;
                int eProStartMonth;
                int eProEndMonth;
                int eProStartDay;
                int eProEndDay;
                String eventMajor;
                int eventGrade;
                String eventDetail;
                String eventLink;
                while(count<jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    userID = object.getString("userID");
                    eventNum = object.getInt("eventNum");
                    eventName = object.getString("eventName");
                    eventType = object.getString("eventType");
                    eResStartMonth = object.getInt("eResStartMonth");
                    eResEndMonth = object.getInt("eResEndMonth");
                    eResStartDay = object.getInt("eResStartDay");
                    eResEndDay = object.getInt("eResEndDay");
                    eProStartMonth = object.getInt("eProStartMonth");
                    eProEndMonth = object.getInt("eProEndMonth");
                    eProStartDay = object.getInt("eProStartDay");
                    eProEndDay = object.getInt("eProEndDay");
                    eventMajor = object.getString("eventMajor");
                    eventGrade = object.getInt("eventGrade");
                    eventDetail = object.getString("eventDetail");
                    eventLink = object.getString("eventLink");
                    DayEventList event = new DayEventList(userID, eventNum, eventName, eventType, eResStartMonth, eResEndMonth, eResStartDay, eResEndDay, eProStartMonth, eProEndMonth, eProStartDay, eProEndDay, eventMajor, eventGrade, eventDetail, eventLink);
                    dayEventLists.add(event);
                    count++;
                }

                if(count == 0){
                    AlertDialog dialog;
                    AlertDialog.Builder builder = new AlertDialog.Builder(calendarFragment.this.getActivity());
                    dialog = builder.setMessage("조회된 행사가 없습니다.").setPositiveButton("확인", null).create();
                    dialog.show();
                }
                adapter.notifyDataSetChanged();

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }*/
}