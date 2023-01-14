package com.example.demo.model.servicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.model.entidades.Persona;

public interface IPersonaServ {
    public Persona guardarPersona(Persona persona);
    public Persona modificarPersona(Persona persona);
    public Persona buscarPorId(Long idPersona);
    public List<Persona> listarPersonas();
    public Page<Persona> listarPersonas(Pageable pageable);
    public Page<Persona> listarPersonas(Pageable pageable, Sort sort);
}
