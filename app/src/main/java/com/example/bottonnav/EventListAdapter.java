package com.example.bottonnav;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class EventListAdapter extends BaseAdapter {

    private Context context;
    private List<DayEventList> eventList;
    private Fragment parent;

    public EventListAdapter(Context context, List<DayEventList> eventList, Fragment parent) {
        this.context = context;
        this.eventList = eventList;
        this.parent = parent;
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int i) {
        return eventList.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.day_event_list,null);
        TextView eventGrade=(TextView) v.findViewById(R.id.eventGrade);
        TextView eventMajor=(TextView) v.findViewById(R.id.eventMajor);
        TextView eventName=(TextView) v.findViewById(R.id.eventName);
        TextView eResEndMonth=(TextView) v.findViewById(R.id.eResEndMonth);
        TextView eResEndDay=(TextView) v.findViewById(R.id.eResEndDay);
        TextView eventType=(TextView) v.findViewById(R.id.eventType);

        eventGrade.setText("관련학년: "+eventList.get(i).getEventGrade()+"학년");
        eventMajor.setText("  단대:"+eventList.get(i).getEventMajor());

        eventName.setText(eventList.get(i).getEventName());

        eResEndMonth.setText("신청마감:"+eventList.get(i).geteResEndMonth()+" /");
        eResEndDay.setText(eventList.get(i).geteResEndDay());

        eventType.setText("  분류:"+eventList.get(i).getEventType());

        Button addButton = (Button)v.findViewById(R.id.addb);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = MainActivity.userID;
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                // 서버로 volley를 이용하여 요청을 함.
                AddRequest AddRequest = new AddRequest(userID,eventList.get(i).getEventNum(),responseListener);
                RequestQueue queue = Volley.newRequestQueue(parent.getActivity());
                queue.add(AddRequest);
            }
        });


        return v;
    }
}
