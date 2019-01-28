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
@RequestMapping("/user")
public class UserController {

    @GetMapping
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
    @GetMapping("/{id:\\d+}")
    public User getInfo(@PathVariable String id) {
        System.out.println(id);
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    /**
     * post请求中传递的参数需要使用@RequestBody进行绑定
     * @param user
     * @return
     */
    @PostMapping
    public User create(@RequestBody User user) {
        System.out.println(user);
        user.setId(1);
        return user;
    }
}
