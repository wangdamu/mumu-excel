package com.mumu.excel.converter;

import com.mumu.excel.ExcelDataConverter;

/**
 * Comment....<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 17:26
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class BooleanConverter implements ExcelDataConverter<Boolean>{
    @Override
    public Boolean convert(String value) {
        return "1".equals(value) || "true".equalsIgnoreCase(value);
    }
}
