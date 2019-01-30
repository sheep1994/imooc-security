package com.talent.model;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author guobing
 * @Title: UserCondition
 * @ProjectName spring-security
 * @Description: user扩展类
 * @date 2019/1/28下午3:52
 */
public class UserCondition {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户年龄起始值")
    private int age;

    @ApiModelProperty(value = "用户年龄区间值")
    private int ageTo;

    @ApiModelProperty(value = "用户...")
    private String xxx;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
