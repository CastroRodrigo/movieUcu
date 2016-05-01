/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.IActor;
import Interfaces.IDirector;
import Interfaces.IMovieUcuAdapter;
import Interfaces.IPelicula;
import Interfaces.IProductor;
import TAD.INodo;
import TAD.Lista;
import TAD.Nodo;

/**
 * @author Rodrigo Castro
 */
public class MovieUcuAdapter implements IMovieUcuAdapter {
    
    Lista<IActor> listaActores;
    Lista<IPelicula> listaPeliculas;
    Lista<IDirector> listaDirectores;
    Lista<IProductor> listaProductores;
    Lista<Relacion> listaPeliculasActores;
    Lista<Relacion> listaPeliculasDirectores;
    Lista<Relacion> listaPeliculasProductores;
    
    @Override
    public Lista getListPelicula() {
        return listaPeliculas;
    }

    @Override
    public void agregarPelicula(IPelicula pelicula) {
        if (pelicula != null ){
            if(this.listaPeliculas == null){
                this.listaPeliculas = new Lista<>();
            }
            INodo<IPelicula> nuevaPelicula = new Nodo(pelicula, pelicula.getId());
            this.listaPeliculas.insertar(nuevaPelicula);
        }
        else{
            throw new NullPointerException("La pelicula es null."); 
        }
    }

    @Override
    public boolean eliminarPelicula(Comparable idPelicula) {
        if(idPelicula != null && this.listaPeliculas != null){
            return this.listaPeliculas.eliminar(idPelicula);
        }
        else{
            throw new NullPointerException("No se encontro la pelicula."); 
        }
    }

    @Override
    public String imprimirPeliculas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPelicula buscarPelicula(Comparable IdPelicula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearListaPeliculas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Lista<IActor> getListActores() {
        return listaActores;
    }

    @Override
    public Lista<IDirector> getListDirectores() {
        return listaDirectores;
    }

    @Override
    public Lista<IProductor> getListProductores() {
        return listaProductores;
    }

    @Override
    public Lista<Relacion> getPeliculasActores() {
        return listaPeliculasActores;
    }

    @Override
    public Lista<Relacion> getPeliculasDirectores() {
        return listaPeliculasDirectores;
    }

    @Override
    public Lista<Relacion> getPeliculasProductores() {
        return listaPeliculasProductores;
    }

    @Override
    public void agregarActor(IActor actor) {
        if (actor != null ){
            if(this.listaActores == null){
                this.listaActores = new Lista<>();
            }
            INodo<IActor> nuevoActor = new Nodo(actor, actor.getId());
            this.listaActores.insertar(nuevoActor);
        }
        else{
            throw new NullPointerException("El Actor es null."); 
        }
    }

    @Override
    public void agregarDiretor(IDirector director) {
        if (director != null ){
            if(this.listaDirectores == null){
                this.listaDirectores = new Lista<>();
            }
            INodo<IDirector> nuevoDirector = new Nodo(director, director.getId());
            this.listaDirectores.insertar(nuevoDirector);
        }
        else{
            throw new NullPointerException("El Director es null."); 
        } 
    }

    @Override
    public void agregarProductor(IProductor productor) {
        if (productor != null ){
            if(this.listaProductores == null){
                this.listaProductores = new Lista<>();
            }
            INodo<IProductor> nuevoProductor = new Nodo(productor, productor.getId());
            this.listaProductores.insertar(nuevoProductor);
        }
        else{
            throw new NullPointerException("El Productor es null."); 
        } 
    }

    @Override
    public void crearListaActores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/Files/Small-Actores.txt", true);
        for(int linea=0;linea<lineas.length;linea++){
            String[] datos = lineas[linea].split("|");
            IActor act = new Actor(Integer.parseInt(datos[0]),datos[1]);
            this.agregarActor(act);
        }
        
        
    }

    @Override
    public void crearListaDirectores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/Files/Small-Directores.txt", true);
        for(int linea=0; linea<lineas.length;linea++){
           String[] datos = lineas[linea].split("|");
           IDirector dir = new Director(Integer.parseInt(datos[0]),datos[1]);
           this.agregarDiretor(dir);
        }
    }

    @Override
    public void crearListaProductores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearListaPeliculasActores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearListaPeliculasDirectores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearListaPeliculasProductores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
