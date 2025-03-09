package com.usandogemini.usando_gemini.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApiConfiguration {

    @Value("${deepseek.api.key}")
    private String apiKey;

    @Value("${external.api.url}")
    private String externalApiUrl;

    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .baseUrl(externalApiUrl+apiKey)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}