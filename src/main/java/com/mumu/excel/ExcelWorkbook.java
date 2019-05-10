package com.mumu.excel;

import java.util.List;

/**
 * Excel之workbook<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 15:49
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public interface ExcelWorkbook {

    /**
     * 获取所有sheet页
     * @return
     */
    List<ExcelSheet> getSheets();

    /**
     * 获取第index个sheet
     * @param index 索引，从0开始
     * @return
     */
    ExcelSheet getSheet(int index);

    /**
     * 按照名字获取sheet
     * @param name
     * @return
     */
    ExcelSheet getSheet(String name);
}
