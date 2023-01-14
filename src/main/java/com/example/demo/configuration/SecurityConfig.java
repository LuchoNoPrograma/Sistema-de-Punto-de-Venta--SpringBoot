package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    protected BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    //Usuarios en memoria para realizar pruebas rapidas sin necesidad de crear las entidadades User y Roles
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
            .withUser("ADMIN123")
                .password(encoder().encode("123")).roles("ADMIN")
            .and()
            .withUser("JEFE123")
                .password(encoder().encode("123")).roles("JEFE")
            .and()
            .withUser("DOCENTE123")
                .password(encoder().encode("123")).roles("DOCENTE")
            .and()
            .withUser("ESTUDIANTE123")
                .password(encoder().encode("123")).roles("ESTUDIANTE")
            .and()
            .withUser("ADMINISTRATIVO123")
                .password(encoder().encode("123")).roles("ADMINISTRATIVO");
    }

    
    @Override
    public void configure(HttpSecurity http) throws Exception{
        //Los requests, al parecer son de las rutas URL que manejan los controladores y no los archivos como creia
        http.authorizeRequests()
            .antMatchers("/informacion", "/css/**", "/custom/**","/js/**", "/images/**", "/fonts/**", "/vendor/**").permitAll()
            .antMatchers("/persona/**").hasRole("ADMIN")
            .antMatchers("/producto/**").hasRole("ADMINISTRATIVO")
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/login").permitAll()
            .and()
            .logout().permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/error_403");
    }
}
