package com.itProger;

import java.text.SimpleDateFormat;
// Класс для получения даты
import java.util.Date;

public class Date_Format {
    public static void main(String[] args) {
        int num = 0;
        Date date = new Date();

        SimpleDateFormat DateFor = new SimpleDateFormat("yyyy/MM/dd");
        String stringDate = DateFor.format(date);
        System.out.println(stringDate);
        //System.out.println("Сегодня: " + date.getDate());

    }
}
