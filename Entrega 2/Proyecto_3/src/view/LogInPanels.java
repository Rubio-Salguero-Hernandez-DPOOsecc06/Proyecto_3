package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import controller.AdminController;
import controller.PlayerController;
import controller.UserController;
@SuppressWarnings("serial")

public class LogInPanels extends JPanel implements ActionListener{
	
	//Class parameters
	JButton participante;
	JButton administrador;
	JButton atras;
	JButton salir;
	JPanel PlayerLogInPanel;
	JPanel AdminLogInPanel;
	JPanel FirstPanel;
    UserController controller;
	AdminController adminController;
	PlayerController playerController;
	
	/**
	 * Crea una instancia del panel donde se escoge que clase de inicio de sesión se desea
	 * @param _controller controlador asociado a la vista 
	 */
	public LogInPanels(UserController _controller) {
		
		this.controller = _controller;
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		this.setSize(500,500);    //Frame is 600x600
		this.setBounds(200, 200, 200, 200);
		
		//Subpanel to add centered elements
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		
		
		//addition of panel contents
		
		//TITLE 1
		JLabel title = new JLabel();
		title.setText("Inicio de Sesión en la Plataforma");
		title.setFont(new Font("MV Boli",Font.BOLD,25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setPreferredSize(new Dimension(600, 80));
		title.setBackground(Color.white);
		title.setOpaque(true);
		
		//WELCOME IMAGE 1
		BufferedImage backImage = null;
		try {
			backImage = ImageIO.read(new File("InterfaceFiles/SoccerBall.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Image dimg = backImage.getScaledInstance(600, 350,
		        Image.SCALE_SMOOTH);
		
		ImageIcon dimgRe = new ImageIcon(dimg);
		
		JLabel picLabel = new JLabel(dimgRe);
		
		//SELECT AN OPTION LABEL
		
		JLabel selectText = new JLabel();
		selectText.setText("Selecciona una opcion:");
		selectText.setFont(new Font("MV Boli",Font.PLAIN,25));
		selectText.setPreferredSize(new Dimension(600, 80));
		selectText.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Options Buttons

		JPanel options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));
		options.setPreferredSize(new Dimension(400, 200));

		
		participante = new JButton(); //Como Participante
		administrador = new JButton(); //Como Admin
		atras = new JButton(); //Retroceder
		salir = new JButton(); //Salir de la app
		
		participante.addActionListener(this);
		administrador.addActionListener(this);
		atras.addActionListener(this);
		salir.addActionListener(this);
		
		//alignments
		participante.setAlignmentX(Component.CENTER_ALIGNMENT);
		administrador.setAlignmentX(Component.CENTER_ALIGNMENT);
		atras.setAlignmentX(Component.CENTER_ALIGNMENT);
		salir.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Set text
		participante.setText("Como Participante");
		administrador.setText("Como Administrador");
		atras.setText("Retroceder");
		salir.setText("Salir de la aplicacion");
		
		//Set size
		participante.setMaximumSize(new Dimension(200,50));
		administrador.setMaximumSize(new Dimension(200,50));
		atras.setMaximumSize(new Dimension(200,50));
		salir.setMaximumSize(new Dimension(200,50));
		
		participante.setPreferredSize(new Dimension(200, 40));
		administrador.setPreferredSize(new Dimension(200, 40));
		atras.setPreferredSize(new Dimension(200, 40));
		salir.setMaximumSize(new Dimension(200,50));
		
		

		options.add(participante);
		options.add(Box.createRigidArea(new Dimension(0,10)));
		options.add(administrador);
		options.add(Box.createRigidArea(new Dimension(0,10)));
		options.add(atras);
		options.add(Box.createRigidArea(new Dimension(0,10)));
		options.add(salir);
		options.add(Box.createRigidArea(new Dimension(0,10)));
		
		
		//addition to main panel
		centerPanel.add(title, BorderLayout.NORTH);
		centerPanel.add(selectText, BorderLayout.CENTER);
		centerPanel.add(options, BorderLayout.SOUTH);
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(picLabel, BorderLayout.NORTH);
		
		this.setVisible(true);
	}

	//Actions performed in this Panel
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==participante) {
			
			//instance of Log in Panels
			this.PlayerLogInPanel = new PlayerLogInPanel(controller);
			JPanel panelName = this.PlayerLogInPanel;
			
			this.removeAll();
			this.add(panelName);
			this.repaint();
			this.revalidate();
			
		}else if(e.getSource()==administrador) {
			
			//instance of Log in Panels

			this.AdminLogInPanel = new AdminLogInPanel(controller);
			JPanel panelName = this.AdminLogInPanel;
			
			this.removeAll();
			this.add(panelName);
			this.repaint();
			this.revalidate();
		}else if(e.getSource()==atras) {
			
			//instance of Log in Panels
			this.FirstPanel = new FirstPanel(controller);
			JPanel panelName = this.FirstPanel;
			this.removeAll();
			this.add(panelName);
			this.repaint();
			this.revalidate();

		}else if(e.getSource()==salir) {
			System.exit(0);
		}
	}
}
