package com.mumu.excel.converter;

import com.mumu.excel.ExcelDataConverter;

/**
 * string 转换<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/10 8:55
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class StringConverter implements ExcelDataConverter<String>{
    @Override
    public String convert(String value) {
        return value;
    }
}
