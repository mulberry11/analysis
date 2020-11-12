package com.yth.analysis;

import com.yth.analysis.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AnalysisApplicationTests {

    @Autowired(required = true)
    private GoodsMapper goodsMapper;
    @Test
    void contextLoads() {
        System.out.println(goodsMapper.findGoods("%胶囊%","%公司%"));
    }

}
