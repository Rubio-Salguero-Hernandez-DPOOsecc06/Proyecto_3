//CLASE COMPLETA
package view;
import controller.UserController;

public class InterfazUsuario {
    
    /**
     * Inicia la conexión con la vista creando la primera ventana
     * @param _controller controlador de usuario
     */
    public void iniciarVista(UserController _controller){
        FirstFrame ventana = new FirstFrame(_controller);
        ventana.setVisible(true);
    }
}
