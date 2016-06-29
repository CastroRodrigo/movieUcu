
package Interfaces;

import TAD.*;
import Clases.*;
import java.util.ArrayList;

/**
 * @author Rodrigo Castro
 */
public interface IMovieUcuAdapter {
    
    /**
     * Metodo que retorna una lista con los nombres de las peliculas
     * @return ArrayList de Strings
     */
    public ArrayList<String> obtenerNombrePeliculas ();
    
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
     * @param productor de tipo IProductor
     */
    public void agregarProductor (IProductor productor);
    
    /**
     * Metodo que agrega un element relacion a la lista
     * @param relacion de tipo Relacion
     */
    public void agregarRelacionPeliActor (Relacion relacion);
    
    /**
     * Metodo que agrega un element relacion a la lista
     * @param relacion de tipo Relacion
     */
    public void agregarRelacionPeliDire (Relacion relacion);
    
    /**
     * Metodo que agrega un element relacion a la lista
     * @param relacion de tipo Relacion
     */
    public void agregarRelacionPeliPro (Relacion relacion);
    
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
    
    /**
     * Metod que busca entre los nombre de las peliculas uno o varios que contengan el nombre parametro
     * @param nombre de tipo string
     * @return Una lista con el/los nombres de las peliculas encontradas
     */
    public ArrayList<String> buscarPorNombre(String nombre);
    
    /**
     * Metodo que busca las peliculas segun su año de estreno
     * @param year de tipo int
     * @return Una lista con el/los nombres de las peliculas de ese año
     */
    public ArrayList<String> buscarPorYear(int year);
    
    /**
     * Metodo que busca las peliculas segun su genero
     * @param genero de tipo String
     * @return Una lista con el/los nombres de las peliculas de ese genero
     */
    public ArrayList<String> buscarPorGenero(String genero);
    
    /**
     * Metodo que devuelve toda la informacion relacionada con una pelicula en concreto
     * @param nombreExacto de tipo string
     * @return Un String con toda la informacion ej: id, nombre, actores, etc.
     */
    public String obtenerInfoPelicula(String nombreExacto);
    
    
}
