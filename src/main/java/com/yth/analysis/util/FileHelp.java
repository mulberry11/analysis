package com.yth.analysis.util;

import org.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;

public class FileHelp {
    public static List<String> fileList(List<String> fileList){
        //创建目录
        for (int i = 0; i < fileList.size() / 2; i++) {
            String temp = fileList.get(i);
            fileList.set(fileList.size()-i-1,fileList.get(i));
            fileList.set(i,temp);
        }
        return fileList;
    }
}
