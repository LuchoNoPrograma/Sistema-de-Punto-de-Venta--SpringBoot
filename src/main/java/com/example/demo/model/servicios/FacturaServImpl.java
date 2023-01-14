package com.example.demo.model.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dao.IFacturaDao;
import com.example.demo.model.entidades.Factura;
import com.example.demo.model.entidades.FacturaProducto;

@Service
public class FacturaServImpl implements IFacturaServ{
    @Autowired private IFacturaDao dao;

    @Override
    public Factura registrarFactura(Factura factura) {
        return dao.save(factura);
    }

    @Override
    public Factura modificarFactura(Factura factura) {
        return dao.save(factura);
    }

    @Override
    public boolean eliminarFactura(Factura factura) {
        try{
            dao.delete(factura);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public List<Factura> listarFacturasPorIdCliente(Long idCliente) {
        return dao.listarFacturasPorIdCliente(idCliente);
    }

    @Override
    public List<FacturaProducto> listarFacturasItemsPorIdFactura(Long idFactura) {
        return dao.listarFacturasProductosPorIdFactura(idFactura);
    }

}
