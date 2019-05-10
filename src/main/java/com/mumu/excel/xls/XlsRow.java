package com.mumu.excel.xls;

import com.mumu.excel.ExcelCell;
import com.mumu.excel.ExcelRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.List;

/**
 * Comment....<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 16:06
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class XlsRow implements ExcelRow{

    private final Row row;

    public XlsRow(Row row) {
        this.row = row;
    }

    @Override
    public <T> ExcelCell<T> getCell(int index) {
        Cell cell = row.getCell(index);
        return new XlsCell(cell);
    }

    @Override
    public int columnCount() {
        return row.getLastCellNum() + 1;
    }
}
