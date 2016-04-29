
package Interfaces;

import TAD.*;
import Clases.*;

/**
 * @author Rodrigo Castro
 */
public interface IMovieUcuAdapter {
    
    /**
     * Metodo que crea la lista de Peliculas
     * @see MovieUcuAdapter#listaPeliculas
     */
    public void crearListaPeliculas();
    /**
     * Metodo que crea la lista de Actores
     * @see MovieUcuAdapter#listaActores
     */
    public void crearListaActores();
    
    /**
     * Metodo que crea la lista de Directores
     * @see MovieUcuAdapter#listaDirectores
     */
    public void crearListaDirectores();
    
    /**
     * Metodo que crea la lista de Productores
     * @see MovieUcuAdapter#listaProductores
     */
    public void crearListaProductores();
    
    /**
     * Metodo que crea la lista los actores segun las pelculas que actuaron
     * @see MovieUcuAdapter#listaPeliculasActores
     */
    public void crearListaPeliculasActores();
    /**
     * Metodo que crea la lista los directores segun las pelculas que dirigieron
     * @see MovieUcuAdapter#listaPeliculasDirectores
     */
    public void crearListaPeliculasDirectores();
    
    /**
     * Metodo que crea la lista los productores segun las pelculas que produgeron
     * @see MovieUcuAdapter#listaPeliculasProductores
     */
    public void crearListaPeliculasProductores();
    
    
    /**
     * Metodo que retorna una lista de pelicualas
     * @return Lista de tipo IPelicula
     */
    public Lista<IPelicula> getListPelicula();
    
    /**
     * Metodo que retorna una lista de Actores 
     * @return Lista de tipo IActores
     */
    public Lista<IActor> getListActores();
    
    /**
     * Metodo que retorna una lista de Directores
     * @return Lista de tipo IDirector
     */
    public Lista<IDirector> getListDirectores();
    
    /**
     * Metodo que retorna una lista de Productores
     * @return Lista de tipo IProductor
     */
    public Lista<IProductor> getListProductores();
    
    /**
     * Metodo que retorna una lista que contiene los id de los actores
     * y los id de las peliculas donde estos trabajaron
     * @return Lista de tipo Relacion
     */
    public Lista<Relacion> getPeliculasActores();
    
    /**
     * Metodo que retorna una lista que contiene los id de los directores
     * y los id de las peliculas donde estos trabajaron 
     * @return Lista de tipo Relacion 
     */
    public Lista<Relacion> getPeliculasDirectores();
    
    /**
     * Metodo que retorna una lista que contiene los id de los productores
     * y los id de las peliculas donde estos trabajaron
     * @return Lista de tipo Relacion
     */
    public Lista<Relacion> getPeliculasProductores();
    
    /**
     * Metdo que agrega una pelicula a la lista de peliculas
     * @param pelicula de tipo IPelicula
     */
    public void agregarPelicula(IPelicula pelicula);
    
    /**
     * Metodo que agrega un actor a la liste de actores 
     * @param actor de tipo IActor
     */
    public void agregarActor(IActor actor);
    
    /**
     * Metodo que agrega un director a la lista de directores 
     * @param director de tipo IDirector 
     */
    public void agregarDiretor(IDirector director);
    
    /**
     * Metodo que agrega un productor a la lista de productores
     * @param productor 
     */
    public void agregarProductor (IProductor productor);
    
    /**
     * Metodo que elimina una pelicula de la lista de peliculas 
     * @param idPelicula Es el id de la pelicula de tipo Comparable
     * @return retorna true si la pelicula existe y fue
     * eliminada y false si la lista esta vacia 
     * o no se encuentra el id no existe
     */
    public boolean eliminarPelicula(Comparable idPelicula);
    
    /**
     * Imprime los nobres de todas las peliculas de la lista
     * @return String de todos los nombres de las pelculas
     */
    public String imprimirPeliculas();
    /**
     * Metodo que busca una pelicula por su Id
     * @param IdPelicula Id de la pelicula a buscar de tipo Comparable
     * @return La pelicula correspondiente
     * o null si el id no existe o la lista esta vacia 
     */
    public IPelicula buscarPelicula (Comparable IdPelicula);
    
    
}
