package com.example.demo;

import com.example.demo.service.ExcelService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
//       ExcelService excelService = new ExcelService();
//        excelService.buildExcelDocument(1L);

    }

}