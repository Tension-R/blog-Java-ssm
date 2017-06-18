package com.ssm.blog.dao;

import com.ssm.blog.entity.BlogType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 博客类别dao
 * Created by tension on 17-6-17.
 */
@Repository
public interface BlogTypeDao {

    /**
     * 添加博客类别信息
     * @param blogType
     * @return
     */
    int addBlogType(BlogType blogType);

    /**
     * 删除博客类别信息
     * @param id
     * @return
     */
    int deleteBlogType(int id);

    /**
     * 更新博客类别信息
     * @param blogType
     * @return
     */
    int updateBlogType(BlogType blogType);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    BlogType queryById(int id);

    /**
     * 分页查询博客类别信息
     * @param start
     * @param end
     * @return
     */
    List<BlogType> listByPage(@Param("start") int start, @Param("end") int end);

    /**
     * 获取总条数
     * @return
     */
    long getTotalNum();
}
