package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import BaseDatos.GuardaDatos;
import controller.PlayerController;
import model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayerAppPanel extends JPanel implements ActionListener {
    
    PlayerController playerController;
    GuardaDatos baseDatos;
    Participante participante;
    JButton crearEquipo = new JButton("Crear Equipo");
    JButton verEquipo = new JButton("Ver equipo");
    JButton eliminarEquipo = new JButton("Eliminar Equipo");
    JButton verEstadisticas = new JButton("ver estadistica");
    JButton salir = new JButton("Salir de la aplicacion");
    JLabel bienvenidaJugador = new JLabel("Bienvenido a Ultimate Soccer Fantasy");
    JLabel seleccionTexto = new JLabel("Por favor elije una de las siguientes opciones:");
    JComboBox equipos;
    
	//WELCOME IMAGE 1
	BufferedImage backImage = null;
	
	

    public PlayerAppPanel(PlayerController _playerController, GuardaDatos _baseDatos, Participante _participante){
        this.baseDatos = _baseDatos;
        this.playerController = _playerController;
        this.participante = _participante;
        
        setLayout(new BorderLayout());
        this.playerController = _playerController;
        this.baseDatos = _baseDatos;
        this.participante = _participante;
        
    	try {
    		backImage = ImageIO.read(new File("InterfaceFiles/Participante.jpg"));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
		JPanel vertical = new JPanel();
		vertical.setLayout(new BoxLayout(vertical, BoxLayout.Y_AXIS));
		vertical.setPreferredSize(new Dimension(600,500));
    	
		JPanel vertical2 = new JPanel();
		vertical2.setLayout(new BoxLayout(vertical2, BoxLayout.Y_AXIS));
		
    	
    	Image dimg = backImage.getScaledInstance(600, 360,
    	        Image.SCALE_SMOOTH);
    	
    	ImageIcon dimgRe = new ImageIcon(dimg);
    	
    	JLabel picLabel = new JLabel(dimgRe);
    	
    	//Config textos
    	
		bienvenidaJugador.setFont(new Font("MV Boli",Font.BOLD,25));
		bienvenidaJugador.setPreferredSize(new Dimension(600, 30));
		bienvenidaJugador.setHorizontalAlignment(SwingConstants.CENTER);
		
		seleccionTexto.setFont(new Font("MV Boli",Font.PLAIN,20));
		seleccionTexto.setPreferredSize(new Dimension(600, 20));
		seleccionTexto.setHorizontalAlignment(SwingConstants.CENTER);
    	
    	//Tamanos botones
    	
    	crearEquipo.setAlignmentX(Component.CENTER_ALIGNMENT);
		verEquipo.setAlignmentX(Component.CENTER_ALIGNMENT);
		eliminarEquipo.setAlignmentX(Component.CENTER_ALIGNMENT);
		verEstadisticas.setAlignmentX(Component.CENTER_ALIGNMENT);
		salir.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Set size
    	crearEquipo.setMaximumSize(new Dimension(200,50));
		verEquipo.setMaximumSize(new Dimension(200,50));
		eliminarEquipo.setMaximumSize(new Dimension(200,50));
		verEstadisticas.setMaximumSize(new Dimension(200,50));
		salir.setMaximumSize(new Dimension(200,50));
		
    	crearEquipo.setPreferredSize(new Dimension(100, 50));
		verEquipo.setPreferredSize(new Dimension(100, 50));
		eliminarEquipo.setPreferredSize(new Dimension(100, 50));
		verEstadisticas.setPreferredSize(new Dimension(100, 50));
		salir.setPreferredSize(new Dimension(100, 50));
    	
        crearEquipo.addActionListener(this);
        verEquipo.addActionListener(this);
        eliminarEquipo.addActionListener(this);
        verEstadisticas.addActionListener(this);
        salir.addActionListener(this);
        
        
        //addition to vertical2
        vertical2.add(bienvenidaJugador);
        vertical2.add(picLabel);
        vertical2.add(Box.createRigidArea(new Dimension(0,10)));
        vertical2.add(seleccionTexto);
        
        add(vertical2, BorderLayout.NORTH);
        vertical.add(Box.createRigidArea(new Dimension(0,10)));
        vertical.add(crearEquipo);
        vertical.add(Box.createRigidArea(new Dimension(0,10)));
        vertical.add(verEquipo);
        vertical.add(Box.createRigidArea(new Dimension(0,10)));
        vertical.add(eliminarEquipo);
        vertical.add(Box.createRigidArea(new Dimension(0,10)));
        vertical.add(verEstadisticas);
        vertical.add(Box.createRigidArea(new Dimension(0,10)));
        vertical.add(salir);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(vertical, BorderLayout.CENTER);
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
