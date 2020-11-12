package com.yth.analysis.service.impl;

import com.yth.analysis.mapper.GoodsMapper;
import com.yth.analysis.model.Goods;
import com.yth.analysis.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    @Override
    public int insertSelective(Goods record) {
        return 0;
    }

    @Override
    public Goods selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Goods record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Goods record) {
        return 0;
    }

    @Override
    public List<Goods> findGoods(String name, String norms) {
        return goodsMapper.findGoods(name,norms);
    }

    @Override
    public void saveList(List<Goods> goodsList) {
        for (Goods goods: goodsList) {
            goodsMapper.saveList(goods);
        }
    }

    @Override
    public List<Goods> findAll() {
        return goodsMapper.findAll();
    }
}
