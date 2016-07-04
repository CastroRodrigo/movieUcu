
package Clases;

import Interfaces.IActor;
import Interfaces.IDirector;
import Interfaces.IPelicula;
import Interfaces.IProductor;
import TAD.Lista;
import TAD.ArbolBB;
import TAD.ElementoAB;
import TAD.IElementoAB;
import TAD.INodo;
import TAD.Nodo;
import java.util.ArrayList;

/**
 * @author Rodrigo Castro
 */
public class Adapter  {

    ArbolBB<IActor> arbolActores;
    ArbolBB<IPelicula> arbolPeliculas;
    ArbolBB<IDirector> arbolDirectores;
    ArbolBB<IProductor> arbolProductores;
    Lista<Relacion> listaPeliculasActores;
    Lista<Relacion> listaPeliculasDirectores;
    Lista<Relacion> listaPeliculasProductores;
    ArrayList<String> listaBusquedas;
    StringBuilder infoPelicula;
    String textoProductores = "src/Files/Smallv2-Productores.csv";
    String textoDirectores = "src/Files/Smallv2-Directores.csv" ;
    String textoActores = "src/Files/Smallv2-Actores.csv";
    String textoPelicula = "src/Files/Smallv2-Peliculas.csv";
    String textoPeliculasActores = "src/Files/Smallv2-PeliculasActores.csv";
    String textoPeliculasDirectores = "src/Files/Smallv2-PeliculasDirectores.csv";
    String textoPeliculasProductores = "src/Files/Smallv2-PeliculasProductores.csv";
    
    /**
     * Metodo que retorna el arbol de prliculas
     * @return arbolPeliculas de tipo ArbolBB
     */
    public ArbolBB<IPelicula> getArbolPeliculas(){
        return arbolPeliculas;
    }
    /**
     * Metdo que retorna el Arbol de Actores
     * @return arbolActores de tipo ArbolBB
     */
    public ArbolBB<IActor> getArbolActores(){
        return arbolActores;
    }
    
    /**
     * Metodo que retorna el Arbol de directores
     * @return arbolDirectores de tipo ArbolBB
     */
    public ArbolBB<IDirector> getArbolDirectores(){
        return arbolDirectores;
    }
    
    /**
     * Metodo que retorna el arbol de productores
     * @return arbolProductores de tipo ArbolBB 
     */
    public ArbolBB<IProductor> getArbolProductores(){
        return arbolProductores;
    }
    
    /**
     * Metodo que retorna un Array con los nombres de las peliculas
     * @param elemento nodo raiz del arbol
     * @param resultado array con los nombres de las peliculas
     * @return resultado array con los nombres de las peliculas
     */
    public ArrayList<String> obtenerNombrePeliculas(IElementoAB<IPelicula> elemento, ArrayList<String> resultado) {
        if (elemento!= null){
            resultado.add(elemento.getDatos().getName());
            if(elemento.getHijoIzq()!= null){
                obtenerNombrePeliculas(elemento.getHijoIzq(),resultado);
            }
            if(elemento.getHijoDer()!= null){
                obtenerNombrePeliculas(elemento.getHijoDer(), resultado);   
            }
        }
        return resultado;
    }
    /**
     * Metodo que retorna un Array con los nombres de los actores
     * @param elemento nodo raiz del arbol
     * @param resultado array con los nombres de los actores
     * @return resultado array con los nombres de los actores
     */
    public ArrayList<String> obtenerNombreActores(IElementoAB<IActor> elemento, ArrayList<String> resultado){
        if (elemento!= null){
            resultado.add(elemento.getDatos().getName());
            if(elemento.getHijoIzq()!= null){
                obtenerNombreActores(elemento.getHijoIzq(),resultado);
            }
            if(elemento.getHijoDer()!= null){
                obtenerNombreActores(elemento.getHijoDer(),resultado);
            }
        }
        return resultado;
    }
    
