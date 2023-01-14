package com.example.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginControlador {
    
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, 
    @RequestParam(value = "logout", required = false) String logout, 
    Model model, Principal principal){
        if(principal != null){
            return "redirect:/";
        }
        if(error != null){
            model.addAttribute("alerta", "error");
        }
        if(logout != null){
            model.addAttribute("alerta", "logout");
        }
        return "login";
    }
}
