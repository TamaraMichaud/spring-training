package com.tamara.springboottraining1.service;

import com.tamara.springboottraining1.model.RawFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Slf4j
@Configuration
public class FileTransformer {


    public void scanFile(RawFile rawFile, TransformColumns transformColumns, FileWriter fileWriter) throws IOException {

        log.debug("Starting file treatment.");

        if(!rawFile.isHasHeader()) {
            log.debug("File is lacking a header...");
            fileWriter.printLine(rawFile.getHeaderVal());
            log.debug("Header row added");
        }

        // iterate file contents
        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream(rawFile.getName());
            String fileSeparator = rawFile.getDelimiter();

            // new class
//            Delimiters finalDelim = Delimiters.FINAL;
//            Delimiters rawDelim = Delimiters.valueOf(rawFile.getDelimiter());
//            if(rawDelim.equals(finalDelim)) {
//                log.info("File has correct delimiter");
//            } else
//            {
//                log.debug("File has delimiter: " + rawDelim);
//                //TODO: change the delimiter in the file...
//            }



            sc = new Scanner(inputStream, rawFile.getEncoding());
//            sc = new Scanner(inputStream, rawFile.getEncoding()).useDelimiter(";"); // same as above (?)
            while (sc.hasNextLine()) {

//                List<String> line = Arrays.asList(sc.nextLine().split(fileSeparator));
// ^^ NO!!
                List<String> line = new LinkedList<>(Arrays.asList(sc.nextLine().split(fileSeparator)));


                log.info(String.format("Line starts with %d columns", line.size()));
                transformColumns.deleteByIndex(line);
                log.info("Line now has: " + line.size() + "cols");

                fileWriter.printLine(line);

            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }

    }


}
