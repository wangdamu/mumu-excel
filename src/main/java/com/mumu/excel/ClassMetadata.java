package com.mumu.excel;

import com.mumu.excel.util.ExcelUtils;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * class的Metadata<br>
 * <p>
 * Copyright: Copyright (c) 2018/1/24 10:57
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class ClassMetadata<T> implements IClassMetadata<T>{
    private Class<T> clazz;
    private Map<String, Method> setMethodMap;
    private Map<String, Field> fieldMap;

    private int fieldRow;

    private String sheetName;

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Map<String, Method> getSetMethodMap() {
        return setMethodMap;
    }

    public void setSetMethodMap(Map<String, Method> setMethodMap) {
        this.setMethodMap = setMethodMap;
    }

    public Map<String, Field> getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(Map<String, Field> fieldMap) {
        this.fieldMap = fieldMap;
    }

    public int getFieldRow() {
        return fieldRow;
    }


    public void setFieldRow(int fieldRow) {
        this.fieldRow = fieldRow;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    @Override
    public T newInstance() throws Exception{
        return clazz.newInstance();
    }

    @Override
    public IIndexFieldOperator genIndexFieldOperator(ExcelRow row) {
        return ExcelUtils.genIndexFieldMethod(row, this);
    }

}
