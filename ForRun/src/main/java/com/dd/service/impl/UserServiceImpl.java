package com.dd.service.impl;
import com.dd.entity.User;
import com.dd.mapper.UserMapper;
import com.dd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public  class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectUserById(Integer id) {
        return userMapper.getUserById(id);
    }
    @Override
    public int getIdByName(String name) {
        return userMapper.getUserByName(name).getUid();
    }
    //登录判断业务逻辑
    @Override
    public boolean login(User user) {
        String name=user.getName();
        String pwd=user.getPwd();
        //通过name得到user
        User u=userMapper.getUserByName(name);
        //先通过name判断数据库中是否有该用户，若无则return ：false，有则比对密码。
        if(null==u){
            return false;
        }
        else{
            if(u.getPwd().equals((pwd))) {
                return true;
            } else{
                return false;
            }
        }
    }
    //注册业务逻辑
    @Override
    public boolean register(User user) {
        int judge= userMapper.insertUser(user);
        //注册成功返回true
        if(judge>0) {
            return true;
        }
        else {
            return false;
        }
    }
}
