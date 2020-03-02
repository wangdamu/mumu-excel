package com.mumu.excel;

import com.mumu.excel.util.ExcelUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <br>
 *
 * @description. <p>
 * @date: 2019-11-04 10:12
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 * @author: wangshuguang
 * <p>
 * @version: 1.0
 * <p>
 */
public class ExcelManager {

    private Class[] clazzes;

    private Map<Class, ClassMetadata> classClassMetadataMap = new ConcurrentHashMap<>();

    public ExcelManager(Class[] clazzes) throws NoSuchMethodException {
        this.clazzes = clazzes;
        for(Class clazz : clazzes){
            classClassMetadataMap.put(clazz, ExcelUtils.createClassMetadata(clazz));
        }
    }


}
