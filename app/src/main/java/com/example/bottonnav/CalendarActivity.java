package com.example.bottonnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class CalendarActivity extends AppCompatActivity {

    private static final String TAG = "CalendarActivity";
    private CalendarView cv;
    private Button add;
    private int theDay, theMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        cv = (CalendarView) findViewById(R.id.cv);
        add = findViewById(R.id.btn_add);

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                theDay = dayOfMonth;
                theMonth = month;
                String date = (month+1) + "/" + dayOfMonth + "/" + year;
                Log.d(TAG, "onSelectedDayChange: mm/dd/yyyy: " + date);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarActivity.this, AddActivity.class);
                intent.putExtra("month", theMonth);
                intent.putExtra("day", theDay);
                startActivity(intent);
            }
        });
    }
}