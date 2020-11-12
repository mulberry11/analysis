package com.yth.analysis.service.impl;

import com.yth.analysis.mapper.FiletbMapper;
import com.yth.analysis.model.Filetb;
import com.yth.analysis.service.FiletbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiletbServiceImpl implements FiletbService {
    @Autowired
    private FiletbMapper filetbMapper;
    //通过文件名获取fiiletb对象
    @Override
    public Filetb findByName(String millname) {
        return filetbMapper.findByName(millname);
    }

    @Override
    public List<String> selectMillNameList() {
        return filetbMapper.selectFileList();
    }
}
