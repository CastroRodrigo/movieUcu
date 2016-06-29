
package TAD;

/**
 * @author Rodrigo Castro
 */
public interface IElementoAB<T> {
    
    /**
	 * Obtiene el valor de la etiqueta del nodo.
	 * @return Etiqueta del nodo.
	 */
	public Comparable getEtiqueta();
        
	
	/**
	 * Obtiene el hijo izquierdo del nodo.
	 * @return Hijo Izquierdo del nodo.
	 */
	public IElementoAB getHijoIzq();
	
	/**
	 * Obtiene el hijo derecho del nodo.
	 * @return Hijo derecho del nodo.
	 */
	public IElementoAB getHijoDer();
	
	/**
	 * Asigna el hijo izquierdo del nodo.
	 * @return Elemento a ser asignado como hijo izquierdo.
	 */
	public void setHijoIzq(IElementoAB elemento);

	/**
	 * Asigna el hijo derecho del nodo.
	 * @return Elemento a ser asignado como hijo derecho.
	 */
	public void setHijoDer(IElementoAB elemento);
        
        /**
	 * Retorna los datos contenidos en el elemento.
	 * @return
	 */
        public T getDatos();

	/**
	 * Busca un elemento dentro del arbol con la etiqueta indicada.
	 * @param unaEtiqueta del nodo a buscar
	 * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
	 */
	public IElementoAB buscar(Comparable unaEtiqueta, Integer[] contador);
	
	/**
	 * 
	 * Inserta un elemento dentro del arbol.
	 *  en el contador devuelve la cantidad de llamadas realizadas
	 * @param elemento Elemento a insertar.
	 * @return Exito de la operaci�n.
	 * 	 * @param contador Vector de 1 solo elemento conteniendo el contador de llamadas
	 * @return Exito de la operaci�n
	 */
	
	public boolean insertar(IElementoAB elemento, Integer[] contador);
	
	
	
	/**
	 * Inserta un elemento dentro del arbol.
	 * @param elemento Elemento a insertar.
	 * @return Exito de la operaci�n.
	 */
	public boolean insertar(IElementoAB elemento);
	
	/**
	 * Imprime en preorden el arbol separado por guiones. 
	 * @return String conteniendo el PreOrden
	 */
	public String preOrden();
	
	/**
	 * Imprime en inorden el arbol separado por guiones. 
	 * @return String conteniendo el InOrden
	 */
	public String inOrden();
	
	/**
	 * Imprime en postorden el arbol separado por guiones. 
	 * @return String conteniendo el PostOrden
	 */
	public String postOrden();
	
	/**
	 * Retorna la altura del arbol cuya raiz es la del nodo actual.
	 * @return Altura del subarbol.
	 */
	public int obtenerAltura();
	
	/**
	 * Retorna el tama�o del arbol cuya raiz es la del nodo actual.
	 * @return Tama�o del subarbol.
	 */
	public int obtenerTamanio();
	
	/**
	 * Retorna el nivel del elemento cuya etiqueta es la pasada por par�metro.
	 * @param unaEtiqueta
	 * @return Nivel
	 */
	public int obtenerNivel(Comparable unaEtiqueta);
	
	/**
	 * Retorna la cantidad de hojas del arbol cuya raiz es la del nodo actual.
	 * @return Cantidad de hojas del subarbol.
	 */
	public int obtenerCantidadHojas();

	/**
	 * Lista las hojas del subarbol junto con su nivel.
	 */
	public void listarHojas();

	/**
	 * Retorna el elemento cuya clave es la m�nima del subarbol.
	 * @return Clave m�nima del subarbol.
	 */
	public IElementoAB encontrarMinimo();

	/**
	 * Retorna el elemento cuya clave es la maxima del subarbol.
	 * @return Clave maxima del subarbol.
	 */
	public IElementoAB encontrarMaximo();
	
	/**
	 * Retorna el elemento inmediatamente anterior.
	 * @return
	 */
	public IElementoAB lexicograficamenteAnterior(Comparable clave, IElementoAB nodo);
        
        /**
         * Retorna la cantidad de nodos que contiene el arbol segun su nivel
         * @param nivel de tipo entero
         * @return La cantidad de nodos en el nivel correspondiente
         */
        public int obtenerCantNodosNivel(int nivel);
        
        /**
         * Retorna el elemento que tenga la etiqueta que se desa eliminar
         * @param unaEtiqueta de tipo Comparable
         * @return Un IElemento que tenga la clave que se busca
         */
        public IElementoAB eliminar (Comparable unaEtiqueta);
        
        /**
         * Retorna el nodo desde el que se invoca el metodo
         * @return Un IElemento 
         */
        public IElementoAB quitaElNodo();
        
        /**
         * Retorna la suma de las claves segun su nivel
         * @param nivel de tipo Integer
         * @param suma de tipo Integer
         * @return  un  Integer con el valor de la suma de las claves segun su nivel
         */
        public Integer sumaClavePorNivel(Integer nivel, Integer suma);
    
    
    
}
