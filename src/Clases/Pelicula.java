
package Clases;

import Interfaces.*;

/**
 * @author Rodrigo Castro
 */
public class Pelicula implements IPelicula {

    private Comparable IdPelicula;
    private String name;
    private float puntuation;
    private int year;
    private String review;
    private String genre;
    
    /**
     * Constructor de la clase Pelicula
     * @param IdPelicula Id de la pelicula de tipo Comprable
     * @param name Nombre de la pelicula de tipo String
     * @param puntuation Puntuacion de la pelicula de tipo int
     * @param year Año de estreno de la pelicula de tipo int
     * @param review Reseña de la pelicula de tipo String 
     * @param genre Genero de la pelicula de tipo String
     */
    public Pelicula(Comparable IdPelicula, String name, int year,float puntuation, String review, String genre) {
        this.IdPelicula = IdPelicula;
        this.name = name;
        this.puntuation = puntuation;
        this.year = year;
        this.review = review;
        this.genre = genre;
    }
    
   
    @Override
    public Comparable getId() {
        return IdPelicula;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getPuntuation() {
        return puntuation;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String getReview() {
        return review;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public void setId(Comparable id) {
        this.IdPelicula = id;
    }

    @Override
    public void setPuntuation(int puntuation) {
        this.puntuation = puntuation;
    }

    @Override
    public void setYear(int year) {
        this.year = year;

    }

    @Override
    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
}
