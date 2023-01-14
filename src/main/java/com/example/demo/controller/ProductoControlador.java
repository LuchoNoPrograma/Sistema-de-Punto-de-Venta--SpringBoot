package com.example.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.entidades.Producto;
import com.example.demo.model.entidades.ProductoCategoria;
import com.example.demo.model.servicios.ProductoServImpl;


/**
 * @apiNote ROL: ADMINISTRATIVO
 * 
 * Este controlador solo se encargara de enviar y recibir informacion REST, a excepcion de su index
 * Tip, para evitar anotar @ResponseBody en cada metodo, poner la anotacion en nivel clase el siguiente:
 * @RestController = @Controller + @ResponseBody
 */
@Controller
@RequestMapping("/producto")
public class ProductoControlador {
    @Autowired private ProductoServImpl productoServicios;

    private String URL = "vistaProducto/index-producto";

    /* Este metodo sera tratado como el inicio de administracion de la entidad Item 
     * La renderizacion de archivos y fragmentos se realizara una vez con ThymeLeaf, el resto se hara con 
     * Vanilla JS puro y duro en la web 
     */
    @GetMapping("/index")
    public String indexProducto(){
        return URL;
    }

    @ResponseBody
    @GetMapping("/api/v1/productos")
    public ResponseEntity<?> listaProductosTotal(HttpSession session){
        return ResponseEntity.ok(productoServicios.listarProductos());
    }

    @PostMapping("/registrar")
    public String registrarProducto(@RequestBody Producto producto){
        productoServicios.registrarProducto(producto);
        return "redirect:/index";
    }

    public String listarItems(Model model){
        return URL;
    }

    @GetMapping("/modificar/{idProducto}")
    public String modificarProducto(@PathVariable Long idProducto){
        Producto i = productoServicios.buscarProductoPorIdProducto(idProducto);
        i.setProducto(i.getProducto().concat("V2"));
        productoServicios.registrarProducto(i);
        return "redirect:/index";
    }

    @GetMapping("/prueba")
    public String mensaje(@RequestBody String estrin){
        return estrin;
    }
}
