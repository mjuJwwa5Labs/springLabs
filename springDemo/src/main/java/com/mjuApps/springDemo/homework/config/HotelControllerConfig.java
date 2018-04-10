package com.mjuApps.springDemo.homework.config;

import com.mjuApps.springDemo.homework.validator.FindHotelDtoValidator.BedsNumberValidator;
import com.mjuApps.springDemo.homework.validator.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HotelControllerConfig {

    @Bean
    public Validator bedsNumberValidator() {return new BedsNumberValidator(); }

}
