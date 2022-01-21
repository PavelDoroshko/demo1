package com.example.demo.controller;

import com.example.demo.mapper.PersonMapper;
import com.example.demo.service.ExcelService;
import com.example.demo.service.api.IPersonService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    private final PersonMapper personMapper;
    private final IPersonService iPersonService;
    private final ExcelService excelService;

    public ExcelController(PersonMapper personMapper, IPersonService iPersonService, ExcelService excelService) {
        this.personMapper = personMapper;
        this.iPersonService = iPersonService;
        this.excelService = excelService;
    }


    @GetMapping("/read/{id}")
    public void readOne(@PathVariable("id") Long id) {
        excelService.buildExcelDocument(id);
      //  return personMapper.map(iPersonService.readOne(id));
        // return iPersonService.readOne(id);
    }
    @GetMapping("/get")
    public void getExcel() {
        excelService.buildExcel();

        // return iPersonService.readOne(id);
    }





}
