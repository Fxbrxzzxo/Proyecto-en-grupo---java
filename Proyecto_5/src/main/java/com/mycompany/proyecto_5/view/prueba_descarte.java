/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_5.view;
 
import com.mycompany.proyecto_5.util.ConexionBD;
import java.sql.Connection;

public class prueba_descarte {
    public static void main(String[] args) {

        Connection con = ConexionBD.getConexion();

        if (con != null) {
            System.out.println("✔ CONEXIÓN EXITOSA");
        } else {
            System.out.println("✖ ERROR DE CONEXIÓN");
        }
    }
}
