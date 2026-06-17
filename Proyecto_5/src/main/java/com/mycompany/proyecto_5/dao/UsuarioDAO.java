/*
 * Clase   : UsuarioDAO
 * Paquete : com.mycompany.proyecto_5.dao
 * Desc    : Acceso a datos para la entidad Usuario. Permite obtener
 *           el listado de clientes registrados en el sistema.
 * Autor   : Grupo 8
 * Fecha   : 12/06/2026
 */
package com.mycompany.proyecto_5.dao;
import com.mycompany.proyecto_5.model.Usuario;
import com.mycompany.proyecto_5.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class UsuarioDAO {
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT idUsuario, nombre, correo FROM Usuario ORDER BY nombre";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                lista.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    public Usuario autenticar(String correo, String clave) {
        String sql = "SELECT idUsuario, nombre, correo FROM Usuario WHERE correo = ? AND clave = ?";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, correo);
            ps.setString(2, clave);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setIdUsuario(rs.getInt("idUsuario"));
                    u.setNombre(rs.getString("nombre"));
                    u.setCorreo(rs.getString("correo"));
                    return u;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
    public boolean existeCorreo(String correo) {
    String sql = "SELECT COUNT(*) FROM Usuario WHERE correo = ?";
    try (Connection con = ConexionBD.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, correo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (Exception e) { e.printStackTrace(); }
    return false;
}

public boolean registrarUsuario(String nombre, String correo, String clave) {
    String sql = "INSERT INTO Usuario (nombre, correo, clave) VALUES (?, ?, ?)";
    try (Connection con = ConexionBD.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, nombre);
        ps.setString(2, correo);
        ps.setString(3, clave);
        return ps.executeUpdate() > 0;
    } catch (Exception e) { e.printStackTrace(); }
    return false;
}
}
