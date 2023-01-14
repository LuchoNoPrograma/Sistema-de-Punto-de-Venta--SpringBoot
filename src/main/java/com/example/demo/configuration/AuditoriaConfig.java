package com.example.demo.configuration;

import java.net.http.HttpRequest;
import java.util.Optional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@Configuration
@EnableJpaAuditing(auditorAwareRef = "aware")
public class AuditoriaConfig {
    @Autowired private HttpServletRequest request;

    @Bean
    public AuditorAware<String> aware(){
        return () -> Optional.of(request.getRemoteUser());
    }
}