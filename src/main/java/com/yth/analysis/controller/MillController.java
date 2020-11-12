package com.yth.analysis.controller;

import com.yth.analysis.dto.MillDto;
import com.yth.analysis.model.Filetb;
import com.yth.analysis.service.MillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;

@Controller
public class MillController {
    @Autowired
    private MillService millService;

    @RequestMapping("findMillAll")
    @ResponseBody
    public List<MillDto> findMillAll(){
        return millService.findMillAll();
    }

    @RequestMapping("delFile")
    @ResponseBody
    public String delFile(@RequestParam("id") Integer id){
        Filetb mill = millService.selectByPrimaryKey(id);
        if (mill==null){
            return "找不到文件,删除失败";
        }
        File file=new File(mill.getUrl());
        if (file.exists()){
            //删除文件
            file.delete();
        }
        //删除数据库信息
        millService.deleteByPrimaryKey(id);
        return "删除成功!";
    }
}
