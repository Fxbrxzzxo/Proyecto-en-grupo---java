/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_5;
import com.mycompany.proyecto_5.view.FrmPrincipal;
import com.mycompany.proyecto_5.view.FrmFunciones;
import com.mycompany.proyecto_5.view.FrmReservas;

/**
 *
 * @author LENOVO
 */
public class Proyecto_5 {

    public static void main(String[] args) {

        try {
            javax.swing.UIManager.setLookAndFeel(
                javax.swing.UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            System.out.println("No se pudo aplicar el LookAndFeel");
        }

        java.awt.EventQueue.invokeLater(() -> {
            new FrmPrincipal().setVisible(true);
            new FrmFunciones().setVisible(true);
            new FrmReservas().setVisible(true);
        });
    }

        
}
