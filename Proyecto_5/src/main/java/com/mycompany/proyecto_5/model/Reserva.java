/*
 * Clase   : Reserva
 * Paquete : com.mycompany.proyecto_5.model
 * Desc    : Representa la reserva de un asiento por parte de un usuario
 *           para una funcion especifica. Incluye estado ACTIVA/CANCELADA.
 * Autor   : Grupo 8
 * Fecha   : 12/06/2026
 */
package com.mycompany.proyecto_5.model;
import java.util.Date;


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
