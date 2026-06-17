/*
 * Clase   : ReservaDAO
 * Paquete : com.mycompany.proyecto_5.dao
 * Desc    : Acceso a datos para la entidad Reserva. Gestiona insercion,
 *           cancelacion y consulta de reservas por usuario con detalle completo.
 * Autor   : Grupo 8
 * Fecha   : 12/06/2026
 */
package com.mycompany.proyecto_5.dao;
import com.mycompany.proyecto_5.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class ReservaDAO {
   public boolean existeReserva(int idFuncion, int idAsiento) {
       
        String sql = "SELECT COUNT(*) FROM Reserva WHERE idFuncion = ? AND idAsiento = ? AND estado = 'ACTIVA'";
    try (Connection con = ConexionBD.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idFuncion);
        ps.setInt(2, idAsiento);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
    }

    public boolean insertarReserva(int idUsuario, int idFuncion, int idAsiento) {

        String sql = "INSERT INTO Reserva (idUsuario, idFuncion, idAsiento) VALUES (?, ?, ?)";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ps.setInt(2, idFuncion);
            ps.setInt(3, idAsiento);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean cancelarReserva(int idReserva, int idUsuario) {

        String sql1 = "UPDATE Reserva SET estado = 'CANCELADA' WHERE idReserva = ?";
        String sql2 = "INSERT INTO HistorialCancelaciones (idReserva, idUsuario) VALUES (?, ?)";

        try (Connection con = ConexionBD.getConexion()) {

            con.setAutoCommit(false);

            try (PreparedStatement ps1 = con.prepareStatement(sql1);
                 PreparedStatement ps2 = con.prepareStatement(sql2)) {

                ps1.setInt(1, idReserva);
                ps1.executeUpdate();

                ps2.setInt(1, idReserva);
                ps2.setInt(2, idUsuario);
                ps2.executeUpdate();

                con.commit();
                return true;

            } catch (Exception e) {
                con.rollback();
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public ResultSet listarReservasUsuario(int idUsuario) {

        String sql = "SELECT * FROM Reserva WHERE idUsuario = ?";

        try {
            Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idUsuario);

            return ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public java.util.List<Object[]> listarReservasDetalle(int idUsuario) {
    String sql = "SELECT r.idReserva, u.nombre, p.titulo, s.nombre, " +
                 "a.fila + '-' + CAST(a.numero AS varchar) AS asiento, " +
                 "CONVERT(varchar, r.fechaReserva, 23), r.estado " +
                 "FROM Reserva r " +
                 "JOIN Usuario u ON r.idUsuario = u.idUsuario " +
                 "JOIN Funcion f ON r.idFuncion = f.idFuncion " +
                 "JOIN Pelicula p ON f.idPelicula = p.idPelicula " +
                 "JOIN Sala s ON f.idSala = s.idSala " +
                 "JOIN Asiento a ON r.idAsiento = a.idAsiento " +
                 "WHERE r.idUsuario = ?";
    java.util.List<Object[]> lista = new java.util.ArrayList<>();
    try (Connection con = ConexionBD.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lista.add(new Object[]{
                rs.getInt(1),     // idReserva
                rs.getString(2),  // usuario
                rs.getString(3),  // película
                rs.getString(4),  // sala
                rs.getString(5),  // asiento (ej: E-1)
                rs.getString(6),  // fecha
                rs.getString(7)   // estado
            });
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista;
}

    public List<String> listarReservasActivas(int idUsuario, int idFuncion) {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT r.idReserva, a.fila, a.numero FROM Reserva r " +
                     "JOIN Asiento a ON r.idAsiento = a.idAsiento " +
                     "WHERE r.idUsuario = ? AND r.idFuncion = ? AND r.estado = 'ACTIVA'";
        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ps.setInt(2, idFuncion);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getInt("idReserva") + " - Asiento " + 
                          rs.getString("fila") + rs.getInt("numero"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }

}
