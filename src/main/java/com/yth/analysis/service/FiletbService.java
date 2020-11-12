package com.yth.analysis.service;

import com.yth.analysis.model.Filetb;

import java.util.List;

public interface FiletbService {
    Filetb findByName(String filename);

    List<String> selectMillNameList();
}
