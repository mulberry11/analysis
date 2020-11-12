package com.yth.analysis.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.yth.analysis.model.CooperationTb;

import java.util.ArrayList;
import java.util.List;

public class EXListener extends AnalysisEventListener<CooperationTb> {

    private static final int BATCH_COUNT = 500;
    List<CooperationTb> tbArrayList =new ArrayList<>();
    public EXListener(List<CooperationTb> list){
        this.tbArrayList=list;
    }


    @Override
    public void invoke(CooperationTb cooperationTb, AnalysisContext analysisContext) {
        tbArrayList.add(cooperationTb);
        if (tbArrayList.size() >= BATCH_COUNT) {
            // 存储完成清理 list
            tbArrayList.clear();
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 不许要保存到数据库
    }
}
