package com.example.dao;

import com.example.entity.users.User;

import java.util.List;

public interface UsersMapper {
      List<User> findAllUser(User user);
      int addUser(User user);
      int deleteUser(int id);
      int updateUser(User user);
      User getUserById(int id);
      User getUserName(String uersname);
}
