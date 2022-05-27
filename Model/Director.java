/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.List;
import java.time.LocalDate;
/**
 *
 * @author Jon
 */
public class Director implements Serializable {
   private String nombre;
   private LocalDate fecha;
   private String lugarnacimiento;
   private String profesiones;
   private List<String> participaciones;

    public Director(String nombre, LocalDate fecha, String lugarnacimiento, String profesiones, List<String> participaciones) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugarnacimiento = lugarnacimiento;
        this.profesiones = profesiones;
        this.participaciones = participaciones;
    }
    
    public String asColumns(int[] numCols) {
        String columnas = "%-"
        + numCols[0]
        + "s%-"
        + numCols[1]
        + "s%-"
        + numCols[2]
        + "s%-"
        + numCols[3]
        + "s%-"
        + numCols[4]
        + "s";
         
        return String.format(columnas,
        this.nombre,
        this.fecha,
        this.lugarnacimiento,
        this.profesiones,
        this.participaciones);
    }
    /*public Director(String[] campos){
        this.nombre = campos[0];
        this.fecha = campos[1];
        this.lugarnacimiento = campos[2];
        this.profesiones = campos[3];
        this.participaciones = campos[4];
    }*/
   
   
   
   
   
   
   
//GETTER SETTER
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

    public String getLugarnacimiento() {
        return lugarnacimiento;
    }

    public void setLugarnacimiento(String lugarnacimiento) {
        this.lugarnacimiento = lugarnacimiento;
    }

    public String getProfesiones() {
        return profesiones;
    }

    public void setProfesiones(String profesiones) {
        this.profesiones = profesiones;
    }

    public List<String> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(List<String> participaciones) {
        this.participaciones = participaciones;
    }
   
}
