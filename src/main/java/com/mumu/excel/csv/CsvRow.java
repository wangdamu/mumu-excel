package com.mumu.excel.csv;

import com.mumu.excel.ExcelCell;
import com.mumu.excel.ExcelRow;

import java.util.ArrayList;
import java.util.List;

/**
 * Comment....<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/10 13:10
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class CsvRow implements ExcelRow{

    private final List<ExcelCell> cellList;

    public CsvRow(List<ExcelCell> cellList) {
        this.cellList = cellList;
    }

    @Override
    public <T> ExcelCell<T> getCell(int index) {
        return (ExcelCell<T>) cellList.get(index);
    }

    @Override
    public int columnCount() {
        return cellList.size();
    }
}
