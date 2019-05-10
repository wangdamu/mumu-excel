package com.mumu.excel;

import java.io.IOException;
import java.io.InputStream;

/**
 * excel workbook 工厂类<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/10 9:05
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public interface ExcelWorkbookFactory {

    /**
     * 创建ExcelWorkbook
     * @param inputStream
     * @return
     */
    ExcelWorkbook createExcelWorkbook(InputStream inputStream) throws IOException;
}
