package com.yth.analysis.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户权限0所有权限1查询上传下载权限2查询下载权限

     */
    private String autho;

    /**
     * 用户创建时间
     */
    private Date createTime;

    /**
     * 姓名
     */
    private String name;

    /**
     * 权限等级0所有权限1查询上传下载权限2查询下载权限

     */
    private Integer identity;

    private static final long serialVersionUID = 1L;
}