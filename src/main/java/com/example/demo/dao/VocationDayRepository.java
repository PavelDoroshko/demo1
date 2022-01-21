package com.example.demo.dao;

import com.example.demo.model.VocationDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
@Repository
public interface VocationDayRepository extends JpaRepository<VocationDay, UUID> {
    @Query(value = "SELECT v FROM VocationDay v WHERE (v.day BETWEEN :localDateFirst AND :localDateLast )")
   List<VocationDay> findVocationDaysByMonthYear( LocalDate localDateFirst,LocalDate localDateLast);
};