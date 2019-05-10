package com.mumu.excel.csv;

import com.mumu.excel.ExcelCell;

/**
 * Comment....<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/10 13:08
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class CsvCell implements ExcelCell<String>{

    private final String value;

    public CsvCell(String value) {
        this.value = value;
    }

    @Override
    public String getData() {
        return value;
    }

    @Override
    public String getStringCellValue() {
        return value;
    }
}
