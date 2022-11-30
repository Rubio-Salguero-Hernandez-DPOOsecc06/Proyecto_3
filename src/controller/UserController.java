package controller;

import BaseDatos.GuardaDatos;
import model.Administrador;
import model.Participante;
import view.InterfazUsuario;

public class UserController{

    private InterfazUsuario view;
    private GuardaDatos baseDatos;
    private Administrador administrador = new Administrador("admin", "admin");
    private final String nombreAdmin = administrador.getNombre();
    private final String claveAdmin = administrador.getClave();

    /**
     * Constructor del controlador de usuario
     * @param _view Vista asociada a este controlador
     */
    public UserController(InterfazUsuario _view, GuardaDatos _baseDatos){
        this.view = _view;
        this.baseDatos = _baseDatos;
    }

    /**
     * Registra a un usuario en la plataforma
     * @param _nombre nombre de usuario ingresado
     * @param _clave clave asociada al usuario
     * @return true si se pudo registrar, false si no
     */
    public boolean registrarUsuario(String _nombre, String _clave){

        Participante participante = new Participante(_nombre, _clave);
        boolean disponible = baseDatos.guardarParticipante(participante, administrador.getNombre());
        if(!disponible){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Revisa que el nombre y clave ingresados concuerden con los del administrador
     * @param _nombre nombre ingresado
     * @param _clave clave ingresada
     * @return true si coinciden, false si no coinciden
     */
    public boolean iniciarSesionAdmin(String _nombre, String _clave){
        if(nombreAdmin.equals(_nombre) && claveAdmin.equals(_clave)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Recupera a un jugador registrado de la base de datos
     * @param _nombre nombre de usuario que se ingreso 
     * @param _clave clave que se ingreso
     * @return el participante
     */
    public Participante iniciarSesionParticipante(String _nombre, String _clave){
        Participante participante = baseDatos.recuperarparticipante(_nombre, _clave);
        return participante;
    }
    /**
     * Inicia la vista de la interfaz
     */
    public void iniciarVista(){;
        view.iniciarVista(this);
    }

    public AdminController crearAdminController(){
        return new AdminController(baseDatos);
    }

    public PlayerController crearPlayerController(Participante _participante){
        return new PlayerController(baseDatos, _participante);
    }

    public GuardaDatos getBaseDatos() {
        return baseDatos;
    }


}
