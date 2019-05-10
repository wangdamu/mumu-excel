package com.mumu.excel.xls;

import com.mumu.excel.ExcelCell;
import com.mumu.excel.util.ExcelUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

/**
 * Xls Xlsx的cell<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 15:57
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class XlsCell implements ExcelCell{

    private final Cell cell;
    private FormulaEvaluator evaluator;

    public XlsCell(Cell cell) {
        this.cell = cell;
        if(cell != null){
            evaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
        }
    }

    @Override
    public Object getData() {
        return ExcelUtils.getCellValue(cell, evaluator);
    }

    @Override
    public String getStringCellValue() {
        Object obj = getData();
        if(obj != null){
            return obj.toString();
        }
        return null;
    }

}
