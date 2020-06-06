package com.xy.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private Integer bookId;
    private String bookName;
    private  String publicDept;
    private Double bookPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicDate;
    private String bookAuth;
    private String imgPath;
    private String summary;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", publicDept='" + publicDept + '\'' +
                ", bookPrice=" + bookPrice +
                ", publicDate=" + publicDate +
                ", bookAuth='" + bookAuth + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublicDept() {
        return publicDept;
    }

    public void setPublicDept(String publicDept) {
        this.publicDept = publicDept;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public String getBookAuth() {
        return bookAuth;
    }

    public void setBookAuth(String bookAuth) {
        this.bookAuth = bookAuth;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
