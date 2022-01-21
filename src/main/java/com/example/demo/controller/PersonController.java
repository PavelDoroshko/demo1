package com.example.demo.controller;

import com.example.demo.dto.PersonDto;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.Person;
import com.example.demo.service.ExcelService;
import com.example.demo.service.api.IPersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final ObjectMapper objectMapper;
    private final IPersonService iPersonService;
    private final PersonMapper personMapper;

    @ResponseBody
    @PostMapping("/create")
    public PersonDto createPerson(@RequestBody PersonDto personDto) {
        Person person = objectMapper.convertValue(personDto, Person.class);
        return objectMapper.convertValue(iPersonService.create(person), PersonDto.class);
    }

    @GetMapping("/read/all")
    public List<PersonDto> readAll() {
        return iPersonService.readAll().stream()
                .map(person -> objectMapper.convertValue(person, PersonDto.class))
                .collect(Collectors.toList());

    }

    @GetMapping("/read/one")
    public PersonDto readOne(@RequestParam("id") long id) {
       Person person = iPersonService.readOne(id);
        return personMapper.map(person);
       // return iPersonService.readOne(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteOne(@PathVariable("id") long id) {
        iPersonService.deleteById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        iPersonService.deleteAll();
    }

    @PutMapping("/update")
    public PersonDto update(@RequestParam(value = "id") long id,
                            @RequestBody PersonDto personDto) {
        Person person = objectMapper.convertValue(personDto, Person.class);
        return objectMapper.convertValue(iPersonService.update(id, person), PersonDto.class);
    }

}
