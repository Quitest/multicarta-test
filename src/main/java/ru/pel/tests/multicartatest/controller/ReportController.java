package ru.pel.tests.multicartatest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pel.tests.multicartatest.entity.Payment;
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
    public List<Payment> lastSales(@RequestParam("weeks") int weeks) {
//        return salesReport.generate(weeks);
    }

    /**
     * самый покупаемый товар за последний месяц
     *
     * @return
     */
    @GetMapping("/sales/bestseller")
    public Payment mostPurchased() {
        return salesReport.findBestseller();
    }

    /**
     * имя и фамилию человека, совершившего больше всего покупок за полгода
     *
     * @return
     */
//    @GetMapping("/bestbuyer")
//    public SalesReport.Person theBestBuyer() {
//        return salesReport.bestBuyer();
//    }

    /**
     * Что чаще всего покупают люди в возрасте 18 лет
     *
     * @return
     */
//    @GetMapping("/sales/byAge")
//    public Payment favoritesOf18yo() {
////        return salesReport.byAge(18);
//        return salesReport.favorite18yo();
//    }

//    @GetMapping("/sales/byAge")
//    public List<Payment> byAge(@RequestParam("age") int age){
//        return salesReport.byAge(/*age*/);
//    }


}
