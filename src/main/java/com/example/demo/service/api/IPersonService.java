package com.example.demo.service.api;


import com.example.demo.model.Person;

import java.util.List;

public interface IPersonService {

   Person create (Person person);

    Person update(Long id,Person car);

    List<Person> readAll();

    Person readOne(Long id);

    void deleteById(Long id);

    void deleteAll();

}
