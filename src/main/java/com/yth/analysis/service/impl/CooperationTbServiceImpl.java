package com.yth.analysis.service.impl;

import com.yth.analysis.dto.exportEXcelDTO;
import com.yth.analysis.mapper.CooperationTbMapper;
import com.yth.analysis.model.CooperationTb;
import com.yth.analysis.service.CooperationTbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CooperationTbServiceImpl implements CooperationTbService {
    @Autowired
    private CooperationTbMapper cooperationTbMapper;
    @Override
    public int insert(CooperationTb record) {
        return 0;
    }

    @Override
    public int insertSelective(CooperationTb record) {
        return cooperationTbMapper.insertSelective(record);
    }

    @Override
    public List<exportEXcelDTO> selectEX() {
        return cooperationTbMapper.selectEX();
    }
}
