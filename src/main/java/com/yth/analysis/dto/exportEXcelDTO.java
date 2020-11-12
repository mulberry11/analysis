package com.yth.analysis.dto;

import lombok.Data;

@Data
public class exportEXcelDTO {
    private String id;
    private String goodsname;
    private String goods_norm;
    private String goods_mill;
    private double purchase_price;
    private double retail_price;
    private String treat;
    private String ynid;
    private String remark;
}
