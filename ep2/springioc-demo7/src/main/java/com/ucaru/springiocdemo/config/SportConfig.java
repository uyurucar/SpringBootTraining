package com.ucaru.springiocdemo.config;

import com.ucaru.springiocdemo.common.Coach;
import com.ucaru.springiocdemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public SwimCoach swimCoach()
    {
        return new SwimCoach();
    }

}
