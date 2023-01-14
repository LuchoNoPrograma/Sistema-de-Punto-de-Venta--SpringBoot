package com.example.demo.model.dao;

import java.util.List;

import com.example.demo.model.entidades.Producto;

public interface ICustomProductoDao {
    public Producto registrarProducto(Producto producto);
    public Producto modificarProducto(Producto producto);
    public Producto buscarProductoPorIdProducto(Long idProducto);
    public List<Producto> listarProductos();
}
