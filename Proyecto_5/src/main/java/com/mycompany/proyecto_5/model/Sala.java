/*
 * Clase   : Sala
 * Paquete : com.mycompany.proyecto_5.model
 * Desc    : Entidad que representa una sala fisica del cine CineStar Barrio.
 *           Contiene nombre y capacidad total de asientos.
 * Autor   : Grupo 8
 * Fecha   : 12/06/2026
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
