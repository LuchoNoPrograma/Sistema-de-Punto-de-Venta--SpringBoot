package com.example.demo.model.servicios;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.example.demo.model.entidades.Cliente;
import com.example.demo.model.entidades.Factura;

public interface IClienteServ {
    public Cliente buscarClientePorId(Long idCliente);
    public Cliente registrarCliente(Cliente cliente);
    public Cliente modificarCliente(Cliente cliente);
    public boolean eliminarCliente(Cliente cliente);
    public List<Cliente> listarClientes(Sort Sort);
}
