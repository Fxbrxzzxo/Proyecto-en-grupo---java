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
public class Reserva {
    private int idReserva;
    private int idUsuario;
    private int idFuncion;
    private int idAsiento;
    private Date fechaReserva;
    private String estado;

    public Reserva() {}

    public Reserva(int idReserva, int idUsuario, int idFuncion, int idAsiento, Date fechaReserva, String estado) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.idFuncion = idFuncion;
        this.idAsiento = idAsiento;
        this.fechaReserva = fechaReserva;
        this.estado = estado;
    }

    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdFuncion() { return idFuncion; }
    public void setIdFuncion(int idFuncion) { this.idFuncion = idFuncion; }

    public int getIdAsiento() { return idAsiento; }
    public void setIdAsiento(int idAsiento) { this.idAsiento = idAsiento; }

    public Date getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(Date fechaReserva) { this.fechaReserva = fechaReserva; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
