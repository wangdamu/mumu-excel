package com.mumu.excel;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * <br>
 *
 * @description. <p>
 * @date: 2020/3/2 10:41
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 * @author: wangshuguang
 * <p>
 * @version: 1.0
 * <p>
 */
public class MapClassMetadata implements IClassMetadata<Map<String, Object>>{
    @Override
    public int getFieldRow() {
        return 0;
    }

    @Override
    public Map<String, Object> newInstance() throws Exception {
        return new HashMap<>();
    }

    @Override
    public IIndexFieldOperator genIndexFieldOperator(ExcelRow row) {
        IndexFieldForMap indexFieldForMap = new IndexFieldForMap();
        Map<Integer, String> index2name = indexFieldForMap.getIndex2name();

        for(int c = 0; c < row.columnCount(); c++){
            ExcelCell cell = row.getCell(c);
            if(cell == null){
                continue;
            }
            String value = cell.getStringCellValue();
            if(StringUtils.isNotEmpty(value)){
                index2name.put(c, value);
            }
        }
        return indexFieldForMap;
    }
}
