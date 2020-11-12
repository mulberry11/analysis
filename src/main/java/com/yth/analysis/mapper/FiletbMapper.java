package com.yth.analysis.mapper;

import com.yth.analysis.dto.MillDto;
import com.yth.analysis.model.Filetb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FiletbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Filetb record);

    int insertSelective(Filetb record);

    Filetb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Filetb record);

    int updateByPrimaryKey(Filetb record);

    List<String> selectFileList();

    Filetb findByName(String filename);

    List<MillDto> findMillall();
}