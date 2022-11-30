package view;

import javax.swing.*;

import BaseDatos.GuardaDatos;
import controller.AdminController;

import java.awt.*;
public class AdminFrame extends JFrame {
    AdminPanel panel;

    public AdminFrame(AdminController _adminController, GuardaDatos _baseDatos){
        setSize(400,500);
        setLayout(new GridLayout(1,1));
        panel = new AdminPanel(_adminController, _baseDatos);
        add(panel);
        setVisible(true);
    }
}
