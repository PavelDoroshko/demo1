package com.example.demo.controller;

import com.example.demo.dto.CatDto;
import com.example.demo.model.Cat;
import com.example.demo.service.api.ICatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cat")
public class CatController {
    private final ObjectMapper objectMapper;
    private final ICatService iCatService;


    @PostMapping("/create")
    public CatDto createCar(@RequestBody CatDto catDto) {
        Cat cat = objectMapper.convertValue(catDto, Cat.class);
        return objectMapper.convertValue(iCatService.create(cat), CatDto.class);
    }

    @GetMapping("/read/all")
    public List<CatDto> readAll() {
        return iCatService.readAll().stream()
                .map(cat -> objectMapper.convertValue(cat,CatDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/read/one")
    public CatDto readOne(@RequestParam("id") long id) {
        return objectMapper.convertValue(iCatService.readOne(id), CatDto.class);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteOne(@PathVariable("id") Long id) {
        iCatService.deleteById(id);

    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        iCatService.deleteAll();
    }

    @PutMapping("/update")
    public CatDto update(@RequestParam(value = "id") Long id,
                         @RequestBody CatDto catDto) {
        Cat cat = objectMapper.convertValue(catDto, Cat.class);
        return objectMapper.convertValue(iCatService.update(id, cat), CatDto.class);
    }


}
