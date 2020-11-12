package com.yth.analysis.controller;

import com.yth.analysis.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GoodsController {
    @Autowired(required = true)
    private GoodsService goodsService;

}
