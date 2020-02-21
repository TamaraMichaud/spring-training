package com.tamara.springboottraining1.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Slf4j
@Getter
@Configuration
public class RawFile {

    private final File name;
    private final String delimiter;
    private final String encoding;
    private final boolean hasHeader;

    public RawFile(@Value("${file.name}") String name,
                   @Value("${file.delimiter}") String delimiter,
                   @Value("${file.encoding}") String encoding,
                   @Value("${file.hasHeader}") boolean hasHeader) {

        this.name = new File(name);
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        this.encoding = encoding;
    }




}
