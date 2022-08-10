package ru.pel.tests.multicartatest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class SalesReport {
    @PersistenceContext
    private EntityManager entityManager;

    public String findBestseller() {
        return (String) entityManager.createNativeQuery(
                "SELECT products.name " +
                        "FROM payments " +
                        "   RIGHT JOIN products ON payments.purchase_item_id=products.id " +
                        "WHERE count IS NOT null " +
                        "   AND payments.purchase_date >= date_trunc('month', current_date - interval '1' month) " +
                        "GROUP BY products.name " +
                        "ORDER BY sum(count) desc " +
                        "LIMIT 1").getSingleResult();

    }

    public List<String> getPaymentsInLastWeek() {
        return entityManager.createNativeQuery("SELECT products.name " +
                "FROM payments " +
                "   RIGHT JOIN products ON payments.purchase_item_id=products.id " +
                "WHERE " +
                "   payments.purchase_date >= date_trunc('day', current_date - interval '7' day) " +
                "ORDER BY products.name").getResultList();
    }
}

