package com.mumu.excel.converter;

import com.mumu.excel.ExcelDataConverter;
import com.mumu.excel.annotation.Converter;
import com.mumu.excel.annotation.DatePattern;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Convert工厂<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 17:53
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class ConvertFactory {

    private static Map<Class, ExcelDataConverter> converterMap = new HashMap<>();

    static {
        converterMap.put(boolean.class, new BooleanConverter());
        converterMap.put(Boolean.class, new BooleanConverter());
        converterMap.put(byte.class, new ByteConverter());
        converterMap.put(Byte.class, new ByteConverter());
        converterMap.put(short.class, new ShortConverter());
        converterMap.put(Short.class, new ShortConverter());
        converterMap.put(int.class, new IntegerConverter());
        converterMap.put(Integer.class, new IntegerConverter());
        converterMap.put(long.class, new LongConverter());
        converterMap.put(Long.class, new LongConverter());
        converterMap.put(float.class, new FloatConverter());
        converterMap.put(Float.class, new FloatConverter());
        converterMap.put(double.class, new DoubleConverter());
        converterMap.put(Double.class, new DoubleConverter());
        converterMap.put(String.class, new StringConverter());
        converterMap.put(BigDecimal.class, new BigDecimalConverter());
    }

    public static ExcelDataConverter createConverter(Field field) throws IllegalAccessException, InstantiationException {
        if (field.getType() == LocalDate.class
                || field.getType() == LocalDateTime.class) {
            DatePattern datePattern = field.getAnnotation(DatePattern.class);
            String pattern = null;
            if (datePattern != null) {
                pattern = datePattern.value();
            }

            if (field.getType() == LocalDate.class) {
                SmartLocalDateConverter smartLocalDateConverter = new SmartLocalDateConverter();
                smartLocalDateConverter.setPattern(pattern);
                return smartLocalDateConverter;
            } else {
                SmartLocalDateTimeConverter smartLocalDateTimeConverter = new SmartLocalDateTimeConverter();
                smartLocalDateTimeConverter.setPattern(pattern);
                return smartLocalDateTimeConverter;
            }
        }else{
            Converter converter = field.getAnnotation(Converter.class);
            if(converter != null){
                Class clz = converter.using();
                return (ExcelDataConverter) clz.newInstance();
            }

            return converterMap.get(field.getType());
        }
    }
}
