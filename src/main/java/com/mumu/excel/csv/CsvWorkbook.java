package com.mumu.excel.csv;

import com.mumu.excel.ExcelSheet;
import com.mumu.excel.ExcelWorkbook;

import java.util.Arrays;
import java.util.List;

/**
 * Comment....<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/10 13:15
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class CsvWorkbook implements ExcelWorkbook{

    private final ExcelSheet sheet;

    public CsvWorkbook(ExcelSheet sheet) {
        this.sheet = sheet;
    }

    @Override
    public List<ExcelSheet> getSheets() {
        return Arrays.asList(sheet);
    }

    @Override
    public ExcelSheet getSheet(int index) {
        return sheet;
    }

    @Override
    public ExcelSheet getSheet(String name) {
        return sheet;
    }
}
