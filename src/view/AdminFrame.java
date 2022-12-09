package view;

import javax.swing.*;

import BaseDatos.GuardaDatos;
import controller.AdminController;

import java.awt.*;
public class AdminFrame extends JFrame {
    AdminPanel panel;

    public AdminFrame(AdminController _adminController, GuardaDatos _baseDatos){
		this.setTitle("Ultimate Soccer Fantasy - ADMIN"); //set title
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(600,800); //set size
		this.setLocationRelativeTo(null);
		
		ImageIcon icon = new ImageIcon("InterfaceFiles/AppIcon.png");
		this.setIconImage(icon.getImage());
		
        panel = new AdminPanel(_adminController, _baseDatos);
        add(panel);
        setVisible(true);
    }
}
