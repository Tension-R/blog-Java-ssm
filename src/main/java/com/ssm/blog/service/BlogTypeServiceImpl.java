package com.ssm.blog.service;

import com.ssm.blog.dao.BlogTypeDao;
import com.ssm.blog.entity.BlogType;
import com.ssm.blog.entity.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tension on 17-6-18.
 */
@Service
public class BlogTypeServiceImpl implements BlogTypeService{

    @Resource
    private BlogTypeDao blogTypeDao;

    public PageBean<BlogType> listByPage(PageBean<BlogType> pageBean) {

        List<BlogType> blogTypeList = blogTypeDao.listByPage(pageBean.getStart(),pageBean.getEnd());
        //记录查询分页的结果
        pageBean.setResult(blogTypeList);
        //记录查询总数
        pageBean.setTotal(blogTypeDao.getTotalNum());
        return pageBean;
    }
}
