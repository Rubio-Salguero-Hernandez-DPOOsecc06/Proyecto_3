package model;

import java.io.Serializable;

public abstract class Temporada implements Serializable{
    private int idTemporada;

    public Temporada(){
    }

    public int getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(int _idTemporada) {
        this.idTemporada = _idTemporada;
    }
}
