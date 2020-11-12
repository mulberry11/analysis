package com.yth.analysis.service.impl;

import com.yth.analysis.dto.MillDto;
import com.yth.analysis.mapper.FiletbMapper;
import com.yth.analysis.model.Filetb;
import com.yth.analysis.service.MillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class MillServiceImpl implements MillService {
    @Autowired
    private FiletbMapper filetbMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return filetbMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Filetb record) {
        return 0;
    }

    @Override
    public int insertSelective(Filetb record) {
        return 0;
    }

    @Override
    public Filetb selectByPrimaryKey(Integer id) {
        return filetbMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Filetb record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Filetb record) {
        return 0;
    }

    @RequestMapping("/findMillAll")
    @ResponseBody
    public List<MillDto> findMillAll(){
        return filetbMapper.findMillall();
    }
}
