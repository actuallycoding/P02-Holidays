package com.example.a15017484.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    TextView tv;
    ArrayAdapter aa;
    ArrayList<Holiday> holiday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lv = (ListView)findViewById(R.id.lv1);
        tv = (TextView)findViewById(R.id.textView);

        Intent i = getIntent();
        String type = i.getStringExtra("type");
        tv.setText(type);
        holiday = new ArrayList<Holiday>();
        if(type.equalsIgnoreCase("secular")){
            holiday.add(new Holiday("New Year's Day","1 Jan 2017",type,"New Year is the time at which a new calendar year begins and the calendar's year count increments by one.",true));
            holiday.add(new Holiday("Labour Day","1 May 2017",type,"Labour Day is an annual holiday to celebrate the achievements of workers.",false));
        } else {
            holiday.add(new Holiday("Chinese New Year","28-29 Jan 2017",type,"Chinese New Year, also known as the \"Spring Festival\" in modern Mainland China, is an important Chinese festival celebrated at the turn of the traditional lunisolar Chinese calendar.",true));
            holiday.add(new Holiday("Good Friday","14 April 2017",type,"Good Friday is a Christian holiday commemorating the crucifixion of Jesus Christ and his death at Calvary.",false));
        }
        aa = new HolidayAdapter(this, R.layout.row, holiday);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHoliday = holiday.get(position);

                Toast.makeText(SecondActivity.this, selectedHoliday.getDesc(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
