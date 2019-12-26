package com.example.springweb;

import com.example.springweb.dao.User;
import com.example.springweb.service.UserService;
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
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void getUsers() {
        List<User> users = userService.getUserList();
        assertFalse("User not null", users == null);
        assertNotNull(users);
        assertNotEquals(users.size(), 0);
        assertEquals(users.get(0).getName(), "admin");
    }

    @Test
    public void  testgetByname1(){
        String username = "admin";
        User user = userService.getByname(username);

        assertFalse("User not null", user == null);
        assertNotNull(user);
        //assertNotEquals(users.size(), 0);
        assertEquals(user.getPassword(), "123456");
    }
    @Test
    public void  testgetByname2(){
        String username = "user";
        User user = userService.getByname(username);

        assertFalse("User not null", user == null);
        assertNotNull(user);
        //assertNotEquals(users.size(), 0);
        assertEquals(user.getPassword(), "123");
    }
    @Test
    public void  testgetByname3(){
        String username = "Li";
        User user = userService.getByname(username);

        //assertFalse("User not null", user == null);
        //assertNotNull(user);
        //assertNotEquals(users.size(), 0);
        assertEquals(user, null);
    }
    @Test
    public void testuserlogin1(){
        String username = "admin";
        String password = "123456";
        assertEquals(userService.userLogin(username,password),true);
    }
    @Test
    public void testuserlogin2(){
        String username = "Lihua";
        String password = "123456";
        assertEquals(userService.userLogin(username,password),true);
    }
    @Test
    public void testInsert() throws Exception{
        //helloService.InsertUser(new HelloUser("4","zyy","dsb"));
       // assertEquals(helloService.getUserList().size(),3);
        Map<String,String> params=new HashMap<>();
        params.put("id","4");
        params.put("name","niha");
        params.put("password","yes");
        userService.InsertUser(params);
        assertEquals(userService.getUserList().size(),4);
    }

    @Test
    public void testGetOne() throws Exception{
        User user = userService.getOne("9");
        assertEquals(user.getName(),null);
    }

    @Test
    public void testUpdate() throws Exception{
       // helloService.UpdateByID(new HelloUser("3","ooo","bbbb"));
       // assertEquals(helloService.getOne("3").getName(),"ooo");
        Map<String,String> params=new HashMap<>();
        params.put("id","4");
        params.put("name","yyy");
        userService.UpdateByID(params);
        assertEquals(userService.getOne("4").getName(),"yyy");
    }

    @Test
    public void testDelete() throws Exception{
        userService.DeleteByID("4");
        assertEquals(userService.getOne("4").getName(),null);
    }
}
