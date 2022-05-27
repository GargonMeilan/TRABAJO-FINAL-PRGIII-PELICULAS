/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Jon
 */
public class Pelicula implements Serializable{
    private String titulo;
    private int año;
    private int duracion;
    private String pais;
    private List<String> listDirectores;
    private String guionista;
    private String musica;
    private List<String> listActores;
    private String productora;
    private String genero;
    private String sinopsis;

    public Pelicula(String titulo, int año, int duracion, String pais, List<String> listDirectores, String guionista, String musica, List<String> listActores, String productora, String genero, String sinopsis) {
        this.titulo = titulo;
        this.año = año;
        this.duracion = duracion;
        this.pais = pais;
        this.listDirectores = listDirectores;
        this.guionista = guionista;
        this.musica = musica;
        this.listActores = listActores;
        this.productora = productora;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }
    
    public String asHTML(){
        String tabla = String.format("<TR>"
                        + "<TD>%s</TD>" //titulo
                        + "<TD>%d</TD>" //año
                        + "<TD>%d</TD>" //duracion
                        + "<TD>%s</TD>" //pais
                        + "<TD>%s</TD>" //Directores
                        + "<TD>%s</TD>" // guionista
                        + "<TD>%s</TD>" //musica
                        + "<TD>%s</TD>" //ACTORES
                        + "<TD>%s</TD>"//productora
                        + "<TD>%s</TD>"//genero
                        + "<TD>%s</TD>"//sinopsis
                        + "</TR>",
                this.titulo,this.año,this.duracion,this.pais,this.listDirectores,this.guionista,this.musica,this.listActores,this.productora,this.genero,this.sinopsis);
        return tabla;
    }
    
//getter setter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<String> getListDirectores() {
        return listDirectores;
    }

    public void setListDirectores(List<String> listDirectores) {
        this.listDirectores = listDirectores;
    }

    public String getGuionista() {
        return guionista;
    }

    public void setGuionista(String guionista) {
        this.guionista = guionista;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public List<String> getListActores() {
        return listActores;
    }

    public void setListActores(List<String> listActores) {
        this.listActores = listActores;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
            
          
    
}
