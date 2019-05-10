package com.mumu.excel.xls;

import com.mumu.excel.ExcelWorkbook;
import com.mumu.excel.ExcelWorkbookFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

/**
 * .xlsx workbook工厂<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/10 9:07
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class XSSFWorkbookFactory implements ExcelWorkbookFactory{
    @Override
    public ExcelWorkbook createExcelWorkbook(InputStream inputStream) throws IOException {
        Workbook wb = new XSSFWorkbook(inputStream);
        return new XlsWorkbook(wb);
    }
}
