package com.example.demo.service;

import com.example.demo.dao.IPersonDao;
import com.example.demo.model.Person;
import com.example.demo.service.api.IPersonService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class PersonServiceImpl implements IPersonService {

    private final IPersonDao iPersonDao;

    public PersonServiceImpl(IPersonDao iPersonDao) {
        this.iPersonDao = iPersonDao;
    }


    @Override
    public Person create(Person person) {
        return iPersonDao.save(person);
    }

    @Override
    public Person update(Long id, Person person) {
        Optional<Person> personFind = iPersonDao.findById(id);
        personFind.get().setAge(person.getAge());
        personFind.get().setName(person.getName());
        personFind.get().setSurName(person.getSurName());
        return iPersonDao.save(personFind.get());
    }

    @Override
    public List<Person> readAll() {
        return (List<Person>) iPersonDao.findAll();
    }

    @Override
    @Transactional
    public Person readOne(Long id) {
        return iPersonDao.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void deleteById(Long id) {
        iPersonDao.deleteById(id);

    }

    @Override
    public void deleteAll() {
        iPersonDao.deleteAll();
    }
}
