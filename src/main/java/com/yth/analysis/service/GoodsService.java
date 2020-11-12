package com.yth.analysis.service;

import com.yth.analysis.model.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GoodsService {
    int deleteByPrimaryKey(String id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> findGoods(String name, String mill);
    /*读取excel表格数据并保存*/
    void saveList(List<Goods> goodsList);

    List<Goods> findAll();
}
