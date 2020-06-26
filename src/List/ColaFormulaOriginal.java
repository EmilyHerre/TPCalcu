/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;


import Exceptions.ColaException;
import Nodes.Nodo;



/**
 * 
 *
 * @author Emily Herrera, Alana Atencio, Sofia Guido 
 */
public class ColaFormulaOriginal {

    private Nodo primero, ultimo;

    

   /**
     * This method is responsible for queuing the elements
     * @param dato
     * @return the element entered
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

    

    /**
     * This method is in charge of removing the elements from the queue
     * @return the element that was remove 
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
     * This method verifies that the queue is empty
     * @return true if it is empty or false if it is not
     */
    public boolean isEmpty() {
        return primero == null;
    }

    /**
     * This method shows the element of the first position
     * @return the element of the first position
     * @throws ColaException
     */
    public String front() throws ColaException {
        if (primero == null) {
            throw new ColaException("La cola está vacía");
        }
        return primero.getDato();
    }

    

}
