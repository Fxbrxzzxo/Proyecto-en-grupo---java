/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_5.model;
import java.util.Date;


/**
 *
 * @author LENOVO
 */
public class Funcion {
   
    private int idFuncion;
    private int idSala;
    private int idPelicula;
    private Date fechaHora;
    private int cupoDisponible;

    public Funcion() {}

    public Funcion(int idFuncion, int idSala, int idPelicula, Date fechaHora, int cupoDisponible) {
        this.idFuncion = idFuncion;
        this.idSala = idSala;
        this.idPelicula = idPelicula;
        this.fechaHora = fechaHora;
        this.cupoDisponible = cupoDisponible;
    }

    public int getIdFuncion() { return idFuncion; }
    public void setIdFuncion(int idFuncion) { this.idFuncion = idFuncion; }

    public int getIdSala() { return idSala; }
    public void setIdSala(int idSala) { this.idSala = idSala; }

    public int getIdPelicula() { return idPelicula; }
    public void setIdPelicula(int idPelicula) { this.idPelicula = idPelicula; }

    public Date getFechaHora() { return fechaHora; }
    public void setFechaHora(Date fechaHora) { this.fechaHora = fechaHora; }

    public int getCupoDisponible() { return cupoDisponible; }
    public void setCupoDisponible(int cupoDisponible) { this.cupoDisponible = cupoDisponible; }
     
}
