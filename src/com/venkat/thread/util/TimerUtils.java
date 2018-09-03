package com.venkat.thread.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimerUtils {

    private TimerUtils(){}

    public static Date getFutureTime(Date initialTime, long millisToAdd ){
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTimeInMillis(initialTime.getTime() + millisToAdd);
        return calendar.getTime();
    }
}
