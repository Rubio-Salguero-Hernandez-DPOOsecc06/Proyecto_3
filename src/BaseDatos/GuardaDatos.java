package BaseDatos;

import java.io.*;

import javax.swing.JOptionPane;

import model.Participante;
import model.TemporadaReal;


public class GuardaDatos {

    String tipoDato = ".obj";

    public GuardaDatos(){ }

    /**
     * Guarda un participante que se acaba de registrar
     * @param _participante Participante que desea registrarse
     * @param _nombreAdmin Nombre del administrador de la aplicación
     * @return true si se pudo registrar, false si no
     */
    public boolean guardarParticipante(Participante _participante, String _nombreAdmin){
        try {
            File carpeta = new File("dataBase/participantes");
            if(!carpeta.exists()){
                carpeta.mkdirs();
            }

            if(_participante.getNombre().equals(_nombreAdmin)){
                return false;
            }
            if(!verificarExistenciaUsuario(_participante.getNombre())){
                ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("dataBase/participantes/" + _participante.getNombre() + tipoDato));
                escritor.writeObject(_participante);
                escritor.close();
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * verifica si existe un participante con el nombre de usuario ingresado
     * @param _nombre nombre de usuario a buscar
     * @return true si existe un participante con ese nombre, false de lo contrario
     */
    public boolean verificarExistenciaUsuario(String _nombre){
        try {
            File rutaParticipante = new File("dataBase/participantes/" + _nombre + tipoDato);
            if(rutaParticipante.exists()){
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Recupera un participante de la base de datos de la aplicacion
     * @param _nombre nombre de usuario buscado
     * @param _clave clave asociada al nombre de usuario
     * @return participante cuyo nombre y clave coincidan con los ingresados por parametro, null si no existe
     */
    public Participante recuperarparticipante(String _nombre, String _clave){
        try {
            File rutaParticipante = new File("dataBase/participantes/" + _nombre + tipoDato);
            if(rutaParticipante.exists()){
                ObjectInputStream lector = new ObjectInputStream(new FileInputStream(rutaParticipante));
                Participante participante = (Participante)lector.readObject();
                lector.close();
                if(_clave.equals(participante.getClave())){
                    return participante;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();   
        }
        return null;
    }

    /**
     * Guarda una temporada recientemente creada
     * @param _temporada temporada a guardar
     */
    public void guardarTemporada(TemporadaReal _temporada){
        File temporadas = new File("dataBase/temporadas");
        if(!temporadas.exists()){
            temporadas.mkdirs();
        }
        String[] season = temporadas.list();
        int seasonSize = season.length;
        _temporada.setIdTemporada(seasonSize + 1);
        File rutaTemporada = new File(temporadas + "/"+_temporada.getIdTemporada()+".obj");
        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(rutaTemporada));
            escritor.writeObject(_temporada);
            escritor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TemporadaReal recuperarTemporadas(){
        File temporadas = new File("dataBase/temporadas");
        try{
            if(temporadas.exists()){
                String[] datos = temporadas.list();
                int tamDatos = datos.length;
                File rutaTemporada = new File(temporadas, tamDatos + tipoDato);
                ObjectInputStream lector = new ObjectInputStream(new FileInputStream(rutaTemporada));
                TemporadaReal temporada = (TemporadaReal)lector.readObject();
                lector.close();
                return temporada;
            }
        }catch(Exception e){
            
        }
        return null;
    }

    public void guardarCambiosParticipante(Participante _participante){
        File rutaParticipante = new File("dataBase/participantes/"+_participante.getNombre()+tipoDato);
        try {
            if(rutaParticipante.exists()){
                ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(rutaParticipante));
                escritor.writeObject(_participante);
                escritor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
