package com.mumu.excel.csv;

import com.mumu.excel.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Comment....<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/10 13:16
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class CsvWorkbookFactory implements ExcelWorkbookFactory{
    @Override
    public ExcelWorkbook createExcelWorkbook(InputStream inputStream) throws IOException {
        String encoding = System.getProperty("csv.encoding");
        if(encoding == null){
            encoding = "UTF-8";
        }

        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, encoding))) {
            Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(br);

            List<ExcelRow> rowList = new LinkedList<>();

            for (CSVRecord record : records) {
                int size = record.size();
                List<ExcelCell> cellList = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    String value = record.get(i);
                    CsvCell cell = new CsvCell(value);
                    cellList.add(cell);
                }

                ExcelRow row = new CsvRow(cellList);
                rowList.add(row);
            }
            ExcelSheet sheet = new CsvSheet(rowList);
            return new CsvWorkbook(sheet);
        }finally {

        }
    }
}
