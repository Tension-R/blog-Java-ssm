package com.ssm.blog.service;

import com.ssm.blog.entity.BlogType;
import com.ssm.blog.entity.PageBean;

/**
 * Created by tension on 17-6-18.
 */
public interface BlogTypeService {
    /**
     * 分页查询博客类型
     * @param pageBean
     * @return
     */
    PageBean<BlogType> listByPage(PageBean<BlogType> pageBean);
}
