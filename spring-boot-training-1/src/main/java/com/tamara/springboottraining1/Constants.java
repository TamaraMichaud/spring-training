package com.tamara.springboottraining1;

import java.util.Collections;
import java.util.List;

public final class Constants {

    // -- global fields required for all pre-processing projects -- //
        // file-specific information
    public static final String FILENAME_FINAL = "./src/main/resources/processed.csv";
    public static final String FILENAME_ORIG = "./src/main/resources/sample.csv";
    public static final String FILE_DELIMITER = ";";
    public static final String FILE_ENCODING = "UTF-8";
    public static final Boolean FILE_HASHEADER = true;
    // ^^ if HASHEADER == true -> HEADERSTRING will never be read
    public static final List<String> FILE_HEADERSTRING = Collections.singletonList("HEADER1;HEADER2;HEADER3;HEADER4");

        // sftp-related information
    public static final String SOURCE_SERVER_HOST = "";
    public static final int SOURCE_SERVER_PORT = 22;
    public static final String SOURCE_SERVER_USERNAME = "";
    public static final String SOURCE_SERVER_KEY = "/path/to/ssh/key.pub";
    public static final String SOURCE_SERVER_DIR = "/path/to/source/file.txt";



    // -- project-specific fields required for specific pre-processing tasks

        // if certain columns need to be deleted
    public static final int FILE_COLUMNS_ORIG = 6;
    public static final int FILE_COLUMNS_FINAL = 4;
    public static final int[] FILE_COLUMNS_TODELETE = {2, 3};  // << not indexes, the actual column number



}
