package com.example.springweb.service;

import com.example.springweb.dao.AppRequest;
import com.example.springweb.dao.User;
import com.example.springweb.mapper.AppMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppService {
    @Resource
    private AppMapper appMapper;
    private String username;
    public List<AppRequest> getAppList(String user) {
        List<AppRequest> list = appMapper.findAll(user);
        return list;
    }
    /*public void InsertUser(HelloUser helloUser){
        helloMapper.insert(helloUser);
        System.out.println("Afterinsert:"+helloMapper.findAll());
    }*/
   /* public void Insertapp(String app_type1,String app_type2,String app_name,String app_level, String app_use,String app_solve,String app_new,String app_state){
        ObjectMapper objectMapper = new ObjectMapper();
        AppRequest appRequest = new AppRequest();
        appRequest.setType1(app_type1);
        appRequest.setType2(app_type2);
        appRequest.setLevel(app_level);
        appRequest.setName(app_name);
        appRequest.setUse(app_use);
        appRequest.setSolve(app_solve);
        appRequest.setNew(app_new);
        if(app_state==null)
            appRequest.setState("未审核");
        else
            appRequest.setState(app_state);
        appMapper.insert(appRequest);
    }*/
    public void Insertapp(Map<String, String> params){
        ObjectMapper objectMapper = new ObjectMapper();
        AppRequest app = objectMapper.convertValue(params, AppRequest.class);
        appMapper.insert(app);
    }
    public void setUsername(String user){
        this.username = user;
    }
    public String  getUsername(){
        return username;
    }
}
