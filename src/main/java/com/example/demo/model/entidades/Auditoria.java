package com.example.demo.model.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditoria<U> implements Serializable{
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", updatable = false)
    public Date fechaCreacion;

    @CreatedBy
    @Column(name = "creado_por", updatable = false)
    public U creadoPor;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion")
    public Date fechaModificacion;

    @LastModifiedBy
    @Column(name = "modificado_por")
    public U modificadoPor;
    
}
