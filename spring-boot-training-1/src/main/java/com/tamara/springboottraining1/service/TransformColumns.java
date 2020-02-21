package com.tamara.springboottraining1.service;

import com.tamara.springboottraining1.model.RawFile;

import java.util.List;

public interface TransformColumns {

    void orderBy();
    void deleteByIndex(List<String> line);
    void deleteByHeaderName();
    void addColumn(String calculatedColumnContent, int columnPositionIndex);

}
