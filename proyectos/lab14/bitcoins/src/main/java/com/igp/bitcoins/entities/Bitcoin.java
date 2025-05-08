package com.igp.bitcoins.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bitcoin")
public class Bitcoin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double cantidad;
    private Double valor;
    @Column(name = "idcuenta")
    private Long idCuenta;
       

    public Bitcoin() {
    }
    public Bitcoin(Double cantidad, Double valor, Long idCuenta) {
        this.cantidad = cantidad;
        this.valor = valor;
        this.idCuenta = idCuenta;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getCantidad() {
        return cantidad;
    }
    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Long getIdCuenta() {
        return idCuenta;
    }
    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    

}
