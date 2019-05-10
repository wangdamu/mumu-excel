package com.mumu.excel.test;

import com.mumu.excel.ClassMetadata;
import com.mumu.excel.util.ExcelUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * Comment....<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/7 16:35
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
public class ExcelApplication {

    /**
     * 读取csv 要设置 -Dcsv.encoding=GBK 来指定使用的编码
     * @param args
     * @throws NoSuchMethodException
     * @throws IOException
     */
    public static void main(String[] args) throws NoSuchMethodException, IOException {
        List<File> fileList = new LinkedList<>();
        fileList.add(new File("D:\\workspace\\git_jd_supply\\jd_supply_chain_portal_doc\\给过来的数据\\新建文件夹"));

        ClassMetadata<BusinessEntity> classMetadata = ExcelUtils.createClassMetadata(BusinessEntity.class);

        List<BusinessEntity> businessEntityList = new LinkedList<>();

        while(fileList.size() > 0){
            File file = fileList.remove(0);
            if(file.isFile()){
                try(
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
                        ){
                    IOUtils.copy(bis, baos);
                    List<BusinessEntity> entities = ExcelUtils.getEntityListForSheet(baos.toByteArray(), file.getName(), null, classMetadata);
                    entities.forEach(entity -> entity.setFileName(file.getName()));
                    businessEntityList.addAll(entities);
                }
            }else{
                File[] fs = file.listFiles(f -> f.isDirectory() || f.getName().endsWith("xlsx") || f.getName().endsWith("xls") || f.getName().endsWith("csv"));
                for(File f : fs){
                    fileList.add(f);
                }
            }
        }

        try (PrintStream ps = new PrintStream(new FileOutputStream("D:\\workspace\\git_jd_supply\\jd_supply_chain_portal_doc\\给过来的数据\\out.csv"), true, "utf-8")){
            ps.println("单据编号,业务编号,业务时间,金额,文件名");
            StringBuilder sb = new StringBuilder();
            for(BusinessEntity be : businessEntityList){
                sb.delete(0, sb.length());

                sb.append(StringUtils.defaultString(be.getTicketNo())).append(",");
                if(be.getBusinessNo() != null){
                    sb.append(StringUtils.defaultString(be.getBusinessNo())).append(",");
                }else{
                    sb.append(StringUtils.defaultString(be.getBusinessNo2())).append(",");
                }
                if(be.getBusinessTime() != null){
                    sb.append(be.getBusinessTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                }else{
                    sb.append("");
                }
                sb.append(",");
                if(be.getAmount() != null){
                    sb.append(be.getAmount());
                }
                sb.append(",").append(be.getFileName());
                ps.println(sb);
            }
        }
    }
}
