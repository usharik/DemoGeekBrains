package ru.geekbrains.patterns.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public SubService1 subService1() {
        return new SubService1Impl();
    }
}
