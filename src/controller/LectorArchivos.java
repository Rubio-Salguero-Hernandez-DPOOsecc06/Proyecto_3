package controller;

import java.io.*;
import model.*;

public class LectorArchivos {
    
    public LectorArchivos(){}

    /**
     * Carga los equipos que jugaran en la temporada
     * @param _nombreArchivo nombre del archivo donde esta la información
     * @param _temporada temporada a la que se debe agregar la información
     */
    public void cargarEquipos(String _nombreArchivo, TemporadaReal _temporada){
        File rutaEquipos = new File("FutbolFantasia/data/infoTemporada/" + _nombreArchivo);
        try {
            if(rutaEquipos.exists()){
                BufferedReader lector = new BufferedReader(new FileReader(rutaEquipos));
                String linea = lector.readLine();
                linea = lector.readLine();
                while(linea != null){
                     String nombre = linea;
                     EquipoReal equipo = new EquipoReal(nombre);
                    _temporada.addEquipo(equipo);
                    linea = lector.readLine();
                }
                lector.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga el archivo de los jugadores de la temporada
     * @param _nombreArchivo nombre del archivo donde esta la informacion de los jugadores
     * @param _temporada temporada a la que se debe cargar la información
     */
    public void cargarJugadores(String _nombreArchivo, TemporadaReal _temporada){
        File rutaJugadores = new File("FutbolFantasia/data/infoTemporada/" + _nombreArchivo);
        try {
            if(rutaJugadores.exists()){
                BufferedReader lector = new BufferedReader(new FileReader(rutaJugadores));
                String linea = lector.readLine();
                linea = lector.readLine();
                while(linea != null){
                    String[] datos = linea.split(";");
                    String nombre = datos[0];
                    String equipo = datos[1];
                    String posicion = datos[2];
                    Double precio = Double.parseDouble(datos[3]);
                    EquipoReal equipoJugador = _temporada.buscarEquipoPorNombre(equipo);
                    JugadorReal jugador = new JugadorReal(nombre, equipoJugador, precio);
                    jugador.setPosicion(posicion);
                    equipoJugador.agregarJugador(jugador);
                    linea = lector.readLine();
                }
                lector.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarFechas(String _nombreArchivo, TemporadaReal _temporada){
        File rutaFechas = new File("FutbolFantasia/data/infoTemporada/" + _nombreArchivo);
        try {  
            if(rutaFechas.exists()){
                BufferedReader lector = new BufferedReader(new FileReader(rutaFechas));
                String linea = lector.readLine();
                linea = lector.readLine();
                while(linea != null){
                    String[] datos = linea.split(";");
                    int idFecha = Integer.parseInt(datos[0]);
                    String dia = datos[1];
                    String hora = datos[2];
                    String nombreLocal = datos[3];
                    String nombreVisitante = datos[4];
                    EquipoReal visitante = _temporada.buscarEquipoPorNombre(nombreVisitante);
                    EquipoReal local = _temporada.buscarEquipoPorNombre(nombreLocal);
                    FechaReal fecha;

                    if(_temporada.getSizeFechas() == 0 || _temporada.buscarFechaPorId(idFecha) == null){
                        fecha = new FechaReal(idFecha);
                        _temporada.agregarFecha(fecha);
                    }else{
                        fecha = _temporada.buscarFechaPorId(idFecha);
                    }

                    PartidoReal partido = fecha.crearPartido(local, visitante, dia, hora);
                    fecha.agregarPartido(partido);
                    linea = lector.readLine();
                }
                lector.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
