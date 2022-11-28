package view;

import java.awt.BorderLayout;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import controller.LectorArchivos;
import model.TemporadaReal;

@SuppressWarnings("serial")

public class AdminAppPanel extends JPanel implements ActionListener{
	
	//Atributes
	JButton crear;
	JButton subir;
	JButton atras;
	JButton salir;
	JButton inputButton;
	FirstFrame FirstFrame;
	
	JTextField inputField;
	JTextArea textArea;
	LectorArchivos LECTOR;
	TemporadaReal nuevaTemporadaReal;
    LectorArchivos lector = new LectorArchivos();
	
	Integer paso = 0; //Numero de paso en el que el programa se encuentra, usado para que funcionen las acciones de los botones.
	
	//Panel Definition
	
	public AdminAppPanel() {
		
	//Layout
	this.setLayout(new GridBagLayout());
	
	//Elements of the Layout
	
	GridBagConstraints constraints = new GridBagConstraints();
	
	
	//#1: Panel with Image and Label with Type of user
	JPanel rightPanel = new JPanel();
	constraints.gridx = 4;
	constraints.gridy = 1;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	
	
	rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
	
	
		//Addition of image to rightPanel
	BufferedImage backImage = null;
	try {
		backImage = ImageIO.read(new File("FutbolFantasia/InterfaceFiles/Admin.jpg"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	Image dimg = backImage.getScaledInstance(400, 250,
	        Image.SCALE_SMOOTH);
	
	ImageIcon dimgRe = new ImageIcon(dimg);
	
	JLabel picLabel = new JLabel(dimgRe);	
	
	rightPanel.add(picLabel); //Here
	
		//Addition of text to rightPanel
	
	JLabel userLabel = new JLabel();
	userLabel.setText("Tipo de Usuario: ADMINISTRADOR");
	userLabel.setFont(new Font("MV Boli",Font.BOLD,18));
	userLabel.setHorizontalAlignment(SwingConstants.CENTER);
	rightPanel.add(userLabel);

	this.add(rightPanel, constraints);
	
	
	//Option buttons for admin
	JPanel buttonPanel = new JPanel();
	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
	constraints.gridx = 4;
	constraints.gridy = 2;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	
	crear = new JButton();
	crear.setText("Crear nueva temporda");
	
	subir = new JButton();
	subir.setText("Subir un resultado real");
	
	atras = new JButton();
	atras.setText("Volver al menu principal");
	
	salir = new JButton();
	salir.setText("Salir de la aplicacion");
	
		//Action listeners
	crear.addActionListener(this);
	subir.addActionListener(this);
	atras.addActionListener(this);
	salir.addActionListener(this);
	
		//Set size
	crear.setMaximumSize(new Dimension(200,50));
	subir.setMaximumSize(new Dimension(200,50));
	atras.setMaximumSize(new Dimension(200,50));
	salir.setMaximumSize(new Dimension(200,50));
	
	crear.setPreferredSize(new Dimension(100, 40));
	subir.setPreferredSize(new Dimension(200, 40));
	atras.setPreferredSize(new Dimension(100, 40));
	salir.setPreferredSize(new Dimension(200, 40));
	
		//JLabel for options
	
	JLabel optionsLabel = new JLabel();
	optionsLabel.setText("Menu de Administrador");
	optionsLabel.setFont(new Font("MV Boli",Font.PLAIN,20));
	optionsLabel.setHorizontalAlignment(SwingConstants.CENTER);

		//addition to BoxLayout
	buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
	buttonPanel.add(optionsLabel);
	buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
	buttonPanel.add(crear);
	buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
	buttonPanel.add(subir);
	buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
	buttonPanel.add(atras);
	buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
	buttonPanel.add(salir);
	buttonPanel.add(Box.createRigidArea(new Dimension(0,10)));
	
		//addition of constraints
	
	this.add(buttonPanel, constraints);
	
	
	//Addition of Title for menu
	JLabel title = new JLabel();
	title.setText("Bienvenido/a a Ultimate Soccer Fantasy, ¡vamos a jugar!");
	title.setFont(new Font("MV Boli",Font.BOLD,30));
	
	constraints.gridx = 0;
	constraints.gridy = 0;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	
	this.add(title, constraints);	
	//Escribe aqui JLabel
	
	JLabel writeHere = new JLabel();
	writeHere.setText("Escribe aqui:");
	writeHere.setFont(new Font("MV Boli",Font.BOLD,15));
	writeHere.setHorizontalAlignment(SwingConstants.CENTER);
	
	constraints.gridx = 0;
	constraints.gridy = 3;
	constraints.gridwidth = 2;
	constraints.gridheight = 1;

	this.add(writeHere, constraints);
	
	
	//Text field where user input goes
	JPanel inputZone = new JPanel();
	inputZone.setLayout(new FlowLayout());
	
	constraints.gridx = 0;
	constraints.gridy = 4;
	constraints.gridwidth = 1;
	constraints.gridheight = 2;
	constraints.weightx = 1.0;
	
	this.inputField = new JTextField();
	inputField.setPreferredSize(new Dimension(600, 40));
	inputField.setFont(new Font("MV Boli",Font.PLAIN,25));
	inputField.setBackground(Color.white);
	inputField.setForeground(Color.black);
	
	this.inputButton = new JButton();
	inputButton.setText("Enviar");
	inputButton.addActionListener(this);
	
	inputZone.add(inputField);
	inputZone.add(inputButton);
	
	this.add(inputZone, constraints);
	
	constraints.weightx = 0;
	
	}
	
	//Metodo para leer inputs
		

	@Override
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == salir){
            System.exit(0);
        }else if(e.getSource() == atras){

        }else if(e.getSource() == subir){

        }else if(e.getSource() == crear){
            String nombreEquipos;
            JOptionPane.showMessageDialog(null, "Ingresa el nombre del archivo de los equipos y pulsa enviar");
            if(e.getSource() == inputButton){
                nombreEquipos = textArea.getText();
            }
            JOptionPane.showMessageDialog(null, "Ingresa el nombre del archivo de los equipos y pulsa enviar");
        }
    }
	

} //cerrar clase
