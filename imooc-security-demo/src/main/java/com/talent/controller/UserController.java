package com.talent.controller;

import com.talent.model.User;
import com.talent.model.UserCondition;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @ApiOperation(value = "用户查询服务")
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
    public User getInfo(@ApiParam(value = "用户id") @PathVariable String id) {
        System.out.println(id);
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    /**
     * post请求中传递的参数需要使用@RequestBody进行绑定
     * @param user
     * @param errors: 在实体类中标注的注解校验不通过了，就会将错误信息放到errors中
     * @return
     */
    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors) {
        System.out.println(user.getBirthday());
        // 是否有错误
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }
        user.setId(1);
        return user;
    }
}
