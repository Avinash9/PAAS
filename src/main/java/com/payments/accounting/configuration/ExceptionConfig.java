package com.payments.accounting.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Ankit Thakwani
 * @version $Id: ExceptionConfig.java, v 0.1 2019-10-10 10:23 AM Ankit Thakwani Exp $$
 */

@Configuration
public class ExceptionConfig {

    @Bean
    public Properties exception() throws IOException {
        return PropertiesLoaderUtils.loadProperties(new ClassPathResource("exception.properties"));
    }
}