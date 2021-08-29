package com.lokesh.history.utils;

import java.util.Date;
/**
 *
 */
public class DateUtils {
    private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;

    public static Date findNextDay(Date date) {
        return new Date(date.getTime() + MILLIS_IN_A_DAY);
    }

    public static Date findPrevDay(Date date) {
        return new Date(date.getTime() - MILLIS_IN_A_DAY);
    }
}