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

        String sql = "SELECT idUsuario, nombre FROM Usuario ORDER BY nombre";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNombre(rs.getString("nombre"));
                lista.add(u);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
