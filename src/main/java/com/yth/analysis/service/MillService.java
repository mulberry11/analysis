package com.yth.analysis.service;

import com.yth.analysis.dto.MillDto;
import com.yth.analysis.model.Filetb;

import java.util.List;

public interface MillService {
    int deleteByPrimaryKey(Integer id);

    int insert(Filetb record);

    int insertSelective(Filetb record);

    Filetb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Filetb record);

    int updateByPrimaryKey(Filetb record);

    public List<MillDto> findMillAll();
}
