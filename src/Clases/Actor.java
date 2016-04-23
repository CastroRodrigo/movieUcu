
package Clases;

import Interfaces.*;

/**
 * @author Rodrigo Castro
 */
public class Actor implements IActor{
    
    private Comparable idActor;
    private String name;
    
    public Actor(Comparable idActor, String name) {
        this.idActor = idActor;
        this.name = name;
    }
    
    @Override
    public Comparable getId() {
        return idActor;
    }

    @Override
    public String getName() {
        return name;
    }
    

    
}
