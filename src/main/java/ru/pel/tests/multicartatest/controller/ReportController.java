package ru.pel.tests.multicartatest.controller;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pel.tests.multicartatest.service.SalesReport;

@Controller
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private SalesReport salesReport;


//    @GetMapping
//    public String greetingsPage(){
//        return "index";
//    }
    /**
     * список покупок за последнюю неделю
     *
     * @return
     */
    @GetMapping("/sales/inLastWeeks")
    public String lastSales(Model model) {
        model.addAttribute("paymentsList", salesReport.getPaymentsInLastWeek());
        return "reports/inLastWeek";
    }

    /**
     * самый покупаемый товар за последний месяц
     *
     * @return
     */
    @GetMapping("/sales/bestseller")
    public String mostPurchased(Model model) {
//        return salesReport.getBestseller();
        model.addAttribute("bestsellerList", salesReport.getBestseller());
        return "reports/bestseller";
    }

    /**
     * имя и фамилию человека, совершившего больше всего покупок за полгода
     *
     * @return
     */
    @GetMapping("/sales/bestbuyer")
    public String theBestBuyer(Model model) {
//        return salesReport.getBestBuyer();
        model.addAttribute("bestbuyerList", salesReport.getBestBuyer());
        return "reports/bestbuyer";
    }

    /**
     * Что чаще всего покупают люди в возрасте 18 лет
     *
     * @return
     */
    @GetMapping("/sales/byAge")
    public String favoritesOf18yo(Model model) {
//        return salesReport.getFavorite18yo();
        model.addAttribute("favorites", salesReport.getFavorite18yo());
        return "reports/byAge";
    }
}
