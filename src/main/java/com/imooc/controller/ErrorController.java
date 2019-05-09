package com.imooc.controller;

import com.imooc.pojo.IMoocJSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author RockerBaozi
 * @date 2019/5/8 22:21
 */
@Controller
@RequestMapping("err")
public class ErrorController {

    @RequestMapping("/error")
    public String error() {

        int a = 1 / 0;

        return "thymeleaf/error";
    }

    @RequestMapping("/ajaxError")
    public String ajaxError() {

        return "thymeleaf/ajaxError";
    }

    @RequestMapping("/getAjaxError")
    public IMoocJSONResult getAjaxError() {

        int a = 1 / 0;

        return IMoocJSONResult.ok();
    }
}
