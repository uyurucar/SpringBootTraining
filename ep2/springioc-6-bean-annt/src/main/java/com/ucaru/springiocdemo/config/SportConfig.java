package com.ucaru.springiocdemo.config;

import com.ucaru.springiocdemo.common.Coach;
import com.ucaru.springiocdemo.common.SwimCoach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SportConfig {

    @Bean("aqua")
    //@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Coach swimCoach()
    {
        return new SwimCoach();
    }

}
