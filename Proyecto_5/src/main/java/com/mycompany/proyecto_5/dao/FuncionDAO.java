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
}
