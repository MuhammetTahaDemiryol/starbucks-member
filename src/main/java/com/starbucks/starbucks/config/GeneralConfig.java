package com.starbucks.starbucks.config;

import com.starbucks.starbucks.adapter.EDUKPSPublicSoap;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfig {
    @Bean
    public ModelMapper createModelMapper(){
        return new ModelMapper();
    }
    @Bean
    public EDUKPSPublicSoap createPublicSoap(){return new EDUKPSPublicSoap();}
}