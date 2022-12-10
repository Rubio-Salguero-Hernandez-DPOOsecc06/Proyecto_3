package model;

import java.io.Serializable;

public abstract class Equipo implements Serializable {
    String nombre;

    public Equipo(String _nombre){
        this.nombre = _nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
