/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

//Hola COMMITTT

import Exceptions.ColaException;
import Nodes.Nodo;



/**
 * CAMBIOS HECHOS Pordehetos
 *
 * @author Emily
 */
public class ColaFormulaOriginal {

    private Nodo primero, ultimo;

    //Encolar encoladero

    /**
     *
     * @param dato
     * @return
     * @throws ColaException
     */
    public String enqueue(String dato) throws ColaException {
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);
        if (primero == null) {
            primero = ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        return ultimo.getDato();
    }

    //Desencolar

    /**
     *
     * @return
     * @throws ColaException
     */
    public String dequeue() throws ColaException {
        if (primero == null) {
            throw new ColaException("La cola está vacía");
        }
        String dato = primero.getDato();
        primero = primero.getSiguiente();
        if (primero == null) {
            ultimo = null;
        }
        return dato;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return primero == null;
    }

    /**
     *
     * @return
     * @throws ColaException
     */
    public String front() throws ColaException {
        if (primero == null) {
            throw new ColaException("La cola está vacía");
        }
        return primero.getDato();
    }

    

}
