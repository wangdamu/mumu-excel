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
public class SmartLocalDateConverter implements ExcelDataConverter<LocalDate> {

    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public LocalDate convert(String value) {
        if(pattern != null){
            return LocalDate.parse(value, DateTimeFormatter.ofPattern(pattern));
        }
        return guessDate(value);
    }

    private LocalDate guessDate(String strValue) {
        String datePattern = "";
        LocalDate localDate = null;
        if(strValue.matches("\\d+")){
            localDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(strValue)), ZoneId.systemDefault())
                    .toLocalDate();
        }else if(strValue.matches("\\d{1,2}-\\d{1,2}-\\d{4}")){
            datePattern = "d-M-yyyy";
        }else if(strValue.matches("\\d{1,2}/\\d{1,2}/\\d{4}")){
            datePattern = "d/M/yyyy";
        }else if(strValue.matches("\\d{4}-\\d{1,2}-\\d{1,2}")){
            datePattern = "yyyy-M-d";
        }else if(strValue.matches("\\d{4}/\\d{1,2}/\\d{1,2}")){
            datePattern = "yyyy/M/d";
        }
        if(localDate == null){
            localDate = LocalDate.parse(strValue, DateTimeFormatter.ofPattern(datePattern));
        }
        return localDate;
    }
}
