package com.mumu.excel.converter;

import com.mumu.excel.ExcelDataConverter;

/**
 * Double转换器<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 17:02
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class DoubleConverter implements ExcelDataConverter<Double>{
    @Override
    public Double convert(String value) {
        return Double.parseDouble(value);
    }
}
