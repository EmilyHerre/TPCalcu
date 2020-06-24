/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Nodes.NodoPila;
import Exceptions.PilaException;

/**
 *
 * @author Nosotras :D
 */
public class Pila {

    private NodoPila cima;
    private int tam;

    /**
     *
     * @return
     */
    public boolean empty() {
        return cima == null;
    }

    //Cima

    /**
     *
     * @return
     * @throws PilaException
     */
    public char top() throws PilaException {
        if (cima == null) {
            throw new PilaException("La lista está vacía");
        }
        return cima.getDato();
    }

    //Desapilar

    /**
     *
     * @return
     * @throws PilaException
     */
    public char pop() throws PilaException {
        char dato;
        if (cima == null) {
            throw new PilaException("La pila está vacía ");
        } else {
            dato = cima.getDato();
            cima = cima.getSiguiente();
            tam--;
        }
        return dato;

    }

    //Apilar

    /**
     *
     * @param dato
     * @return
     * @throws PilaException
     */
    public char push(char dato) throws PilaException {
        NodoPila nuevo = new NodoPila();
        nuevo.setDato(dato);

        if (cima == null) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
        tam++;
        return cima.getDato();
    }

    /**
     *
     * @param dato
     * @return
     * @throws PilaException
     */
    public int search(char dato) throws PilaException {
        int contador = 0;
        if (cima == null) {
            throw new PilaException("La pila está vacía");
        } else {
            NodoPila actual = cima;
            while (actual != null) {
                if (actual.getDato() == dato) {
                    return contador;
                }
                contador++;
                actual = actual.getSiguiente();
            }
        }
        return -1;

    }

    /**
     *
     * @return
     */
    public int size() {
        return tam;
    }

}
