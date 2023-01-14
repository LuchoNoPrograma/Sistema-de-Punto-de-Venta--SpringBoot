package com.example.demo.model.servicios;

import java.util.List;

import com.example.demo.model.entidades.Factura;
import com.example.demo.model.entidades.FacturaProducto;

public interface IFacturaServ {
    public Factura registrarFactura(Factura factura);
    public Factura modificarFactura(Factura factura);
    public boolean eliminarFactura(Factura factura);
    public List<Factura> listarFacturasPorIdCliente(Long idCliente);
    public List<FacturaProducto> listarFacturasItemsPorIdFactura(Long idFactura);
}
