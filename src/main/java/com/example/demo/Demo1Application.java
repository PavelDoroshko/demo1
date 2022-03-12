package com.example.demo;

import com.example.demo.model.enam.VacationType;
import com.example.demo.service.ExcelService;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args)  {
        SpringApplication.run(Demo1Application.class,args);
    }

}
