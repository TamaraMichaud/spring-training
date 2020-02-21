package com.tamara.springboottraining1.model;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.List;

import static com.tamara.springboottraining1.Constants.*;

@Slf4j
@Getter
@Configuration
public class RawFile {

    private final File name;
    private final String delimiter;
    private final String encoding;
    private final boolean hasHeader;
    private final List<String> headerVal;

    private final String finalFileName;

//    private final int columnsRaw;
//    private final int columnsFinal;
//    private final int[] columnsToDelete;

//    public RawFile(@Value("${file.name}") String name,
//                   @Value("${file.delimiter}") String delimiter,
//                   @Value("${file.encoding}") String encoding,
//                   @Value("${file.hasHeader}") boolean hasHeader,
//                   @Value("${file.headerVal}") String headerVal,
//                   @Value("${file.columns.raw}") int columnsRaw,
//                   @Value("${file.columns.final}") int columnsFinal,
//                   @Value("${file.columns.toDelete}") int[] columnsToDelete) {

    public RawFile() {
        this.finalFileName = FILENAME_FINAL;

        this.name = new File(FILENAME_ORIG);
        this.delimiter = FILE_DELIMITER;
        this.hasHeader = FILE_HASHEADER;
        this.encoding = FILE_ENCODING;
        this.headerVal = FILE_HEADERSTRING;
//        this.columnsRaw = FILE_COLUMNS_ORIG;
//        this.columnsFinal = FILE_COLUMNS_FINAL;
//        this.columnsToDelete = FILE_COLUMNS_TODELETE;
        // ^^ not really relevant here... (?)
    }

}
