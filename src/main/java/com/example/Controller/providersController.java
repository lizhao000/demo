package com.example.Controller;

import com.example.Service.impl.ProviderServiceImpl;
import com.example.entity.users.Provider;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class providersController {
    @Autowired
    ProviderServiceImpl providerService;
    @RequestMapping("/providers")
    public String providers(Map map, Provider provider, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);//引入分页查询，使用PageHelper分页功能在查询之前传入当前页，然后多少记录
        List <Provider> providers = providerService.getProviders(provider);//startPage后紧跟的这个查询就是分页查询
        PageInfo pageInfo = new PageInfo<Provider>(providers); //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
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
        map.put("provider",provider.getProviderName());
        return "provider/provider";
    }
    @PostMapping("/provider")
    public String add(Provider provider) {
        //保存数据操作
       providerService.addProvider(provider);
        return "redirect:/providers";
    }
    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid") Integer pid,Map map) {
        //查看详情
        Provider provider= providerService.getProviderByPid(pid);
        map.put("provider",provider);
        return "provider/view";
    }
    @RequestMapping("/update/{pid}")
    public String update(@PathVariable("pid") Integer pid,Map map) {
        Provider provider= providerService.getProviderByPid(pid);
        map.put("provider",provider);
        return "/provider/update";
    }
    @RequestMapping("/updateprovider")
    public String updateprovider(Provider provider) {
      providerService.updateProvider(provider);
        return "redirect:providers";
    }
    @RequestMapping("/providerde/{pid}")
    public String delete(@PathVariable("pid") Integer pid) {
        providerService.deleteProviderByPid(pid);
        return "redirect:/providers";
    }
    @RequestMapping("/deleteprovider")
    public String deleteprovider(@RequestBody List<Long> ids) {
        providerService.batchDelete(ids);
        return "redirect:/bills";
    }
}
