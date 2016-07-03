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
import java.util.ArrayList;

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
    ArrayList<String> listaBusquedas;
    StringBuilder infoPelicula;
    String textoProductores = "src/Files/Big-Productores.csv";
    String textoDirectores = "src/Files/Big-Directores.csv" ;
    String textoActores = "src/Files/Big-Actores.csv";
    String textoPelicula = "src/Files/Big-Peliculas.csv";
    String textoPeliculasActores = "src/Files/Big-PeliculasActores.csv";
    String textoPeliculasDirectores = "src/Files/Big-PeliculasDirectores.csv";
    String textoPeliculasProductores = "src/Files/Big-PeliculasProductores.csv";
    
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
        StringBuilder nombres = new StringBuilder();
        INodo<IPelicula> aux = listaPeliculas.getPrimero();
        while(aux!=null){
            nombres.append(aux.getDato().getName());
            nombres.append("\n");
            aux=aux.getSiguiente();
        }
        return nombres.toString();
    }
    
    @Override
    public ArrayList<String> obtenerNombrePeliculas (){
        ArrayList<String> nombres = new ArrayList();
        INodo<IPelicula> aux = listaPeliculas.getPrimero();
        while(aux!=null){
            nombres.add(aux.getDato().getName());
            aux=aux.getSiguiente();
        }
        return nombres;
    }
            

    @Override
    public IPelicula buscarPelicula(Comparable idPelicula) {
        INodo<IPelicula> aux = listaPeliculas.getPrimero();
        while(aux != null){
            if (aux.getEtiqueta().equals(idPelicula)){
                return aux.getDato();
            }
            else{
                aux = aux.getSiguiente();
            }
        }
        throw new NullPointerException("La id buscada no existe");
    }
    
    

    @Override
    public void crearAlmacenPeliculas() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoPelicula, false);
        for(int linea=0;linea<lineas.length;linea++){
            try{
                String[] datos = lineas[linea].split("\\|");
                IPelicula peli = new Pelicula(Integer.parseInt(datos[0]),datos[1],Integer.parseInt(datos[2]),Float.parseFloat(datos[3]),datos[4],datos[5]);
                this.agregarPelicula(peli);
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println("No se pudieron agregar algunas peliculas" + ex.getMessage());
            }
        }
    }

    public Lista<IActor> getListActores() {
        return listaActores;
    }

    public Lista<IDirector> getListDirectores() {
        return listaDirectores;
    }

    public Lista<IProductor> getListProductores() {
        return listaProductores;
    }

    public Lista<Relacion> getPeliculasActores() {
        return listaPeliculasActores;
    }

    public Lista<Relacion> getPeliculasDirectores() {
        return listaPeliculasDirectores;
    }

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
    public void crearAlmacenActores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoActores, false);
        for(int linea=0;linea<lineas.length;linea++){
            try{
                String[] datos = lineas[linea].split("\\|");
                IActor act = new Actor(Integer.parseInt(datos[0]),datos[1]);
                this.agregarActor(act);
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println("No se pudieron agregar algunas peliculas" + ex.getMessage());
            }
            
        }
        
        
    }

    @Override
    public void crearAlmacenDirectores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoDirectores, false);
        for(int linea=0; linea<lineas.length;linea++){
            try{
                String[] datos = lineas[linea].split("\\|");
                IDirector dir = new Director(Integer.parseInt(datos[0]),datos[1]);
                this.agregarDiretor(dir);
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println("No se pudieron agregar algunos Drectores" + ex.getMessage());
            }
        }
    }

    @Override
    public void crearAlmacenProductores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoProductores, false);
        for(int linea=0; linea<lineas.length;linea++){
            try{
                String[] datos = lineas[linea].split("\\|");
                IProductor pro = new Productor(Integer.parseInt(datos[0]),datos[1]);
                this.agregarProductor(pro);
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println("No se pudieron agregar algunas Productores" + ex.getMessage());
            }
        }
    }

    @Override
    public void crearListaPeliculasActores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoPeliculasActores, false);
        for(int linea=0; linea<lineas.length;linea++){
            try{
                String[] datos = lineas[linea].split("\\|");
                Relacion peliActor = new Relacion(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
                this.agregarRelacionPeliActor(peliActor);
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println("No se pudieron agregar algunas relaciones" + ex.getMessage());
            }
        }
    }

    @Override
    public void crearListaPeliculasDirectores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoPeliculasDirectores, false);
        for(int linea=0; linea<lineas.length;linea++){
            try{
                String[] datos = lineas[linea].split("\\|");
                Relacion peliDire = new Relacion(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
                this.agregarRelacionPeliDire(peliDire);
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println("No se pudieron agregar algunas relaciones" + ex.getMessage());
            }
        }
    }

    @Override
    public void crearListaPeliculasProductores() {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(textoPeliculasProductores, false);
        for(int linea=0; linea<lineas.length;linea++){
            try{
                String[] datos = lineas[linea].split("\\|");
                Relacion peliPro = new Relacion(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]));
                this.agregarRelacionPeliPro(peliPro);
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println("No se pudieron agregar algunas relaciones" + ex.getMessage());
            }
            
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
    public ArrayList<String> buscarPorNombre(String nombre) {
        listaBusquedas = new ArrayList();
        INodo<IPelicula> aux = listaPeliculas.getPrimero();
        while(aux!=null){
            if(aux.getDato().getName().toLowerCase().contains(nombre.toLowerCase())){
                listaBusquedas.add(aux.getDato().getName());
                aux = aux.getSiguiente();
            }
            else {
                aux=aux.getSiguiente();
            }
        }
        return listaBusquedas;
    }

    @Override
    public ArrayList<String> buscarPorYear(int year) {
        listaBusquedas = new ArrayList();
        INodo<IPelicula> aux = listaPeliculas.getPrimero();
        while (aux!=null){
            if(aux.getDato().getYear()== year){
                listaBusquedas.add(aux.getDato().getName());
                aux = aux.getSiguiente();
            }
            else {
                aux=aux.getSiguiente();
            }
        }
        return listaBusquedas;
    }

    @Override
    public ArrayList<String> buscarPorGenero(String genero) {
        listaBusquedas = new ArrayList();
        INodo<IPelicula> aux = listaPeliculas.getPrimero();
        while(aux!= null){
            if(aux.getDato().getGenre().toLowerCase().contains(genero.toLowerCase())){
                listaBusquedas.add(aux.getDato().getName());
                aux= aux.getSiguiente();
            }
            else{
                aux=aux.getSiguiente();
            }
        }
        
        return listaBusquedas;
    }
    
    

    @Override
    public String obtenerInfoPelicula(String nombreExacto) {
        infoPelicula = new StringBuilder();
        INodo<IPelicula> aux = listaPeliculas.getPrimero();
        Comparable id = aux.getDato().getId();
        while(aux!=null){
            if(aux.getDato().getName().equals(nombreExacto)){
                id = aux.getDato().getId();
                infoPelicula.append("IDENTIFICADOR: ").append(aux.getDato().getId().toString()).append("\n");
                infoPelicula.append("NOMBRE: ").append(aux.getDato().getName()).append("\n");
                infoPelicula.append("PUNTUACION: ").append(aux.getDato().getPuntuation()).append("\n");
                infoPelicula.append("AÑO: ").append(aux.getDato().getYear()).append("\n");
                infoPelicula.append("RESEÑA:\n").append(aux.getDato().getReview()).append("\n");
                infoPelicula.append("GENERO:\n").append(aux.getDato().getGenre()).append("\n");
                break;
            }
            else{
                aux=aux.getSiguiente();
            }
        }
        infoPelicula.append("\nACTORES: ").append("\n");
        INodo<Relacion> auxPeliAct = listaPeliculasActores.getPrimero();
        while (auxPeliAct!= null){
            if(auxPeliAct.getDato().getIdPelicula().equals(id)){
                Comparable idActor = auxPeliAct.getDato().getId();
                INodo<IActor> auxAct = listaActores.getPrimero();
                while(auxAct!= null){
                    if(auxAct.getDato().getId().equals(idActor)){
                        infoPelicula.append(auxAct.getDato().getName()).append("\n"); 
                    }
                    auxAct=auxAct.getSiguiente();
                }
            }
            auxPeliAct=auxPeliAct.getSiguiente();
        }
        
        infoPelicula.append("\nDIRECTORES: ").append("\n");
        INodo<Relacion> auxPeliDire = listaPeliculasDirectores.getPrimero();
        while (auxPeliDire!= null){
            if(auxPeliDire.getDato().getIdPelicula().equals(id)){
                Comparable idDirector = auxPeliDire.getDato().getId();
                INodo<IDirector> auxDire = listaDirectores.getPrimero();
                while(auxDire!= null){
                    if(auxDire.getDato().getId().equals(idDirector)){
                        infoPelicula.append(auxDire.getDato().getName()).append("\n");                   
                    }
                    auxDire=auxDire.getSiguiente();
                }
            }
            auxPeliDire=auxPeliDire.getSiguiente();
        }
        infoPelicula.append("\nPRODUCTORES: ").append("\n");
        INodo<Relacion> auxPeliPro = listaPeliculasProductores.getPrimero();
        while (auxPeliPro!= null){
            if(auxPeliPro.getDato().getIdPelicula().equals(id)){
                Comparable idProductor = auxPeliPro.getDato().getId();
                INodo<IProductor> auxPro = listaProductores.getPrimero();
                while(auxPro!= null){
                    if(auxPro.getDato().getId().equals(idProductor)){
                        infoPelicula.append(auxPro.getDato().getName()).append("\n");
                    }
                    auxPro=auxPro.getSiguiente();
                }
            }
            auxPeliPro=auxPeliPro.getSiguiente();
            
        } 
        
        return infoPelicula.toString();
    }
    
}
