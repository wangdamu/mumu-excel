package com.mumu.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Comment....<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 17:38
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DatePattern {
    /**
     * 日期pattern
     * @return
     */
    String value();
}
