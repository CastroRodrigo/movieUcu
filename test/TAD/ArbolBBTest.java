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
public class ArbolBBTest {
    
    public ArbolBBTest() {
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
     * Test of getRaiz method, of class ArbolBB.
     */
    @Test
    public void testGetRaiz() {
        System.out.println("getRaiz");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,1);
        IElementoAB nodo2 = new ElementoAB(2,2);
        IElementoAB nodo3 = new ElementoAB(2,2);
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1);
        IElementoAB expResult = nodo2;
        IElementoAB result = instance.getRaiz();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertar method, of class ArbolBB.
     */
    @Test
    public void testInsertar_IElementoAB() {
        System.out.println("insertar");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,1);
        IElementoAB nodo2 = new ElementoAB(2,2);
        IElementoAB nodo3 = new ElementoAB(2,2);
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1);
        IElementoAB expResult = nodo2;
        IElementoAB result = instance.getRaiz();
        assertEquals(expResult, result);
    }

    /**
     * Test of buscar method, of class ArbolBB.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,1);
        IElementoAB nodo2 = new ElementoAB(2,2);
        IElementoAB nodo3 = new ElementoAB(3,3);
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1);
        IElementoAB expResult = nodo3;
        IElementoAB result = instance.buscar(3);
        assertEquals(expResult, result);
    }

    /**
     * Test of preOrden method, of class ArbolBB.
     */
    @Test
    public void testPreOrden() {
        System.out.println("preOrden");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,"A");
        IElementoAB nodo2 = new ElementoAB(2,"B");
        IElementoAB nodo3 = new ElementoAB(3,"C");
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1);
        String expResult = " 2 1 3";
        String result = instance.preOrden();
        assertEquals(expResult, result);
    }

    /**
     * Test of inOrden method, of class ArbolBB.
     */
    @Test
    public void testInOrden() {
        System.out.println("inOrden");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,"A");
        IElementoAB nodo2 = new ElementoAB(2,"B");
        IElementoAB nodo3 = new ElementoAB(3,"C");
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1);
        String expResult = " 1 2 3";
        String result = instance.inOrden();
        assertEquals(expResult, result);
    }

    /**
     * Test of postOrden method, of class ArbolBB.
     */
    @Test
    public void testPostOrden() {
        System.out.println("postOrden");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,"A");
        IElementoAB nodo2 = new ElementoAB(2,"B");
        IElementoAB nodo3 = new ElementoAB(3,"C");
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1);
        String expResult = " 1 3 2";
        String result = instance.postOrden();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerAltura method, of class ArbolBB.
     */
    @Test
    public void testObtenerAltura() {
        System.out.println("obtenerAltura");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,"A");
        IElementoAB nodo2 = new ElementoAB(2,"B");
        IElementoAB nodo3 = new ElementoAB(3,"C");
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1);
        int expResult = 1;
        int result = instance.obtenerAltura();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerTamanio method, of class ArbolBB.
     */
    @Test
    public void testObtenerTamanio() {
        System.out.println("obtenerTamanio");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,"A");
        IElementoAB nodo2 = new ElementoAB(2,"B");
        IElementoAB nodo3 = new ElementoAB(3,"C");
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1);
        int expResult = 3;
        int result = instance.obtenerTamanio();
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerNivel method, of class ArbolBB.
     */
    @Test
    public void testObtenerNivel() {
        System.out.println("obtenerNivel");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,"A");
        IElementoAB nodo2 = new ElementoAB(2,"B");
        IElementoAB nodo3 = new ElementoAB(3,"C");
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1);        
        int expResult = 0;
        int result = instance.obtenerNivel(2);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerCantidadHojas method, of class ArbolBB.
     */
    @Test
    public void testObtenerCantidadHojas() {
        System.out.println("obtenerCantidadHojas");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,"A");
        IElementoAB nodo2 = new ElementoAB(2,"B");
        IElementoAB nodo3 = new ElementoAB(3,"C");
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1);         
        int expResult = 2;
        int result = instance.obtenerCantidadHojas();
        assertEquals(expResult, result);
    }

    /**
     * Test of listarHojas method, of class ArbolBB.
     */
    @Test
    public void testListarHojas() {
        System.out.println("listarHojas");
        ArbolBB instance = new ArbolBB();
        instance.listarHojas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encontrarMinimo method, of class ArbolBB.
     */
    @Test
    public void testEncontrarMinimo() {
        System.out.println("encontrarMinimo");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,"A");
        IElementoAB nodo2 = new ElementoAB(2,"B");
        IElementoAB nodo3 = new ElementoAB(3,"C");
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1); 
        IElementoAB expResult = nodo1;
        IElementoAB result = instance.encontrarMinimo();
        assertEquals(expResult, result);
    }

    /**
     * Test of encontrarMaximo method, of class ArbolBB.
     */
    @Test
    public void testEncontrarMaximo() {
        System.out.println("encontrarMaximo");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,"A");
        IElementoAB nodo2 = new ElementoAB(2,"B");
        IElementoAB nodo3 = new ElementoAB(3,"C");
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1);         
        IElementoAB expResult = nodo3;
        IElementoAB result = instance.encontrarMaximo();
        assertEquals(expResult, result);
    }

    /**
     * Test of lexicograficamenteAnterior method, of class ArbolBB.
     */
    @Test
    public void testLexicograficamenteAnterior() {
        System.out.println("lexicograficamenteAnterior");
        Comparable unaClave = null;
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,"A");
        IElementoAB nodo2 = new ElementoAB(2,"B");
        IElementoAB nodo3 = new ElementoAB(3,"C");
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1); 
        IElementoAB expResult = nodo2;
        IElementoAB result = instance.lexicograficamenteAnterior(3);
        assertEquals(expResult, result);
    }

    /**
     * Test of obtenerCantNodosNivel method, of class ArbolBB.
     */
    @Test
    public void testObtenerCantNodosNivel() {
        System.out.println("obtenerCantNodosNivel");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,"A");
        IElementoAB nodo2 = new ElementoAB(2,"B");
        IElementoAB nodo3 = new ElementoAB(3,"C");
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1);   
        int expResult = 1;
        int result = instance.obtenerCantNodosNivel(1);
        assertEquals(expResult, result);
    }

    /**
     * Test of esDeBusqueda method, of class ArbolBB.
     */
    @Test
    public void testEsDeBusqueda() {
        System.out.println("esDeBusqueda");
        ArbolBB instance = new ArbolBB();
        boolean expResult = false;
        boolean result = instance.esDeBusqueda();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminar method, of class ArbolBB.
     */
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Comparable etiqueta = null;
        ArbolBB instance = new ArbolBB();
        instance.eliminar(etiqueta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumaClavePorNivel method, of class ArbolBB.
     */
    @Test
    public void testSumaClavePorNivel() {
        System.out.println("sumaClavePorNivel");
        Integer nivel = null;
        ArbolBB instance = new ArbolBB();
        Integer expResult = null;
        Integer result = instance.sumaClavePorNivel(nivel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esVacio method, of class ArbolBB.
     */
    @Test
    public void testEsVacio() {
        System.out.println("esVacio");
        ArbolBB instance = new ArbolBB();
        IElementoAB nodo1 = new ElementoAB(1,"A");
        IElementoAB nodo2 = new ElementoAB(2,"B");
        IElementoAB nodo3 = new ElementoAB(3,"C");
        instance.insertar(nodo2);
        instance.insertar(nodo3);
        instance.insertar(nodo1); 
        boolean expResult = false;
        boolean result = instance.esVacio();
        assertEquals(expResult, result);
    }
    
}
