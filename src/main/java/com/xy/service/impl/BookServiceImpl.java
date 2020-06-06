package com.xy.service.impl;

import com.xy.dao.BookDao;
import com.xy.dao.OrderDao;
import com.xy.dao.StoreHouseDao;
import com.xy.entity.Account;
import com.xy.entity.Book;
import com.xy.entity.StoreHouse;
import com.xy.entity.User;
import com.xy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    StoreHouseDao storeHouseDao;

    @Override
    public List<Book> queryBookByPage(Integer index, Integer pageSize) {
        Integer start = (index-1)*pageSize;
        return bookDao.getBookByPage(start,pageSize);
    }

    @Override
    public Book queryUserById(Integer id) {
        return bookDao.getBookById(id);
    }

    @Override
    public Integer queryRowsCount() {
        return bookDao.getRowsCount();
    }

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }


    @Override
    public boolean buyBook(Integer bookId, Integer accId) {
        boolean flag = false;
       StoreHouse storeHouse =  storeHouseDao.getStock(bookId);
       Integer count = storeHouse.getBookCount();
       if(count>0){
           count--;
           storeHouseDao.updateStoreHouseById(bookId,count);
           flag =true;
       }else{
           flag =false;
       }

       Double balance = orderDao.getBalance(accId)+0.00;
       Book book = bookDao.getBookById(bookId);
       if(balance>= book.getBookPrice()){
            Account account = new Account();
            account.setAccId(accId);
            account.setBalance(balance-book.getBookPrice());
            orderDao.updateAccount(account);
            flag =true;
       }else{
           flag = false;
       }
        return flag;
    }
}
