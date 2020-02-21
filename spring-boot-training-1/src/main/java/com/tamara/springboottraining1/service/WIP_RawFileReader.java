//package com.tamara.springboottraining1.service;
//
//import org.springframework.context.annotation.Bean;
//
//@Bean
//public class RawFileReader {
//    public FlatFileItemReader<Voltage> reader() {
//        return new FlatFileItemReaderBuilder<Voltage>()
//                .name("voltItemReader")
//                .resource(new ClassPathResource("Volts.csv"))
//                .delimited()
//                .names(new String[]{"volt", "time"})
//                .lineMapper(lineMapper())
//                .fieldSetMapper(new BeanWrapperFieldSetMapper<Voltage>() {{
//                    setTargetType(Voltage.class);
//                }})
//                .build();
//    }
//
//}
