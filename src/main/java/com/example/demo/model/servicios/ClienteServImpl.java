package com.example.demo.model.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.dao.IClienteDao;
import com.example.demo.model.entidades.Cliente;

@Service
public class ClienteServImpl implements IClienteServ{
    @Autowired private IClienteDao dao;

    @Override
    public Cliente buscarClientePorId(Long idCliente) {
        return dao.findById(idCliente).orElse(null);
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        return dao.save(cliente);
    }

    @Override
    public Cliente modificarCliente(Cliente cliente) {
        return dao.save(cliente);
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        try{
            dao.delete(cliente);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }

    @Override
    public List<Cliente> listarClientes(Sort sort) {
        return dao.findAll(sort);
    }
}
