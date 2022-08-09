package ru.pel.tests.multicartatest.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reports")
public class Report {

    /**
     * список покупок за последнюю неделю
     * @return
     */
    @GetMapping("/sales")
    public String lastSales(){

    }

    /**
     * самый покупаемый товар за последний месяц
     * @return
     */
    public String mostPurchased(){

    }

    /**
     * имя и фамилию человека, совершившего больше всего покупок за полгода
     * @return
     */
    public String theCoolestBuyer(){}

    /**
     * Что чаще всего покупают люди в возрасте 18 лет
     * @return
     */
    public String favoritesOf18yo(){}


}
