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
public class SalaDAO {
    public List<String> listarSalas() {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT idSala, nombre FROM Sala ORDER BY nombre";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getInt("idSala") + " - " + rs.getString("nombre"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }
}
