package model;

public class JugadorFantasia extends JugadorReal{

    int puntosAcumulados;

    public JugadorFantasia(JugadorReal _jugador){

        super(_jugador.getNombre(), _jugador.getEquipo(), _jugador.getPrecio());
        posicion = _jugador.getPosicion();
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void agregarPuntos(int _puntos){ }


}
