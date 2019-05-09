package com.imooc.controller;

import com.imooc.pojo.IMoocJSONResult;
import com.imooc.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @RestController = @Controller + @ResponseBody
 *
 * @author RockerBaozi
 * @date 2019/5/6 17:39
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
    /**
     * @ResponseBody
     */
    public User getUser() {

        User user = new User();
        user.setName("imooc2");
        user.setAge(30);
        user.setBirthday(new Date());
        user.setPassword("imooc");
        user.setDesc("Hello SpringBoot");

        return user;
    }

    @RequestMapping("/getUserJson")
    /**
     * @ResponseBody
     */
    public IMoocJSONResult getUserJson() {

        User user = new User();
        user.setName("Json");
        user.setAge(20);
        user.setBirthday(new Date());
        user.setPassword("Json");
        user.setDesc("2019-05-07");

        return IMoocJSONResult.ok(user);
    }
}
