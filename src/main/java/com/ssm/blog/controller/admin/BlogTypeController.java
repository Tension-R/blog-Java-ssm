package com.ssm.blog.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ssm.blog.entity.BlogType;
import com.ssm.blog.entity.PageBean;
import com.ssm.blog.service.BlogTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tension on 17-6-18.
 * 博客分类控制器
 */
@Controller
@RequestMapping(value = "/admin/blogType")
public class BlogTypeController {

    @Resource
    private BlogTypeService blogTypeService;

    //分页查询博客类别
    @RequestMapping(value = "/list")
    public String listBlogType(
            @RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows,
            HttpServletResponse resp) throws IOException {

        //根据页面传回的参数初始化pageBean
        PageBean<BlogType> blogTypePageBean = new PageBean<BlogType>(
                Integer.parseInt(page), Integer.parseInt(rows));

        //设置分页结果和总数
        blogTypePageBean = blogTypeService.listByPage(blogTypePageBean);

        //使用阿里巴巴的FastJson创建jsonObject
        JSONObject jsonObject = new JSONObject();

        //通过fastJson序列化分页结果
        String jsonArray = JSON.toJSONString(blogTypePageBean.getResult());
        JSONArray array = JSONArray.parseArray(jsonArray);

        //序列化结果放入json对象
        jsonObject.put("rows",array);
        jsonObject.put("total",blogTypePageBean.getTotal());

        //响应输出
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(jsonObject.toJSONString());
        writer.flush();
        writer.close();

        return null;
    }
}
