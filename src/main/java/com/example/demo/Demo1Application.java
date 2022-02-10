package com.example.demo;

import com.example.demo.model.enam.VacationType;
import com.example.demo.service.ExcelService;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Demo1Application.class, args);
//       ExcelService excelService = new ExcelService();
//        excelService.buildExcelDocument(1L);
        List<String> integerList = List.of("1", "2", "2", "3", "5", "2", "8");
        List<String> integerList1 = integerList.stream()
                .filter(a -> a.equals("8"))
                .collect(Collectors.toList());
        System.out.println(integerList1);

        LocalDate first = LocalDate.of(2022,1,1);
        LocalDate second = LocalDate.of(2022,3,1);
        LocalDate example = LocalDate.of(2022,2,1);
        LocalDate now = LocalDate.now ();
        VacationType vacation = VacationType.VACATION;
        if ((example.isAfter(first) && example.isBefore(second)) && vacation.equals(VacationType.VACATION)) {

            System.out.println("внутри периода");
        }
        System.out.println("продолжаем");
    }

}





