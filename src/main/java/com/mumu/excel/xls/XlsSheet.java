package com.mumu.excel.xls;

import com.mumu.excel.ExcelRow;
import com.mumu.excel.ExcelSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Excel sheet页<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 16:08
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class XlsSheet implements ExcelSheet{

    private final Sheet sheet;

    public XlsSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    @Override
    public String name() {
        return sheet.getSheetName();
    }

    @Override
    public List<ExcelRow> getRows() {
        return IntStream.range(sheet.getFirstRowNum(), sheet.getLastRowNum() + 1)
                .mapToObj(i -> {
                            Row row = sheet.getRow(i);
                            return new XlsRow(row);
                        }
                    ).collect(Collectors.toList());
    }

    @Override
    public int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }

    @Override
    public ExcelRow getRow(int row) {
        Row rowObj = sheet.getRow(row);
        return new XlsRow(rowObj);
    }
}