    /**
     * Metodo que retorna un Array con los nombres de los productores
     * @param elemento nodo raiz del arbol
     * @param resultado array con los nombres de los productores
     * @return resultado array con los nombres de los productores
     */
    public ArrayList<String> obtenerNombreProductores (IElementoAB<IProductor> elemento, ArrayList<String> resultado){
        if(elemento != null){
            resultado.add(elemento.getDatos().getName());
            if(elemento.getHijoIzq()!= null){
                obtenerNombreProductores(elemento.getHijoIzq(),resultado);
            }
            if(elemento.getHijoDer()!= null){
                obtenerNombreProductores(elemento.getHijoDer(),resultado);
            }
        }
        
        return resultado;
    }

    /**
     * Metodo que retorna un Array con los nombres de los directores
     * @param elemento nodo raiz del arbol
     * @param resultado array con los nombres de los directores
     * @return resultado array con los nombres de los directores
     */
    public ArrayList<String> obtenerNombreDirectores( IElementoAB<IDirector> elemento, ArrayList<String> resultado){
        if(elemento != null){
            resultado.add(elemento.getDatos().getName());
            if(elemento.getHijoIzq()!= null){
                obtenerNombreDirectores(elemento.getHijoIzq(),resultado);
            }
            if(elemento.getHijoDer()!= null){
                obtenerNombreDirectores(elemento.getHijoDer(),resultado);
            }
        }
        
        return resultado;
    }
    /**
     * Metodo Almacen que utiliza una estructura de arbol binario para almacenar las peliculas
     */
    public void crearAlmacenPeliculas() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoPelicula, false);
        for(int linea=0;linea<lineas.length;linea++){
                String[] datos = lineas[linea].split("\\|",-1);
                if(datos[2].compareTo("") == 0){
                    datos[2]= "-1";
                }
                if(datos[3].compareTo("") == 0){
                    datos[3]= "-1";
                }
                IPelicula peli = new Pelicula(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]),Float.parseFloat(datos[3]),datos[4],datos[5]);
                this.agregarPelicula(peli);
        }
    }

    /**
     * Metodo Almacen que utiliza una estructura de arbol binario para almacenar las actores
     */
    public void crearAlmacenActores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoActores, false);
        for(int linea=0;linea<lineas.length;linea++){
                String[] datos = lineas[linea].split("\\|",-1);
                if(datos[0].compareTo("") == 0){
                    datos[0]= "-1";
                }
                IActor act = new Actor(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],datos[4]);
                this.agregarActor(act);
            }
    }

    /**
     * Metodo Almacen que utiliza una estructura de arbol binario para almacenar las directores
     */
    public void crearAlmacenDirectores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoDirectores, false);
        for(int linea=0; linea<lineas.length;linea++){
                String[] datos = lineas[linea].split("\\|",-1);
                if(datos[0].compareTo("") == 0){
                    datos[0]= "-1";
                }
                IDirector dir = new Director(Integer.parseInt(datos[0]),datos[1]);
                this.agregarDiretor(dir);
            }
    }

    /**
     * Metodo Almacen que utiliza una estructura de arbol binario para almacenar las productores
     */
    public void crearAlmacenProductores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoProductores, false);
        for(int linea=0; linea<lineas.length;linea++){
                String[] datos = lineas[linea].split("\\|",-1);
                if(datos[0].compareTo("") == 0){
                    datos[0]= "-1";
                }
                IProductor pro = new Productor(Integer.parseInt(datos[0]),datos[1]);
                this.agregarProductor(pro);
            }
    }

    /**
     * Metodo que agrega los elementos a la lista de relaciones
     */
    public void crearListaPeliculasActores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoPeliculasActores, false);
        for(int linea=0; linea<lineas.length;linea++){
                String[] datos = lineas[linea].split("\\|",-1);
                if(datos[0].compareTo("") == 0){
                    datos[0]= "-1";
                }
                if (datos[1].compareTo("") == 0){
                    datos[1] = "-1";
                }
                Relacion peliActor = new Relacion(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
                this.agregarRelacionPeliActor(peliActor);
            }
    }

    /**
     * Metodo que agrega los elementos a la lista de relaciones
     */
    public void crearListaPeliculasDirectores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoPeliculasDirectores, false);
        for(int linea=0; linea<lineas.length;linea++){
                String[] datos = lineas[linea].split("\\|",-1);
                if(datos[0].compareTo("") == 0){
                    datos[0]= "-1";
                }
                if (datos[1].compareTo("") == 0){
                    datos[1] = "-1";
                }
                Relacion peliDire = new Relacion(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
                this.agregarRelacionPeliDire(peliDire);
            }
    }

    /**
     * Metodo que agrega los elementos a la lista de relaciones
     */
    public void crearListaPeliculasProductores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoPeliculasProductores, false);
        for(int linea=0; linea<lineas.length;linea++){
                String[] datos = lineas[linea].split("\\|",-1);
                if(datos[0].compareTo("") == 0){
                    datos[0]= "-1";
                }
                if (datos[1].compareTo("") == 0){
                    datos[1] = "-1";
                }
                Relacion peliPro = new Relacion(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
                this.agregarRelacionPeliPro(peliPro);
            }
    }

    /**
     * Metodo que inserta una peliculas al arbol/lista
     * @param pelicula de tipo IPelicula
     */
    public void agregarPelicula(IPelicula pelicula) {
        if(pelicula != null){
            if(this.arbolPeliculas == null){
                this.arbolPeliculas = new ArbolBB<>();
            }
            IElementoAB<IPelicula> nuevaPelicula = new ElementoAB (pelicula.getId(),pelicula);
            this.arbolPeliculas.insertar(nuevaPelicula);
        }
        else{
            throw new NullPointerException("La pelicula es null.");
        }
    }

    /**
     * Metodo que inserta un actor al arbol/lista
     * @param actor de tipo IActor
     */
    public void agregarActor(IActor actor) {
        if (actor != null ){
            if(this.arbolActores == null){
                this.arbolActores = new ArbolBB<>();
            }
            IElementoAB<IActor> nuevoActor = new ElementoAB(actor.getId(), actor);
            this.arbolActores.insertar(nuevoActor);
        }
        else{
            throw new NullPointerException("El Actor es null."); 
        }
    }

    /**
     * Metodo que inserta un director al arbol/lista
     * @param director de tipo IDirector
     */
    public void agregarDiretor(IDirector director) {
        if (director != null ){
            if(this.arbolDirectores == null){
                this.arbolDirectores = new ArbolBB<>();
            }
            IElementoAB<IDirector> nuevoDirector = new ElementoAB(director.getId(), director);
            this.arbolDirectores.insertar(nuevoDirector);
        }
        else{
            throw new NullPointerException("El Director es null."); 
        } 
    }

    /**
     * Metodo que inserta un director al arbol/lista
     * @param productor de tipo IDirector
     */
    public void agregarProductor(IProductor productor) {
        if (productor != null ){
            if(this.arbolProductores == null){
                this.arbolProductores = new ArbolBB<>();
            }
            IElementoAB<IProductor> nuevoProductor = new ElementoAB(productor.getId(),productor);
            this.arbolProductores.insertar(nuevoProductor);
        }
        else{
            throw new NullPointerException("El Productor es null."); 
        } 
    }

    /**
     * Metodo que inserta una relacion a una lista/arbol
     * @param relacion de tipo Relacion
     */
    public void agregarRelacionPeliActor(Relacion relacion) {
        if (relacion != null ){
            if(this.listaPeliculasActores == null){
                this.listaPeliculasActores = new Lista<>();
            }
            INodo<Relacion> nuevaRelacion = new Nodo(relacion,relacion.getIdPelicula());
            this.listaPeliculasActores.insertar(nuevaRelacion);
        }
        else{
            throw new NullPointerException("La Relacion es null."); 
        } 
    }

    /**
     * Metodo que inserta una relacion a una lista/arbol
     * @param relacion de tipo Relacion
     */
    public void agregarRelacionPeliDire(Relacion relacion) {
        if (relacion != null ){
            if(this.listaPeliculasDirectores == null){
                this.listaPeliculasDirectores = new Lista<>();
            }
            INodo<Relacion> nuevaRelacion = new Nodo(relacion,relacion.getIdPelicula());
            this.listaPeliculasDirectores.insertar(nuevaRelacion);
        }
        else{
            throw new NullPointerException("La Relacion es null."); 
        } 
    }

    /**
     * Metodo que inserta una relacion a una lista/arbol
     * @param relacion de tipo Relacion
     */
    public void agregarRelacionPeliPro(Relacion relacion) {
        if (relacion != null ){
            if(this.listaPeliculasProductores == null){
                this.listaPeliculasProductores = new Lista<>();
            }
            INodo<Relacion> nuevaRelacion = new Nodo(relacion,relacion.getIdPelicula());
            this.listaPeliculasProductores.insertar(nuevaRelacion);
        }
        else{
            throw new NullPointerException("La Relacion es null."); 
        } 
    }

    /**
     * Metodo que elimina una pelicula del arbol/lista
     * @param idPelicula de tipo Comparable
     * @return true or false
     */
    public boolean eliminarPelicula(Comparable idPelicula) {
        if(arbolPeliculas.getRaiz() != null){
            IElementoAB resultado = arbolPeliculas.getRaiz().eliminar(idPelicula);
            if (resultado != null){
                return true;
            }
        }
        return false;
    }

    public String imprimirPeliculas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo que permite buscar una pelicula por id
     * @param IdPelicula de tipo omparable
     * @return 
     */
    public IPelicula buscarPelicula(Comparable IdPelicula) {
        IElementoAB<IPelicula> aux = arbolPeliculas.buscar(IdPelicula);
        return aux.getDatos();
    }

    /**
     * Metodo que permite buscar una pelicula por nombre
     * @param nombre de tipo String
     * @param elemento de tipo IElementoAB
     * @param resultado de tipo ArrayList
     * @return resultado de tipo ArrayList
     */
    public ArrayList<String> buscarPorNombre(String nombre, IElementoAB<IPelicula> elemento, ArrayList<String> resultado) {
        if (elemento!= null){
            if( elemento.getDatos().getName().toLowerCase().contains(nombre.toLowerCase())){
                resultado.add(elemento.getDatos().getName());
            }
            if(elemento.getHijoIzq()!= null){
                buscarPorNombre(nombre, elemento.getHijoIzq(),resultado);
            }
            if(elemento.getHijoDer()!= null){
                buscarPorNombre(nombre, elemento.getHijoDer(), resultado);
                
            }
                                
        }
        return resultado;
    }
    
    public ArrayList<String> buscarPorActor(String nombre, IElementoAB<IActor> elemento, ArrayList<String> resultado){
        if(elemento!= null){
            if(elemento.getDatos().getName().trim().toLowerCase().contains(nombre.toLowerCase())){
                INodo<Relacion> aux = listaPeliculasActores.getPrimero();
                while(aux!= null){
                    if(elemento.getDatos().getId() == aux.getDato().getId()){
                        IElementoAB<IPelicula> pelicula = arbolPeliculas.buscar(aux.getDato().getIdPelicula());
                        resultado.add(pelicula.getDatos().getName());
                    }
                    aux = aux.getSiguiente();  
                }   
            }
            if(elemento.getHijoIzq()!= null){
                buscarPorActor(nombre,elemento.getHijoIzq(),resultado);
            }
            if(elemento.getHijoDer()!= null){
                buscarPorActor(nombre,elemento.getHijoDer(),resultado);
            }    
        }
        return resultado;
    }
    
    /**
     * Metodo que permite buscar una pelicula con su nombre exacto
     * @param nombreExacto el nombre exacto de la pelicula
     * @param elemento de tipo IElementoAB
     * @param resultado de tipo Arraylist
     * @return resultado de tipo ArrayList
     */
    public ArrayList<IPelicula> buscarPorNombreExacto(String nombreExacto, IElementoAB<IPelicula> elemento, ArrayList<IPelicula> resultado){
        if (elemento!= null){
            if( elemento.getDatos().getName().contains(nombreExacto)){
                resultado.add(elemento.getDatos());
            }
            if(elemento.getHijoIzq()!= null){
                buscarPorNombreExacto(nombreExacto, elemento.getHijoIzq(),resultado);
            }
            if(elemento.getHijoDer()!= null){
                buscarPorNombreExacto(nombreExacto, elemento.getHijoDer(), resultado);
                
            }
                                
        }
        return resultado;
    }
    
    /**
     * Metodo que permite buscar un actor por su nombre
     * @param nombreExacto Nombre exacto del actor
     * @param elemento de tipo IElemento 
     * @param resultado de tipo ArrayLIst
     * @return resultado de tipo ArrayList
     */
    public ArrayList<IActor> buscarActorPorNombreExacto (String nombreExacto, IElementoAB<IActor> elemento, ArrayList<IActor> resultado){
        if(elemento != null){
            if( elemento.getDatos().getName().contains(nombreExacto)){
                resultado.add(elemento.getDatos());
            }
            if(elemento.getHijoIzq()!= null){
                buscarActorPorNombreExacto(nombreExacto, elemento.getHijoIzq(), resultado);
            }
            if(elemento.getHijoDer()!=null){
                buscarActorPorNombreExacto(nombreExacto, elemento.getHijoDer(), resultado);
            }
        }
        return resultado;
    }

    /**
     * Metodo que permite buscar una pelicula por año
     * @param year año de estreno de lapelicula
     * @param elemento de IElemento
     * @param resultado de tipo ArrayList
     * @return resultado de tipo ArrayList
     */
    public ArrayList<String> buscarPorYear(int year, IElementoAB<IPelicula> elemento, ArrayList<String> resultado) {
        if (elemento!= null){
            if( elemento.getDatos().getYear() == year){
                resultado.add(elemento.getDatos().getName());
            }
            if(elemento.getHijoIzq()!= null){
                buscarPorYear(year, elemento.getHijoIzq(),resultado);
            }
            if(elemento.getHijoDer()!= null){
                buscarPorYear(year, elemento.getHijoDer(), resultado);
            }                     
        }
        return resultado;
        
    }

    /**
     * Metodo que permite buscar una pelicula por genero
     * @param genero de tipo String
     * @param elemento de tipo IElemento
     * @param resultado de tipo ArrayList
     * @return resultado de ArrayList
     */
    public ArrayList<String> buscarPorGenero(String genero, IElementoAB<IPelicula> elemento, ArrayList<String> resultado) {
        if (elemento!= null){
            if( elemento.getDatos().getGenre().toLowerCase().contains(genero.toLowerCase())){
                resultado.add(elemento.getDatos().getName());
            }
            if(elemento.getHijoIzq()!= null){
                buscarPorGenero(genero, elemento.getHijoIzq(),resultado);
            }
            if(elemento.getHijoDer()!= null){
                buscarPorGenero(genero, elemento.getHijoDer(), resultado);
            }                     
        }
        return resultado;
    }
    
    /**
     * Metodo que devuelve una lista con todos los actores de una pelicula en particular
     * @param idPelicula de tipo Comparable
     * @return reparto de tipo ArrayList
     */
    public ArrayList<IActor> obtenerReparto (Comparable idPelicula){
        ArrayList<IActor> reparto = new ArrayList<>();
        INodo<Relacion> auxPeliAct = listaPeliculasActores.getPrimero();
        while (auxPeliAct!= null){
            try{
                if(auxPeliAct.getDato().getIdPelicula().equals(idPelicula)){
                    IElementoAB<IActor> aux = arbolActores.buscar(auxPeliAct.getDato().getId());
                    reparto.add(aux.getDatos()); 
                } 
            }catch(NullPointerException e){
              
            }
            auxPeliAct=auxPeliAct.getSiguiente();
        }
        return reparto;
    }
    
    /**
     * Metodo que devuelve una lista con todos los productores de una pelicula
     * @param idPelicula de tipo comprable
     * @return productores de tipo ArrayList
     */
    public ArrayList<IProductor> obtenerProductoresPorPelicula (Comparable idPelicula){
        ArrayList<IProductor> productores = new ArrayList<>();
        INodo<Relacion> auxPeliPro = listaPeliculasProductores.getPrimero();
        while (auxPeliPro != null){
            if(auxPeliPro.getDato().getIdPelicula().equals(idPelicula)){
                IElementoAB<IProductor> aux = arbolProductores.buscar(auxPeliPro.getDato().getId());
                productores.add(aux.getDatos());
            }
            auxPeliPro = auxPeliPro.getSiguiente();
        }
        
        return productores;
    }
    
    /**
     * Metodo que devuelve una lista con los directores de una pelicula en particularr 
     * @param idPelicula de tipo Comparable
     * @return direcotres de tipo ArrayList
     */
    public ArrayList<IDirector> obtenerDirectoresPorPelicula (Comparable idPelicula){
        ArrayList<IDirector> directores = new ArrayList<>();
        INodo<Relacion> auxPeliDire = listaPeliculasDirectores.getPrimero();
        while ( auxPeliDire != null){
            if(auxPeliDire.getDato().getIdPelicula().equals(idPelicula)){
                IElementoAB<IDirector> aux = arbolDirectores.buscar(auxPeliDire.getDato().getId());
                directores.add(aux.getDatos());
            }
            auxPeliDire = auxPeliDire.getSiguiente();
        }
        
        return directores;
    }
        
    /**
     * Metodo que permite eliminar una actor del arbol/Lista de actores y todas sus referencias
     * @param nombreExacto nombre del actor
     * @return true o false
     */
    public boolean eliminarActor (String nombreExacto){
        ArrayList<IActor> actor = new ArrayList();
        buscarActorPorNombreExacto(nombreExacto, arbolActores.getRaiz(),actor);
        arbolActores.eliminar(actor.get(0).getId());
        INodo<Relacion> auxPeliActor = listaPeliculasActores.getPrimero();
        while (auxPeliActor != null){
            if(auxPeliActor.getDato().getId()== actor.get(0).getId()){
               listaPeliculasActores.eliminar(auxPeliActor.getDato().getIdPelicula());
               return true;
            }
            auxPeliActor = auxPeliActor.getSiguiente();
        }
        return false;
    }
    
    
    /**
     * Metodo que devuelve toda la informacion de una pelicula en particular 
     * @param nombreExacto nombre de la pelicula
     * @return InfoPelicula de tipo String
     */
    public String obtenerInfoPelicula(String nombreExacto) {
        infoPelicula = new StringBuilder();
        ArrayList<IPelicula> pelicula = new ArrayList();
        buscarPorNombreExacto(nombreExacto, arbolPeliculas.getRaiz(),pelicula);
        infoPelicula.append("IDENTIFICADOR: ").append(pelicula.get(0).getId().toString()).append("\n").append("\n");
        infoPelicula.append("NOMBRE: ").append(pelicula.get(0).getName()).append("\n").append("\n");
        infoPelicula.append("PUNTUACION: ").append(pelicula.get(0).getPuntuation()).append("\n").append("\n");
        infoPelicula.append("AÑO: ").append(pelicula.get(0).getYear()).append("\n").append("\n");
        infoPelicula.append("RESEÑA:\n").append(pelicula.get(0).getReview()).append("\n").append("\n");
        infoPelicula.append("GENERO:\n").append(pelicula.get(0).getGenre()).append("\n").append("\n");
        
        
        ArrayList<IActor> reparto = obtenerReparto(pelicula.get(0).getId());
        infoPelicula.append("\nACTORES: ").append("\n");
        for (int i=0; i< reparto.size(); i++){
            infoPelicula.append("- ").append(reparto.get(i).getName()).append("\n");
        }

        ArrayList<IDirector> directores = obtenerDirectoresPorPelicula (pelicula.get(0).getId());
        infoPelicula.append("\nDIRECTORES: ").append("\n");
        for (int i=0; i< directores.size(); i++){
            infoPelicula.append("- ").append(directores.get(i).getName()).append("\n");
        }
        
        ArrayList<IProductor> productores = obtenerProductoresPorPelicula (pelicula.get(0).getId());
        infoPelicula.append("\nPRODUCTORES: ").append("\n");
        for (int i=0; i< productores.size(); i++){
            infoPelicula.append("- ").append(productores.get(i).getName()).append("\n");
        }
        
        return infoPelicula.toString();
    }
    
}
