package com.xy.service;

import com.xy.entity.User;

public interface UserService {
    /**
     *
     * @param loginName
     * @return
     */
    User queryById(String loginName);

    /**
     *
     * @param user
     * @return
     */
    int addUser(User user);
}
