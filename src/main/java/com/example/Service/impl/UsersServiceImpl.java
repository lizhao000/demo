package com.example.Service.impl;

import com.example.Service.UsersService;
import com.example.dao.UsersMapper;
import com.example.entity.users.User;
import com.example.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper UserMapper;
    @Autowired
    RedisClient redisClient;

    @Override
    @Transactional//开启事务管理
    public List<User> findAll(User user) {
        return UserMapper.findAllUser(user);
    }
    @Override

    //注解缓存 @CacheEvict(cacheNames = "User", key="#id")
    public Integer deleteId(int id) {
        int size = UserMapper.deleteUser(id);
////        删除缓存key=id
//        if (size > 0) {
//            redisClient.del(id);
//        }
        return id;
    }

    @Override
//    @CachePut(cacheNames = "User",key="#User.id")
    public User update(User user) {
        int size = UserMapper.updateUser(user);
//        if (size > 0) {
//            //更新缓存数据
//            redisClient.set(user.getId(), user);
//        }
        return user;
    }

    @Override
//    @Cacheable(cacheNames  = "User",key="#id")
    public User getById(int id) {
//        Object object = redisClient.get(id);
//        if (object != null) {
//            return (User) object;
//        }
        User User = UserMapper.getUserById(id);
//        redisClient.set(id, User);
        return User;
    }

    @Override
    public User getName(String uersname) {
        return UserMapper.getUserName(uersname);
    }

    @Override
    public void add(User user) {

        int size = UserMapper.addUser(user);
        //添加缓存
//        if (size > 0) {
//            redisClient.set(user.getId(), user);
//        }
    }
}
