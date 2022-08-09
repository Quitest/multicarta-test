package ru.pel.tests.multicartatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import ru.pel.tests.multicartatest.entity.Product;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class ReportImpl implements Report {
    @Autowired
    private PaymentService service;


    @Override
    @Query("SELECT purchase_item_id p FROM payments WHERE purchase_date")
    public List<Product> lastSales(ChronoUnit unit, int amount) {

        return null;
    }
}
