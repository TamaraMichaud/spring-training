package com.tamara.springboottraining1.service;


// https://www.baeldung.com/java-write-to-file
// If you are dealing with large files, FileChannel can be faster than standard IO


import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

@Configuration
public class FileWriter {

    public void printLine(List<String> line) throws IOException {

        //TODO: :(
        String formattedLine = "";
        for(String lineValue : line) {
            formattedLine += lineValue + ";";
        }

        System.out.println("Printing formatted line: '" + formattedLine + "'");

        RandomAccessFile stream = new RandomAccessFile("./src/main/resources/ProcessedFile.txt", "rw");
        //TODO: ^^ parameterize path
        //TODO: check file doesn't already exist: overwrite if yes or throw error?

        stream.seek(stream.length());
        stream.write((formattedLine + "\r\n").getBytes());
        // TODO: is this the correct newline char; will the file indeed process correctly?

        stream.close();




        // verify
        //TODO: add testing!
//        RandomAccessFile reader = new RandomAccessFile("ProcessedFile.txt", "r");
//        assertEquals(value, reader.readLine());
//        reader.close();
    }



}
