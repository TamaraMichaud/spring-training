package com.tamara.springboottraining1.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Slf4j
@Getter
@Configuration
public class RawFile {

    private final File name;
    private final String delimiter;
    private final String encoding;
    private final boolean hasHeader;
    private final List<String> headerVal;

    private final int columnsRaw;
    private final int columnsFinal;
    private final int[] columnsToDelete;

    public RawFile(@Value("${file.name}") String name,
                   @Value("${file.delimiter}") String delimiter,
                   @Value("${file.encoding}") String encoding,
                   @Value("${file.hasHeader}") boolean hasHeader,
                   @Value("${file.headerVal}") String headerVal,
                   @Value("${file.columns.raw}") int columnsRaw,
                   @Value("${file.columns.final}") int columnsFinal,
                   @Value("${file.columns.toDelete}") int[] columnsToDelete) {

        this.name = new File(name);
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        this.encoding = encoding;
        this.headerVal = Collections.singletonList(headerVal);
        this.columnsRaw = columnsRaw;
        this.columnsFinal = columnsFinal;
        this.columnsToDelete = columnsToDelete;
    }




}
