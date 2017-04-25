package com.example.a15017484.p02_holidays;

/**
 * Created by 15017484 on 25/4/2017.
 */

public class Holiday {
    private String holiday;
    private String date;
    private String type;
    private Boolean img;

    public Holiday(String holiday, String date,String type, Boolean img) {
        this.date = date;
        this.holiday = holiday;
        this.type = type;
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public String getHoliday() {
        return holiday;
    }

    public String getType() {
        return type;
    }

    public Boolean getImg() {
        return img;
    }
}
