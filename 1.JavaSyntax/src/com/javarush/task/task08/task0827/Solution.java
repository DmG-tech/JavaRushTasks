package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date tempdate = df.parse(date);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(tempdate);
        DateFormat days = new SimpleDateFormat("D");

        int day = Integer.parseInt(days.format(calendar.getTime()));

        if (day % 2 == 0){
            return false;
        }
        else
            return true;
        /*
        date = date.trim();
        String[] ArrayDate = date.split(" +");
        DateFormat month = new SimpleDateFormat("MM");

        Calendar calendar = new GregorianCalendar();
        calendar.set(calendar.MONTH, Integer.parseInt(month.format(ArrayDate[0])));
        calendar.set(calendar.DAY_OF_MONTH, Integer.parseInt(ArrayDate[1]));
        calendar.set(calendar.YEAR, Integer.parseInt(ArrayDate[2]));
        DateFormat days = new SimpleDateFormat("D");
        int day = Integer.parseInt(days.format(calendar.getTime()));

        if (day % 2 == 0){
            return false;
        }
        else
        return true;
        */
    }
}
