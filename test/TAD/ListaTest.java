/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo
 */
public class ListaTest {
    
    public ListaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertar method, of class Lista.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Lista instance = new Lista();
        INodo nodo1 = new Nodo(1,1);
        INodo nodo2 = new Nodo(2,2);
        INodo nodo3 = new Nodo(3,3);
        instance.insertar(nodo1);
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        assertEquals(instance.cantElementos(),3);
    }

    /**
     * Test of buscar method, of class Lista.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Comparable clave = 1;
        Lista instance = new Lista();
        Comparable expResult = 1;
        INodo nodo1 = new Nodo(1,1);
        INodo nodo2 = new Nodo(2,2);
        INodo nodo3 = new Nodo(3,3);
        instance.insertar(nodo1);
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        INodo result = instance.buscar(1);
        assertEquals(expResult, result.getEtiqueta());
        
    }

    /**
     * Test of eliminar method, of class Lista.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Lista instance = new Lista();
        INodo nodo1 = new Nodo(1,1);
        INodo nodo2 = new Nodo(2,2);
        INodo nodo3 = new Nodo(3,3);
        instance.insertar(nodo1);
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.eliminar(2);
        assertEquals(instance.cantElementos(),2);
    }

    /**
     * Test of imprimir method, of class Lista.
     */
    @Test
    public void testImprimir_String() {
        System.out.println("imprimir");
        Lista instance = new Lista();
        INodo nodo1 = new Nodo(1,1);
        instance.insertar(nodo1);
        String expResult = "";
        String result = instance.imprimir();
        assertEquals(expResult, result);
    }

    /**
     * Test of cantElementos method, of class Lista.
     */
    @Test
    public void testCantElementos() {
        System.out.println("cantElementos");
        Lista instance = new Lista();
        INodo nodo1 = new Nodo(1,1);
        INodo nodo2 = new Nodo(2,2);
        INodo nodo3 = new Nodo(3,3);
        instance.insertar(nodo1);
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        assertEquals(instance.cantElementos(),3);
    }

    /**
     * Test of esVacia method, of class Lista.
     */
    @Test
    public void testEsVacia() {
        System.out.println("esVacia");
        Lista instance = new Lista();
        boolean expResult = true;
        boolean result = instance.esVacia();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrimero method, of class Lista.
     */
    @Test
    public void testGetPrimero() {
        System.out.println("getPrimero");
        Lista instance = new Lista();
        INodo nodo1 = new Nodo(1,1);
        INodo nodo2 = new Nodo(2,2);
        INodo nodo3 = new Nodo(3,3);
        instance.insertar(nodo1);
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        INodo expResult = nodo1;
        INodo result = instance.getPrimero();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getUltimo method, of class Lista.
     */
    @Test
    public void testGetUltimo() {
        System.out.println("getUltimo");
        Lista instance = new Lista();
        INodo nodo1 = new Nodo(1,1);
        INodo nodo2 = new Nodo(2,2);
        INodo nodo3 = new Nodo(3,3);
        instance.insertar(nodo1);
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        INodo expResult = nodo3;
        INodo result = instance.getUltimo();
        assertEquals(expResult, result);
    }
    
}
