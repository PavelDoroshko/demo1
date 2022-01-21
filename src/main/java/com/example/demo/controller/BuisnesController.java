package com.example.demo.controller;

import com.example.demo.dto.PersonDto;
import com.example.demo.dto.VocationDto;
import com.example.demo.model.Person;
import com.example.demo.model.VocationDay;
import com.example.demo.model.enam.VacationType;
import com.example.demo.service.BuisnesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/buisness")
public class BuisnesController {
    private final ObjectMapper objectMapper;
    private final BuisnesService buisnesService;


    @GetMapping("/read")
    public List<Person> readOne(@RequestParam("month") Integer month,
                                @RequestParam("year") Integer year,
                                @RequestParam("age") Integer age,
                                @RequestParam(name ="vocationtype")List<VacationType> vocationtype
                                ) {

        return buisnesService.getVocationDay(month, year, age,vocationtype);
        //  return buisnesService.getAllVocationDay(month,year);

    }
}
