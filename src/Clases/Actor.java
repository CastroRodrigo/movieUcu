
package Clases;

import Interfaces.*;

/**
 * @author Rodrigo Castro
 */
public class Actor implements IActor{
    
    private Comparable idActor;
    private String name;
    private String nacimiento;
    private String lugarNacimiento;
    private String biografia;
    
    public Actor(Comparable idActor, String name) {
        this.idActor = idActor;
        this.name = name;
    }
    
    public Actor(Comparable idActor, String name, String nacimietno, String lugarNacimiento, String biografia){
        this.idActor = idActor;
        this.name = name;
        this.nacimiento = nacimiento;
        this.lugarNacimiento = lugarNacimiento;
        this.biografia = biografia;
        
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
    public String getFechaNaciemiento() {
        return nacimiento;
    }

    @Override
    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    @Override
    public String getBiografia() {
        return biografia;
    }
    

    
}
