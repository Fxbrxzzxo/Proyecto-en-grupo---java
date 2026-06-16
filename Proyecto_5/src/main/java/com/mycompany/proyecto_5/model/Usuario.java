/*
 * Clase   : Usuario
 * Paquete : com.mycompany.proyecto_5.model
 * Desc    : Entidad que representa a un cliente registrado en el sistema
 *           de reservas de CineStar Barrio.
 * Autor   : Grupo 8
 * Fecha   : 12/06/2026
 */
package com.mycompany.proyecto_5.model;

/**
 *
 * @author LENOVO
 */
public class Usuario {
private int idUsuario;
    private String nombre;
    private String correo;
    private String clave;

    public Usuario() {}

    public Usuario(int idUsuario, String nombre, String correo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    
    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }
}
