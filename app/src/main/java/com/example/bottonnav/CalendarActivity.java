package com.example.bottonnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

public class CalendarActivity extends AppCompatActivity {

    private CalendarView cv;
    private Button btn_add;
    private int theDay, theMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_calendar);

        cv = (CalendarView) findViewById(R.id.cv);
        btn_add = (Button) findViewById(R.id.btn_add);

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(), "!", Toast.LENGTH_LONG).show();
                //String date = (month+1) + "/" + dayOfMonth + "/" + year;

                theDay = dayOfMonth;
                theMonth = month;

                //Toast.makeText(getApplicationContext(), date, Toast.LENGTH_LONG).show();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = (theMonth+1) + "/" + theDay;
                Toast.makeText(getApplicationContext(), date, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(CalendarActivity.this, AddActivity.class);
                intent.putExtra("month", theMonth);
                intent.putExtra("day", theDay);
                startActivity(intent);
            }
        });
    }
}