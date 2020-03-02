package com.mumu.excel;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * <br>
 *
 * @description. <p>
 * @date: 2020/3/2 10:42
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 * @author: wangshuguang
 * <p>
 * @version: 1.0
 * <p>
 */
public class IndexFieldForMap implements IIndexFieldOperator{
    private Map<Integer, String> index2name = new HashMap<>();

    @Override
    public boolean existsField(int index) {
        return index2name.containsKey(index);
    }

    @Override
    public void setFieldValue(Object obj, int index, Object value) throws Exception {
        String name = index2name.get(index);
        if(StringUtils.isNotBlank(name)){
            Map<String, Object> map = (Map<String, Object>)obj;
            map.put(name, value);
        }
    }

    @Override
    public Class<?> getFieldType(int index) {
        return String.class;
    }

    @Override
    public Field getField(int index) {
        return null;
    }

    public Map<Integer, String> getIndex2name() {
        return index2name;
    }

    public void setIndex2name(Map<Integer, String> index2name) {
        this.index2name = index2name;
    }
}
