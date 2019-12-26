package com.example.springweb;

import com.example.springweb.dao.AppRequest;
import com.example.springweb.service.AppService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppServiceTest {
    @Autowired
    AppService appService;
    @Test
    public void getapps1() {
        List<AppRequest> apps = appService.getAppList("admin");
        assertFalse("User not null", apps == null);
        assertNotNull(apps);
        assertNotEquals(apps.size(), 0);
        assertEquals(apps.get(0).getName(), "学生管理系统");
        assertEquals(apps.get(0).getType1(), "适用范围");
        assertEquals(apps.get(0).getType2(), "基础共性工业APP");
        assertEquals(apps.get(0).getLevel(), "A");
        assertEquals(apps.get(0).getState(), "已通过");
    }
    @Test
    public void getapps2() {
        List<AppRequest> apps = appService.getAppList("admin");
        assertFalse("User not null", apps == null);
        assertNotNull(apps);
        assertEquals(apps.size(), 4);
        assertEquals(apps.get(1).getName(), "学生管理系统");
    }
    @Test
    public void testInsert1() throws Exception{
        //helloService.InsertUser(new HelloUser("4","zyy","dsb"));
        // assertEquals(helloService.getUserList().size(),3);
        Map<String,String> params=new HashMap<>();
        params.put("type1","适用范围");
        params.put("type2","基础共性工业APP");
        params.put("name","黑白棋对战平�);
        params.put("level","A");
        params.put("use","游戏");
        params.put("solve","对战");
        params.put("new","普�);
        params.put("state","未通过");
        params.put("user","user");
        appService.Insertapp(params);
        assertEquals(appService.getAppList("user").size(),4);
    }
    @Test
    public void testInsert_2() throws Exception{
        //helloService.InsertUser(new HelloUser("4","zyy","dsb"));
        // assertEquals(helloService.getUserList().size(),3);
        Map<String,String> params=new HashMap<>();
        params.put("type1","适用范围");
        params.put("type2","基础共性工业APP");
        params.put("name","操作系统");
        params.put("level","A");
        params.put("use","PC");
        params.put("solve","计算机领�);
        params.put("new","普�);
        params.put("state","已通过");
        params.put("user","user");
        appService.Insertapp(params);
        assertEquals(appService.getAppList("user").size(),3);
    }
    @Test
    public void testInsert3() throws Exception{
        Map<String,String> params=new HashMap<>();
        params.put("type1","");
        params.put("type2","");
        params.put("name","操作系统");
        params.put("level","A");
        params.put("use","PC");
        params.put("solve","计算机领�);
        params.put("new","普�);
        params.put("state","已通过");
        params.put("user","user");
        appService.Insertapp(params);
        assertEquals(appService.getAppList("user").size(),4);
    }
    @Test
    public void testInsert4() throws Exception{
        Map<String,String> params=new HashMap<>();
        params.put("type1","适用范围");
        params.put("type2","基础共性工业APP");
        params.put("name","操作系统");
        params.put("level","AAAAAAAAAAAAAAAAAAAAAAAAAAA");
        params.put("use","PC");
        params.put("solve","计算机领�);
        params.put("new","普�);
        params.put("state","已通过");
        params.put("user","user");
        appService.Insertapp(params);
        assertEquals(appService.getAppList("user").size(),4);
    }
}
