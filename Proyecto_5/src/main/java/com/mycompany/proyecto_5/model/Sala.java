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
  private int id;
    private int numero;
    private int capacidad;

    public Sala() {}

    public Sala(int id, int numero, int capacidad) {
        this.id = id;
        this.numero = numero;
        this.capacidad = capacidad;
    }

    public int getId() { return id; }
    public int getNumero() { return numero; }
    public int getCapacidad() { return capacidad; }
}
