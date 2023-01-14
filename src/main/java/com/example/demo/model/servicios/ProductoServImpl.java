package com.example.demo.model.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.dao.ICustomProductoDao;
import com.example.demo.model.dao.IProductoDao;
import com.example.demo.model.entidades.Producto;

@Transactional
@Service
public class ProductoServImpl implements IProductoServ{
    @Autowired private ICustomProductoDao customDao; //Manera personalizada
    @Autowired private IProductoDao genericDao; //Proporcionado por JpaRepository

    @Override
    public Producto registrarProducto(Producto producto) {
        return customDao.registrarProducto(producto);
    }

    @Override
    public Producto modificarProducto(Producto producto) {
        return customDao.modificarProducto(producto);
    }

    @Override
    public Producto buscarProductoPorIdProducto(Long idProducto) {
        return customDao.buscarProductoPorIdProducto(idProducto);
    }

    @Override
    public List<Producto> listarProductos() {
        return customDao.listarProductos();
    }

    @Override
    public List<Producto> listarProductos(Sort sort) {
        return genericDao.findAll(sort);
    }
    
}
