package com.example.springweb.dao;

import java.io.Serializable;

public class AppRequest implements Serializable {
    private String app_type1;
    private String app_type2;
    private String app_name;
    private String app_level;
    private String app_use;
    private String app_solve;
    private String app_new;
    private String app_state;
    private String app_user;

    public AppRequest(){
        app_type1 = null;
        app_type2 = null;
        app_name = null;
        app_level = null;
        app_use = null;
        app_solve = null;
        app_new = null;
        app_state = null;
    }
    public AppRequest(String app_type1,String app_type2,String app_name,String app_level, String app_use,String app_solve,String app_new,String app_state){
        this.app_type1=app_type1;
        this.app_type2=app_type2;
        this.app_name=app_name;
        this.app_level = app_level;
        this.app_use=app_use;
        this.app_solve=app_solve;
        this.app_new=app_new;
        this.app_state = app_state;
    }

    public String getType1() {
        return app_type1;
    }
    public String getType2() {
        return app_type2;
    }
    public void setType1(String app_type1) {
        this.app_type1=app_type1;
    }
    public void setType2(String app_type2) {
        this.app_type2=app_type2;
    }
    public String getName() {
        return app_name;
    }

    public void setName(String app_name) {
        this.app_name = app_name;
    }

    public String getLevel() {
        return app_level;
    }

    public void setLevel(String app_level) {
        this.app_level = app_level;
    }

    public String getUse() {
        return app_use;
    }

    public void setUse(String app_use) {
        this.app_use = app_use;
    }

    public String getSolve() {
        return app_solve;
    }

    public void setSolve(String app_solve) {
        this.app_solve = app_solve;
    }

    
    public String getNew() {
        return app_new;
    }

    public void setNew(String app_new) {
        this.app_new = app_new;
    }


    public String getState() {
        return app_state;
    }

    public void setState(String app_state) {
        this.app_state = app_state;
    }
    public String getUser() {
        return app_user;
    }

    public void setUser(String app_user) {
        this.app_user = app_user;
    }
    @Override
    public String toString() {
        return app_type1 + "," + app_type2 + "," + app_name + "," + app_level;
    }
}
