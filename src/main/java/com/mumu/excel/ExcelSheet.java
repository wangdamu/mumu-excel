package com.mumu.excel;

import java.util.List;

/**
 * Excel Sheet<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 15:47
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public interface ExcelSheet {

    /**
     * sheet名字
     * @return
     */
    String name();

    /**
     * 获取所有行
     * @return
     */
    List<ExcelRow> getRows();

    /**
     * 获取行数
     * @return
     */
    int getRowCount();

    /**
     * 获取某一行
     * @param row 行，从0开始
     * @return
     */
    ExcelRow getRow(int row);
}
