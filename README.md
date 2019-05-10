# mumu-excel
Excel读取（包含CSV），注解方式直接读取成bean对象

## 读取excel为bean对象步骤

### 1. 定义bean对象

```java
@ExcelEntity
public class BusinessEntity {

    @ExcelField("单据编号")
    private String ticketNo;

    @ExcelField("业务单号")
    private String businessNo;

    @ExcelField("采购单号")
    private String businessNo2;

    @ExcelField("业务发生时间")
    private LocalDateTime businessTime;

    @ExcelField("金额")
    private BigDecimal amount;

    private String fileName;

    // getter setter方法
}
```

### 2. 读取xls,xlxs,csv文件

```java
// csv文件要注意编码， 设置编码可以通过 -Dcsv.encoding=GBK 来设置
ClassMetadata<BusinessEntity> classMetadata = ExcelUtils.createClassMetadata(BusinessEntity.class);
List<BusinessEntity> entities = ExcelUtils.getEntityListForSheet(bytes, filename, null, classMetadata);
```

### 3. 自定义converter

当bean对象的field有新类型，可以实现自己的ExcelDataConverter，然后使用注解 Converter 来指定使用的类

```java
@ExcelEntity
public class BusinessEntity {

    @Converter(using = StringConverter.class)
    @ExcelField("单据编号")
    private String ticketNo;
    // ...
}
```

### 4. LocalDate和LocalDateTime可以使用DatePattern来指定日期/时间格式

```java
@ExcelEntity
public class BusinessEntity {

    @DatePattern("yyyy-MM-dd HH:mm:ss")
    @ExcelField("业务发生时间")
    private LocalDateTime businessTime;
    
    // ...
}
```

