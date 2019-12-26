package com.example.springweb.controller;
import com.example.springweb.dao.User;
import com.example.springweb.service.AppService;
import com.example.springweb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    UserService userService;
    AppService appService;
    public final static Logger logger = LoggerFactory.getLogger(AddAppController.class);

    @RequestMapping(value = "/index")
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/login")
    public ModelAndView submit(@RequestParam("username") String username,
                               @RequestParam("password") String password,HttpServletRequest request,ModelAndView mv) {
        HttpSession session = request.getSession();
        if (userService.userLogin(username,password)) {
            //session.setAttribute("loginUser", username);
            //session.setAttribute("user",username);
            mv.setViewName("redirect:/main");
            mv.addObject("user", username);
            //mv.addObject("password", password);
        } else {
            mv.setViewName("redirect:/index");
            mv.addObject("name", "登录失败,请检查用户名密码");
        }
        return mv;
    }

}
