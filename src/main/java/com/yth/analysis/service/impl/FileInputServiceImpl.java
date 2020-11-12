package com.yth.analysis.service.impl;

import com.yth.analysis.mapper.FiletbMapper;
import com.yth.analysis.model.Filetb;
import com.yth.analysis.service.FileInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileInputServiceImpl implements FileInputService {
    @Autowired
    private FiletbMapper filetbMapper;

    public int deleteByPrimaryKey(Integer id){
        return filetbMapper.deleteByPrimaryKey(id);
    }

    public int insert(Filetb record){
        return filetbMapper.insert(record);
    }

    public int insertSelective(Filetb record){
        return filetbMapper.insertSelective(record);
    }

    public Filetb selectByPrimaryKey(Integer id){
        return filetbMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Filetb record){
        return filetbMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Filetb record){
        return filetbMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<String> selectFileList() {
        return filetbMapper.selectFileList();
    }
}
