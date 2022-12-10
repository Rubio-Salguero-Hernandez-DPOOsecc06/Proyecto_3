package model;

import java.io.Serializable;

public class PartidoReal implements Serializable {
    EquipoReal local, visitante;
    String dia, hora;

    public PartidoReal(EquipoReal _local, EquipoReal _visitante, String _dia, String _hora){
        this.local = _local;
        this.visitante = _visitante;
        this.dia = _dia;
        this.hora = _hora;
    }
}
