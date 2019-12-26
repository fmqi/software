package com.example.springweb.mapper;

import com.example.springweb.dao.AppRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppMapper {
    @Select("select * from app where App_User = #{app_user}")
    @Results({
            @Result(property = "app_type1", column = "App_t1"),
            @Result(property = "app_type2", column = "App_t2"),
            @Result(property = "app_name", column = "App_N"),
            @Result(property = "app_level", column = "App_L"),
            @Result(property = "app_use", column = "App_U"),
            @Result(property = "app_solve", column = "App_S"),
            @Result(property = "app_new", column = "App_New"),
            @Result(property = "app_state", column = "App_State"),
            @Result(property = "app_user", column = "App_User")
    })
    List<AppRequest> findAll(String user);

    @Insert("insert into app(App_t1,App_t2,App_N,App_L,App_U,App_S,App_New,App_State,App_User)values(#{app_type1},#{app_type2},#{app_name},#{app_level},#{app_use},#{app_solve},#{app_new},#{app_state},#{app_user})")
    void insert(AppRequest app);


    /*@Select("select * from user where stringId = #{id}")
    @Results({
            @Result(property = "id",column = "stringId"),
            @Result(property = "name",column = "user_name")
    })
    HelloUser getOne(String id);


    @Select("select * from user where user_name = #{name}")
    @Results({
            @Result(property = "id",column = "stringId"),
            @Result(property = "name",column = "user_name")
    })
    HelloUser getByname(String name);


    @Update("update user set user_name = #{name}, password = #{password} where StringId = #{id}")
    void updateByID(HelloUser helloUser);//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值

    @Delete("delete from user where StringId = #{id}")
    void deleteByID(String id);//DELETE FROM 表名称 WHERE 列名称 = 值*/
}
