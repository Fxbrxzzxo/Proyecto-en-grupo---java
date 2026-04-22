/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_5.model;


/**
 *
 * @author LENOVO
 */
public class Funcion {
   
     private int id;
    private int peliculaId;
    private int salaId;
    private String horario;

    public Funcion() {}

    public Funcion(int id, int peliculaId, int salaId, String horario) {
        this.id = id;
        this.peliculaId = peliculaId;
        this.salaId = salaId;
        this.horario = horario;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPeliculaId() { return peliculaId; }
    public void setPeliculaId(int peliculaId) { this.peliculaId = peliculaId; }

    public int getSalaId() { return salaId; }
    public void setSalaId(int salaId) { this.salaId = salaId; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
}
