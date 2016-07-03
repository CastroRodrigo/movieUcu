
package TAD;

/**
 * @author Rodrigo Castro
 */
public class ArbolBB<T> implements IArbolBB<T> {
    
    protected IElementoAB raiz;    

    
    
    public ArbolBB() {        
               
    }
    
    public IElementoAB getRaiz(){
        return raiz;
    }
            
    @Override
    public boolean insertar(IElementoAB unElemento) {
        if (raiz == null){
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    @Override
    public boolean insertar(IElementoAB unElemento, Integer[] contador) {
        boolean resultado = false;
        if (raiz == null){
            raiz = unElemento;
            contador[0] = 1; //Si inserta el primer elemento.
            return true;
        } else {
            contador [0] = 0;
            resultado = raiz.insertar(unElemento, contador);
            System.out.println(contador[0]);/* Muestra por consola el contenido            
                                                           final del contador */            
            return resultado;
        }        
    }

    @Override
    public IElementoAB buscar(Comparable unaEtiqueta) {
        IElementoAB resultado = null;
        if (raiz == null) {
		return null;
	} else {
	    resultado = raiz.buscar(unaEtiqueta);     
            return resultado;
	}
    }

    @Override
    public String preOrden() {        
        if (raiz == null){
            return "arbol vacio";
        }else {
            return raiz.preOrden();
        }        
    }

    @Override
    public String inOrden() {
         if (raiz == null){
            return "arbol vacio";
        }else {
            return raiz.inOrden();
        }
    }

    @Override
    public String postOrden() {
        if (raiz == null){
            return "arbol vacio";
        }else {
            return raiz.postOrden();
        }
    }

    @Override
    public int obtenerAltura() {
        if (raiz == null){
            return -1;
        }else {
            return raiz.obtenerAltura();
        }        
    }

    @Override
    public int obtenerTamanio() {
        if (raiz == null){
            return 0;
        }else {
            return raiz.obtenerTamanio();
        }       
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (raiz == null){
            return -1;
        }else {;
            if(raiz.obtenerNivel(unaEtiqueta) < 0){
                return -1;
            }else{
                return raiz.obtenerNivel(unaEtiqueta);
            }
        }     
    }

    @Override
    public int obtenerCantidadHojas() {
        if (raiz == null){
            return 0;
        }else {
            return raiz.obtenerCantidadHojas();
        }
    }

    @Override
    public void listarHojas() {
        if (raiz == null){
            System.out.println("El árbol se encuentra vacío");
        }else {
            raiz.listarHojas();
        }
    }

    @Override
    public IElementoAB encontrarMinimo() {
        IElementoAB resultado = null;
        if (raiz != null){
            resultado = raiz.encontrarMinimo();
        }
        return resultado;
    }

    @Override
    public IElementoAB encontrarMaximo() {
        IElementoAB resultado = null;
        if (raiz != null){
            resultado = raiz.encontrarMaximo();
        }
        return resultado;
    }

    @Override
    public IElementoAB lexicograficamenteAnterior(Comparable unaClave) {
        IElementoAB resultado = null;
        if ( raiz != null){
            return raiz.lexicograficamenteAnterior(unaClave,resultado);                        
        }        
        return resultado;
    }

    @Override
    public int obtenerCantNodosNivel(int nivel) {
       if (raiz == null){
            return 0;
        }else {
            return raiz.obtenerCantNodosNivel(nivel);
        }
    }

    @Override
    public boolean esDeBusqueda() {        
        String aAnalizar = raiz.inOrden();
        String [] nodos = aAnalizar.split(" ");
        for (int i = 1; i < nodos.length; i ++){
            if (Integer.parseInt(nodos[i-1].trim()) > Integer.parseInt(nodos[i].trim())){
                return false;
            }           
        }
        return true;
            
    }
    
    @Override
    public void eliminar (Comparable etiqueta){
        if (raiz != null ){
            raiz = raiz.eliminar (etiqueta);
        }
    }
    
    @Override
    public Integer sumaClavePorNivel(Integer nivel){
        if (raiz == null){
            return 0;
        }else{
            Integer suma = 0;
            suma = raiz.sumaClavePorNivel(nivel, suma);
            return suma;
        }
        
    }
    @Override
    public boolean esVacio(){
        return raiz == null;
    }
    
}
