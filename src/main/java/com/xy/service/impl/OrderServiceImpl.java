package com.xy.service.impl;

import com.xy.dao.OrderDao;
import com.xy.entity.Account;
import com.xy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    public List<Account> queryAccounts(Integer userId) {
        return orderDao.getAccount(userId);
    }

    @Override
    public Integer queryBalance(Integer id) {
        return orderDao.getBalance(id);
    }
}
