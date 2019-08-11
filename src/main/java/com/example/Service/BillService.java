package com.example.Service;

import com.example.entity.users.Bill;
import com.example.entity.users.BillProvider;

import java.util.List;

public interface BillService {
    List<BillProvider> getBills(Bill bill);

    BillProvider getBillByBid(Integer bid);

    int addBill(Bill bill);

    int updateBill(Bill bill);

    int deteleByBid(Integer bid);
}
