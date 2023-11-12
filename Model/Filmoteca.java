/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.nio.file.Path;
import java.nio.file.Files;
import com.coti.tools.Rutas;
import com.coti.tools.OpMat;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Jon
 */
public class Filmoteca {
    
    public String[][] directoresLista;
    public List<Director> directoresListaBin = new ArrayList<>();
    
    public String[][] actoresLista;
    public List<Actor> actoresListaBin = new ArrayList<>();
    
    public String[][] peliculasLista;
    public List<Pelicula> peliculasListaBin = new ArrayList<>();
    
    
    
    public void arranque(){
        
        Path rutadirectores = Rutas.pathToFileInFolderOnDesktop("IMDB21","directores.bin");
        Path rutaactores = Rutas.pathToFileInFolderOnDesktop("IMDB21","actores.bin");
        Path rutapeliculas = Rutas.pathToFileInFolderOnDesktop("IMDB21","peliculas.bin");
        
        
        
        //DIRECTORES
        if(rutadirectores.toFile().exists()){
            
            try {
                FileInputStream fis = new FileInputStream(rutadirectores.toFile());
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
                directoresListaBin = (List<Director>) ois.readObject();
                ois.close();
                
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Error");
                
            }
            
        }
        else{
            
            rutadirectores = Rutas.pathToFileInFolderOnDesktop("IMDB21","directores.txt");
            System.out.println("Se ha cargado txt");
            if(rutadirectores.toFile().exists()){
                try{
                    directoresLista = OpMat.importFromDisk(rutadirectores.toFile(), "#");
                   
                } catch (Exception ex) {
                    System.err.println("Error directores.txt");               
                }
                for(String[] s : directoresLista){
                    
                    List<String> listaParticipaciones = new ArrayList<String>(Arrays.asList(s[4].split("\t")));
                    if("".equals(s[1])){s[1]="1111-11-11";}
                    LocalDate localFecha = LocalDate.parse(s[1]);
                    Director d = new Director(s[0],localFecha,s[2],s[3],listaParticipaciones);
                    directoresListaBin.add(d);
                    
                }
                
            }
            else{
                System.out.println("No hay fichero directores.txt");
            }
        }
        
        //ACTORES
        if(rutaactores.toFile().exists()){
            
            try {
                FileInputStream fis = new FileInputStream(rutaactores.toFile());
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
                actoresListaBin = (List<Actor>) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Error al cargar actores.bin");
                
            }
            
        }
        else{
            
            rutaactores = Rutas.pathToFileInFolderOnDesktop("IMDB21","actores.txt");
            
            if(rutaactores.toFile().exists()){
                try{
                    actoresLista = OpMat.importFromDisk(rutaactores.toFile(),"#");
                    
                } catch (Exception ex) {
                    System.err.println("Error actores.txt");               
                }
                 for(String[] s : actoresLista){
                    
                    List<String> listaPapeles = new ArrayList<String>(Arrays.asList(s[4].split("\t")));
                    
                    if("".equals(s[1])){s[1]="1111-11-11";}
                    LocalDate fechaNacimiento = LocalDate.parse(s[1]);
                    if("".equals(s[3])){s[3]="0";}
                    Actor a = new Actor(s[0], fechaNacimiento, s[2], Integer.parseInt(s[3]), listaPapeles);
                    actoresListaBin.add(a);
                    
                }
            }
            else{
                System.out.println("No hay fichero actores.txt");
            }
        }
        //PELICULAS
        if(rutapeliculas.toFile().exists()){
            
            try {
                FileInputStream fis = new FileInputStream(rutapeliculas.toFile());
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
                peliculasListaBin = (List<Pelicula>) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Error peliculas.txt");
                
            }
            
        }
        else{
            
            rutapeliculas = Rutas.pathToFileInFolderOnDesktop("IMDB21","peliculas.txt");
            if(rutapeliculas.toFile().exists()){
                try{
                    peliculasLista = OpMat.importFromDisk(rutapeliculas.toFile(), "#");
                    
                } catch (Exception ex) {
                    System.err.println("Error");               
                }
                for(String[] s : peliculasLista){
                   
                    List<String> listaDireccion = new ArrayList<String>(Arrays.asList(s[4].split("\t")));
                    
                    List<String> listaReparto = new ArrayList<String>(Arrays.asList(s[7].split("\t")));
                    
                    
                    Pelicula p = new Pelicula(s[0], Integer.parseInt(s[1]),Integer.parseInt(s[2]),s[3],listaDireccion,s[5],s[6],listaReparto,s[8],s[9],s[10]);
                    peliculasListaBin.add(p);
                    
                    
                    
                }
            }
            else{
                System.out.println("No hay fichero peliculas.txt");
            }
        }
            //COMPROBARLISTAS
            /*for(Pelicula a : peliculasListaBin ){
                System.out.println(a.getTitulo());
            }
            for(Director d : directoresListaBin ){
                System.out.println(d.getNombre());
            }
            for(Actor c : actoresListaBin ){
                System.out.println(c.getNombre());
            }*/
    }
    
