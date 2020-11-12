package com.yth.analysis.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.yth.analysis.model.Goods;
import com.yth.analysis.service.GoodsService;

import java.util.ArrayList;
import java.util.List;

public class ExDataListener extends AnalysisEventListener<Goods> {
    private static final int BATCH_COUNT = 500;
    List<com.yth.analysis.model.Goods> goodsList=new ArrayList<>();

    private GoodsService goodsService;

    public ExDataListener(GoodsService goodsService){
        this.goodsService=goodsService;
    }

    @Override
    public void invoke(Goods goods, AnalysisContext analysisContext) {
        goodsList.add(goods);
        if (goodsList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            goodsList.clear();
        }
    }

    private void saveData() {
        goodsService.saveList(goodsList);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
    }
}
