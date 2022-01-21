package com.example.demo.mapper;

import com.example.demo.dto.CatDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.model.Person;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class PersonMapper {
    public PersonDto map(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .age(person.getAge())
                .name(person.getName())
                .surName(person.getSurName())
                .cats(person.getCats().stream().map(cat -> CatDto.builder()
                        .id(cat.getId())
                        .age(cat.getAge())
                        .name(cat.getName())
                        .build()).collect(Collectors.toList()))
                .build();
    }

}
