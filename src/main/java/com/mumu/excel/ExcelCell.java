package com.mumu.excel;

/**
 * Excel格子<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 15:30
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public interface ExcelCell<T> {

    /**
     * 获取数据
     * @return
     */
    T getData();

    /**
     * 获取数据字符串
     * @return
     */
    String getStringCellValue();

}
