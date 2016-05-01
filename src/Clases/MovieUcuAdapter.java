/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Interfaces.IActor;
import Interfaces.IDirector;
import Interfaces.IMovieUcuAdapter;
import Interfaces.IPelicula;
import Interfaces.IProductor;
import TAD.INodo;
import TAD.ILista;
import TAD.Lista;
import TAD.Nodo;

/**
 * @author Rodrigo Castro
 */
public class MovieUcuAdapter implements IMovieUcuAdapter {
    
    Lista<IActor> listaActores;
    Lista<IPelicula> listaPeliculas;
    Lista<IDirector> listaDirectores;
    Lista<IProductor> listaProductores;
    Lista<Relacion> listaPeliculasActores;
    Lista<Relacion> listaPeliculasDirectores;
    Lista<Relacion> listaPeliculasProductores;
    String textoProductores = "src/Files/Small-Productores.txt";
    String textoDirectores = "src/Files/Small-Directores.txt" ;
    String textoActores = "src/Files/Small-Actores.txt";
    String textoPelicula = "src/Files/Small-Peliculas.txt";
    String textoPeliculasActores = "src/Files/Small-PeliculasActores.txt";
    String textoPeliculasDirectores = "src/Files/Small-PeliculasDirectores.txt";
    String textoPeliculasProductores = "src/Files/Small-PeliculasProductores.txt";
    
    @Override
    public Lista getListPelicula() {
        return listaPeliculas;
    }

    @Override
    public void agregarPelicula(IPelicula pelicula) {
        if (pelicula != null ){
            if(this.listaPeliculas == null){
                this.listaPeliculas = new Lista<>();
            }
            INodo<IPelicula> nuevaPelicula = new Nodo(pelicula, pelicula.getId());
            this.listaPeliculas.insertar(nuevaPelicula);
        }
        else{
            throw new NullPointerException("La pelicula es null."); 
        }
    }

    @Override
    public boolean eliminarPelicula(Comparable idPelicula) {
        if(idPelicula != null && this.listaPeliculas != null){
            return this.listaPeliculas.eliminar(idPelicula);
        }
        else{
            throw new NullPointerException("No se encontro la pelicula."); 
        }
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
    public void crearListaPeliculas() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoPelicula, false);
        for(int linea=0;linea<lineas.length;linea++){
            String[] datos = lineas[linea].split("\\|");
            IPelicula peli = new Pelicula(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]),Float.parseFloat(datos[3]),datos[4],datos[5]);
            this.agregarPelicula(peli);
        }
    }

    @Override
    public Lista<IActor> getListActores() {
        return listaActores;
    }

    @Override
    public Lista<IDirector> getListDirectores() {
        return listaDirectores;
    }

    @Override
    public Lista<IProductor> getListProductores() {
        return listaProductores;
    }

    @Override
    public Lista<Relacion> getPeliculasActores() {
        return listaPeliculasActores;
    }

    @Override
    public Lista<Relacion> getPeliculasDirectores() {
        return listaPeliculasDirectores;
    }

    @Override
    public Lista<Relacion> getPeliculasProductores() {
        return listaPeliculasProductores;
    }

    @Override
    public void agregarActor(IActor actor) {
        if (actor != null ){
            if(this.listaActores == null){
                this.listaActores = new Lista<>();
            }
            INodo<IActor> nuevoActor = new Nodo(actor, actor.getId());
            this.listaActores.insertar(nuevoActor);
        }
        else{
            throw new NullPointerException("El Actor es null."); 
        }
    }

    @Override
    public void agregarDiretor(IDirector director) {
        if (director != null ){
            if(this.listaDirectores == null){
                this.listaDirectores = new Lista<>();
            }
            INodo<IDirector> nuevoDirector = new Nodo(director, director.getId());
            this.listaDirectores.insertar(nuevoDirector);
        }
        else{
            throw new NullPointerException("El Director es null."); 
        } 
    }

    @Override
    public void agregarProductor(IProductor productor) {
        if (productor != null ){
            if(this.listaProductores == null){
                this.listaProductores = new Lista<>();
            }
            INodo<IProductor> nuevoProductor = new Nodo(productor, productor.getId());
            this.listaProductores.insertar(nuevoProductor);
        }
        else{
            throw new NullPointerException("El Productor es null."); 
        } 
    }

    @Override
    public void crearListaActores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoActores, false);
        for(int linea=0;linea<lineas.length;linea++){
            String[] datos = lineas[linea].split("|");
            IActor act = new Actor(Integer.parseInt(datos[0]),datos[1]);
            this.agregarActor(act);
        }
        
        
    }

    @Override
    public void crearListaDirectores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoDirectores, false);
        for(int linea=0; linea<lineas.length;linea++){
           String[] datos = lineas[linea].split("|");
           IDirector dir = new Director(Integer.parseInt(datos[0]),datos[1]);
           this.agregarDiretor(dir);
        }
    }

    @Override
    public void crearListaProductores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoProductores, false);
        for(int linea=0; linea<lineas.length;linea++){
            String[] datos = lineas[linea].split("|");
            IProductor pro = new Productor(Integer.parseInt(datos[0]),datos[1]);
            this.agregarProductor(pro);
        }
    }

    @Override
    public void crearListaPeliculasActores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoPeliculasActores, false);
        for(int linea=0; linea<lineas.length;linea++){
            String[] datos = lineas[linea].split("|");
            Relacion peliActor = new Relacion(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
            this.agregarRelacion(peliActor, listaPeliculasActores);
        }
    }

    @Override
    public void crearListaPeliculasDirectores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoPeliculasDirectores, false);
        for(int linea=0; linea<lineas.length;linea++){
            String[] datos = lineas[linea].split("|");
            Relacion peliDire = new Relacion(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
            this.agregarRelacion(peliDire, listaPeliculasDirectores);
        }
    }

    @Override
    public void crearListaPeliculasProductores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoPeliculasProductores, false);
        for(int linea=0; linea<lineas.length;linea++){
            String[] datos = lineas[linea].split("|");
            Relacion peliPro = new Relacion(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
            this.agregarRelacion(peliPro, listaPeliculasProductores);
        }
    }

    @Override
    public void agregarRelacion(Relacion relacion, ILista<Relacion> lista) {
        if (relacion != null ){
            if(lista == null){
                lista = new Lista<>();
            }
            INodo<Relacion> nuevaRelacion = new Nodo(relacion,relacion.getIdPelicula());
            lista.insertar(nuevaRelacion);
        }
        else{
            throw new NullPointerException("El Productor es null."); 
        } 
    }
    
    public static void main(String[] args) {
        
        IMovieUcuAdapter adapter = new MovieUcuAdapter();
        adapter.crearListaPeliculas();
        System.out.println(adapter.getListPelicula().imprimir());
    }
    
}
