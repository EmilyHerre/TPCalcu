/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Exceptions.ColaException;
import Nodes.Nodo;
import java.util.ArrayList;

/**
 * @author Emily Herrera, Alana Atencio, Sofia Guido
 */
public class ColaFormulaPostfija {

    private Nodo primero, ultimo;
    private int tam = 0;

    /**
     * This method is responsible for queuing the elements
     *
     * @param dato a string containing the formula with operations
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
        tam++;
        return ultimo.getDato();
    }

    /**
     * This method is in charge of removing the elements from the queue
     *
     * @return the item that takes out
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
        tam--;
        return dato;
    }

    /**
     * This method verifies that the queue is empty
     *
     * @return true if it is empty or false if it is not
     */
    public boolean isEmpty() {
        return primero == null;
    }

    /**
     * This method shows the element of the first position
     *
     * @return the element of the first position
     * @throws ColaException
     */
    public String front() throws ColaException {
        if (primero == null) {
            throw new ColaException("La cola está vacía");
        }
        return primero.getDato();
    }

    /**
     * This method replace the letter variable with the value assigned
     *
     * @param dato
     * @param value
     * @throws ColaException
     */
    public void replace(String dato, double value) throws ColaException {
        if (primero == null) {
            throw new ColaException("La cola está vacía");
        }

        for (Nodo actual = primero; actual != null; actual = actual.getSiguiente()) {
            if (actual.getDato().equals(dato)) {
                actual.setDato(String.valueOf(value));
            }

        }
    }

    /**
     * The getTam method return size list
     *
     * @return
     */
    public int getTam() {
        return tam;
    }

    /**
     * The getLetters method collects all the letters of the formula, that is,
     * the postfix queue and enters them in the arrayList
     *
     * @return listLetters
     */
    public ArrayList<String> getLetters() {
        Nodo temp = primero;
        ArrayList<String> listLetters = new ArrayList<>();
        while (temp != null) {
            if (Character.isLetter(temp.getDato().charAt(0))) {
                if (!listLetters.contains(temp.getDato())) {
                    listLetters.add(temp.getDato());

                }

            }
            temp = temp.getSiguiente();
        }
        return listLetters;
    }

}
