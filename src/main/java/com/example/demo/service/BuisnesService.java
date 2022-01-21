package com.example.demo.service;

import com.example.demo.dao.VocationDayRepository;
import com.example.demo.model.Person;
import com.example.demo.model.VocationDay;
import com.example.demo.model.enam.VacationType;
import org.hibernate.Session;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

@Component
public class BuisnesService {
    @PersistenceContext
    EntityManager entityManager;
    private final VocationDayRepository vocationDayRepository;

    public BuisnesService(VocationDayRepository vocationDayRepository) {
        this.vocationDayRepository = vocationDayRepository;
    }

    public List<Person> getVocationDay(int month, int year, int age,List<VacationType> vocationtype) {

        List <Person> personList = new ArrayList<>();
        LocalDate initial = LocalDate.of(year, month, 1);
        LocalDate start = initial.with(firstDayOfMonth());
        LocalDate end = initial.with(lastDayOfMonth());
        List<VocationDay> vocationDayList = vocationDayRepository.findVocationDaysByMonthYear(start, end);
        if (age!=0) {
         personList = getPersonByVocationDayByName(vocationDayList,age);
        } else{
         personList = getPersonByVocationDayWithoutName(vocationDayList);}


        return personList;
    }


    public List<Person> getPersonByVocationDayByName(List<VocationDay> vocationDayList, int age) {
        List<Person> personListByVocationByName = new ArrayList<>();
        for (VocationDay vocationDay : vocationDayList) {
            if (vocationDay.getPerson().getAge()==age) {
                personListByVocationByName.add(vocationDay.getPerson());
            }
        }
        return personListByVocationByName;
    }

    public List<Person> getPersonByVocationDayWithoutName(List<VocationDay> vocationDayList) {
        List<Person> personListByVocation = new ArrayList<>();
        for (VocationDay vocationDay : vocationDayList) {
            personListByVocation.add(vocationDay.getPerson());
        }
        return personListByVocation;
    }
   public List<Person> getPersonByVocationType(List<Person> persons,List<VacationType> vocationtype){


return null;

   }


    public List<VocationDay> getAllVocationDay(int month, int year) {
        List<VocationDay> allVocationDayNew = new ArrayList<>();
        List<VocationDay> allVocationDay = vocationDayRepository.findAll();
        for (VocationDay vocationDay : allVocationDay) {
            if (vocationDay.getDay().getMonthValue() == month && vocationDay.getDay().getYear() == year) {
                allVocationDayNew.add(vocationDay);
            }
        }
        return allVocationDayNew;
    }
}
