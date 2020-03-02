package com.mumu.excel.test;

import com.mumu.excel.MapClassMetadata;
import com.mumu.excel.util.ExcelUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;

/**
 * <br>
 *
 * @description. <p>
 * @date: 2020/3/2 10:47
 * <p>
 * Company: 苏州渠成易销网络科技有限公司
 * <p>
 * @author: wangshuguang
 * <p>
 * @version: 1.0
 * <p>
 */
public class ExcelTest {

    @Test
    public void testReadMap() throws IOException {
        MapClassMetadata mapClassMetadata = new MapClassMetadata();
        String filename = "/Users/apple/Documents/clickpaas/work/国际化二期/导入用/exchangeRateImport.xlsx";
        File file = new File(filename);
        byte[] bs = FileUtils.readFileToByteArray(file);

        List<Map<String, Object>> mapList =  ExcelUtils.getEntityListForSheet(bs, file.getName(), null, mapClassMetadata);
        Assert.assertTrue(CollectionUtils.isNotEmpty(mapList));
    }
}
