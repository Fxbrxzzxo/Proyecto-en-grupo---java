/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_5.model;
import java.time.LocalDateTime;

/**
 *
 * @author LENOVO
 */
public class Reserva {
    private int id;
    private Funcion funcion;
    private Asiento asiento;
    private String estado;
    private String codigo;
    private LocalDateTime fecha;

    public Reserva() {}

    public Reserva(int id, Funcion funcion, Asiento asiento, String estado, String codigo) {
        this.id = id;
        this.funcion = funcion;
        this.asiento = asiento;
        this.estado = estado;
        this.codigo = codigo;
        this.fecha = LocalDateTime.now();
    }

    public int getId() { return id; }
    public Funcion getFuncion() { return funcion; }
    public Asiento getAsiento() { return asiento; }
    public String getEstado() { return estado; }
    public String getCodigo() { return codigo; }
}
