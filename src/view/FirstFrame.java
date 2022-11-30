// CLASE COMPLETA
package view;
import java.awt.*;
import javax.swing.*;
import controller.UserController;
@SuppressWarnings("serial")

public class FirstFrame extends JFrame{
	//Class atributes

	
	/**
	 * Constructor de la ventana principal de la aplicación
	 * @param _controller controlador de usuario 
	 */
	public FirstFrame(UserController _controller){
		this.setTitle("Ultimate Soccer Fantasy"); //set title
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true); 
		this.setSize(600,800); //set size
		this.setLocationRelativeTo(null);
		
		//Icon image change
		ImageIcon icon = new ImageIcon("InterfaceFiles/AppIcon.png");
		this.setIconImage(icon.getImage());
		this.getContentPane().setBackground(new Color(230,230,230));

		//addition of First Panel Class
		FirstPanel firstPanel = new FirstPanel(_controller);
		this.add(firstPanel, BorderLayout.NORTH);
		this.setVisible(true); //Set visibility
	}
}
