package com.xy.service.impl;

import com.xy.dao.UserDao;
import com.xy.entity.User;
import com.xy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User queryById(String loginName) {
        return userDao.getUserById(loginName);
    }

    @Override
    public int addUser(User user) {
        return userDao.putUser(user);
    }
}
