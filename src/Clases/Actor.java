
package Clases;

/**
 * @author Rodrigo Castro
 */
public class Actor implements Interfaces.IActor{
    
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

    @Override
    public void setId(Comparable id) {
        this.idActor = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    

    
}
