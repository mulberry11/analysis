package com.yth.analysis.read;

import com.alibaba.excel.metadata.BaseRowModel;

public class Goods extends BaseRowModel {
    /**
     * 货号
     */
    private String id;

    /**
     * 品名
     */
    private String name;

    /**
     * 商品别名
     */
    private String alias;

    /**
     * 规格
     */
    private String norms;

    /**
     * 厂家
     */
    private String mill;

    /**
     * 仓库库存
     */
    private Integer stock;

    /**
     * 最后进价
     */
    private Double bid;

    /**
     * 合作价
     */
    private Double cooperateBid;

    /**
     * 合作价
     */
    private Double retail;

    /**
     * 采购数量
     */
    private Integer purchase;

    /**
     * 采集优势
     */
    private String superiority;
}
