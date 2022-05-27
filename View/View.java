/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Controller;
import Model.Actor;
import Model.Director;
import Model.Pelicula;
import static com.coti.tools.DiaUtil.clear;
import static com.coti.tools.Esdia.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jon
 */
public class View {
    Controller c = new Controller();
    
    public void mostrarMenu(){
        c.arranque();
        boolean exit = false;
        while(!exit){
            String menu ="%n== MENU =="
                    +"%n1) Archivos"
                    +"%n2) Peliculas"
                    +"%n3) Directores"
                    +"%n4) Actores"
                    +"%n5) Listados"
                    +"%nq) Salir"                    
                    + "%n";
                    
            
            String option = readString(menu).toLowerCase();
            switch (option) {
               case "1":
                   this.subMenuArchivos();
                   break;
                   
               case "2":
                   this.subMenuPeliculas();
                   break;
                   
               case "3":
                   this.subMenuDirectores();
             
                   break;
                   
               case "4":
                   this.subMenuActores();
                   break;
                   
               case "5":
                   this.subMenuListados();
                   break;
                   
               case "q":
                   exit = yesOrNo("¿Desea realmente salir?");
                  c.salida();
                   break;
               
               default:
                   System.out.printf("Opcion no valida!!%n%n");
            }
        }
    }
    private void subMenuArchivos(){
        clear();
            boolean exit = false;
        while(!exit){
            String submenuArchivos="%n==Archivos=="
                                    +"%n1) Exportar Directores"
                                    +"%n2) Exportar peliculas"
                                    +"%nq) Volver al menu"
                                    +"%n";
    
            String option = readString(submenuArchivos).toLowerCase();
            switch (option) {
               case "1":
                   c.exportarDirectores();
                   break;
                   
               case "2":
                   c.exportarPelisHTML();
                   break;
                   
               case "q":
                   exit = yesOrNo("¿Desea realmente salir?");
                   break;
               default:
                   System.out.printf("Opcion no valida!!%n%n");
            }     
        }
    }
    
    private void subMenuPeliculas(){
        
        boolean exit = false;
        while(!exit){
            String subMenuPeliculas="%n==Peliculas=="
                                    +"%n1) Altas"
                                    +"%n2) Bajas"
                                    +"%n3) Modificaciones"
                                    +"%n4) Consultas"
                                    +"%nq) Salir"
                                    +"%n";
    
            String option = readString(subMenuPeliculas).toLowerCase();
            switch (option) {
               case "1":
                   this.añadirPelicula();
                   break;
                   
               case "2":
                   this.borrarPeli();
                   break;
                   
               case "3":
                   this.modificacionesPeliculas();
                   break;
                
               case "4":
                   String peli = readString("Introduce titulo de la pelicula que quieras consultar:");
                   if(c.existePeli(peli)){
                    Pelicula pelicula = c.mostrarPeli(peli); //this.duracion,this.pais,this.listDirectores,this.guionista,this.musica,this.listActores,this.productora,this.genero,this.sinopsis
                    String pell = String.format("%s\t%d\t%d\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s",pelicula.getTitulo(),pelicula.getAño(),pelicula.getDuracion(),pelicula.getPais(),pelicula.getListDirectores(),pelicula.getGuionista(),pelicula.getMusica(),pelicula.getListActores(),pelicula.getProductora(),pelicula.getGenero(),pelicula.getSinopsis());
                    System.out.println(pell);
                   }
                   else{
                       System.out.println("No existe esa pelicula");
                   }
                   break;
               case "q":
                   exit = yesOrNo("¿Desea realmente salir?");
                   break;
               default:
                   System.out.printf("Opcion no valida!!%n%n");
            }     
        }
        
    }
    
    private void añadirPelicula(){
        boolean exit = false;
        String tmp;
        List<String> lDirectores = new ArrayList();
        List<String> lActores = new ArrayList();
        String titulo = readString("Introduce titulo de la pelicula:");
        int año = readInt("Introduce año:");
        int duracion = readInt("Introduce duracion en minutos:");
        String pais = readString("Introduce Pais:");
        while(!exit){
            tmp = readString("Introduce director:");
            lDirectores.add(tmp);
            exit = !yesOrNo("Introducir otro director?");
        } 
        exit = false;
        String guionista = readString("Introduce los guionistas:");
        String musica = readString("Introduce compositores:");
        while(!exit){
            tmp = readString("Introduce actor:");
            lActores.add(tmp);
            exit = !yesOrNo("Introducir otro Actor?");
        }
        String productora = readString("Introduce productora:");
        String genero = readString("Introduce genero:");
        String sinopsis = readString("Introduce sinopsis:");
        
        
        c.añadirPeli(titulo,año,duracion,pais,lDirectores,guionista,musica,lActores,productora,genero,sinopsis);
    }
    
