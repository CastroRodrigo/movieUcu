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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarDiretor(IDirector director) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarProductor(IProductor productor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearListaActores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearListaDirectores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
