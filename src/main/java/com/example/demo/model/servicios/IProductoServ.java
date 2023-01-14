package com.example.demo.model.servicios;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.example.demo.model.entidades.Producto;

/*
 * La capa de las interfaces en los servicios permite hacer una inyeccion de todas aquellas clases "Beans" que implementan dicha interfaz
 * Para poder establecer un "Bean" como principal, usar @Primary
 * Para especificar un "Bean" se usara @Qualifier("nombreClase")
 * 
 * Todo esto con el fin de evitar conflictos de dependencias, por lo general, si solo hay una clase que implementa el servicio
 * esa clsase sera tomado como la principal
 */
public interface IProductoServ {
    public Producto registrarProducto(Producto item);
    public Producto modificarProducto(Producto item);
    public Producto buscarProductoPorIdProducto(Long idItem);
    public List<Producto> listarProductos();
    public List<Producto> listarProductos(Sort sort);
}
