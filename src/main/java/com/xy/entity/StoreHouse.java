package com.xy.entity;

import java.io.Serializable;

public class StoreHouse implements Serializable {

    private Integer bookId;
    private Integer bookCount;

    @Override
    public String toString() {
        return "StoreHouseService{" +
                "bookId=" + bookId +
                ", bookCount=" + bookCount +
                '}';
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }
}
