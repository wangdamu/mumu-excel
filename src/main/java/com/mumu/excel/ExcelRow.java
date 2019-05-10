package com.mumu.excel;

/**
 * Excel行<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 15:30
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public interface ExcelRow {

    /**
     * 获取指定格子
     * @param index 索引，从0开始
     * @param <T>
     * @return
     */
    <T> ExcelCell<T> getCell(int index);

    /**
     * 获取列数量
     * @return
     */
    int columnCount();
}
