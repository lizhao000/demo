package com.example.dao;

import com.example.entity.users.Bill;
import com.example.entity.users.BillProvider;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
//@Mapper 或 @MapperScan("com.mengxuegu.springboot.mapper")
public interface BillMapper {

    List<BillProvider> getBills(Bill bill);

    BillProvider getBillByBid(Integer bid);

    int addBill(Bill bill);

    int updateBill(Bill bill);

    int deteleBillByBid(Integer bid);

    int batchDelete(@Param("list") List<Long> ids);

}
