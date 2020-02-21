package com.tamara.springboottraining1.service;

import com.tamara.springboottraining1.model.RawFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
public class TransformColumnsImpl implements TransformColumns {

    private final RawFile rawFile;

    public TransformColumnsImpl(RawFile rawFile) {
        this.rawFile = rawFile;
    }


    @Override
    public void orderBy() {
        log.debug("this is poorly coded...");
    }

    @Override
    public void deleteByIndex(List<String> line) {

        log.info("Removing columns from record");

        int[] idxToDelete = rawFile.getColumnsToDelete();

        for (int idx = idxToDelete.length - 1; idx >= 0; idx--) {

            log.debug("Deleting column: " + idxToDelete[idx]);

            line.remove(idxToDelete[idx]);
        }

        System.out.println("looped correctly?");
    }


    @Override
    public void deleteByHeaderName() {
        log.debug("this is poorly coded...");
    }

    @Override
    public void addColumn(String calculatedColumnContent, int columnPositionIndex) {
        log.debug("this is poorly coded...");
    }

}
