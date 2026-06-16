/*
 * Clase   : Pelicula
 * Paquete : com.mycompany.proyecto_5.model
 * Desc    : Entidad que almacena la informacion basica de una pelicula
 *           disponible en el catalogo de CineStar Barrio.
 * Autor   : Grupo 8
 * Fecha   : 12/06/2026
 */
package com.mycompany.proyecto_5.model;

/**
 *
 * @author LENOVO
 */
public class Pelicula {
    private int idPelicula;
    private String titulo;
    private int duracionMin;
    private String clasificacion;

    public Pelicula() {}

    public Pelicula(int idPelicula, String titulo, int duracionMin, String clasificacion) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracionMin = duracionMin;
        this.clasificacion = clasificacion;
    }

    public int getIdPelicula() { return idPelicula; }
    public void setIdPelicula(int idPelicula) { this.idPelicula = idPelicula; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getDuracionMin() { return duracionMin; }
    public void setDuracionMin(int duracionMin) { this.duracionMin = duracionMin; }

    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }

}

