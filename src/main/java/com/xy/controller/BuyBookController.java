package com.xy.controller;

import com.xy.entity.Book;
import com.xy.entity.StoreHouse;
import com.xy.entity.User;
import com.xy.service.BookService;
import com.xy.service.StoreHouseService;
import com.xy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller

public class BuyBookController {

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    @Autowired
    StoreHouseService storeHouseService;

    @RequestMapping("/logincheck")
    public String login(){
        return "login";
    }

    @RequestMapping("login")

    public String login(String username, String password, HttpServletRequest request){
        HttpSession session =request.getSession();
        User user = null;
        if(username != null && password != null){

              user = userService.queryById(username);

            if(password.equals(user.getLoginPwd())){
                session.setAttribute("user",user);

                return "forward:check/order";
            }
        }

        return "error";
    }
    @RequestMapping("/check/order")
    public String order(Integer id, Model model){
        Book book = bookService.queryUserById(id);
        StoreHouse storeHouse = storeHouseService.queryStock(id);
        model.addAttribute("book",book);
        model.addAttribute("storeHouse",storeHouse);
        return "order";
    }

    @RequestMapping("/mainlogin")
    @ResponseBody
    public String mianLogin(String username ,String password,HttpServletRequest request){
        System.out.println(username+"---"+password);
        HttpSession session =request.getSession();
        User user = null;
        if(username != null && password != null){

            user = userService.queryById(username);

            if(password.equals(user.getLoginPwd())){
                session.setAttribute("user",user);

                return user.getLoginName();
            }
        }

        return "error";
    }
}
