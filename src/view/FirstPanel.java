//CLASE COMPLETA
package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

import controller.UserController;

public class FirstPanel extends JPanel implements ActionListener {

	//Parametros
    JButton registro = new JButton();
    JButton inicio = new JButton();
    JButton salir = new JButton();
    UserController controller;

	/**
	 * Constructor del panel de la ventana principal
	 * @param _controller controlador para estalecer conexión con el resto del programa
	 */
    public FirstPanel(UserController _controller){
		
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
		title.setText("Bienvenido/a a Ultimate Soccer Fantasy");
		title.setFont(new Font("MV Boli",Font.BOLD,25));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setPreferredSize(new Dimension(600, 100));
		title.setBackground(Color.white);
		title.setOpaque(true);
		
		//WELCOME IMAGE 1
		BufferedImage backImage = null;
		try {
			backImage = ImageIO.read(new File("FutbolFantasia/InterfaceFiles/SoccerBall.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Image dimg = backImage.getScaledInstance(600, 350, Image.SCALE_SMOOTH);
		ImageIcon dimgRe = new ImageIcon(dimg);
		JLabel picLabel = new JLabel(dimgRe);
		
		//SELECT AN OPTION LABEL
		JLabel selectText = new JLabel();
		selectText.setText("Selecciona una opcion del siguiente menu:");
		selectText.setFont(new Font("MV Boli",Font.PLAIN,25));
		selectText.setPreferredSize(new Dimension(600, 100));
		selectText.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Options Buttons
		JPanel options = new JPanel();
		options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));

		inicio = new JButton(); //Iniciar sesion
		registro = new JButton(); //Registro
		salir = new JButton(); //Salir de la aplicacion
		
		inicio.addActionListener(this);
		registro.addActionListener(this);
		salir.addActionListener(this);
		
		//alignments
		inicio.setAlignmentX(Component.CENTER_ALIGNMENT);
		registro.setAlignmentX(Component.CENTER_ALIGNMENT);
		salir.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Set text
		inicio.setText("Iniciar sesion");
		registro.setText("Registrarse en la plataforma");
		salir.setText("Salir de la aplicacion");
		
		//Set size
		inicio.setMaximumSize(new Dimension(200,50));
		registro.setMaximumSize(new Dimension(200,50));
		salir.setMaximumSize(new Dimension(200,50));
		
		inicio.setPreferredSize(new Dimension(100, 40));
		registro.setPreferredSize(new Dimension(200, 40));
		salir.setPreferredSize(new Dimension(200, 40));
		
		options.add(inicio, BorderLayout.CENTER);
		options.add(Box.createRigidArea(new Dimension(0,10)));
		options.add(registro, BorderLayout.CENTER);
		options.add(Box.createRigidArea(new Dimension(0,10)));
		options.add(salir, BorderLayout.CENTER);
		options.add(Box.createRigidArea(new Dimension(0,35)));
		
		//Credits label
		JLabel credits = new JLabel();
		credits.setText("Aplicacion construida por el Grupo 5 del curso de DPOO. Semestre 2022-20");
		credits.setHorizontalAlignment(SwingConstants.CENTER);
		credits.setFont(new Font("MV Boli",Font.PLAIN,15));
		
		//addition to main panel
		centerPanel.add(title, BorderLayout.NORTH);
		centerPanel.add(selectText, BorderLayout.CENTER);
		centerPanel.add(options, BorderLayout.SOUTH);
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(picLabel, BorderLayout.NORTH);
		this.add(credits, BorderLayout.SOUTH);
		
		this.setVisible(true);  
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == registro){
            removeAll();
			PlayerRegisterPanel register = new PlayerRegisterPanel(controller);
			add(register);
			repaint();
			this.revalidate();
        }
        else if(e.getSource() == inicio){
            removeAll();
            LogInPanels log = new LogInPanels(controller);
            add(log);
			repaint();
			this.revalidate();

        }else if(e.getSource() == salir){
            System.exit(0);
        }
    }
}
