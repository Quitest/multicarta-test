package ru.pel.tests.multicartatest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MappingJackson2XmlView;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
public class AppConfig {

    @Bean
    @Description("Позволяет REST контроллерам принимать и отправлять данные в форматах JSON и XML. При необходимости, " +
            "можно легко добавить и другие форматы")
    public ViewResolver contentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver resolver =
                new ContentNegotiatingViewResolver();

        List<View> views = new ArrayList<>();
        views.add(new MappingJackson2XmlView());
        views.add(new MappingJackson2JsonView());
        resolver.setDefaultViews(views);
        return resolver;
    }

//    @Bean
//    public Jaxb2Marshaller jaxb2Marshaller(){
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setSchema(new ClassPathResource("request.xsd"));
//        marshaller.setClassesToBeBound();
//        return marshaller;
//    }
}
