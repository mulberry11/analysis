package com.yth.analysis.dto;

import lombok.Data;

import java.util.Date;
@Data
public class MillDto {
    //id
    private Integer id;
    //商品名称
    private String mill_name;

    //文件名称
    private String fileName;
    //上传时间
    private Date create_time;
}
