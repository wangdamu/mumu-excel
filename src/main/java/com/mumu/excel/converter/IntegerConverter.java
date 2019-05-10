package com.mumu.excel.converter;

import com.mumu.excel.ExcelDataConverter;

/**
 * integer转换器<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 17:02
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class IntegerConverter implements ExcelDataConverter<Integer>{
    @Override
    public Integer convert(String value) {
        return Integer.parseInt(value);
    }
}
