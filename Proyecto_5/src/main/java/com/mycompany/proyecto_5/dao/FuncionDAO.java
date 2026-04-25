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
import com.mycompany.proyecto_5.model.Funcion;

/**
 *
 * @author LENOVO
 */
public class FuncionDAO {
    public List<String> listarFunciones() {
        List<String> lista = new ArrayList<>();

        String sql = "SELECT f.idFuncion, p.titulo, f.fechaHora " +
                     "FROM Funcion f INNER JOIN Pelicula p ON f.idPelicula = p.idPelicula";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(
                    rs.getInt(1) + " - " +
                    rs.getString(2) + " - " +
                    rs.getString(3)
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public List<Object[]> listarFuncionesDetalle() {
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT f.idFuncion, p.titulo, s.nombre, " +
                     "CONVERT(varchar,f.fechaHora,23) AS fecha, " +
                     "CONVERT(varchar,f.fechaHora,8) AS hora, f.cupoDisponible " +
                     "FROM Funcion f " +
                     "INNER JOIN Pelicula p ON f.idPelicula = p.idPelicula " +
                     "INNER JOIN Sala s ON f.idSala = s.idSala " +
                     "ORDER BY f.fechaHora";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Object[]{
                    rs.getInt(1), rs.getString(2), rs.getString(3),
                    rs.getString(4), rs.getString(5), rs.getInt(6)
                });
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }
    
    public int obtenerIdSala(int idFuncion) {
        String sql = "SELECT idSala FROM Funcion WHERE idFuncion = ?";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idFuncion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);
        } catch (Exception e) { e.printStackTrace(); }
        return -1;
    }
}
