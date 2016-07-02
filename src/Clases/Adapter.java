
package Clases;

import Interfaces.IActor;
import Interfaces.IDirector;
import Interfaces.IMovieUcuAdapter;
import Interfaces.IPelicula;
import Interfaces.IProductor;
import TAD.Lista;
import TAD.ArbolBB;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarActor(IActor actor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarDiretor(IDirector director) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarProductor(IProductor productor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarRelacionPeliActor(Relacion relacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarRelacionPeliDire(Relacion relacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarRelacionPeliPro(Relacion relacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
