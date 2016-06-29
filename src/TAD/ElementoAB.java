
package TAD;

/**
 * @author Rodrigo Castro
 */
public class ElementoAB<T> implements IElementoAB<T> {
    
    private Comparable etiqueta;
    protected IElementoAB hijoIzq;
    protected IElementoAB hijoDer;
    private T datos;
    

    public ElementoAB(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.datos = dato;
        this.hijoDer = null;
        this.hijoIzq = null;        
    }
    

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public IElementoAB getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public IElementoAB getHijoDer() {
        return this.hijoDer;
    }
    
    @Override
    public T getDatos() {
        return this.datos;
    }
    
    @Override
    public void setHijoIzq(IElementoAB elemento) {
        hijoIzq = elemento;
    }

    @Override
    public void setHijoDer(IElementoAB elemento) {
       hijoDer = elemento;
    }

    @Override
    public IElementoAB buscar(Comparable unaEtiqueta, Integer[] contador) {
        contador[1]+=1; //Incrementa el contador en cada invocación al mimso.
        if (unaEtiqueta.compareTo(etiqueta) == 0) {            
            return this;
        } else {
            if (unaEtiqueta.compareTo(etiqueta) < 0) {
                if (hijoIzq != null) {                    
                    return hijoIzq.buscar(unaEtiqueta, contador);
                } else {
                    contador [1] = -1 * contador[1]; /*Si la clave no se 
                              encuentra retorna el contador con valor negativo*/
                    return null;
                }
            } else {
                if (unaEtiqueta.compareTo(etiqueta) > 0) {
                    if (hijoDer != null) {                       
                        return hijoDer.buscar(unaEtiqueta,contador);
                    } else {
                        contador [1] = -1 * contador[1]; /*Si la clave no se 
                              encuentra retorna el contador con valor negativo*/
                        return null;
                    }
                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public boolean insertar(IElementoAB elemento, Integer[] contador) {       
        contador [0]++; //Incrementa el contador en cada invocación al mimso.
        if (elemento.getEtiqueta().compareTo(this.etiqueta) == 0){
            contador [0] = 0; //Si el elemento no se inserta, contador = 0;
            return false;
        }
        if(elemento.getEtiqueta().compareTo(this.etiqueta) < 0 ){
            if (hijoIzq == null){
                hijoIzq = elemento;                
                return true;
            }else{
                hijoIzq.insertar(elemento, contador);                
                return true;
            }
        }else {
            if (hijoDer == null){
                hijoDer = elemento;                
                return true;
            }else{
                hijoDer.insertar(elemento, contador);                
                return true;
            }
        }        
    }

    @Override
    public boolean insertar(IElementoAB elemento) {
        if (elemento.getEtiqueta().compareTo(this.etiqueta)== 0){
            return false;
        }
        if(elemento.getEtiqueta().compareTo(this.etiqueta) < 0 ){
            if (hijoIzq == null){
                hijoIzq = elemento;
                return true;
            }else{
                hijoIzq.insertar(elemento);
                return true;
            }
        }else {
            if (hijoDer == null){
                hijoDer = elemento;
                return true;
            }else{
                hijoDer.insertar(elemento);
                return true;
            }
        }        
    }

    @Override
    public String preOrden() {
        String temp = "";
        temp = temp + " " + etiqueta;
        if (hijoIzq != null){
            temp = temp + hijoIzq.preOrden();   
        }
        if (hijoDer != null){
            temp = temp + hijoDer.preOrden();    
        }
        return temp;
    }

    @Override
    public String inOrden(){
        String temp="";
        if(hijoIzq!=null){
            temp = hijoIzq.inOrden() + " ";
        }
        temp += this.etiqueta;
        if (hijoDer!=null){
            temp = temp + " " + hijoDer.inOrden();
        }
        return temp;
    }

    @Override
    public String postOrden(){
        String temp="";
        if(hijoIzq!=null){
            temp = hijoIzq.postOrden();
        }        
        if (hijoDer!=null){
            temp = temp + hijoDer.postOrden();
        }
        temp = temp + " " + etiqueta;
        return temp;
    }

    @Override
    public int obtenerAltura() {
        if (hijoIzq == null && hijoDer == null){
            return 0;            
        }else if (hijoIzq == null && hijoDer != null){
            return 1 + hijoDer.obtenerAltura();
        }else if (hijoDer == null && hijoIzq != null){
            return 1 + hijoIzq.obtenerAltura();
        }else{
            return 1 + Math.max(hijoIzq.obtenerAltura(),hijoDer.obtenerAltura());
        }               
    }

    @Override
    public int obtenerTamanio() {
        if (hijoIzq == null && hijoDer == null){
            return 1;            
        }else if (hijoIzq == null && hijoDer != null){
            return 1 + hijoDer.obtenerTamanio();
        }else if (hijoDer == null && hijoIzq != null){
            return 1 + hijoIzq.obtenerTamanio();
        }else{
            return 1 + hijoIzq.obtenerTamanio() + hijoDer.obtenerTamanio(); 
        }
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {        
        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            return 0;
            } else {
                if (unaEtiqueta.compareTo(etiqueta) < 0) {                    
                    if (hijoIzq != null) {                    
                        return 1 + hijoIzq.obtenerNivel(unaEtiqueta);
                    } else {                        
                        return -10000;
                    }
                } else {
                    if (unaEtiqueta.compareTo(etiqueta) > 0) {                        
                        if (hijoDer != null) {                       
                            return 1 + hijoDer.obtenerNivel(unaEtiqueta);
                        } else {                            
                            return -10000;
                        }
                    }else {
                        return -10000;
                    }
                }
            }        
    }

    @Override
    public int obtenerCantidadHojas() {
        if (hijoIzq == null && hijoDer == null){
            return 1;            
        }else if (hijoIzq == null && hijoDer != null){
            return 0 + hijoDer.obtenerCantidadHojas();
        }else if (hijoDer == null && hijoIzq != null){
            return 0 + hijoIzq.obtenerCantidadHojas();
        }else{
            return hijoIzq.obtenerCantidadHojas()+hijoDer.obtenerCantidadHojas(); 
        }
    }

    @Override
    //retornaba un int
    public void listarHojas() {
        IElementoAB referencia = this;
        if (hijoIzq == null && hijoDer == null){            
            System.out.println(this.getEtiqueta().toString()) ;
            
        }else if (hijoIzq == null && hijoDer != null){            
            hijoDer.listarHojas();
        }else if (hijoDer == null && hijoIzq != null){            
            hijoIzq.listarHojas();
        }else{            
            hijoIzq.listarHojas();
            hijoDer.listarHojas();
            
        }
    }  
   
    
    @Override
    public IElementoAB encontrarMinimo() {
        IElementoAB resultado = this;
        if (hijoIzq != null){
            resultado = hijoIzq.encontrarMinimo();
        }
        return resultado;
    }

    @Override
    public IElementoAB encontrarMaximo() {
        IElementoAB resultado = this;
        if (hijoDer != null){
            resultado = hijoDer.encontrarMaximo();
        }
        return resultado;
    }

    @Override
    public IElementoAB lexicograficamenteAnterior(Comparable clave, IElementoAB nodo) {
        if (this.getEtiqueta().compareTo(clave)==0){
            return nodo;
        }
        
        if(hijoIzq!=null && this.getEtiqueta().compareTo(clave)==1){
            return hijoIzq.lexicograficamenteAnterior(clave, nodo);
        }
        nodo=this;
        
        if (hijoDer!=null && this.getEtiqueta().compareTo(clave)==-1){
            return hijoDer.lexicograficamenteAnterior(clave, nodo);
        }
        return nodo;
    }
    
    @Override
    public int obtenerCantNodosNivel(int nivel){
        if (nivel == 0){
            return 1;
        }else if (hijoIzq == null && hijoDer == null && nivel > 0){
            return 0;
        }else if (hijoIzq == null && hijoDer != null){
            return 0 + hijoDer.obtenerCantNodosNivel(nivel-1);
        }else if (hijoDer == null && hijoIzq != null){
            return 0 + hijoIzq.obtenerCantNodosNivel(nivel-1);
        }else{
            return hijoIzq.obtenerCantNodosNivel(nivel-1)+ hijoDer.obtenerCantNodosNivel(nivel-1); 
        }   
    }
    @Override
    public IElementoAB eliminar (Comparable unaEtiqueta){
        if (unaEtiqueta.compareTo(etiqueta) < 0){
            if ( hijoIzq != null){
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(etiqueta) > 0){
            if ( hijoDer != null){
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return this.quitaElNodo();        
    }
    @Override
    public IElementoAB quitaElNodo(){
        if (hijoIzq == null && hijoDer == null){
            return null;            
        }else if (hijoIzq == null){
            return hijoDer;        
        }else if (hijoDer == null){
            return hijoIzq;
        }else {
            IElementoAB elHijo = hijoIzq;
            IElementoAB elPadre = this;
            while(elHijo.getHijoDer() != null){
                elPadre = elHijo;
                elHijo = elHijo.getHijoDer();
            }
            if(elPadre != this){
                elPadre.setHijoDer(elHijo.getHijoIzq()); 
                elHijo.setHijoIzq(hijoIzq);
            }
            elHijo.setHijoDer(hijoDer);
            return elHijo;
        }
    }
    @Override
    public Integer sumaClavePorNivel(Integer nivel, Integer suma){
        
        if (nivel == 0){
            suma  = suma + (int) etiqueta ;            
            
        }else if (nivel > 0){
            nivel = nivel - 1;
            if (hijoIzq != null){
               suma = hijoIzq.sumaClavePorNivel(nivel, suma);
            }
            if (hijoDer != null){
                suma = hijoDer.sumaClavePorNivel(nivel, suma);
            }
            
        }else{
            suma = -1;
        }
        return suma;
        
    }
    
    
}
