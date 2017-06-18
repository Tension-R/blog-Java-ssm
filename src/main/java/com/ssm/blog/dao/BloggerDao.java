package com.ssm.blog.dao;

import com.ssm.blog.entity.Blogger;
import org.springframework.stereotype.Repository;

/**
 * 博主dao接口
 * Created by tension on 17-6-16.
 */
@Repository //注册为持久层bean
public interface BloggerDao {
    /**
     * 查询博主信息
     * @return
     */
    Blogger getBloggerData();
}
