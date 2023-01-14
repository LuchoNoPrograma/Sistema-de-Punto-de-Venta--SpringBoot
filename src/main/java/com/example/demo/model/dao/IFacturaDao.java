package com.example.demo.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.entidades.Factura;
import com.example.demo.model.entidades.FacturaProducto;

public interface IFacturaDao extends JpaRepository<Factura, Long>{
    //Parametro por palabra
    @Query(value = "SELECT f FROM Factura f WHERE f.cliente.idCliente = :idCliente")
    public List<Factura> listarFacturasPorIdCliente(@Param("idCliente") Long idCliente);

    //Parametro por posicion
    @Query(value = "SELECT fi FROM FacturaProducto fi WHERE fi.factura.idFactura = ?1")
    public List<FacturaProducto> listarFacturasProductosPorIdFactura(Long idFactura);
}
