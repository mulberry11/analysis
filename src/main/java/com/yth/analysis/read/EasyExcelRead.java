package com.yth.analysis.read;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.yth.analysis.model.CooperationTb;
import org.apache.poi.ss.formula.functions.T;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class EasyExcelRead {

    // 简单读取 (同步读取)
    public static List<CooperationTb> simpleRead(String url, Class clazz) {

        // 读取 excel 表格的路径
        //String readPath = url;

        try {
            // sheetNo --> 读取哪一个 表单
            // headLineMun --> 从哪一行开始读取( 不包括定义的这一行，比如 headLineMun为2 ，那么取出来的数据是从 第三行的数据开始读取 )
            // clazz --> 将读取的数据，转化成对应的实体，需要 extends BaseRowModel
            Sheet sheet = new Sheet(1, 1, clazz);

            // 这里 取出来的是 GoodsExl实体 的集合
            List<Object> readList = EasyExcelFactory.read(new FileInputStream(url), sheet);
            // 存 GoodsEx 实体的 集合
            List<CooperationTb> list = new ArrayList<CooperationTb>();
            for (Object obj : readList) {
                list.add((CooperationTb) obj);
            }
            return list;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
