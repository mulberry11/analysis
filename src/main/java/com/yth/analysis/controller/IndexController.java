package com.yth.analysis.controller;

import com.alibaba.excel.EasyExcel;
import com.yth.analysis.dto.exportEXcelDTO;
import com.yth.analysis.model.CooperationTb;
import com.yth.analysis.model.Filetb;
import com.yth.analysis.model.Goods;
import com.yth.analysis.service.CooperationTbService;
import com.yth.analysis.service.FiletbService;
import com.yth.analysis.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private FiletbService filetbService;

    @Autowired
    private CooperationTbService cooperationTbService;

    /**
     * 跳转首页
     */
    @GetMapping("index")
    public String index(Model model){
        List<String> milllist =filetbService.selectMillNameList();
        model.addAttribute("fileList",milllist);
        return "index";
    }
    /**
     * 查询所有数据返回前端分页
     * @return
     */
    @RequestMapping("findAll")
    @ResponseBody
    public List<Goods> findAll(){
        return goodsService.findAll();
    }

    /**
     * 模糊查询信息
     * @param name
     * @param mill
     * @return
     */
    @RequestMapping("findgoods")
    @ResponseBody
    public List<Goods> findGoods(@RequestParam("name") String name,
                                 @RequestParam("mill") String mill){
        //返回商品列表
        name="%" +name+"%";
        mill="%" +mill+"%";
        return goodsService.findGoods(name,mill);
    };

    /**
     * 保存处理结果
     * @param cooperationTb 保存对象
     * @return
     */
    @ResponseBody
    @RequestMapping("saveCoop")
    public String saveCoop(@RequestBody CooperationTb cooperationTb){
        cooperationTb.setCreateTime(new Date());
        int i = cooperationTbService.insertSelective(cooperationTb);
        if (i==1)
            return "已保存处理结果";
        return "保存处理结果失败";
    }

    /**
     * 读取对应ex文件返回前端
     * 请求url /readEx
     * 返回json data
     */
    @RequestMapping("readEx")
    @ResponseBody
    public List<CooperationTb> readEx(@RequestParam("millName")String millName,
                                      Model model){
        //根据filename查询filetb对象
        Filetb filetb=filetbService.findByName(millName);
        if (filetb==null){
            model.addAttribute("message","该表不存在或已删除!");
            return null;
        }
        List<CooperationTb> list = EasyExcel.read(filetb.getUrl()).head(CooperationTb.class).sheet().doReadSync();
        return list;
    }

    @GetMapping("mill")
    public String mill(){
        return "mill";
    }

    /**
     * 导出excel
     */
    @RequestMapping("exportExcel")
    @ResponseBody
    public List<exportEXcelDTO> exportExcel(){
        return cooperationTbService.selectEX();
    }

}
