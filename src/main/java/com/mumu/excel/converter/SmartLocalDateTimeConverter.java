package com.mumu.excel.converter;

import com.mumu.excel.ExcelDataConverter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * LocalDate转换器<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 17:07
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class SmartLocalDateTimeConverter implements ExcelDataConverter<LocalDateTime> {

    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public LocalDateTime convert(String value) {
        if(pattern != null){
            return LocalDateTime.parse(value, DateTimeFormatter.ofPattern(pattern));
        }
        return guess(value);
    }

    private LocalDateTime guess(String strValue) {
        String datePattern = "";
        LocalDateTime localDateTime = null;
        if(strValue.matches("\\d+")){
            localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(strValue)), ZoneId.systemDefault());
        }else if(strValue.matches("\\d{1,2}-\\d{1,2}-\\d{4}\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])")){
            datePattern = "dd-MM-yyyy HH:mm:ss";
        }else if(strValue.matches("\\d{1,2}/\\d{1,2}/\\d{4}\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])")){
            datePattern = "d/M/yyyy HH:mm:ss";
        }else if(strValue.matches("\\d{4}-\\d{1,2}-\\d{1,2}\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])")){
            datePattern = "yyyy-MM-dd HH:mm:ss";
        }else if(strValue.matches("\\d{4}-\\d{1,2}-\\d{1,2}\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])\\.[0-9]+")){
            datePattern = "yyyy-MM-dd HH:mm:ss.S";
        }else if(strValue.matches("\\d{4}/\\d{1,2}/\\d{1,2}\\s([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])")){
            datePattern = "yyyy/MM/dd HH:mm:ss";
        }
        if(localDateTime == null){
            localDateTime = LocalDateTime.parse(strValue, DateTimeFormatter.ofPattern(datePattern));
        }
        return localDateTime;
    }
}
