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
import com.mycompany.proyecto_5.model.Asiento;


/**
 *
 * @author LENOVO
 */
public class AsientoDAO {
     public List<Integer> asientosOcupados(int idFuncion) {

        List<Integer> lista = new ArrayList<>();

        String sql = "SELECT idAsiento FROM Reserva WHERE idFuncion = ? AND estado = 'ACTIVA'";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idFuncion);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
     
      public List<Asiento> asientosPorSala(int idSala) {
        List<Asiento> lista = new ArrayList<>();
        String sql = "SELECT idAsiento, idSala, fila, numero FROM Asiento WHERE idSala = ? ORDER BY fila, numero";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idSala);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Asiento(
                    rs.getInt("idAsiento"),
                    rs.getInt("idSala"),
                    rs.getString("fila"),
                    rs.getInt("numero")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }
}
