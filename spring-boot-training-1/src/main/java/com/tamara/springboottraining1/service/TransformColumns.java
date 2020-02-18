package com.tamara.springboottraining1.service;

public interface TransformColumns {

    void orderBy(int... indexesInOrder);
    void deleteByIndex(int... indexesToDelete);
    void deleteByHeaderName(String... headersToDelete);
    void addColumn(String calculatedColumnContent);

}
