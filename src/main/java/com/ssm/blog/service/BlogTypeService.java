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

    /**
     * 增加博客类型
     * @param blogType
     * @return
     */
    int addBlogType(BlogType blogType);

    /**
     * 删除博客类型
     * @param id
     * @return
     */
    int deleteBlogType(Integer id);

    /**
     * 更新博客类型
     * @param blogType
     * @return
     */
    int updateBlogType(BlogType blogType);

    long getTotalNum();
}
