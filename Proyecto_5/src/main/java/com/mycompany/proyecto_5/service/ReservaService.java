/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_5.service;
import com.mycompany.proyecto_5.dao.ReservaDAO;
import com.mycompany.proyecto_5.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author LENOVO
 */
public class ReservaService {
     private ReservaDAO reservaDAO = new ReservaDAO();

    public String reservarAsiento(int idUsuario, int idFuncion, int idAsiento) {

        Connection con = null;

        try {
            con = ConexionBD.getConexion();
            con.setAutoCommit(false);

            if (reservaDAO.existeReserva(idFuncion, idAsiento)) {
                return "Asiento ya reservado";
            }

            
            String sqlCupo = "SELECT cupoDisponible FROM Funcion WITH (UPDLOCK, ROWLOCK) WHERE idFuncion = ?";
            PreparedStatement psCupo = con.prepareStatement(sqlCupo);
            psCupo.setInt(1, idFuncion);

            ResultSet rs = psCupo.executeQuery();

            if (!rs.next()) {
                return "Función no existe";
            }

            int cupo = rs.getInt("cupoDisponible");

            if (cupo <= 0) {
                return "Función llena";
            }

            String sqlReserva = "INSERT INTO Reserva (idUsuario, idFuncion, idAsiento) VALUES (?, ?, ?)";
            PreparedStatement psReserva = con.prepareStatement(sqlReserva);
            psReserva.setInt(1, idUsuario);
            psReserva.setInt(2, idFuncion);
            psReserva.setInt(3, idAsiento);
            psReserva.executeUpdate();

            String sqlUpdate = "UPDATE Funcion SET cupoDisponible = cupoDisponible - 1 WHERE idFuncion = ?";
            PreparedStatement psUpdate = con.prepareStatement(sqlUpdate);
            psUpdate.setInt(1, idFuncion);
            psUpdate.executeUpdate();

            con.commit();
            return "Reserva exitosa";

        } catch (Exception e) {
            try {
                if (con != null) con.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return "Error al reservar";
        }
    }
}
