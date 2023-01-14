package com.example.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControlador {
    @GetMapping({"/", "/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/informacion")
    public String informacion(){
        return "info";
    }
}
