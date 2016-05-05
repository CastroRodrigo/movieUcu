
package TAD;

/**
 * @author Rodrigo Castro
 */
public class Lista<E> implements ILista<E> {

    private INodo<E> primero;
    private INodo<E> ultimo;

    public Lista() {
        primero = null;
        ultimo = null;
    }

    public Lista(INodo<E> unNodo) {
        this.primero = unNodo;
        ultimo = primero;
    }

    @Override
    public void insertar(INodo<E> unNodo) {
        if (esVacia()) {
            primero = unNodo;
            ultimo = primero;
        }
        else if (ultimo != null){
            INodo<E> aux = ultimo;
            ultimo.setSiguiente(unNodo);
            ultimo = ultimo.getSiguiente();
        }
        
    }

    @Override
    public INodo<E> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            INodo<E> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        INodo<E> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            INodo<E> temp1 = aux;
            INodo<E> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave) && aux.getSiguiente() == ultimo){
                aux.setSiguiente(null);
                ultimo = aux;
                return true;
            }
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                INodo<E> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            INodo<E> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    @Override
    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            INodo<E> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public INodo<E> getPrimero() {
        return primero;
    }
    
    @Override
    public INodo<E> getUltimo() {
           return ultimo;
    }    
  
}
