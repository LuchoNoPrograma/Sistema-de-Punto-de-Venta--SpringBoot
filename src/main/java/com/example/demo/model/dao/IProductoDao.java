package com.example.demo.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entidades.Producto;

//Manera 1 de trabajar con la DB
public interface IProductoDao extends JpaRepository<Producto, Long>{
}
