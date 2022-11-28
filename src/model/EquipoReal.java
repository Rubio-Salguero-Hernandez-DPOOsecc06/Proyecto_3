package model;

import java.util.ArrayList;

public class EquipoReal extends Equipo {
    
    ArrayList<JugadorReal> jugadoresEquipo = new ArrayList<>();

    public EquipoReal(String _nombre){
        super(_nombre);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    public void agregarJugador(JugadorReal _jugador){
        jugadoresEquipo.add(_jugador);
    }

    public int getPlayerSize(){
        return jugadoresEquipo.size();
    }

    public JugadorReal buscarJugadorPorNombre(String _nombre){
        int i = 0;
        while(i < getPlayerSize()){
            JugadorReal jugador = jugadoresEquipo.get(i);
            String nombreJugador = jugador.getNombre();
            if(nombreJugador.equals(_nombre)){
                return jugador;
            }
            i += 1;
        }
        return null;
    }

    public ArrayList<JugadorReal> buscarJugadoresPorPosicion(Posicion _posicion){
        ArrayList<JugadorReal> jugadores = new ArrayList<>();
        for (int i = 0; i < getPlayerSize(); i++) {
            JugadorReal jugador = jugadoresEquipo.get(i);
            Posicion posicionJugador = jugador.getPosicion();
            if(posicionJugador.equals(_posicion)){
                jugadores.add(jugador);
            }
        }
        return jugadores;
    }
}
