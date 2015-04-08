package com.jodo.notify.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    DateFormat _yyyyMMdd_;

    DateFormat _yyyy_MM_dd_hms_;

    DateFormat _yyyyMMddhhmmss_;

    private DateUtil() {
        this._yyyyMMdd_ = new SimpleDateFormat("yyyy-MM-dd");
        this._yyyy_MM_dd_hms_ = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this._yyyyMMddhhmmss_ = new SimpleDateFormat("yyyyMMddHHmmss");
    }

    public static Date parseYMDHMS(String str) {
        try {
            return threadLocal.get()._yyyy_MM_dd_hms_.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date parseYMD(String str) {
        try {
            return threadLocal.get()._yyyyMMdd_.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String formatYMD(Date date) {
        return threadLocal.get()._yyyyMMdd_.format(date);
    }

    public static String formatYMDHMS(Date date) {
        return threadLocal.get()._yyyy_MM_dd_hms_.format(date);
    }

    public static String formatyyyymmddhhmmss(Date date) {
        return threadLocal.get()._yyyyMMddhhmmss_.format(date);
    }

    public static int dayDiff(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);

        c2.set(Calendar.HOUR_OF_DAY, 0);
        c2.set(Calendar.MINUTE, 0);
        c2.set(Calendar.SECOND, 0);

        long msdiff = c1.getTimeInMillis() - c2.getTimeInMillis();
        int daydiff = (int) (msdiff / (24 * 60 * 60 * 1000));
        return Math.abs(daydiff);
    }
    
    public static final Date parseTimems(long timems) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timems);
        return c.getTime();
    }
    
    private static final MyThreadLocal threadLocal = new MyThreadLocal();

    private static class MyThreadLocal extends ThreadLocal<DateUtil> {

        @Override
        protected DateUtil initialValue() {
            return new DateUtil();
        }

    }

}
