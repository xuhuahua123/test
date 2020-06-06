package com.xy.controller;

import com.xy.entity.Account;
import com.xy.entity.User;
import com.xy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {


    @Autowired
    OrderService orderService;

    @RequestMapping("/gerAcc")
    @ResponseBody
    public List<Account> getAccounts(HttpServletRequest request){
       HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");
        return orderService.queryAccounts(user.getUserid());
    }
    @RequestMapping("/balance")
    @ResponseBody
    public Integer getbalance(Integer id){
        System.out.println(id);
        return orderService.queryBalance(id);
    }

}
