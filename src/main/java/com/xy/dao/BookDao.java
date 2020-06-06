package com.xy.dao;

import com.xy.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;

import java.util.List;

public interface BookDao {
    /**
     *
     * @param start
     * @param pageSize
     * @return
     */
    List<Book> getBookByPage(@Param("start") Integer start , @Param("pageSize") Integer pageSize);

    /**
     *
     * @param id
     * @return
     */
    Book getBookById(@Param("id") Integer id);

    /**
     *
     * @return
     */
    Integer getRowsCount();

    /**
     *
     * @param book
     * @return
     */
    int addBook(@Param("book") Book book);


}
