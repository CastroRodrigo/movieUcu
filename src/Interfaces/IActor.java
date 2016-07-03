package Interfaces;

/**
 * @author Rodrigo Castro
 */
public interface IActor {
    
    /**
     * Metodo que retorna el Id del actor
     * @return id de tipo Comparable
     */
    public Comparable getId();
    
    /**
     * Metodo que retorna el nombre del actor
     * @return name de tipo String
     */
    public String getName();
    
    /**
     * Metodo que retorna la fecha de nacimiento del actor
     * @return  nacimiento de tipo string
     */
    public String getFechaNaciemiento();
    
    /**
     * Metodo que retorna el lugar de nacimiento
     * @return  lugarNacimiento de tipo String
     */
    public String getLugarNacimiento();
    
    /**
     * Metodo que retorna una biografia del actor
     * @return biografia de tipo String
     */
    public String getBiografia();
    
    
}
