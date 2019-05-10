package com.mumu.excel;

/**
 * excel数据转换<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 17:00
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public interface ExcelDataConverter<T> {

    /**
     * 将字符串转换成指定类型数据
     * @param value
     * @return
     */
    T convert(String value);
}
