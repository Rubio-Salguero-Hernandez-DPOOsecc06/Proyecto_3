package model;

public class Administrador extends Usuario {

    /**
     * Constructor de un administrador
     * @param _nombre
     * @param _clave
     */
    public Administrador(String _nombre, String _clave){
        super(_nombre, _clave);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public String getClave(){
        return super.getClave();
    }
    
}
