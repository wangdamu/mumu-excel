package com.mumu.excel;

import java.lang.reflect.InvocationTargetException;

/**
 * class metadata接口<br>
 *
 * @description. <p>
 * @date: 2020/3/2 10:10
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 * @author: wangshuguang
 * <p>
 * @version: 1.0
 * <p>
 */
public interface IClassMetadata<T> {
    /**
     * 字段名称行
     * @return
     */
    int getFieldRow();

    /**
     * 创建一个对象T
     * @return
     */
    T newInstance() throws Exception;

    /**
     * 生成列index和field关系的操作类
     * @return
     */
    IIndexFieldOperator genIndexFieldOperator(ExcelRow row);
}
