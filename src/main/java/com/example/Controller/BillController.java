package com.example.Controller;

import com.example.Service.BillService;
import com.example.Service.ProviderService;
import com.example.entity.users.Bill;
import com.example.entity.users.BillProvider;
import com.example.entity.users.Provider;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class BillController {
    @Autowired
    BillService billService;
    @Autowired
    ProviderService providerService;
    @RequestMapping("/bills")
    public String bills(Map map, Bill bill, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);//引入分页查询，使用PageHelper分页功能在查询之前传入当前页，然后多少记录
        List <BillProvider> bills = billService.getBills(bill);// ;//startPage后紧跟的这个查询就是分页查询
        List <Provider> providers = providerService.getProviders(null);
        PageInfo pageInfo = new PageInfo<BillProvider>(bills, 5); //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
        map.put("pageInfo", pageInfo);
        //获得当前页
        map.put("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        map.put("pageSize", pageInfo.getPageSize());
        //是否是第一页
        map.put("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        map.put("totalPages", pageInfo.getPages());
        //是否是最后一页
        map.put("isLastPage", pageInfo.isIsLastPage());
        //总条数
        map.put("Total", pageInfo.getTotal());

        map.put("providers",providers);
        map.put("bills",bills);
        map.put("billName", bill.getBillName());
        map.put("pid", bill.getPid());
        map.put("pay", bill.getPay());
        return "bill/bill";
    }
    @RequestMapping("/bill")
    public String addbill(Bill bill) {
        //保存数据操作
        billService.addBill(bill);
        return "redirect:/bills";
    }
    @RequestMapping("/bill/{bid}")
    public String billById(Map map , @RequestParam(value="type", defaultValue = "view") String type,@PathVariable("bid")Integer bid){
        BillProvider bill = billService.getBillByBid(bid);
        if( "update".equals(type)) {
            List <Provider> providers = providerService.getProviders(null);
            map.put("providers", providers);
        }
        map.put("bill",bill);
        return "bill/"+type;
    }
    @RequestMapping("/updatebill")
    public String updatebill(Bill bill, Model model) {
        billService.updateBill(bill);
        return "redirect:bills";
    }
    @RequestMapping("/billde/{bid}")
    public String delete(@PathVariable("bid") Integer bid) {
        billService.deteleByBid(bid);
        return "redirect:/bills";
    }
}
