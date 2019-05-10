package com.mumu.excel.xls;

import com.mumu.excel.ExcelSheet;
import com.mumu.excel.ExcelWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * XlsWorkbook<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 15:54
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class XlsWorkbook implements ExcelWorkbook{

    private final Workbook workbook;

    public XlsWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    @Override
    public List<ExcelSheet> getSheets() {
        int numberOfSheets = workbook.getNumberOfSheets();
        return IntStream.range(0, numberOfSheets)
                .mapToObj(i -> {
                    Sheet sheet = workbook.getSheetAt(i);
                    return new XlsSheet(sheet);
                }).collect(Collectors.toList());
    }

    @Override
    public ExcelSheet getSheet(int index) {
        Sheet sheet = workbook.getSheetAt(index);
        return new XlsSheet(sheet);
    }

    @Override
    public ExcelSheet getSheet(String name) {
        Sheet sheet = workbook.getSheet(name);
        return new XlsSheet(sheet);
    }
}
