package com.thread.scheduled.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final String DEFAULT_DATE_TIME_MILLISECONDS_FORMAT = "yyyyMMddHHmmssSSS";
    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyyMMddHHmmss";
    public static String getTodayDateTime(String format) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    public static String getNowDateTimeMilliseconds() { return getTodayDateTime(DEFAULT_DATE_TIME_MILLISECONDS_FORMAT); }
}
