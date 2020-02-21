package com.tamara.springboottraining1.service;

import com.tamara.springboottraining1.Delimiters;
import com.tamara.springboottraining1.model.RawFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

@Slf4j
@Configuration
public class FileTransformer {


    public void scanFile(RawFile rawFile) throws IOException {

        log.debug("started...");

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

                String[] line = sc.nextLine().split(fileSeparator);
//                String line = sc.nextLine();

                System.out.println("Let's treat this line somehow... it has:");
                System.out.println(line);





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
