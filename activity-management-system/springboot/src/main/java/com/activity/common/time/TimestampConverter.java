package com.activity.common.time;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampConverter {
    public static String format = "yyyy-MM-dd HH:mm:ss";

    public static Timestamp stringToTimestamp(String dateString){
        // 定义日期时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        Date parsedDate = null;
        try {
            // 尝试将字符串类型的时间解析为 Date 对象
            parsedDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 将 Date 对象转换为 Timestamp 对象，并返回
        return new Timestamp(parsedDate.getTime());
    }
}
