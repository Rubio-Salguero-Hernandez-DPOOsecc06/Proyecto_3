package view;
import javax.swing.*;

import BaseDatos.GuardaDatos;
import controller.PlayerController;
import model.Participante;

import java.awt.Color;


@SuppressWarnings("serial")

public class PlayerAppFrame extends JFrame{

	//Class atributes
	PlayerAppPanel playerAppPanel;
	
	public PlayerAppFrame(PlayerController _controller, GuardaDatos _baseDatos, Participante _participante) {
		this.setTitle("Ultimate Soccer Fantasy - Participante"); //set title
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(600,800); //set size
		this.setLocationRelativeTo(null);
		
		ImageIcon icon = new ImageIcon("InterfaceFiles/AppIcon.png");
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(new Color(230,230,230));
		
		//addition of Admin App Panel Class
		
		playerAppPanel = new PlayerAppPanel(_controller, _baseDatos, _participante);
		this.add(playerAppPanel);
		
		this.setVisible(true); //Set visibility
	}
	
	
}
