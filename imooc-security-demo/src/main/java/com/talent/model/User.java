package com.talent.model;

import com.alibaba.fastjson.JSON;

import java.util.Date;

/**
 * @author guobing
 * @Title: User
 * @ProjectName spring-security
 * @Description: TODO
 * @date 2019/1/28下午3:40
 */
public class User {

    private int id;

    private String username;

    private String password;

    private Date birthday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
