package ru.pel.tests.multicartatest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
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

    public List<String> getBestBuyer() {
        List<Object[]> queryResults = entityManager.createNativeQuery("SELECT p.name, p.lastname " + /*, sum(p.count) " +*/
                "FROM payments p " +
                "WHERE purchase_date >= date_trunc('month', current_date - interval '6' MONTH) " +
                "GROUP BY p.name ,p.lastname " +
                "HAVING sum(p.count) >= ALL ( " +
                "   SELECT sum(p2.count) FROM payments p2 " +
                "   WHERE p2.purchase_date >= date_trunc('month', current_date - interval '6' MONTH) " +
                "   GROUP BY p2.name ,p2.lastname " +
                ")").getResultList();
        List<String> bestBuyers = new ArrayList<>();
        for (Object[] row : queryResults){
            bestBuyers.add(row[0] + " "+ row[1]);
        }
        return bestBuyers;
    }

    public List<String> favorite18yo(){
              return   entityManager.createNativeQuery("SELECT p2.name " +
                "FROM payments p " +
                "JOIN products p2 ON p.purchase_item_id = p2.id " +
                "WHERE p.age = 18 " +
                "GROUP BY p2.name " +
                "HAVING sum(p.count)>=ALL ( " +
                "SELECT sum(p3.count) FROM payments p3 " +
                "WHERE p3.age = 18 " +
                "GROUP BY p3.purchase_item_id " +
                ")").getResultList();
    }
}

