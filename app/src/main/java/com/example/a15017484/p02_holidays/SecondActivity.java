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
            holiday.add(new Holiday("New Year's Day","1 Jan 2017",type,true));
            holiday.add(new Holiday("Labour Day","1 May 2017",type,false));
        } else {
            holiday.add(new Holiday("Chinese New Year","28-29 Jan 2017",type,true));
            holiday.add(new Holiday("Good Friday","14 April 2017",type,false));
        }
        aa = new HolidayAdapter(this, R.layout.row, holiday);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHoliday = holiday.get(position);

                Toast.makeText(SecondActivity.this, selectedHoliday.getHoliday() + " Date: "+selectedHoliday.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
