package com.example.demo.controller;

import com.example.demo.mapper.PersonMapper;
import com.example.demo.service.ExcelService;
import com.example.demo.service.api.IPersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.util.HttpHeadersUtil.getAttachHeaders;
import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

@RestController
@RequestMapping("/excel")
@Tag(name = "Экспорт в excel", description = "создает таблицу persons")
public class ExcelController {
    public static final String CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

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

    }

    @SneakyThrows
    @GetMapping("/get")
    @Operation(summary = "перевод в байты", description = "создает массив байт")
    public ResponseEntity<?> getExcel() {
        Resource responseFile = excelService.export();

     //   HttpHeaders header = new HttpHeaders();
        return  ResponseEntity
                .ok()
                .contentLength(responseFile.contentLength())
                .contentType(MediaType.parseMediaType(CONTENT_TYPE))
                //.header(CONTENT_DISPOSITION, "attachment; filename=list_person.xlsx")
                .headers(getAttachHeaders("excel.xlsx"))
                .body(responseFile);
    }


}
