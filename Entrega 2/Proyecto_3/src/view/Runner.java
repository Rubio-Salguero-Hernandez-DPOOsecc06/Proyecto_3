package view;

import BaseDatos.GuardaDatos;
import controller.UserController;

public class Runner {
    public static void main(String[] args) {
        InterfazUsuario view = new InterfazUsuario();
        GuardaDatos baseDatos = new GuardaDatos();
        UserController controller = new UserController(view, baseDatos);
        controller.iniciarVista();
        
    }
}
