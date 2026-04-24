/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_5;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author LENOVO
 */
public class Proyecto_5 {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Sistema de Reservas CineStar");

        ventana.setSize(500,300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        JLabel texto = new JLabel("Sistema de Reservas CineStar", SwingConstants.CENTER);
        ventana.add(texto);

        ventana.setVisible(true);
    }
}