    private void borrarPeli(){
        String pelii=readString("Que pelicula quieres borrar:");
        c.borrarPeli(pelii);
    }
    private void modificacionesPeliculas(){
        String titulo = readString("Que pelicula quieres modificar");
        boolean founded = c.existePeli(titulo);
        if(!founded){
            System.out.println("No existe esa pelicula");
        }
        else{
            int año = readInt("Introduce año:");
            int duracion = readInt("Introduce duracion en minutos:");
            String pais = readString("Introduce Pais:");
            String guionista = readString("Introduce los guionistas:");
            String musica = readString("Introduce compositores:");
            String productora = readString("Introduce productora:");
            String genero = readString("Introduce genero:");
            String sinopsis = readString("Introduce sinopsis:");
            
            c.modificarPeli(titulo,año,duracion,pais,guionista,musica,productora,genero,sinopsis);
        }
    }
    
    private void subMenuDirectores(){
        boolean exit = false;
        while(!exit){
            String subMenuDirectores="%n==Directores=="
                                    +"%n1) Altas"
                                    +"%n2) Bajas"
                                    +"%n3) Modificaciones"
                                    +"%nq) Salir"
                                    +"%n";
    
            String option = readString(subMenuDirectores).toLowerCase();
            switch (option) {
               case "1":
                   this.añadirDirector();
                   break;
                   
               case "2":
                   this.borrarDirector();
                   break;
                   
               case "3":
                   this.modificarDirector();
                   break;
                
               
               case "q":
                   exit = yesOrNo("¿Desea realmente salir?");
                   break;
               default:
                   System.out.printf("Opcion no valida!!%n%n");
            }     
        }
    }
    
    private void añadirDirector(){
        String nombre=readString("Nombre:");
        String fecha=readString("Introduzca fecha en formato yyyy-mm-dd:");
        String lugarNac=readString("Lugar de nacimiento:");
        String profesion=readString("Introduzca profesiones separadas por espacios:");
        List<String> pelis = new ArrayList<>();
        boolean k=false;
        while(!k){
            String tmp = readString("Introduzca pelicula dirijida:");
            pelis.add(tmp);
            k=!yesOrNo("Añadir otra?");
        }
        c.añadirDirector(nombre,fecha,lugarNac,profesion,pelis);
    }
    
    private void borrarDirector(){
        String nombre = readString("Que director quieres borrar:");
        if(c.existeDir(nombre)){
            c.borrarDir(nombre);
        }
        else{
            System.out.println("No existe ese director");
        }
    }
    
    private void modificarDirector(){
        String nombre = readString("Que director quieres editar:");
        if(c.existeDir(nombre)){
            String fecha=readString("Introduzca fecha en formato yyyy-mm-dd:");
            String lugarNac=readString("Lugar de nacimiento:");
            String profesion=readString("Introduzca profesiones separadas por espacios:");
            c.modificarDir(nombre,fecha,lugarNac,profesion);
        }
        else{
            System.out.println("No existe ese director");
        }
    }
    
