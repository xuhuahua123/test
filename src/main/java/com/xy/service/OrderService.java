package com.xy.service;

import com.xy.entity.Account;

import java.util.List;

public interface OrderService {

    /**
     *
     * @return
     */
    List<Account> queryAccounts(Integer userid);

    /**
     *
     * @param id
     * @return
     */
    Integer queryBalance(Integer id);
}
