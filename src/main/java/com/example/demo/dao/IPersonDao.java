package com.example.demo.dao;

import com.example.demo.model.Cat;
import com.example.demo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonDao extends CrudRepository<Person,Long> {
}
