package com.example.demo.service;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Slf4j
@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void insert(User user) {
        userMapper.insert(user);
    }
    public User getUser(String name) {
        log.debug("2");
        return userMapper.getByUserName(name);
    };

    public void updateUser(String userName, String name, int age, String gender, String detail) {
        userMapper.updateUser(userName, name, age, gender, detail);
    }

    public void changePassword(String userName, String password) {
        userMapper.changePassword(userName, password);
    }
}
