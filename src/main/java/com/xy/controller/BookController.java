package com.xy.controller;

import com.xy.entity.Book;
import com.xy.service.BookService;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Controller

public class BookController {

    @Autowired
    BookService bookService;
    @RequestMapping("/")
    public String gotoIndex(){
        return "redirect:page";
    }

    @RequestMapping("/page")
    public String getBookByPage(@RequestParam(defaultValue = "1",required = false) Integer index, @RequestParam(defaultValue = "5",required = false) Integer pageSize ,Model model){
        List<Book> bookList = bookService.queryBookByPage(index,pageSize);
        Integer count = bookService.queryRowsCount();
        int totalPage = count%pageSize ==0?count/pageSize:count/pageSize+1;
        model.addAttribute("booklist" ,bookList);
        model.addAttribute("totalpage",totalPage);
        model.addAttribute("index",index);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("count",count);
        return "main";
    }

    @RequestMapping("/byid")
    public String  getBookById(Integer id,Model model){

       Book book =  bookService.queryUserById(id);
       model.addAttribute("book" ,book);
      return "bookinfo";
    }

    @RequestMapping("/addbefore")
    public String add(){

        return "bookadd";
    }
    @RequestMapping("/add")
    public String add(Book book){

        int temp = bookService.addBook(book);
        System.out.println(book);
        return "redirect:page";
    }
    @RequestMapping("/gotoupload")
    public String gotoUpload(){
        return "bookadd2";
    }
    @RequestMapping("/upload")

    public String upload(Book book , MultipartFile pic) {
        if(pic.isEmpty()){
            return "error";
        }
        try {
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            String root = path.getAbsolutePath()+"\\static\\images";
            String oldName = pic.getOriginalFilename();

            pic.transferTo(new File(root+"\\"+oldName));
            book.setImgPath("images/"+oldName);
            bookService.addBook(book);
            return "redirect:page";
        }catch (IOException e){
            e.printStackTrace();
        }
        return "error";
    }
    @RequestMapping(value = "download" ,method = RequestMethod.GET)
    public ResponseEntity<byte []> downloadFile(String filename, HttpServletRequest request) throws IOException {
        String name = filename.substring(filename.lastIndexOf("/")+1);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment",filename);
        File path;
        String root;
        File file = null;
        try {
             path = new File(ResourceUtils.getURL("classpath:").getPath());
             root = path.getAbsolutePath() + "\\static";
             file = new File(root+"\\"+filename);
        }catch (IOException e){
            e.printStackTrace();
        }

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),httpHeaders, HttpStatus.OK);
    }
    @RequestMapping("/tobuy")
    @ResponseBody
    public String tobuy(Integer bookId,Integer accId){
        System.out.println(bookId+"  "+accId);
        if(bookService.buyBook(bookId,accId)){
            return "成功";
        }
        return "失败";
    }
}
