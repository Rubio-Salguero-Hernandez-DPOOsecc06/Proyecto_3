package model;

import java.io.Serializable;

public abstract class Usuario implements Serializable {

    private String nombre, clave;

    public Usuario(String _nombre, String _clave){
        this.nombre = _nombre;
        this.clave = _clave;
    }

    /**
     * Retorna el nombre de usuario del objeto
     * @return nombre del usuario
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Retorna la clave asociada al nombre de usuario del objeto
     * @return clave asociada a nombre
     */
    public String getClave(){
        return clave;
    }
}
