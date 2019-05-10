package com.mumu.excel.converter;

import com.mumu.excel.ExcelDataConverter;

import java.math.BigDecimal;

/**
 * BigDecimal转换<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/10 10:08
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class BigDecimalConverter implements ExcelDataConverter<BigDecimal>{
    @Override
    public BigDecimal convert(String value) {
        value = value.replace(",", "")
                .replaceAll("\\s+", "");
        return new BigDecimal(value);
    }
}
