/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 * @author Rodrigo Castro
 */
public interface IProductor {
    
    
     /**
     * Metodo que retorna el id del Productor
     * @return id de tipo Comparable
     */
    public Comparable getId();
    
    /**
     * Metodo que retorna el Nombre del Productor
     * @return name de tipo String
     */
    public String getName();
    
}
