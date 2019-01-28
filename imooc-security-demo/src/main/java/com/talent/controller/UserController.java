package com.talent.controller;

import com.talent.model.User;
import com.talent.model.UserCondition;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guobing
 * @Title: UserController
 * @ProjectName spring-security
 * @Description: 用户控制器
 * @date 2019/1/28下午3:19
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> query(UserCondition userCondition) {
        System.out.println(userCondition);
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    /**
     * 只能接收数字
     * @param id
     * @return
     */
    @GetMapping("/user/{id:\\d+}")
    public User getInfo(@PathVariable String id) {
        System.out.println(id);
        User user = new User();
        user.setUsername("tom");
        return user;
    }
}
