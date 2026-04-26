/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_5.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

/**
 *
 * @author LENOVO
 */
public class ConexionBD {
    private static Connection conexion = null;

    public static Connection getConexion() {
    try {
        Properties props = new Properties();
        InputStream input = ConexionBD.class
                .getClassLoader()
                .getResourceAsStream("db.properties");

        if (input == null) {
            System.out.println("No se encontró db.properties");
            return null;
        }

        props.load(input);
        input.close();

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        return DriverManager.getConnection(url, user, password);

    } catch (Exception e) {
        System.out.println("Error de conexión");
        e.printStackTrace();
        return null;
    }
}
    
}
