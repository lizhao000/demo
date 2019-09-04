package com.example.entity.users;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 供应商实体类
 * @Title: Provider
 * @Description: com.mengxuegu.springboot.entities
 * @Auther: www.mengxuegu.com
 * @Version: 1.0
 */
@Data
public class Provider implements Serializable {
    private Integer pid;
    //供应商编码
    private String providerCode;
    //供应商名称
    private String providerName;
    //联系人
    private String people;
    //联系电话
    private String phone;
    //联系地址
    private String address;
    //传真
    private String fax;
    //描述
    private String describe;
    // 创建时间
    private Date createDate;
    // 批量删除 N 沒刪除 ， Y 是刪除
    private String isDeleted;
}
