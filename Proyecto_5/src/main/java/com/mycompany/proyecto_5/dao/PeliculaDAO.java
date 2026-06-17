/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_5.dao;
import com.mycompany.proyecto_5.util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PeliculaDAO {
    public boolean agregarPelicula(String titulo, int duracion, String clasificacion) {
        String sql = "INSERT INTO Pelicula (titulo, duracionMin, clasificacion) VALUES (?, ?, ?)";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, titulo);
            ps.setInt(2, duracion);
            ps.setString(3, clasificacion);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public List<String> listarPeliculas() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT idPelicula, titulo FROM Pelicula ORDER BY titulo";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getInt("idPelicula") + " - " + rs.getString("titulo"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }
}
