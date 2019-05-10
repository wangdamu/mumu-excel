package com.mumu.excel.converter;

import com.mumu.excel.ExcelDataConverter;

/**
 * byte类型转换器<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 17:06
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class ByteConverter implements ExcelDataConverter<Byte> {
    @Override
    public Byte convert(String value) {
        return Byte.parseByte(value);
    }
}