    private void subMenuActores(){
        boolean exit = false;
        while(!exit){
            String subMenuActores="%n==Actores=="
                                    +"%n1) Altas"
                                    +"%n2) Bajas"
                                    +"%n3) Modificaciones"
                                    +"%n4) Peliculas"
                                    +"%nq) Salir"
                                    +"%n";
    
            String option = readString(subMenuActores).toLowerCase();
            switch (option) {
               case "1":
                   this.añadirActor();
                   break;
                   
               case "2":
                   this.borrarActor();
                   break;
                   
               case "3":
                   this.modificarActor();
                   break;
               case "4":
                   this.mostrarPelis();
                   break;
               
               case "q":
                   exit = yesOrNo("¿Desea realmente salir?");
                   break;
               default:
                   System.out.printf("Opcion no valida!!%n%n");
            }     
        }
    }
    private void añadirActor(){
        String nombre=readString("Nombre:");
        String fecha=readString("Introduzca fecha en formato yyyy-mm-dd:");
        String lugarNac=readString("Lugar de nacimiento:");
        int año=readInt("Introduzca año:");
        List<String> papeles = new ArrayList<>();
        boolean k=false;
        while(!k){
            String tmp = readString("Introduzca pelicula:");
            papeles.add(tmp);
            k=!yesOrNo("Añadir otra?");
        }
        
        c.añadirActor(nombre,fecha,lugarNac,año,papeles);
    }
    private void borrarActor(){
        String nombre = readString("Que actor quieres borrar:");
        if(c.existeAct(nombre)){
            c.borrarActor(nombre);
        }
        else{
            System.out.println("No existe ese Actor");
        }
    }
    private void modificarActor(){
        String nombre = readString("Que actor quieres editar:");
        if(c.existeAct(nombre)){
            String fecha=readString("Introduzca fecha en formato yyyy-mm-dd:");
            String lugarNac=readString("Lugar de nacimiento:");
            int año=readInt("Introduzca año:");
            c.modificarAct(nombre,fecha,lugarNac,año);
        }
        else{
            System.out.println("No existe ese director");
        }
    }
    private void mostrarPelis(){
        String nombre = readString("De que actor quieres ver sus pelis:");
        List<Pelicula> pelis = new ArrayList<>();
        if(c.existeAct(nombre)){
            pelis = c.mostrarPelAct(nombre);
            for(Pelicula p : pelis){
                System.out.printf("%s\t%d\t%d\t%s\t%s%n",p.getTitulo(),p.getAño(),p.getDuracion(),p.getGenero(),p.getPais());
            }
        }else{
            System.out.println("No existe ese actor");
        }
       
    }
    
    private void subMenuListados(){
        boolean exit = false;
        while(!exit){
            String subMenuListados="%n==Listados=="
                                    +"%n1) Peliculas"
                                    +"%n2) Directores"
                                    +"%n3) Actores"
                                    +"%nq) Salir"
                                    +"%n";
    
            String option = readString(subMenuListados).toLowerCase();
            switch (option) {
               case "1":
                   this.listadoPeliculas();
                   break;
                   
               case "2":
                   this.listadoDirectores();
                   break;
                   
               case "3":
                   this.listadoActores();
                   break;
               
               case "q":
                   exit = yesOrNo("¿Desea realmente salir?");
                   break;
               default:
                   System.out.printf("Opcion no valida!!%n%n");
            }     
        }
    }
    private void listadoPeliculas(){
        List<Pelicula> peliculas = new ArrayList<>();
        int[] numCols = {40,20,20,40,40};
        String columnas = "%-"
                + numCols[0]
                + "s%-"
                + numCols[1]
                + "s%-"
                + numCols[2]
                + "s%-"
                + numCols[3]
                + "s%-"
                +numCols[4]
                +"s"
                +"%n";
        peliculas = c.listadoPel(); //titul año duracion pais genero
        for(Pelicula p : peliculas){
            System.out.printf(String.format(columnas,p.getTitulo(),p.getAño(),p.getDuracion(),p.getPais(),p.getGenero()));
            
        }
    }
    private void listadoDirectores(){
        int[] numCols = {30,40,50,60};
        String columnas = "%-"
                + numCols[0]
                + "s%-"
                + numCols[1]
                + "s%-"
                + numCols[2]
                + "s%-"
                + numCols[3]
                + "s"
                +"%n";
        List<Director> directores = new ArrayList<>();
        directores = c.listadoDir(); //nombre fecha nacionalidad profesion
        for(Director d : directores){
            System.out.printf(String.format(columnas,d.getNombre(),d.getFecha(),d.getLugarnacimiento(),d.getProfesiones()));
        }
    }
    private void listadoActores(){
        List<Actor> actores = new ArrayList<>();
        int[] numCols = {30,40,50,60};
        String columnas = "%-"
                + numCols[0]
                + "s%-"
                + numCols[1]
                + "s%-"
                + numCols[2]
                + "s%-"
                + numCols[3]
                + "s"
                +"%n";
        actores = c.listadoAct();
        for(Actor a : actores){
            System.out.printf(columnas,a.getNombre(),a.getFecha(),a.getPais(),a.getAño());
        }
    }
}
