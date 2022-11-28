package controller;

import BaseDatos.GuardaDatos;
import model.TemporadaReal;
import view.InterfazAdmin;

public class AdminController {

    private InterfazAdmin view;
    private GuardaDatos baseDatos;
    private LectorArchivos lector = new LectorArchivos();
    
    public AdminController(InterfazAdmin _view, GuardaDatos _baseDatos){
        this.view = _view;
        this.baseDatos = _baseDatos;        
    }

    public TemporadaReal crearTemprada(String _nombreArchivoEquipos, String _nombreArchivoJugadores, String _nombreArchivoFechas){
        TemporadaReal temporada = new TemporadaReal();
        cargarEquiposTemporada(_nombreArchivoEquipos, temporada);
        cargarJugadoresTemporadas(_nombreArchivoJugadores, temporada);
        cargarFechasTemporada(_nombreArchivoFechas, temporada);
        baseDatos.guardarTemporada(temporada);
        
        return temporada;
    }

    public void cargarEquiposTemporada(String _nombreArchivo, TemporadaReal _temporada){
        lector.cargarEquipos(_nombreArchivo, _temporada);
    }

    public void cargarJugadoresTemporadas(String _nombreArchivo, TemporadaReal _temporada){
        lector.cargarJugadores(_nombreArchivo, _temporada);
    }

    public void cargarFechasTemporada(String _nombreArchivo, TemporadaReal _temporada){
        lector.cargarFechas(_nombreArchivo, _temporada);
    }
}
