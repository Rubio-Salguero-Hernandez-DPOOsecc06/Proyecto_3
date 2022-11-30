package view;

import javax.swing.*;

import BaseDatos.GuardaDatos;
import controller.PlayerController;
import model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerAppPanel extends JPanel implements ActionListener {
    
    PlayerController playerController;
    GuardaDatos baseDatos;
    Participante participante;
    JButton crearEquipo = new JButton("Crear Equipo");
    JButton verEquipo = new JButton("Ver equipo");
    JButton eliminarEquipo = new JButton("Eliminar Equipo");
    JButton verEstadisticas = new JButton("ver estadistica");
    JButton salir = new JButton("Salir de la aplicacion");
    JComboBox equipos;

    public PlayerAppPanel(PlayerController _playerController, GuardaDatos _baseDatos, Participante _participante){
        this.baseDatos = _baseDatos;
        this.playerController = _playerController;
        this.participante = _participante;
        setLayout(new GridLayout(5,1));
        this.playerController = _playerController;
        this.baseDatos = _baseDatos;
        this.participante = _participante;
        add(crearEquipo);
        add(verEquipo);
        add(eliminarEquipo);
        add(verEstadisticas);
        add(salir);
        crearEquipo.addActionListener(this);
        verEquipo.addActionListener(this);
        eliminarEquipo.addActionListener(this);
        verEstadisticas.addActionListener(this);
        salir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == crearEquipo){
            // BUG si se intenta crear un equipo con el mismo nombre de otro que ya se tiene y se da cancelar se rompe el programa
            String nombre = JOptionPane.showInputDialog("Ingresa el nombre de tu equipo");
            EquipoFantasia equipo = playerController.crearEquipoFantasia(nombre);
            while(equipo == null){
                nombre = JOptionPane.showInputDialog("Ya tienes un equipo con ese nombre\nIntenta con otro");
                equipo = playerController.crearEquipoFantasia(nombre);
            }
            JOptionPane.showMessageDialog(null, "Equipo: " + equipo.getNombre() + " creado");
            playerController.guardarCambios();

        }else if(e.getSource() == verEquipo){
            // si no hay equipos no funciona
            String[] nombres = playerController.getNombresEquipos();
            String nombre = (String)JOptionPane.showInputDialog(null, "Cual deseas ver", "Ver Equipo", JOptionPane.DEFAULT_OPTION, null, nombres, nombres[0]);
            
        }else if(e.getSource() == eliminarEquipo){
            // Si no hay equipos no funciona
            String[] nombres = playerController.getNombresEquipos();
            String nombre = (String)JOptionPane.showInputDialog(null, "Cual deseas quitar", "Eliminar Equipo", JOptionPane.DEFAULT_OPTION, null, nombres, nombres[0]);
            playerController.eliminarEquipo(nombre);

        }else if(e.getSource() == verEstadisticas){
            
        }else if(e.getSource() == salir){
            playerController.guardarCambios();
            System.exit(0);
        }
        
    }
}
