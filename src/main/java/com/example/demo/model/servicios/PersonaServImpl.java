package com.example.demo.model.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IPersonaDao;
import com.example.demo.model.entidades.Persona;

@Service
public class PersonaServImpl implements IPersonaServ{
    @Autowired private IPersonaDao dao;

    @Override
    @Transactional
    public Persona guardarPersona(Persona persona) {
        return dao.save(persona);
    }

    @Override
    @Transactional
    public Persona modificarPersona(Persona persona) {
        return dao.save(persona);
    }

    @Override
    @Transactional
    public Persona buscarPorId(Long idPersona) {
        return dao.findById(idPersona).orElse(null);
    }

    @Override
    @Transactional
    public List<Persona> listarPersonas() {
        return (List<Persona>) dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Persona> listarPersonas(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public Page<Persona> listarPersonas(Pageable pageable, Sort sort) {
        return null;
    }
}
