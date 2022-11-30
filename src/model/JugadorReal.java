package model;

public class JugadorReal extends Jugador {
    
    private EquipoReal equipo;
    
    public JugadorReal (String _nombre, EquipoReal _equipo, Double _precio){
        super(_nombre, _precio);
        this.equipo = _equipo;
    }

    /**
     * Retorna el equipo al que pertenece el jugador
     * @return equipo del jugador
     */
    public EquipoReal getEquipo() {
        return equipo;
    }
}
