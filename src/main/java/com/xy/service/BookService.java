package com.xy.service;

import com.xy.entity.Book;
import com.xy.entity.User;

import java.util.List;

public interface BookService {
    /**
     *
     * @param index
     * @param pageSize
     * @return
     */
    List<Book>  queryBookByPage(Integer index, Integer pageSize);

    /**
     *
     * @param id
     * @return
     */
    Book queryUserById(Integer id);

    /**
     *
     * @return
     */
    Integer queryRowsCount();

    /**
     *
     * @param book
     * @return
     */
    int addBook(Book book);

    boolean buyBook(Integer bookId ,Integer accId);
}
