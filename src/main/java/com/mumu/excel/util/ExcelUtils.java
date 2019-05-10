package com.mumu.excel.util;

import com.mumu.excel.*;
import com.mumu.excel.annotation.ExcelEntity;
import com.mumu.excel.annotation.ExcelField;
import com.mumu.excel.converter.ConvertFactory;
import com.mumu.excel.csv.CsvWorkbookFactory;
import com.mumu.excel.xls.HSSFWorkbookFactory;
import com.mumu.excel.xls.XSSFWorkbookFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Comment....<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/9 16:01
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class ExcelUtils {
    private final static String excel2003L = ".xls";    //2003- 版本的excel
    private final static String excel2003csv = ".csv";    //2003- 版本的excel
    private final static String excel2007U = ".xlsx";   //2007+ 版本的excel

    private static DataFormatter dataFormatter = new DataFormatter();

    public static Object getCellValue(final Cell cell, FormulaEvaluator evaluator) {
        if (cell == null) {
            return null;
        } else {
            return getCellValue0(cell, evaluator);
        }
    }

    /**
     * 获取格子内容
     *
     * @param cell      格子
     * @param evaluator
     * @return 格子内容
     * @throws Exception
     */
    private static Object getCellValue0(Cell cell, FormulaEvaluator evaluator) {
        if(cell.getCellTypeEnum() == CellType.NUMERIC){
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                Date date = cell.getDateCellValue();
                return date.getTime();
            }
        }

        cell = evaluator.evaluateInCell(cell);
        if(cell.getCellTypeEnum() == CellType.FORMULA){
            cell.setCellType(CellType.NUMERIC);
        }

        return dataFormatter.formatCellValue(cell);
    }

    /**
     * 根据文件名获取ExcelWorkbookFactory
     * @param filename
     * @return
     * @throws IOException
     */
    private static ExcelWorkbookFactory getExcelWorkbookFactory(String filename) throws IOException {
        String fileType = filename.substring(filename.lastIndexOf("."));
        if (excel2003L.equals(fileType)) {
            return new HSSFWorkbookFactory();
        } else if (excel2007U.equals(fileType)) {
            return new XSSFWorkbookFactory();  //2007+
        }else if(excel2003csv.equals(fileType)){
            return new CsvWorkbookFactory();  //2003-
        } else {
            throw new IOException("解析的文件格式有误！");
        }
    }

    /**
     * 生成位置到字段/方法的映射
     * @param row
     * @param classMetadata
     * @return
     */
    public static IndexFieldMethod genIndexFieldMethod(ExcelRow row, ClassMetadata classMetadata){
        IndexFieldMethod indexFieldMethod = new IndexFieldMethod();

        Map<Integer, Method> index2method = new HashMap<>();
        Map<Integer, Field> index2field = new HashMap<>();

        for(int c = 0; c < row.columnCount(); c++){
            ExcelCell cell = row.getCell(c);
            if(cell == null){
                continue;
            }
            String value = cell.getStringCellValue();
            if(StringUtils.isNotEmpty(value)){
                Method method = (Method) classMetadata.getSetMethodMap().get(value);
                index2method.put(c, method);
                index2field.put(c, (Field) classMetadata.getFieldMap().get(value));
            }
        }

        indexFieldMethod.setIndex2field(index2field);
        indexFieldMethod.setIndex2method(index2method);

        return indexFieldMethod;
    }

    /**
     * 创建数据bean对象
     * @param row
     * @param classMetadata
     * @param indexFieldMethod
     * @param <T>
     * @return
     */
    public static <T> T createDataBean(ExcelRow row, ClassMetadata<T> classMetadata, IndexFieldMethod indexFieldMethod) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T obj = classMetadata.getClazz().newInstance();
        for(int c = 0; c < row.columnCount(); c++){
            ExcelCell cell = row.getCell(c);
            if(cell == null){
                continue;
            }
            Method method = indexFieldMethod.getIndex2method().get(c);
            if(method != null){
                final Object value = cell.getData();
                final String strValue = String.valueOf(value).trim();
                if(StringUtils.isBlank(strValue)
                        || strValue.contains("#N/A")){
                    continue;
                }

                Field field = indexFieldMethod.getIndex2field().get(c);
                ExcelDataConverter converter = ConvertFactory.createConverter(field);

                Object convertedObj = converter.convert(strValue);
                method.invoke(obj, convertedObj);
            }
        }
        return obj;
    }

    public static <T> List<T> getEntityListForSheet(byte[] bytes, String fileName, String sheetName, ClassMetadata<T> classMetadata) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        try {
            ExcelWorkbookFactory excelWorkbookFactory = getExcelWorkbookFactory(fileName);

            ExcelWorkbook workbook = excelWorkbookFactory.createExcelWorkbook(bais);
            ExcelSheet sheet = null;
            if(StringUtils.isNotEmpty(sheetName)){
                sheet = workbook.getSheet(sheetName);
            }else{
                sheet = workbook.getSheet(0);
            }

            List<T> list = new ArrayList<>();

            int fieldRow = classMetadata.getFieldRow();
            int rowCount = sheet.getRowCount();
            ExcelRow firstRow = sheet.getRow(fieldRow);
            IndexFieldMethod indexFieldMethod = genIndexFieldMethod(firstRow, classMetadata);

            for (int r = fieldRow + 1; r < rowCount; r++) {
                ExcelRow row = sheet.getRow(r);
                if (row == null) {
                    break;
                }
                T obj = createDataBean(row, classMetadata, indexFieldMethod);
                list.add(obj);
            }

            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建class的metadata
     * @param clazz
     * @return
     */
    public static ClassMetadata createClassMetadata(Class clazz) throws NoSuchMethodException {
        ClassMetadata cm = new ClassMetadata();
        cm.setClazz(clazz);

        ExcelEntity excelEntity = (ExcelEntity) clazz.getDeclaredAnnotation(ExcelEntity.class);
        if(excelEntity != null){
            cm.setFieldRow(excelEntity.fieldRow());
        }

        Map<String, Method> setMethodMap = new HashMap<>();
        Map<String, Field> fieldMap = new HashMap<>();
        Field[] fs = clazz.getDeclaredFields();
        for(Field f : fs){
            ExcelField excelField = f.getAnnotation(ExcelField.class);
            if(excelField != null){
                Method method = clazz.getMethod("set" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1), f.getType());
                setMethodMap.put(excelField.value(), method);
                fieldMap.put(excelField.value(), f);
            }
        }
        cm.setSetMethodMap(setMethodMap);
        cm.setFieldMap(fieldMap);
        return cm;
    }
}
