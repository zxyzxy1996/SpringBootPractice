package com.imooc.controller;

import com.imooc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author RockerBaozi
 * @date 2019/5/8 15:02
 */
@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("name", "Yoo Hello Thymeleaf");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center(ModelMap modelMap) {
        return "thymeleaf/center/center";
    }

    @RequestMapping("test")
    public String test(ModelMap modelMap) {

        User user = new User();
        user.setName("superadmin");
        user.setAge(18);
        user.setPassword("password");
        user.setBirthday(new Date());
        user.setDesc("<font color='green'><b>hello imooc</b></font>");

        modelMap.addAttribute("user", user);

        User user1 = new User();
        user1.setName("imooc_2");
        user1.setAge(11);
        user1.setPassword("password");
        user1.setBirthday(new Date());
        user1.setDesc("<font color='green'><b>hello imooc</b></font>");

        User user2 = new User();
        user2.setName("imooc_3");
        user2.setAge(22);
        user2.setPassword("password");
        user2.setBirthday(new Date());
        user2.setDesc("<font color='green'><b>hello imooc</b></font>");

        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);

        modelMap.addAttribute("userList", userList);

        return "thymeleaf/test";
    }

    @RequestMapping("postform")
    public String postForm(User user) {
        System.out.println(user.getName());
        System.out.println(user.getAge());
        return "redirect:/th/test";
    }

    @RequestMapping("showerror")
    public String showError(User user) {

        int a = 1 / 0;

        return "redirect:/th/test";
    }
}
