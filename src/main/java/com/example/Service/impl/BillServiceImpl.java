package com.example.Service.impl;

import com.example.Service.BillService;
import com.example.dao.BillMapper;
import com.example.entity.users.Bill;
import com.example.entity.users.BillProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillMapper billMapper;
    @Override
    public List<BillProvider> getBills(Bill bill) {
        return billMapper.getBills(bill);
    }

    @Override
    public BillProvider getBillByBid(Integer bid) {
        return billMapper.getBillByBid(bid);
    }

    @Override
    public int addBill(Bill bill) {
        billMapper.addBill(bill);
        return 0;
    }

    @Override
    public int updateBill(Bill bill) {
        billMapper.updateBill(bill);
        return 0;
    }

    @Override
    public int deteleByBid(Integer bid) {
        billMapper.deteleBillByBid(bid);
        return 0;
    }
}
