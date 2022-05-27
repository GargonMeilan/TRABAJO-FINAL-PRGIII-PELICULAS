/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Actor;
import Model.Director;
import Model.Filmoteca;
import Model.Pelicula;
import java.util.List;

/**
 *
 * @author Jon
 */
public class Controller {
    Filmoteca m = new Filmoteca();
    
    public void arranque(){
        m.arranque();
    }
    public void salida(){
        m.salida();
    }
    
    public void exportarDirectores(){
        m.exportarDirectores();
    }
    
    public void exportarPelisHTML(){
        m.exportarPelisHTML();
    }
    
    public void añadirPeli(String titulo,int año,int duracion,String pais,List<String> directores,String guionista,String musica,List<String> actores,String productora,String genero,String sinopsis){
        m.añadirPeli(titulo,año,duracion,pais,directores,guionista,musica,actores,productora,genero,sinopsis);
    }
    public void borrarPeli(String pelicula){
        m.borrarPeli(pelicula);
    }
    public boolean existePeli(String titulo){
        return m.existePeli(titulo);
    }
    public void modificarPeli(String titulo,int año,int duracion,String pais,String guionista,String musica,String productora,String genero,String sinopsis){
        m.modificarPeli(titulo,año,duracion,pais,guionista,musica,productora,genero,sinopsis);
    }
    public Pelicula mostrarPeli(String titulo){
        return m.mostrarPeli(titulo);
    }
    public void añadirDirector(String nombre,String fecha,String lugarNac,String profesion,List<String> pelis){
        m.añadirDirector(nombre,fecha,lugarNac,profesion,pelis);
    }
    public boolean existeDir(String nombre){
        return m.existeDir(nombre);
    }
    public void borrarDir(String nombre){
        m.borrarDir(nombre);
    }
    public void modificarDir(String nombre,String fecha,String lugar,String profesion){
        m.modificarDir(nombre,fecha,lugar,profesion);
    }
    public void añadirActor(String nombre,String fecha,String pais,int año,List<String> papeles){
        m.añadirActor(nombre,fecha,pais,año,papeles);
    }
    public boolean existeAct(String nombre){
        return m.existeAct(nombre);
    }
    public void borrarActor(String nombre){
        m.borrarActor(nombre);
    }
    public void modificarAct(String nombre,String fecha,String lugarNac,int año){
        m.modificarAct(nombre,fecha,lugarNac,año);
    }
    public List<Pelicula> mostrarPelAct(String nombre){
        return m.mostrarPelAct(nombre);
    }
    public List<Pelicula> listadoPel(){
        return m.listadoPel();
    }
    public List<Director> listadoDir(){
        return m.listadoDir();
    }
    public List<Actor> listadoAct(){
        return m.listadoAct();
    }
}
