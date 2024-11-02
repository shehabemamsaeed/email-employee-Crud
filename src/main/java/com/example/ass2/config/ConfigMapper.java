package com.example.ass2.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMapper {

@Bean
    public ModelMapper modelMapper(){
    return new ModelMapper();
    }
}
