package com.example.demo.service;

import com.example.demo.dao.ICatDao;
import com.example.demo.model.Cat;
import com.example.demo.service.api.ICatService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CatServiceImpl implements ICatService {

    private final ICatDao iCatDao;

    public CatServiceImpl(ICatDao iCatDao) {
        this.iCatDao = iCatDao;
    }

    @Override
    public Cat create(Cat cat) {
        return iCatDao.save(cat);
    }

    @Override
    public Cat update(Long id, Cat cat) {
        Optional<Cat> catFind = iCatDao.findById(id);
        catFind.get().setName(cat.getName());
        catFind.get().setAge(cat.getAge());
        return iCatDao.save(catFind.get());
    }

    @Override
    public List<Cat> readAll() {
        return (List<Cat>) iCatDao.findAll();
    }

    @Override
    public Cat readOne(Long id) {
        Optional<Cat> cat = iCatDao.findById(id);
        return cat.get();
    }

    @Override
    public void deleteById(Long id) {
       iCatDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
          iCatDao.deleteAll();
    }
}
