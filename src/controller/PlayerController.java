package controller;

import java.util.ArrayList;

import BaseDatos.GuardaDatos;
import model.EquipoFantasia;
import model.Participante;
import model.TemporadaReal;

public class PlayerController implements RecuperarTemporada {
    
    GuardaDatos baseDatos;
    Participante participante;

    public PlayerController(GuardaDatos _baseDatos, Participante _participante){
        this.baseDatos = _baseDatos;
        this.participante = _participante;
    }

    public EquipoFantasia crearEquipoFantasia(String _nombre){
        EquipoFantasia nuevoEquipo = participante.crearEquipoFantasia(_nombre);
        return nuevoEquipo;
    }

    public void guardarCambios(){
        baseDatos.guardarCambiosParticipante(participante);
    }

    public String[] getNombresEquipos() {
        ArrayList<EquipoFantasia> equipos = participante.getEquipos();
        ArrayList<String> nombresEquipos = new ArrayList<>();
        for(EquipoFantasia equipo: equipos){
            nombresEquipos.add(equipo.getNombre());
        }
        String[] nombres = nombresEquipos.toArray(new String[0]);
        return nombres;
    }

    public void eliminarEquipo(String _nombre){
        participante.eliminarEquipoFantasia(_nombre);
    }

    @Override
    public TemporadaReal recuperarTemporada() {
        TemporadaReal temporada = baseDatos.recuperarTemporadas();
        return temporada;
    }

    public void comprarJugador(){
        
    }
}
