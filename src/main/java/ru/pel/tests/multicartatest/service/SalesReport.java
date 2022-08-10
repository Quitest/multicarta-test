package ru.pel.tests.multicartatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pel.tests.multicartatest.entity.Payment;
import ru.pel.tests.multicartatest.repository.ReportRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class SalesReport {
    @Autowired
    private ReportRepository repository;
    @PersistenceContext
    private EntityManager entityManager;
    private List<Payment> lastWeekPayments;

    public Payment findBestseller() {
//        return repository.findBestsellers();
        return entityManager.createQuery(
                "SELECT count(p) FROM payments p GROUP BY purchase_item_id ORDER BY p.purchase_item_id DESC",
                Payment.class).setMaxResults(1).getSingleResult();

    }

    public List<String> byAge(int age) {
        return repository.findByAgeIs();
    }


}

