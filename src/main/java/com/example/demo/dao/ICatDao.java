package com.example.demo.dao;

import com.example.demo.model.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatDao  extends CrudRepository<Cat,Long> {
}
