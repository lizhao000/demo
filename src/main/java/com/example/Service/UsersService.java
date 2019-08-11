package com.example.Service;

import com.example.entity.users.User;

import java.util.List;

public interface UsersService {
    List <User> findAll(User user);

    void add(User user);

    Integer deleteId(int id);

    User update(User user);

    User getById(int id);

    User getName(String uersname);
}
