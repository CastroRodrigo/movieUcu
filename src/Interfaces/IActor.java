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
     * Metodo que setea el id de la actor 
     * @param id de tipo Comparable
     */
    public void setId(Comparable id);
    
    /**
     * Metodo que setea el nombre del actor
     * @param name de tipo String
     */
    public void setName(String name);
    
}
