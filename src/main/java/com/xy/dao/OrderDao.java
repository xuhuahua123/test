package com.xy.dao;

import com.xy.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    /**
     *
     * @param userId
     * @return
     */
    List<Account> getAccount(@Param("userId") Integer userId);

    /**
     *
     * @param id
     * @return
     */
    Integer getBalance(@Param("id") Integer id);

    /**
     *
     * @param account
     * @return
     */
    int updateAccount(@Param("account") Account account);


}
