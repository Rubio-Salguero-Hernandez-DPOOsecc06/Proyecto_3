package model;

import java.util.ArrayList;

public class TemporadaReal extends Temporada{

    ArrayList<EquipoReal> equiposTemporada = new ArrayList<>();
    ArrayList<FechaReal> fechasTemporada = new ArrayList<>();
    
    public TemporadaReal(){
    }

    @Override
    public int getIdTemporada() {
        return super.getIdTemporada();
    }

    @Override
    public void setIdTemporada(int _idTemporada) {
        super.setIdTemporada(_idTemporada);
    }

    /**
     * Agrega un equipo real a la lista de equipos
     * @param _equipo equipos a ser agregado
     */
    public void addEquipo(EquipoReal _equipo){
        equiposTemporada.add(_equipo);
    }

    /**
     * Retorna el tamaño de la lista de equipos
     * @return tamaño lista de equipos
     */
    public int getSizeEquipos(){
        return equiposTemporada.size();
    }

    /**
     * Retorna el numero de fechas en la temporada
     * @return numero de fechas de la temporada
     */
    public int getSizeFechas(){
        return fechasTemporada.size();
    }

    /**
     * Busca una fecha por su id
     * @param _id id de de la fecha
     * @return Fecha buscada, null si no encuentra la fecha
     */
    public FechaReal buscarFechaPorId(int _id){
        int i = 0;
        while(i < fechasTemporada.size()){
            FechaReal fecha = fechasTemporada.get(i);
            if(fecha.getIdFecha() == _id){
                return fecha;
            }
            i += 1;
        }  
        return null;
    }

    /**
     * Agrega una fecha a la lista de fechas
     * @param _fecha fecha a agregar
     */
    public void agregarFecha(FechaReal _fecha){
        this.fechasTemporada.add(_fecha);
    }

    /**
     * Busca un equipo en la lista de equipos por su nombre
     * @param _nombreEquipo nombre del equipo a ser buscado
     * @return equipo encontrado
     */
    public EquipoReal buscarEquipoPorNombre(String _nombreEquipo){
        for (EquipoReal equipoReal : equiposTemporada) {
            if(equipoReal.getNombre().equals(_nombreEquipo)){
                return equipoReal;
            }
        }
        return null;
    }
}
