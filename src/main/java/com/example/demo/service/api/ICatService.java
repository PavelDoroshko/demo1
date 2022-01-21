package com.example.demo.service.api;

import com.example.demo.model.Cat;

import java.util.List;

public interface ICatService {

    Cat create(Cat cat);

    Cat update(Long id, Cat car);

    List<Cat> readAll();

    Cat readOne(Long id);

    void deleteById(Long id);

    void deleteAll();

}
