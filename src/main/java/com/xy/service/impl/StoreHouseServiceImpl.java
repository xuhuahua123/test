package com.xy.service.impl;

import com.xy.dao.StoreHouseDao;
import com.xy.entity.StoreHouse;
import com.xy.service.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreHouseServiceImpl implements StoreHouseService {

    @Autowired
    StoreHouseDao storeHouseDao;
    @Override
    public StoreHouse queryStock(Integer id) {
        return storeHouseDao.getStock(id);
    }
}
