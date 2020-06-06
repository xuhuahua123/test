package com.xy.dao;

import com.xy.entity.StoreHouse;
import org.apache.ibatis.annotations.Param;

public interface StoreHouseDao {
    /**
     *
     * @param id
     * @return
     */
    StoreHouse getStock(@Param("id") Integer id);

    /**
     *
     * @param id
     * @return
     */
    int updateStoreHouseById(@Param("bookId") Integer bookId,@Param("count") Integer count);
}
