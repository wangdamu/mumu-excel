package com.mumu.excel.csv;

import com.mumu.excel.ExcelRow;
import com.mumu.excel.ExcelSheet;

import java.util.List;

/**
 * Comment....<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/10 13:13
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class CsvSheet implements ExcelSheet{

    private final List<ExcelRow> rowList;

    public CsvSheet(List<ExcelRow> rowList) {
        this.rowList = rowList;
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public List<ExcelRow> getRows() {
        return rowList;
    }

    @Override
    public int getRowCount() {
        return rowList.size();
    }

    @Override
    public ExcelRow getRow(int row) {
        return rowList.get(row);
    }
}
