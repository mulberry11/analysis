package com.yth.analysis.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * cooperation_tb
 * @author 
 */
@Data
public class CooperationTb implements Serializable {
    /**
     * 货号
     */
    private String id;

    /**
     * 品名
     */
    private String goodsname;

    /**
     * 规格
     */
    private String goodsNorm;

    /**
     * 厂家
     */
    private String goodsMill;

    /**
     * 购进价
     */
    private Double purchasePrice;

    /**
     * 零售价
     */
    private Double retailPrice;

    /**
     * 仓库库存
     */
    private Integer goodsStock;

    /**
     * 门店库存
     */
    private Integer storeStock;

    /**
     * 年销量
     */
    private Integer yearSales;

    /**
     * 年销售额
     */
    private Double yearSalesAmount;

    /**
     * 年毛利额
     */
    private Double yearGrossAmount;

    /**
     * 销售排名
     */
    private Integer salesRank;

    /**
     * 处理方式
     */
    private String treat;

    /**
     * 雨诺编码
     */
    private String ynid;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}