package ru.pel.tests.multicartatest.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.pel.tests.multicartatest.filter.PaymentFilter;

@Configuration
public class BeansRegistration {

    @Bean
    public FilterRegistrationBean<PaymentFilter> paymentFilterFilterRegistrationBean(){
        FilterRegistrationBean<PaymentFilter> filterRegistrationBean = new FilterRegistrationBean<>();

        filterRegistrationBean.setFilter(new PaymentFilter());
        filterRegistrationBean.addUrlPatterns("/products");
        filterRegistrationBean.setOrder(1);

        return filterRegistrationBean;
    }
}
