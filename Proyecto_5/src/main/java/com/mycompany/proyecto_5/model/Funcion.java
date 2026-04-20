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
public class Funcion {
   
     private int id;
    private Pelicula pelicula;
    private Sala sala;
    private LocalDateTime horario;

    public Funcion() {}

    public Funcion(int id, Pelicula pelicula, Sala sala, LocalDateTime horario) {
        this.id = id;
        this.pelicula = pelicula;
        this.sala = sala;
        this.horario = horario;
    }

    public int getId() { return id; }
    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
    public LocalDateTime getHorario() { return horario; }
}
