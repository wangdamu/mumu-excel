package com.mumu.excel.test;

import com.mumu.excel.annotation.ExcelEntity;
import com.mumu.excel.annotation.ExcelField;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Comment....<br>
 * <p>
 * Copyright: Copyright (c) 2019/5/7 16:36
 * <p>
 * Company: DataSense
 * <p>
 *
 * @author Peter peter.wang@mulberrylearning.cn
 * @version 1.0
 */
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

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getBusinessNo2() {
        return businessNo2;
    }

    public void setBusinessNo2(String businessNo2) {
        this.businessNo2 = businessNo2;
    }

    public LocalDateTime getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(LocalDateTime businessTime) {
        this.businessTime = businessTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "BusinessEntity{" +
                "ticketNo='" + ticketNo + '\'' +
                ", businessNo='" + businessNo + '\'' +
                ", businessNo2='" + businessNo2 + '\'' +
                ", businessTime=" + businessTime +
                ", amount=" + amount +
                '}';
    }
}
