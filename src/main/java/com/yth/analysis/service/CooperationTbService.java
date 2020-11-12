package com.yth.analysis.service;

import com.yth.analysis.dto.exportEXcelDTO;
import com.yth.analysis.model.CooperationTb;

import java.util.List;

public interface CooperationTbService {
    int insert(CooperationTb record);

    int insertSelective(CooperationTb record);

    List<exportEXcelDTO> selectEX();
}