    public void salida(){
        Path rutadirectores = Rutas.pathToFileInFolderOnDesktop("IMDB21","directores.bin");
        Path rutaactores = Rutas.pathToFileInFolderOnDesktop("IMDB21","actores.bin");
        Path rutapeliculas = Rutas.pathToFileInFolderOnDesktop("IMDB21","peliculas.bin");
        
        //Guardar directores.bin
        try{
            FileOutputStream fos = new FileOutputStream(rutadirectores.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(directoresListaBin);
            oos.close();
        }catch(IOException ex){
            System.err.println("No fue posible guardar el archivo directores");
        }
        
        //Guardar actores.bin
        try{
            FileOutputStream fos = new FileOutputStream(rutaactores.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(actoresListaBin);
            oos.close();
        }catch(IOException ex){
            System.err.println("No fue posible guardar el archivo actores");
        }
        
        //Guardar peliculas.bin
        try{
            FileOutputStream fos = new FileOutputStream(rutapeliculas.toFile());
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(peliculasListaBin);
            oos.close();
        }catch(IOException ex){
            System.err.println("No fue posible guardar el archivo peliculas");
        }
    }
    
    public void exportarDirectores(){
        File exportedCol = Rutas.pathToFileInFolderOnDesktop("IMDB21","directores.col").toFile();
        if(exportedCol.exists()){
            exportedCol.delete();
        }
        int[] numCol = {25, 11, 20, 70, 140};
        if(directoresListaBin == null || directoresListaBin.isEmpty()){
            System.out.println("Lista Vacia");
            return;
        }
        List<String> columnas = new ArrayList<>();
        for(Director d : directoresListaBin){
            if("".equals(d.getLugarnacimiento())){d.setLugarnacimiento("UNKNOWN");}
            if("".equals(d.getProfesiones())){d.setProfesiones("UNKNOWN");}
            
            columnas.add(d.asColumns(numCol));
        }
        try{
            Files.write(exportedCol.toPath(), columnas, Charset.defaultCharset(),StandardOpenOption.CREATE);
        }catch(IOException ex){
            System.out.println("ERROR AL EXPORTAR COLUMNAS");
            return;
        }
        System.out.println("Exportadas correctamente");
    }
    
    public void exportarPelisHTML(){
        File exportedHTML = Rutas.pathToFileInFolderOnDesktop("IMDB21","peliculas.html").toFile();
        if(exportedHTML.exists()){
            exportedHTML.delete();
        }
        try{
            PrintWriter pw = new PrintWriter(exportedHTML);
            pw.printf("<DOCTYPE html>%n"
                    + "<HTML>%n"
                    + "<HEAD>%n"
                    + "<meta charset=\"UTD-8\">%n"
                    + "<H1>PELICULAS</H1>%n"
                    + "</HEAD>%n"
                    + "<BODY>");
            pw.printf("<TABLE BORDER=1>%n");
            pw.printf("<TR>"
                        + "<TD>TITULO</TD>" //titulo
                        + "<TD>AÑO</TD>" //año
                        + "<TD>DURACION</TD>" //duracion
                        + "<TD>PAIS</TD>" //pais
                        + "<TD>DIRECTORES</TD>" //Directores
                        + "<TD>GUIONISTA</TD>" // guionista
                        + "<TD>MUSICA</TD>" //musica
                        + "<TD>ACTORES</TD>" //ACTORES
                        + "<TD>PRODUCTORA</TD>"//productora
                        + "<TD>GENERO</TD>"//genero
                        + "<TD>SINOPSIS</TD>"//sinopsis
                        + "</TR>");
            for(Pelicula pel : peliculasListaBin){
               pw.printf("%s%n", pel.asHTML());
            }
            pw.printf("</>%n</BODY>%n</HTML>%n");
            pw.close();
        }catch(FileNotFoundException ex){
            System.out.println("ERROR AL EXPORTAR A HTML");
        } 
    }
    
    public void añadirPeli(String titulo,int año,int duracion,String pais,List<String> directores,String guionista,String musica,List<String> actores,String productora,String genero,String sinopsis){
        int n=0;
        Pelicula p = new Pelicula(titulo,año,duracion,pais,directores,guionista,musica,actores,productora,genero,sinopsis);
        peliculasListaBin.add(p);
        List<String> titu = new ArrayList<>();
        titu.add(titulo);
        
        
        for(String dd : directores){
           for(Director d : directoresListaBin){
               if(dd.equals(d.getNombre())){
                   directoresListaBin.get(n).getParticipaciones().add(titulo);
                   directores.remove(dd);
                   break;
               }
               
               n=n+1;
           }
        }
        if(!directores.isEmpty()){
            for(String dd : directores){
            
                   Director ddd = new Director(dd,LocalDate.parse("1111-11-11"),"Unknown","Director",titu);
                   directoresListaBin.add(ddd);
                   
               
            }
        }
        n=0;
        for(String aa : actores){
            for(Actor a : actoresListaBin){
                if(aa.equals(a.getNombre())){
                    actoresListaBin.get(n).getPeliculas().add(titulo);
                    actores.remove(aa);
                    break;
                }
                n=n+1;
                
            }
            
        }
        if(!actores.isEmpty()){
            for(String aa : actores){
                Actor aaa = new Actor(aa,LocalDate.parse("1111-11-11"),"Unknown",00,titu);
                actoresListaBin.add(aaa);
                
            }
        }
    }
    
    
    public void borrarPeli(String peli){
        int n = 0;
        boolean founded = false;
        for(Pelicula pp : peliculasListaBin){
            if(peli.equalsIgnoreCase(pp.getTitulo())){
                peliculasListaBin.remove(pp);
                founded = true;
                break;
            }
        }  
        if(founded==false){
            System.out.println("No se encontro ninguna pelicula con ese titulo");
        }
        if(founded){
            for(Director dd : directoresListaBin){
                for( String dir : dd.getParticipaciones()){
                    if(dir.equalsIgnoreCase(peli)){
                    directoresListaBin.get(n).getParticipaciones().remove(peli);
                    break;
                    }
                }
                n=n+1;
            }
            n=0;
            for(Actor aa : actoresListaBin){
                for(String act : aa.getPeliculas()){
                    if(act.equalsIgnoreCase(peli)){
                        actoresListaBin.get(n).getPeliculas().remove(peli);
                        break;
                    }
                }
                n=n+1;
            }
        }
    }  
    
    public boolean existePeli(String titulo){
        for(Pelicula p : peliculasListaBin){
            if(p.getTitulo().equalsIgnoreCase(titulo)){
                return true;
            }
        }
        return false;
    }
   
    public void modificarPeli(String titulo,int año,int duracion,String pais,String guionista,String musica,String productora,String genero,String sinopsis){
        int n =0;
        for(Pelicula p : peliculasListaBin){
            if(p.getTitulo().equalsIgnoreCase(titulo)){
                peliculasListaBin.get(n).setAño(año);
                peliculasListaBin.get(n).setDuracion(duracion);
                peliculasListaBin.get(n).setPais(pais);
                peliculasListaBin.get(n).setGuionista(guionista);
                peliculasListaBin.get(n).setMusica(musica);
                peliculasListaBin.get(n).setProductora(productora);
                peliculasListaBin.get(n).setGenero(genero);
                peliculasListaBin.get(n).setSinopsis(sinopsis);
                
                
            }
            n=n+1;
        }
    }
    
    public Pelicula mostrarPeli(String titulo){
        for(Pelicula p : peliculasListaBin){
            if(p.getTitulo().equalsIgnoreCase(titulo)){
                return p;
                
            }
        }
        return null;
    }
    
    public void añadirDirector(String nombre,String fecha,String lugarNac,String profesion,List<String> pelis){
        Director d = new Director(nombre,LocalDate.parse(fecha),lugarNac,profesion,pelis);
        directoresListaBin.add(d);
    }
    public boolean existeDir(String nombre){
        for(Director d : directoresListaBin){
            if(d.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }
    
    public void borrarDir(String nombre){
        
        boolean borrable=true;
        for(Director d : directoresListaBin){
            if(d.getNombre().equalsIgnoreCase(nombre)){
                for(String pel : d.getParticipaciones()){
                    if(existePeli(pel)){
                        System.out.println("No se puede borrar porque tiene peliculas registradas");
                        borrable = false;
                        break;
                    }
                }
                if(borrable){
                    directoresListaBin.remove(d);
                    break;
                }
                
            }
            
        }
    }
    public void modificarDir(String nombre,String fecha,String lugar,String profesion){
        int n=0;
        
        for(Director d : directoresListaBin){
            if(d.getNombre().equalsIgnoreCase(nombre)){
                directoresListaBin.get(n).setFecha(LocalDate.parse(fecha));
                directoresListaBin.get(n).setLugarnacimiento(lugar);
                directoresListaBin.get(n).setProfesiones(profesion);
            }
            n=n+1;
        }
    }
    
    public void añadirActor(String nombre,String fecha,String pais,int año,List<String> papeles){
        Actor a = new Actor(nombre,LocalDate.parse(fecha),pais,año,papeles);
        actoresListaBin.add(a);
    }
    public boolean existeAct(String nombre){
        for(Actor a : actoresListaBin){
            if(a.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }
    public void borrarActor(String nombre){
        boolean borrable = true;
        for(Actor a : actoresListaBin){
            if(a.getNombre().equalsIgnoreCase(nombre)){
                for(String pel : a.getPeliculas()){
                    if(existePeli(pel)){
                        System.out.println("No se puede borrar porque tiene peliculas registradas");
                        borrable = false;
                        break;
                    }
                }
                if(borrable){
                    actoresListaBin.remove(a);
                    break;
                }
            }   
        }
    }
    public void modificarAct(String nombre,String fecha,String lugarNac,int año){
        int n=0;
        for(Actor a : actoresListaBin){
            if(a.getNombre().equalsIgnoreCase(nombre)){
                actoresListaBin.get(n).setFecha(LocalDate.parse(fecha));
                actoresListaBin.get(n).setPais(lugarNac);
                actoresListaBin.get(n).setAño(año);
            }
            n=n+1;
        }
    }
    public List<Pelicula> mostrarPelAct(String nombre){
        List<Pelicula> peliculas = new ArrayList<>();
        List <String> peltmp = new ArrayList<>();
        for(Actor a : actoresListaBin){
            if(a.getNombre().equalsIgnoreCase(nombre)){
                peltmp = a.getPeliculas();
            }
        }
        for(Pelicula p : peliculasListaBin){
            for(String pp : peltmp){
                if(pp.equalsIgnoreCase(p.getTitulo())){
                    peliculas.add(p);
                }
            }
        }
        return peliculas;
    }
    
    
    public List<Pelicula> listadoPel(){
        peliculasListaBin.sort(Comparator.comparing(Pelicula::getTitulo));
        return peliculasListaBin;
    }
    public List<Director> listadoDir(){
        directoresListaBin.sort(Comparator.comparing(Director::getLugarnacimiento).thenComparing(Director::getFecha));
        return directoresListaBin;
    }
    public List<Actor> listadoAct(){
        actoresListaBin.sort(Comparator.comparing(Actor::getAño).thenComparing(Actor::getNombre));
        return actoresListaBin;
    }
}
