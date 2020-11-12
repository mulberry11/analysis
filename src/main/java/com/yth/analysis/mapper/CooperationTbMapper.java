package com.yth.analysis.mapper;

import com.yth.analysis.dto.exportEXcelDTO;
import com.yth.analysis.model.CooperationTb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CooperationTbMapper {
    int insert(CooperationTb record);

    int insertSelective(CooperationTb record);

    List<exportEXcelDTO> selectEX();
}