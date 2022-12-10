package model;

import java.io.Serializable;
import java.util.ArrayList;

public class FechaReal implements Serializable {
    int idFecha;
    ArrayList<PartidoReal> partidosFecha = new ArrayList<>();

    public FechaReal(int _id){
        this.idFecha = _id;
    }

    public int getIdFecha() {
        return idFecha;
    }

    public PartidoReal crearPartido(EquipoReal _local, EquipoReal _visitante, String _dia, String _hora){
        return new PartidoReal(_local, _visitante, _dia, _hora);
    }

    public void agregarPartido(PartidoReal _partido){
        this.partidosFecha.add(_partido);
    }
}
