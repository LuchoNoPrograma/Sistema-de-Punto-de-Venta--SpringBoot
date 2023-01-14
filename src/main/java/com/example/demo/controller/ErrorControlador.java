package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorControlador implements ErrorController{

    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView handleError(AccessDeniedException ex){
        ModelAndView vista = new ModelAndView("error/403");

        return vista;
    }
}
