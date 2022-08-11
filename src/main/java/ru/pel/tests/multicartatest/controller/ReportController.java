package ru.pel.tests.multicartatest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pel.tests.multicartatest.service.SalesReport;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private SalesReport salesReport;

    /**
     * список покупок за последнюю неделю
     *
     * @return
     */
    @GetMapping("/sales/inLastWeeks")
    public List<String> lastSales() {
        return salesReport.getPaymentsInLastWeek();
    }

    /**
     * самый покупаемый товар за последний месяц
     *
     * @return
     */
    @GetMapping("/sales/bestseller")
    public String mostPurchased() {
        return salesReport.findBestseller();
    }

    /**
     * имя и фамилию человека, совершившего больше всего покупок за полгода
     *
     * @return
     */
    @GetMapping("/bestbuyer")
    public List<String> theBestBuyer() {
//        salesReport.getBestBuyer();
//        return "заглушка";
        return salesReport.getBestBuyer();
    }

    /**
     * Что чаще всего покупают люди в возрасте 18 лет
     *
     * @return
     */
//    @GetMapping("/sales/byAge")
//    public String favoritesOf18yo() {
//        return salesReport.favorite18yo();
//    }
}
