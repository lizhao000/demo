package com.example.Controller;

import com.example.Service.impl.UsersServiceImpl;
import com.example.entity.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ChangePasswordController {
    @Autowired
    UsersServiceImpl usersService;

    @RequestMapping("/pwd/{oldPwd}")
    @ResponseBody
    public Boolean checkPwd(HttpSession session, @PathVariable("oldPwd") String oldPwd) {
        //1.从Session中获取当前登录用户的User对象
        User user = (User) session.getAttribute("loginUser");
        if (user.getPassword().equals(oldPwd)) {
            //输入的旧密码正确
            return true;
        }
        return false;
    }

    @RequestMapping("/updatepwd")
    public String updatepwd(HttpSession session, String password) {
//        1.从Session中获取当前登录用户信息
        User user = (User) session.getAttribute("loginUser");
        //2. 更新密码
        user.setPassword(password);
//        3. 提交到数据库
        usersService.update(user);
        //4. 注销重新登录
        return "redirect:/logout";
    }

}
