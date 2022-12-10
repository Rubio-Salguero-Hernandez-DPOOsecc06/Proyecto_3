package view;

import java.awt.*;
import javax.swing.*;

import BaseDatos.GuardaDatos;
import controller.PlayerController;
import controller.UserController;
import model.Participante;

import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")

public class PlayerRegisterPanel extends JPanel implements ActionListener{
	
	//Class parameters
	JButton registro;
	JButton atras;
	JButton salir;
	JTextField textUsername;
	JPasswordField textPassword;
	FirstPanel FirstPanel;
	UserController controller;
	
	/**
	 * Constructor del panel donde un participante podra registrarse 
	 * @param _controller
	 */
	public PlayerRegisterPanel(UserController _controller){
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
		title.setText("Registro como Participante del Juego");
		title.setFont(new Font("MV Boli",Font.BOLD,25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setPreferredSize(new Dimension(600, 80));
		title.setBackground(Color.white);
		title.setOpaque(true);
		
		//WELCOME IMAGE 1
		BufferedImage backImage = null;
		try {
			backImage = ImageIO.read(new File("InterfaceFiles/Participante.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Image dimg = backImage.getScaledInstance(600, 360, Image.SCALE_SMOOTH);
		ImageIcon dimgRe = new ImageIcon(dimg);
		JLabel picLabel = new JLabel(dimgRe);
		
		//SELECT AN OPTION LABEL
		JLabel selectText = new JLabel();
		selectText.setText("Por favor ingresa los siguientes datos:");
		selectText.setFont(new Font("MV Boli",Font.PLAIN,25));
		selectText.setPreferredSize(new Dimension(600, 80));
		selectText.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Credentials text spaces

		JPanel options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));

		JPanel vertical = new JPanel();
		vertical.setLayout(new BoxLayout(vertical, BoxLayout.PAGE_AXIS));
		vertical.setPreferredSize(new Dimension(400,200));
		
		JPanel horizontal = new JPanel();
		horizontal.setLayout(new BoxLayout(horizontal, BoxLayout.X_AXIS));
		horizontal.setPreferredSize(new Dimension(10,30));
		
		JPanel horizontal2 = new JPanel();
		horizontal2.setLayout(new BoxLayout(horizontal2, BoxLayout.X_AXIS));
		horizontal2.setPreferredSize(new Dimension(10,30));
		
		registro = new JButton(); //Iniciar sesion
		atras = new JButton(); //Retroceder
		salir = new JButton(); //Salir de la app
		
		registro.addActionListener(this);
		atras.addActionListener(this);
		salir.addActionListener(this);
		
		
		//TEXT BOXES
		JLabel username = new JLabel();
		JLabel password = new JLabel();

		username.setText("Usuario:   ");
		password.setText("Clave:   ");
		
		textUsername = new JTextField();
		textUsername.setMaximumSize(new Dimension(200,35));
		textUsername.setPreferredSize(new Dimension(200,35));
		
		textPassword = new JPasswordField();
		textPassword.setEchoChar('*');
		textPassword.setPreferredSize(new Dimension(200,35));
		textPassword.setMaximumSize(new Dimension(200,35));
		
		horizontal.add(username);
		horizontal.add(textUsername);
		
		horizontal2.add(password);
		horizontal2.add(textPassword);
		
		//alignments
		registro.setAlignmentX(Component.CENTER_ALIGNMENT);
		atras.setAlignmentX(Component.CENTER_ALIGNMENT);
		salir.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Set text
		registro.setText("Registrarse");
		atras.setText("Retroceder");
		salir.setText("Salir de la aplicación");
		
		//Set size
		registro.setMaximumSize(new Dimension(200,30));
		atras.setMaximumSize(new Dimension(200,30));
		salir.setMaximumSize(new Dimension(200,30));

		registro.setPreferredSize(new Dimension(100, 30));
		atras.setPreferredSize(new Dimension(50, 30));
		salir.setPreferredSize(new Dimension(50, 30));
	
		
		options.add(horizontal); //Addition of X BoxLayout to Y BoxLayout
		options.add(Box.createRigidArea(new Dimension(0,10)));
		
		options.add(horizontal2);
		options.add(Box.createRigidArea(new Dimension(0,30)));

		vertical.add(registro);
		vertical.add(Box.createRigidArea(new Dimension(0,10)));

		vertical.add(atras);
		vertical.add(Box.createRigidArea(new Dimension(0,10)));

		vertical.add(salir);
		vertical.add(Box.createRigidArea(new Dimension(0,10)));
		
		options.add(vertical);
		
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
		if(e.getSource() == registro){

			String username = textUsername.getText();
			char[] encripted = textPassword.getPassword();
			String password = String.valueOf(encripted);
			boolean registrado = controller.registrarUsuario(username, password);
			if(registrado){
				Participante participante = controller.iniciarSesionParticipante(username, password);
				GuardaDatos baseDatos = controller.getBaseDatos();
				PlayerController playerController = controller.crearPlayerController(participante);
				new PlayerAppFrame(playerController, baseDatos, participante);
			}else{
				JOptionPane.showMessageDialog(null, "usuario no disponible");
			}
			

		}else if(e.getSource() == atras){
			removeAll();
			FirstPanel panel = new FirstPanel(controller);
			add(panel);
			repaint();
			this.revalidate();

		}else if(e.getSource() == salir){
			System.exit(0);
		}
	}

}

