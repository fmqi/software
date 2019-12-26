package com.example.springweb.controller;

import com.example.springweb.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AddAppController {
    @Autowired
    AppService appService;
    public final static Logger logger = LoggerFactory.getLogger(AddAppController.class);
    @RequestMapping(value = "/addApp")
    public ModelAndView addApp(ModelAndView mv) {
        mv.setViewName("addApp");
        return mv;
    }
    @RequestMapping("/add")
    public ModelAndView add(ModelAndView mv,HttpServletRequest request) {
        //model.addAttribute("greeting", "Hello!");
        HttpSession session = request.getSession();
        mv.setViewName("redirect:/addApp");
        String user = request.getParameter("user");
        //mv.addObject("user", user);
      //  mv.addObject("name", "登录成功");
        return mv;
    }
    @RequestMapping("/cancle")
    public ModelAndView cancle(ModelAndView mv, HttpServletRequest request){
        HttpSession session = request.getSession();
        String user = appService.getUsername();
        mv.setViewName("redirect:/main");
        mv.addObject("user", user);
        return mv;
    }
    @RequestMapping(value = "/up")
    public ModelAndView addApp(@RequestParam("app_type1") String app_type1,
                        @RequestParam("app_type2") String app_type2,
                        @RequestParam("app_name") String app_name,
                        @RequestParam("app_level") String app_level,
                        @RequestParam("app_use") String app_use,
                        @RequestParam("app_solve") String app_solve,
                        @RequestParam("app_new") String app_new,ModelAndView mv,HttpServletRequest request,Model model){
        HttpSession sessoin = request.getSession();
        //String user = request.getParameter("user");
        Map<String,String> params=new HashMap<>();params.put("type1",app_type1);
        params.put("type2",app_type2);      params.put("name",app_name);
        params.put("level",app_level);      params.put("use",app_use);
        params.put("solve",app_solve);      params.put("new",app_new);
        params.put("state","未审核");        params.put("user",appService.getUsername());
        appService.Insertapp(params);
        //logger.info("sucess insert");
        //model.addAttribute("greeting", "Hello!"+ helloService.getUserList());
        //model.addAttribute("list", appService.getUserList());
        mv.setViewName("redirect:/main");
        mv.addObject("user", appService.getUsername());
        //mv.addObject("name", "登录成功");
        return mv;
    }

}
