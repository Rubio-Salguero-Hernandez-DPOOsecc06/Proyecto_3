package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import BaseDatos.GuardaDatos;
import controller.AdminController;
import model.TemporadaReal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AdminPanel extends JPanel implements ActionListener{
    JButton crear = new JButton("Crear temporada");
    JButton cargar = new JButton("Cargar resultado");
    JButton salir = new JButton("Salir de la aplicación");
    AdminController adminController;
    GuardaDatos baseDatos;
    
    
    JLabel bienvenidaAdmin = new JLabel("Bienvenido/a administrador/a");
    JLabel seleccionTexto  = new JLabel("Selecciona una de las siguientes opciones");
    
	//WELCOME IMAGE 1
	BufferedImage backImage = null;

    public AdminPanel(AdminController _AdminController, GuardaDatos _baseDatos){
        this.adminController = _AdminController;
        this.baseDatos = _baseDatos;
        setLayout(new BorderLayout());

        /////////////////////////////////////
        
    	try {
    		backImage = ImageIO.read(new File("InterfaceFiles/referee2.png"));
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
    	
		bienvenidaAdmin.setFont(new Font("MV Boli",Font.BOLD,25));
		bienvenidaAdmin.setPreferredSize(new Dimension(600, 50));
		bienvenidaAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		
		seleccionTexto.setFont(new Font("MV Boli",Font.PLAIN,20));
		seleccionTexto.setPreferredSize(new Dimension(600, 30));
		seleccionTexto.setHorizontalAlignment(SwingConstants.CENTER);
    	
    	//Tamanos botones
    	
    	crear.setAlignmentX(Component.CENTER_ALIGNMENT);
		cargar.setAlignmentX(Component.CENTER_ALIGNMENT);
		salir.setAlignmentX(Component.CENTER_ALIGNMENT);

		
		//Set size
    	crear.setMaximumSize(new Dimension(200,50));
		cargar.setMaximumSize(new Dimension(200,50));
		salir.setMaximumSize(new Dimension(200,50));
		
    	crear.setPreferredSize(new Dimension(100, 50));
		cargar.setPreferredSize(new Dimension(100, 50));
		salir.setPreferredSize(new Dimension(100, 50));
    	
        crear.addActionListener(this);
        cargar.addActionListener(this);
        salir.addActionListener(this);
        
        
        //addition to vertical2
        vertical2.add(bienvenidaAdmin);
        vertical2.add(picLabel);
        vertical2.add(Box.createRigidArea(new Dimension(0,10)));
        vertical2.add(seleccionTexto);
        
        add(vertical2, BorderLayout.NORTH);
        vertical.add(Box.createRigidArea(new Dimension(0,10)));
        vertical.add(crear);
        vertical.add(Box.createRigidArea(new Dimension(0,10)));
        vertical.add(cargar);
        vertical.add(Box.createRigidArea(new Dimension(0,10)));
        vertical.add(salir);
        add(Box.createRigidArea(new Dimension(0,10)));
        add(vertical, BorderLayout.CENTER);
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
