package ru.pel.tests.multicartatest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository {
    @Query("select p.lastname FROM payments p WHERE p.age=18")
    List<String> findByAgeIs();
}
