package com.example.demo.config

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate


@Configuration
class RestTemplateConfiguration {

    @Bean
    fun restTemplate(builder: RestTemplateBuilder ) : RestTemplate{
        return builder.build()
       // return builder.basicAuthentication("apiKey","nxzAAC1EQAAU7AGY8gUQnev_99A").build()
    }

}

