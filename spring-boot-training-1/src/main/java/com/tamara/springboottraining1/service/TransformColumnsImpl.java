package com.tamara.springboottraining1.service;

import com.tamara.springboottraining1.model.RawFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.tamara.springboottraining1.Constants.FILE_COLUMNS_TODELETE;

@Slf4j
@Configuration
public class TransformColumnsImpl implements TransformColumns {

//    private final RawFile rawFile;
//
//    public TransformColumnsImpl(RawFile rawFile) {
//        this.rawFile = rawFile;
//    }

    @Override
    public void orderBy() {
        log.debug("this is poorly coded...");
    }

    @Override
    public void deleteByIndex(List<String> line) {

        int[] idxToDelete = FILE_COLUMNS_TODELETE; //rawFile.getColumnsToDelete();
        log.debug(String.format("Removing %d columns from record", idxToDelete.length));

        for (int idx = idxToDelete.length - 1; idx >= 0; idx--) {

            log.debug("Deleting column: " + idxToDelete[idx]);
            line.remove(idxToDelete[idx]);
        }
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
