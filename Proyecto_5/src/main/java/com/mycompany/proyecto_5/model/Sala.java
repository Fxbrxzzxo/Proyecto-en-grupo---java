/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_5.model;

/**
 *
 * @author LENOVO
 */
public class Sala {
     private int idSala;
    private String nombre;
    private int capacidad;

    public Sala() {}

    public Sala(int idSala, String nombre, int capacidad) {
        this.idSala = idSala;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public int getIdSala() { return idSala; }
    public void setIdSala(int idSala) { this.idSala = idSala; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
}
