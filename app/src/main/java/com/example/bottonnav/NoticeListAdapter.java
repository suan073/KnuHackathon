package com.example.bottonnav;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NoticeListAdapter extends BaseAdapter {

    private Context context;
    private List<Course> noticeList;

    public NoticeListAdapter(Context context, List<Course> noticeList) {
        this.context = context;
        this.noticeList = noticeList;
    }

    @Override
    public int getCount() {
        return noticeList.size();
    }

    @Override
    public Object getItem(int i) {
        return noticeList.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.notice,null);
        TextView eventGrade=(TextView) v.findViewById(R.id.eventGrade);
        TextView eventMajor=(TextView) v.findViewById(R.id.eventMajor);
        TextView eventName=(TextView) v.findViewById(R.id.eventName);
        TextView eResEndMonth=(TextView) v.findViewById(R.id.eResEndMonth);
        TextView eResEndDay=(TextView) v.findViewById(R.id.eResEndDay);
        TextView eventType=(TextView) v.findViewById(R.id.eventType);

        eventGrade.setText("관련학년: "+Integer.toString(noticeList.get(i).getEventGrade())+"학년");
        eventMajor.setText("  단대:"+noticeList.get(i).getEventMajor()+"대학");

        eventName.setText(noticeList.get(i).getEventName());

        eResEndMonth.setText("신청마감:"+Integer.toString(noticeList.get(i).geteResEndMonth())+"/");
        eResEndDay.setText(Integer.toString(noticeList.get(i).geteResEndDay()));

        eventType.setText("  분류:"+noticeList.get(i).getEventType());

        return v;
    }
}
