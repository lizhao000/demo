package com.example.Controller;

import com.example.Service.UsersService;
import com.example.entity.users.User;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/getUsersList")
    @ResponseBody
    public List<User> userList(User user) {
        List <User> list = usersService.findAll(user);
        return list;
    }

//    @RequestMapping("/adduser")
//    @ResponseBody
//    public String adduser() {
//        User user = new User();
//        user.setId(4);
//        user.setUsername("ziz");
//        user.setPassword("1236");
//        usersService.add(user);
//        return "添加成功";
//    }

    @ResponseBody
    @RequestMapping("/getUsersById/{id}")
    public User getUsersById(@PathVariable("id") int id) {
        User user = usersService.getById(id);
        return user ;
    }

    @ResponseBody
    @RequestMapping("/getUsersName/{name}")
    public User getUsersName(@PathVariable("name") String name) {
        User name1 = usersService.getName(name);
        return name1;
    }
    @RequestMapping("/deleteUsers/{id}")
    @ResponseBody
    public Integer deleteUsers(@PathVariable("id") int id) {
        Integer id1 = usersService.deleteId(id);

        return id1;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Integer update(int id) {
        User user = new User();
        user.setId(id);
        user.setUsername("aaa");
        user.setPassword("aaa");
        usersService.update(user);
        return id;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //1. 清空session中的用户信息
        session.removeAttribute("loginUser");
        //2. 再将session进行注销
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/index1")
    public String index() {
        return "index";
    }
    @RequestMapping("/homepage")
    public String homepage(HttpSession session, String username, String password, Map <String, Object> map) {
        if (!StringUtils.isNullOrEmpty(username) && !StringUtils.isNullOrEmpty(password)) {
            User user = usersService.getName(username);
            if (user != null && user.getPassword().equals(password)) {
                session.setAttribute("loginUser", user);
                return "redirect:/home";
            }
        }
        map.put("msg", "用户名或密码错误");
        return "login";
    }
    @RequestMapping("/password")
    public String password(){
        return "password/password";
    }
    @RequestMapping("/sss")
    public String sss(){
        return "homepage1.html";
    }

}

