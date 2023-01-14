package com.example.demo.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entidades.Persona;

@Repository
public interface IPersonaDao extends PagingAndSortingRepository<Persona, Long>{
}
