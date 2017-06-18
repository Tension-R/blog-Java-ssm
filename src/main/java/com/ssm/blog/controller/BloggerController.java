package com.ssm.blog.controller;

/**
 * 博主控制器
 * Created by tension on 17-6-16.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //注册为控制器bean
@RequestMapping(value = "/admin") //请求路径
public class BloggerController {

    @RequestMapping(value = "/menu") //请求路径
    public String menu(){
        return "admin/menu";
    }
}
