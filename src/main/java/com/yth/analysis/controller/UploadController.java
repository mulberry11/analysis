package com.yth.analysis.controller;

import com.alibaba.fastjson.JSON;
import com.yth.analysis.model.Filetb;
import com.yth.analysis.model.Goods;
import com.yth.analysis.service.FileInputService;
import com.yth.analysis.service.GoodsService;
import com.yth.analysis.util.EasyExcels;
import com.yth.analysis.util.FileHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class UploadController {

    @Autowired
    private FileInputService fileInputService;

    @Autowired
    private GoodsService goodsService;

    @Value("file.url")
    private String fileUrl;

    @PostMapping("fileinput")
    public String uploadfile(@RequestParam("file")MultipartFile multipartFile,
                               @RequestParam("millName") String millname,
                               Model model){
        if (multipartFile==null){
            model.addAttribute("message","上传失败,无法找到文件!");
            return null;
        }
        Filetb filetb =new Filetb();
        //文件名
        StringBuffer filename=new StringBuffer(multipartFile.getOriginalFilename());
        //在文件名中插入时间戳
        filename.insert(filename.indexOf("."),System.currentTimeMillis());
        String fileName = filename.toString();
        //文件名放入filetb对象中
        filetb.setFilename(fileName);
        String filePath =fileUrl+fileName;
        //文件保存路径放入filetb对象中
        filetb.setUrl(filePath);
        File file=new File(filePath);
        if (!file.exists())
            file.mkdirs();
        try {
            multipartFile.transferTo(file);
        }catch (IOException e){
            e.printStackTrace();
        }
        //合作公司名称
        filetb.setMillName(millname);
        //设置传入数据属性
        filetb.setType(0);
        //传入时间
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        filetb.setCreateTime(date);
        //存入数据库
        fileInputService.insert(filetb);
        model.addAttribute("message","文件上传成功");
        //更新文件列表
        List<String> fileList=fileInputService.selectFileList();
        //将更新后的列表倒叙传回前端
        model.addAttribute("fileList",FileHelp.fileList(fileList));
        return "index";
    }

    @PostMapping("dataInput")
    public String dataInput(@RequestParam("file")MultipartFile multipartFile,
                            Model model) {
        List<Goods> goodsList = null;
        try {
            List<Map<String, String>> excelContentList = EasyExcels.getExcelContent(multipartFile, Goods.class);
            goodsList = new ArrayList<>();
            for (int i = 1; i < excelContentList.size(); i++) {
                Map<String, String> list = excelContentList.get(i);
                if (list.size() > 0) {
                    //创建读取对象
                   /* Goods goods = new Goods(
                            list.get(0),
                            list.get(1),
                            list.get(2),
                            list.get(3),
                            list.get(4),
                            Integer.valueOf(list.get(5)),
                            Double.valueOf(list.get(6)),
                            Double.valueOf(list.get(7)),
                            Double.valueOf(list.get(8)),
                            Integer.valueOf(list.get(10)),
                            list.get(11));

                    */
                    Goods goods =new Goods();
                    goods.setId(list.get(0));
                    goods.setName(list.get(1));
                    goods.setAlias(list.get(2));
                    goods.setNorms(list.get(3));
                    goods.setMill(list.get(4));
                    goodsList.add(goods);
                    System.out.println(JSON.toJSON(goods));
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        goodsService.saveList(goodsList);
        return "index";
    }
}
