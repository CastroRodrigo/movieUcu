/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.IDirector;

/**
 * @author Rodrigo Castro
 */
public class Director implements IDirector{

    public Director(Comparable id, String name) {
        this.id = id;
        this.name = name;
    }
    
    private Comparable id;
    private String name;

    @Override
    public Comparable getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
    
}
