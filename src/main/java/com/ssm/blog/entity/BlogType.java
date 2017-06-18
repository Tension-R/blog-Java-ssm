package com.ssm.blog.entity;



/**
 * 博客类别entity
 * Created by tension on 17-6-17.
 */
public class BlogType {

    //使用基本类型int会报异常
    //No constructor found in com.ssm.blog.entity.BlogType matching [java.lang.Integer, java.lang.String, java.lang.Integer]
    //？？
    private Integer id;
    private String typeName;
    private Integer orderNum;

    public BlogType(Integer id, String typeName, Integer orderNum) {
        this.id = id;
        this.typeName = typeName;
        this.orderNum = orderNum;
    }

    public BlogType(String typeName, Integer orderNum) {
        this.typeName = typeName;
        this.orderNum = orderNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "BlogType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", orderNum=" + orderNum +
                '}';
    }
}
