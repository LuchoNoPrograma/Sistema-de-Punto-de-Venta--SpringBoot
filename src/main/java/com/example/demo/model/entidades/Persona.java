package com.example.demo.model.entidades;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//La libreria lombok me facilita muchisimas cosas e incluso puedo implementar el patron Builder
//Se volvio en mi favorito
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "persona")
public class Persona extends Auditoria<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    public Long idPersona;

    @Column(length = 155)
    public String nombres;

    @Column(length = 155)
    public String paterno;

    @Column(length = 155)
    public String materno;

    //Nuevo api de Fechas, a comparacion de Date, LocalDate me permite solo saber Fecha y no la zona horaria
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "fecha_nacimiento")
    public LocalDate fechaNacimiento;
}
