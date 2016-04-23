
package Clases;

/**
 * @author Rodrigo Castro
 */
public class Relacion {
    
    private Comparable id;
    private Comparable idPelicula;
    
    /**
     * Metodo que retorna el Id del actor, director o productor asociado
     * a la pelicula
     * @see Actor#idActor
     * @return idActor
     */
     public Comparable getIdActor() {
        return id;
    }
     
     /**
     * Metodo que retorna el Id del actor
     * @see Actor#
     * @return idActor
     */
    public Comparable getIdPelicula() {
        return idPelicula;
    }
    
    
    
}
