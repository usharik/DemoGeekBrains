package ru.geekbrains.patterns.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public SubService1 subService1() {
        return new SubService1Impl();
    }

    @Bean
    public SubService2 subService2() {
        return new SubService2Impl();
    }

    @Bean
    public Service service(SubService1 subService1, SubService2 subService2) {
        return new ServiceImp(subService1, subService2);
    }
}
