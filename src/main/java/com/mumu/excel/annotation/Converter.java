package com.mumu.excel.annotation;

import com.mumu.excel.ExcelDataConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 转换注解<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 17:48
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Converter {
    /**
     * converter所使用的class
     * @return
     */
    Class<? extends ExcelDataConverter> using();
}
