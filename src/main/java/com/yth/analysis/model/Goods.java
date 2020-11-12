package com.yth.analysis.model;

import lombok.Data;

import java.io.Serializable;

/**
 * goods
 * @author 
 */
@Data
public class Goods implements Serializable {
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

    private static final long serialVersionUID = 1L;

    /*public Goods(String id, String name, String alias, String norms, String mill, Integer stock, Double bid, Double cooperateBid, Double retail, Integer purchase, String superiority) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.norms = norms;
        this.mill = mill;
        this.stock = stock;
        this.bid = bid;
        this.cooperateBid = cooperateBid;
        this.retail = retail;
        this.purchase = purchase;
        this.superiority = superiority;
    }*/
}