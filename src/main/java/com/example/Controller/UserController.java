package com.example.Controller;

import com.example.Service.UsersService;
import com.example.entity.users.Provider;
import com.example.entity.users.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UsersService usersService;
    @RequestMapping("/user")
    public String users(Map map ,User user,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "1") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);//引入分页查询，使用PageHelper分页功能在查询之前传入当前页，然后多少记录
        List <User> users = usersService.findAll(user);
        PageInfo pageInfo = new PageInfo<User>(users, 5); //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
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

        map.put("users",users);
        map.put("username",user.getUsername());
        return "user/user";
    }
    @RequestMapping("/adduser")
    public String adduser(User user,Map map){
        User name = usersService.getName(user.getUsername());
        if (name==null){
            usersService.add(user);
            return "redirect:/user";
        }
//        map.put("username","用户名已存在");
        return"redirect:/user";
    }
    @RequestMapping("/user/{id}")
    public String user(Map map , @RequestParam(value="type", defaultValue = "view") String type,@PathVariable("id")Integer id){
        User user = usersService.getById(id);
        map.put("user",user);
        return "user/"+type;
    }
    @RequestMapping("/updateuser")
    public String updateuser(User user) {
       usersService.update(user);
        return "redirect:/user";
    }
    @RequestMapping("/userdelete/{id}")
    public String userdelete(@PathVariable("id") Integer id) {
          usersService.deleteId(id);
        return "redirect:/user";
    }
}
