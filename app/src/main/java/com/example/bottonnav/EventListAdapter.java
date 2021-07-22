package com.example.bottonnav;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class EventListAdapter extends BaseAdapter {

    private Context context;
    private List<DayEventList> eventList;

    public EventListAdapter(Context context, List<DayEventList> eventList) {
        this.context = context;
        this.eventList = eventList;
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
    public View getView(int i, View convertView, ViewGroup parent) {
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

        eResEndMonth.setText("신청마감:"+eventList.get(i).geteResEndMonth()+"/");
        eResEndDay.setText(eventList.get(i).geteResEndDay());

        eventType.setText("  분류:"+eventList.get(i).getEventType());

        return v;
    }
}
