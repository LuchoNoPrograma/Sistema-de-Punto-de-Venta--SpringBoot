package com.example.demo.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.entidades.Producto;

//Al parecer es necesario la anotacion Repository, a diferencia de 
//CrudRepository o JpaRepository que no lo necesitan
@Repository
public class ProductoDaoImpl implements ICustomProductoDao{
    //Anotacion que permite inyectar EntityManager y administar su ciclo de vida
    //para poder interactuar con la base de datos
    @PersistenceContext
    private EntityManager em;

    @Override
    public Producto registrarProducto(Producto producto) {
        em.persist(producto);
        return producto;
    }

    @Override
    public Producto modificarProducto(Producto producto) {
        em.merge(producto);
        return producto;
    }

    @Override
    public Producto buscarProductoPorIdProducto(Long idProducto) {
        String sql = "SELECT pro FROM Producto pro "+
                    "WHERE pro.idPro = :id";
        return em.createQuery(sql, Producto.class)//Clase de salida esperada
            .setParameter("id", idProducto)//Parametro texto
            .getSingleResult();
    }

    @Override
    public List<Producto> listarProductos() {
        String sql = "SELECT pro FROM Producto pro";
        return em.createQuery(sql, Producto.class).getResultList();
    }
    
}
