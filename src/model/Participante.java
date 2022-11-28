package model;

import java.util.ArrayList;
public class Participante extends Usuario {
   private double presupuesto = 15000.0;
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

    public double getPresupuesto() {
        return presupuesto;
    }

    public void efectuarCompra(double _pago){
        presupuesto -= _pago;
    }

    public boolean verificarPresupuesto(double _precio){
        if(_precio <= presupuesto){
            return true;
        }else{
            return false;
        }
    }

    public JugadorFantasia comprarJugador(JugadorReal _jugador){
        double precio = _jugador.getPrecio();
        boolean disponible = verificarPresupuesto(precio);
        if(disponible){
            JugadorFantasia nuevoJugador = new JugadorFantasia(_jugador);
            return nuevoJugador;
        }else{
            return null;
        }
    }

    public void venderJugador(){ }

    public void crearEquipoFantasia(String _nombre){ 
        EquipoFantasia equipo = new EquipoFantasia(_nombre);
        equipos.add(equipo);
    }
}
