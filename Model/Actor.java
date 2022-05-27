/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author Jon
 */
public class Actor implements Serializable{
    private String nombre;
    private LocalDate fecha;
    private String pais;
    private int año;
    private List<String> peliculas;

    public Actor(String nombre, LocalDate fecha, String pais, int año, List<String> peliculas) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.pais = pais;
        this.año = año;
        this.peliculas = peliculas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public List<String> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<String> peliculas) {
        this.peliculas = peliculas;
    }
    
    
}
