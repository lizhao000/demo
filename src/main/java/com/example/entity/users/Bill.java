package com.example.entity.users;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Bill implements Serializable {

    private Integer bid;
    // 账单编码
    private String billCode;
    // 商品名称
    private String billName;
    // 商品单位
    private String billCom;
    // 商品数量
    private Integer billNum;
    // 总金额
    private Double money;
    // 供应商
    private Provider provider;
    //供应商id
    private Integer pid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    // 是否付款 0 未付款， 1已付款
    private Integer pay;
    // 创建时间
    private Date createDate;
    public Bill() {}

    public Bill(Integer bid, String billCode, String billName, String billCom, Integer billNum, Double money, Provider provider, Integer pay) {
        this.bid = bid;
        this.billCode = billCode;
        this.billName = billName;
        this.billCom = billCom;
        this.billNum = billNum;
        this.money = money;
        this.provider = provider;
        this.pay = pay;
        this.createDate = new Date();
    }

}
