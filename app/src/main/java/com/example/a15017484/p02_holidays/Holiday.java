package com.example.a15017484.p02_holidays;

/**
 * Created by 15017484 on 25/4/2017.
 */

public class Holiday {
    private String holiday;
    private String type;
    private String img;

    public Holiday(String holiday, String type, String img) {
        this.holiday = holiday;
        this.type = type;
        this.img = img;
    }

    public String getHoliday() {
        return holiday;
    }

    public String getType() {
        return type;
    }

    public String getImg() {
        return img;
    }
}
