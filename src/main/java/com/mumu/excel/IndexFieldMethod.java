package com.mumu.excel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 位置到字段/方法的映射<br>
 * <p>
 * Copyright: Copyright (c) 2018/1/24 11:03
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class IndexFieldMethod implements IIndexFieldOperator{
    private Map<Integer, Method> index2method;
    private Map<Integer, Field> index2field;

    public Map<Integer, Method> getIndex2method() {
        return index2method;
    }

    public void setIndex2method(Map<Integer, Method> index2method) {
        this.index2method = index2method;
    }

    public Map<Integer, Field> getIndex2field() {
        return index2field;
    }

    public void setIndex2field(Map<Integer, Field> index2field) {
        this.index2field = index2field;
    }

    @Override
    public boolean existsField(int index) {
        Method method = getIndex2method().get(index);
        return method != null;
    }

    @Override
    public void setFieldValue(Object obj, int index, Object value) throws Exception{
        Method method = getIndex2method().get(index);
        method.invoke(obj, value);
    }

    @Override
    public Class<?> getFieldType(int index) {
        Field field = index2field.get(index);
        if(field != null){
            return field.getType();
        }
        return null;
    }

    @Override
    public Field getField(int index) {
        return index2field.get(index);
    }
}
