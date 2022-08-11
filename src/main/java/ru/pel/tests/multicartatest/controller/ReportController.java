package ru.pel.tests.multicartatest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pel.tests.multicartatest.service.SalesReport;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private SalesReport salesReport;


    @GetMapping
    public String greetingsPage(){
        return "index";
    }
    /**
     * список покупок за последнюю неделю
     *
     * @return
     */
    @GetMapping("/sales/inLastWeeks")
    public String lastSales(Model model) {
        model.addAttribute("paymentsList", salesReport.getPaymentsInLastWeek());
        return "inLastWeek";
    }

    /**
     * самый покупаемый товар за последний месяц
     *
     * @return
     */
    @GetMapping("/sales/bestseller")
    public List<String> mostPurchased() {
        return salesReport.findBestseller();
    }

    /**
     * имя и фамилию человека, совершившего больше всего покупок за полгода
     *
     * @return
     */
    @GetMapping("/bestbuyer")
    public List<String> theBestBuyer() {
        return salesReport.getBestBuyer();
    }

    /**
     * Что чаще всего покупают люди в возрасте 18 лет
     *
     * @return
     */
    @GetMapping("/sales/byAge")
    public List<String> favoritesOf18yo() {
        return salesReport.favorite18yo();
    }
}
