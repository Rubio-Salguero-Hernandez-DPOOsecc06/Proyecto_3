package view;

import javax.swing.*;

import BaseDatos.GuardaDatos;
import controller.AdminController;
import model.TemporadaReal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JPanel implements ActionListener{
    JButton crear = new JButton("Crear temporada");
    JButton cargar = new JButton("Cargar resultado");
    JButton salir = new JButton("salir de la aplicación");
    AdminController adminController;
    GuardaDatos baseDatos;

    public AdminPanel(AdminController _AdminController, GuardaDatos _baseDatos){
        this.adminController = _AdminController;
        this.baseDatos = _baseDatos;
        setLayout(new GridLayout(4,1));
        add(crear);
        add(cargar);
        add(salir);
        crear.addActionListener(this);
        cargar.addActionListener(this);
        salir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == salir){
            System.exit(0);
        }else if(e.getSource() == cargar){
            TemporadaReal temporada = adminController.recuperarTemporada();
            JOptionPane.showMessageDialog(null,"id Temporada: " + temporada.getIdTemporada() + "\nEquipos: " + temporada.getSizeEquipos() + "\nFechas: " + temporada.getSizeFechas());
            

        }else if(e.getSource() == crear){
            String equipos = JOptionPane.showInputDialog("Ingresa el nombre del archivo de equipos");
            String jugadores = JOptionPane.showInputDialog("Ingresa el nombre del archivo de jugadores");
            String fechas = JOptionPane.showInputDialog("Ingresa el nombre del archivo de fechas");
            TemporadaReal temporada = adminController.crearTemprada(equipos, jugadores, fechas);
            JOptionPane.showMessageDialog(null,"id Temporada: " + temporada.getIdTemporada() + "\nEquipos: " + temporada.getSizeEquipos() + "\nFechas: " + temporada.getSizeFechas());
        }
    }
}
