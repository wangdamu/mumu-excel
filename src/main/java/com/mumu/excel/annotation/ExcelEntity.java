package com.mumu.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excel实体<br>
 * <p>
 * Copyright: Copyright (c) 2018/1/15 15:47
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelEntity {
    String value() default "";

    /**
     * 字段名所在的行 从0开始
     * @return
     */
    int fieldRow() default 0;
}
