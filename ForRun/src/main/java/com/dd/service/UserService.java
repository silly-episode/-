package com.dd.service;
import com.dd.entity.User;


public interface UserService {

    User selectUserById(Integer id);

    int getIdByName(String name);

    boolean login(User user);

    boolean register(User user);
}
