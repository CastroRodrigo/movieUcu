
package Interfaces;

/**
 * @author Rodrigo Castro
 */
public interface IPelicula {
    
    /**
     * Metodo que retorna el Id de la pelicula
     * @see Clases.Pelicula#IdPelicula
     * @return Comparable idPelicula
     */
    public Comparable getId();
    
    /**
     * Metodo que retorna el Nombre de la pelicula
     * @see Clases.Pelicula#name
     * @return String name
     */
    public String getName();
    
    /**
     * Metodo que retorna la puntuacion de la pelicula
     * @see Clases.Pelicula#puntuation
     * @return int puntuation
     */
    public int getPuntuation();
    
    /**
     * Metodo que retorna el año de estreno de la pelicula
     * @see Clases.Pelicula#year
     * @return int year
     */
    public int getYear();
    
    /**
     * Metodo que retorna la review de la pelicula 
     * @see Clases.Pelicula#review
     * @return String review 
     */
    public String getReview();
    
    //public ImyList<Actors> getCast();
    
    /**
     * Metodo que retorna el genero de la pelicula
     * @see Clases.Pelicula#genre
     * @return String genre
     */
    public String getGenre();
    
    /**
     * Metodo que setea el Id de la pelicula
     * @param id De tipo Comparable
     */
    public void setId(Comparable id);
    
    /**
     * Metodo que setea el nombre de la pelicula
     * @param name De tipo String
     */
    public void setName(String name);
    
    /**
     * Metodo que setea la puntuación de la pelicula
     * @param puntuation de tipo int
     */
    public void setPuntuation(int puntuation);
    
    /**
     * Metodo que setea el año de la pelicula
     * @param year de tipo int
     */
    public void setYear(int year);
    
    /**
     * Metodo que setea la reseña de la pelicula
     * @param review de tipo String
     */
    public void setReview (String review);
    
    //public void setCast (ImyList<Actors> actorsList);
    
    /**
     * Metodo que setea el genero de la pelicula 
     * @param genre de tipo String 
     */
    public void setGenre (String genre);
    
    

}