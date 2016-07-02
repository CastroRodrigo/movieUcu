
package Clases;

import Interfaces.IActor;
import Interfaces.IDirector;
import Interfaces.IMovieUcuAdapter;
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
public class Adapter implements IMovieUcuAdapter {

    ArbolBB<IActor> arbolActores;
    ArbolBB<IPelicula> arbolPeliculas;
    ArbolBB<IDirector> arbolDirectores;
    ArbolBB<IProductor> arbolProductores;
    Lista<Relacion> listaPeliculasActores;
    Lista<Relacion> listaPeliculasDirectores;
    Lista<Relacion> listaPeliculasProductores;
    ArrayList<String> listaBusquedas;
    StringBuilder infoPelicula;
    String textoProductores = "src/Files/Big-Productores.csv";
    String textoDirectores = "src/Files/Big-Directores.csv" ;
    String textoActores = "src/Files/Big-Actores.csv";
    String textoPelicula = "src/Files/Big-Peliculas.csv";
    String textoPeliculasActores = "src/Files/Big-PeliculasActores.csv";
    String textoPeliculasDirectores = "src/Files/Big-PeliculasDirectores.csv";
    String textoPeliculasProductores = "src/Files/Big-PeliculasProductores.csv";
    
    
    
    
    @Override
    public ArrayList<String> obtenerNombrePeliculas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo Almacen que utiliza una estructura de arbol binario para almacenar las peliculas
     */
    @Override
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
    @Override
    public void crearAlmacenActores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoActores, false);
        for(int linea=0;linea<lineas.length;linea++){
                String[] datos = lineas[linea].split("\\|",-1);
                if(datos[0].compareTo("") == 0){
                    datos[0]= "-1";
                }
                IActor act = new Actor(Integer.parseInt(datos[0]),datos[1]);
                this.agregarActor(act);
            }
    }

    /**
     * Metodo Almacen que utiliza una estructura de arbol binario para almacenar las directores
     */
    @Override
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
    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public boolean eliminarPelicula(Comparable idPelicula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String imprimirPeliculas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPelicula buscarPelicula(Comparable IdPelicula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> buscarPorYear(int year) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> buscarPorGenero(String genero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerInfoPelicula(String nombreExacto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
