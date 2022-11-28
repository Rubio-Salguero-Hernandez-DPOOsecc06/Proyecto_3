package model;

public abstract class Equipo {
    String nombre;

    public Equipo(String _nombre){
        this.nombre = _nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
