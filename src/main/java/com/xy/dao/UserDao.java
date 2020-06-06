package com.xy.dao;

import com.xy.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    /**
     *
     * @param loginName
     * @return
     */
    User getUserById(@Param("loginName") String loginName);

    int putUser(@Param("user") User user);


}
