package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.entidades.Cliente;
import com.example.demo.model.entidades.Persona;
import com.example.demo.model.servicios.IPersonaServ;
import com.example.demo.util.Paginador;

/**
 * @apiNote ROL: ADMIN
 * 
 * Este controlador renderizara los archivos HTML y las consultas se realizaran con ThymeLeaf automaticamente
 */

@Controller
@RequestMapping("/persona")
public class PersonaControlador {
    @Autowired private IPersonaServ prsServicios;

    @GetMapping("/formulario")
    public String formularioPersona(@ModelAttribute Persona persona, HttpSession session){
        return "vistaPersona/form-registro";
    }

    @GetMapping("/listar")
    public String listarPersona(@RequestParam(defaultValue = "0") int page, 
    @RequestParam(defaultValue = "asc") String orden, @RequestParam(defaultValue = "paterno") String columna,
    Model model, HttpSession session){

        Pageable paginaRequest;
        if(orden.equals("asc")){
            paginaRequest = PageRequest.of(page, 6, Sort.by(columna).ascending());
        }else{
            paginaRequest = PageRequest.of(page, 6, Sort.by(columna).descending());
        }
        
        List<String> listaColumnas = List.of("Paterno", "Materno", "Nombres");

        Page<Persona> paginaPersonas =  prsServicios.listarPersonas(paginaRequest);
        Paginador<Persona> paginador = new Paginador<>("/persona/listar", paginaPersonas);

        model.addAttribute("listaColumnas", listaColumnas);
        model.addAttribute("columna", columna);
        model.addAttribute("orden", orden);
        model.addAttribute("listaPersonas", paginaPersonas);
        model.addAttribute("paginador", paginador);
        return "vistaPersona/lista";
    }

    @PostMapping("/registrar")
    public String registrar(@Validated Persona persona, HttpSession session){
        prsServicios.guardarPersona(persona);
        return "redirect:/persona/listar";
    }

    @GetMapping("/modificar/{idPersona}")
    public String modificar(@PathVariable Long idPersona, HttpSession session){
        prsServicios.buscarPorId(idPersona);
        return "vistaPersona/form-modificacion";
    }

    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(@PathVariable Long idPersona, HttpSession session){
        prsServicios.buscarPorId(idPersona);
        return "redirect:/persona/lista";
    }
}
