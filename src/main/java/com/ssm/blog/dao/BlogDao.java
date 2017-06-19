package com.ssm.blog.dao;

import com.ssm.blog.entity.Blog;
import com.ssm.blog.entity.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 博文Dao
 * Created by tension on 17-6-19.
 */
@Repository
public interface BlogDao {

    /**
     * 分页查询博客
     *
     * @param map
     * @return
     */
    List<PageBean> listBlog(Map<String, Object> map);

    /**
     * 获取总记录
     *
     * @return
     */
    int getTotalNum(Map<String, Object> map);

    /**
     * 根据博客类型id查询博客数量
     * @param typeId
     * @return
     */
    int getBlogNumByTypeId(int typeId);

    /**
     * 增加博客
     * @param blog
     * @return
     */
    int addBlog(Blog blog);

    /**
     * 删除博客
     * @param blogId
     * @return
     */
    int deleteBlog(int blogId);

    /**
     * 更新博客
     * @param blog
     * @return
     */
    int updateBlog(Blog blog);

    /**
     * 通过博客id查询博客
     * @param blogId
     * @return
     */
    Blog getBlogById(int blogId);
}
