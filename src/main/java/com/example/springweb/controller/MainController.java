package com.example.springweb.controller;

import com.example.springweb.dao.AppRequest;
import com.example.springweb.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    AppService appService;
    public final static Logger logger = LoggerFactory.getLogger(MainController.class);


    @RequestMapping("/main")
    public ModelAndView main(ModelAndView mv, HttpServletRequest request) {
        //logger.info("hello logging" + appService.getUserList());
        HttpSession session = request.getSession();
        String user = request.getParameter("user");
        appService.setUsername(user);
        List<AppRequest> list = appService.getAppList(user);
        mv.addObject("list", list);
        mv.setViewName("/main");
        mv.addObject("user", user);
        //mv.addObject("name", "登录成功");
        //session.setAttribute("user",user);
        //mv.addObject("user",user);
        return mv;
    }
}
