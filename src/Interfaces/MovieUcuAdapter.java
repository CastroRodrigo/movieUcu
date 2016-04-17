
package Interfaces;

import TAD.*;
import Interfaces.*;

/**
 *
 * @author Rodrigo Castro
 */
public interface MovieUcuAdapter {
    
    public Lista getListPelicula();
    
    public void agregarPelicula();
    
    public boolean eliminarPelicula(Comparable idPelicula);
    
    /**
     * Imprime los nobres de todas las peliculas de la lista
     * @return String de todos los nombres de las pelculas
     */
    public String imprimirPeliculas();
    
    public IPelicula buscarPelicula (Comparable IdPelicula);
    
    
}
