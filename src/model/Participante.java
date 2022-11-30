package model;

import java.util.ArrayList;
public class Participante extends Usuario {
    ArrayList<EquipoFantasia> equipos = new ArrayList<>();

    /**
     * Constructor de un partiicipante
     * @param _nombre
     * @param _clave
     */
    public Participante(String _nombre, String _clave){
        super(_nombre, _clave);
    }

    public ArrayList<EquipoFantasia> getEquipos() {
        return equipos;
    }

    public void comprarJugador(){
    }

    public void venderJugador(){ }


    public EquipoFantasia crearEquipoFantasia(String _nombre){ 
        EquipoFantasia equipo = new EquipoFantasia(_nombre);
        for(EquipoFantasia equipoFantasia: equipos){
            if(equipoFantasia.getNombre().equals(_nombre)){
                return null;
            }
        }
        equipos.add(equipo);
        return equipo;
    }

    public void eliminarEquipoFantasia(String _nombre){
        EquipoFantasia equipo = buscarEquipoPorNombre(_nombre);
        if(equipo != null){
            equipos.remove(equipo);
        }
    }

    public EquipoFantasia buscarEquipoPorNombre(String _nombre){
        for(EquipoFantasia equipo: equipos){
            if(equipo.getNombre().equals(_nombre)){
                return equipo;
            }
        }
        return null;
    }
}
