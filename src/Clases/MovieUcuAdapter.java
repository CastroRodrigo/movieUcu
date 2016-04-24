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
        INodo<IPelicula> nuevaPelicula = new Nodo(pelicula, pelicula.getId());
        listaPeliculas.insertar(nuevaPelicula);
    }

    @Override
    public boolean eliminarPelicula(Comparable idPelicula) {
        if (listaPeliculas.esVacia()){
            return false;
        }
        else{
            INodo resultado = listaPeliculas.buscar(idPelicula);
            if (resultado == null){
                return false;
            }  
        }
        return true;
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
    public void crearListas() {
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
    
}
