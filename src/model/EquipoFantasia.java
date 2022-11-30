package model;

public class EquipoFantasia extends Equipo {
    private double presupuesto = 15000.0;
    public EquipoFantasia(String _nombre){
        super(_nombre);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    
}
