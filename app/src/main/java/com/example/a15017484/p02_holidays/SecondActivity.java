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
            holiday.add(new Holiday("New Year's Day","1 Jan 2017",type,"New Year is the time at which a new calendar year begins and the calendar's year count increments by one.",R.drawable.newyear));
            holiday.add(new Holiday("Labour Day","1 May 2017",type,"Labour Day is an annual holiday to celebrate the achievements of workers.",R.drawable.labourday));
            holiday.add(new Holiday("National Day","9 Aug 2017",type,"The National Day of Singapore is celebrated every year on August 9, in commemoration of the Singapore's independence from Malaysia in the year 1965. ",R.drawable.nationalday));
        } else {
            holiday.add(new Holiday("Chinese New Year","28-29 Jan 2017",type,"Chinese New Year, also known as the \"Spring Festival\" in modern Mainland China, is an important Chinese festival celebrated at the turn of the traditional lunisolar Chinese calendar.",R.drawable.cny));
            holiday.add(new Holiday("Good Friday","14 April 2017",type,"Good Friday is a Christian holiday commemorating the crucifixion of Jesus Christ and his death at Calvary.",R.drawable.goodfriday));
            holiday.add(new Holiday("Vesak Day","10 May 2017",type,"Sometimes informally called \"Buddha's Birthday\", it commemorates the birth, enlightenment (Buddhahood), and death (Parinirvāna) of Gautama Buddha in the Theravada or southern tradition.",R.drawable.vesakday));
            holiday.add(new Holiday("Hari Raya Puasa","25 June 2017",type,"Hari Raya Puasa is the celebration at the end of the Ramadan month of fasting. It is also known as the festival of Eid or as Hari Raya Aidilfitri.",R.drawable.harirayapuasa));
            holiday.add(new Holiday("Hari Raya Haji","1 Sep 2017",type,"Hari Raya Haji is celebrated by Muslims around the world and is the commemoration of Ibrahim’s willingness to be obedient to Allah and to sacrifice his own son, Ishmael. At the last minute, Allah provided a ram for the sacrifice as a substitute for Ishmael.",R.drawable.harirayahaji));
            holiday.add(new Holiday("Deepavali","18 Oct 2017",type,"Diwali or Deepavali is the Hindu festival of lights celebrated every year in autumn in the northern hemisphere",R.drawable.deepavali));
            holiday.add(new Holiday("Christmas Day","25 Dec 2017",type,"Christmas or Christmas Day is an annual festival commemorating the birth of Jesus Christ, observed most commonly on December 25 as a religious and cultural celebration among billions of people around the world.",R.drawable.christmas));
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
