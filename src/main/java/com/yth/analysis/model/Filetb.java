package com.yth.analysis.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * filetb
 * @author 
 */
@Data
public class Filetb implements Serializable {
    /**
     * 文件id
     */
    private Integer id;

    /**
     * 文件名
     */
    private String filename;

    /**
     * 文件路径
     */
    private String url;

    /**
     * 文件属性,0 和盛 1 对比表
     */
    private Integer type;

    /**
     * 文件上传时间
     */
    private Date createTime;

    /**
     * 合作公司名称
     */
    private String millName;

    private static final long serialVersionUID = 1L;
}