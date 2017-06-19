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
        jsonObject.put("rows", array);
        jsonObject.put("total", blogTypePageBean.getTotal());

        //响应输出
        respWrite(resp, jsonObject);

        return null;
    }

    @RequestMapping(value = "/save")
    public String save(BlogType blogType, HttpServletResponse resp) throws IOException {
        //返回记录的数量
        int resultNum = 0;

        if (blogType.getId() != null) {
            //id不为空，更新博客类别
            resultNum = blogTypeService.updateBlogType(blogType);
        } else {
            //id为空，新增博客类型
            resultNum = blogTypeService.addBlogType(blogType);
        }

        JSONObject jsonObject = new JSONObject();
        //操作是否成功
        if (resultNum > 0) {
            jsonObject.put("success", true);
        } else {
            jsonObject.put("success", false);
        }
        //响应输出
        respWrite(resp, jsonObject);

        return null;
    }

    @RequestMapping(value = "/delete")
    public String deleteBlog(@RequestParam("ids") String ids, HttpServletResponse resp) throws IOException {
        //返回记录数量
        int resultNum = 0;
        //分离为id数组
        String[] idsStr = ids.split(",");

        JSONObject jsonObject = new JSONObject();

        for (String anIdsStr : idsStr) {
            //TODO
            //判断该博客类型下是否有博客
            resultNum = blogTypeService.deleteBlogType(Integer.parseInt(anIdsStr));
        }

        if (resultNum > 0) {
            jsonObject.put("success", true);
        }

        respWrite(resp, jsonObject);

        return null;
    }


    //响应输出
    private void respWrite(HttpServletResponse resp, JSONObject jsonObject) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(jsonObject.toJSONString());
        writer.flush();
        writer.close();
    }
}
