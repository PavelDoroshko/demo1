package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonDto {
    private Long id;
    private String name;
    private Integer age;
    private String surName;
    private List<CatDto> cats;

}
