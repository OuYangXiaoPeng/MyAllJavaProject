package com.neu.service;

import com.neu.mapper.UserMapper;
import com.neu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl() {
    }

    public User getUser(String userName) {
        return this.userMapper.findUserByName(userName);
    }

    public boolean isLogin(User user) {
        boolean flag = false;
        User u = this.userMapper.findUserByName(user.getUserName());
        if (u != null && user.getPassword().equals(u.getPassword())) {
            flag = true;
        }

        return flag;
    }

    public List<User> getUsers() {
        return this.userMapper.findAll();
    }

    public int addUser(User user) {
        return this.userMapper.insert(user);
    }

    public int updateUser(User user) {
        return this.userMapper.update(user);
    }

    public int delUser(String id) {
        return this.userMapper.delete(id);
    }

    public User getSingleUser(String id) {
        return this.userMapper.findUserById(id);
    }

    @Override
    public List<User> getUsersByKeyword(String keyword) {
        return this.userMapper.findUserByKeyword(keyword);
    }

}
