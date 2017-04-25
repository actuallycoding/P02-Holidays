package com.example.a15017484.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.a15017484.p02_holidays.R.id.tv;

/**
 * Created by 15017484 on 25/4/2017.
 */

public class HolidayAdapter extends ArrayAdapter{

    private Context context;
    private ArrayList<Holiday> holiday;
    private TextView tvHoliday;
    private TextView tvDate;
    private ImageView iv;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        holiday = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvHoliday = (TextView) rowView.findViewById(R.id.textViewH);
        tvDate = (TextView)rowView.findViewById(R.id.textViewD);
        // Get the ImageView object
        iv = (ImageView) rowView.findViewById(R.id.imageView);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday currentHoliday= holiday.get(position);

        tvHoliday.setText(currentHoliday.getHoliday());
        tvDate.setText(currentHoliday.getDate());

        // Set the image to prog or nonprog accordingly
        if(currentHoliday.getType().equalsIgnoreCase("secular")) {
            if(currentHoliday.getImg()){
                iv.setImageResource(R.drawable.newyear);
            } else {
                iv.setImageResource(R.drawable.labourday);
            }
        }
        else {
            if (currentHoliday.getImg()){
                iv.setImageResource(R.drawable.cny);
            } else {
                iv.setImageResource(R.drawable.goodfriday);
            }

        }
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
