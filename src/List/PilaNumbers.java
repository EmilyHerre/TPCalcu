/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Nodes.NodoNumbers;
import Exceptions.PilaException;

/**
 *
 * @author Nosotras :D
 */
public class PilaNumbers {

    private NodoNumbers cima;
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
    public double top() throws PilaException {
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
    public double pop() throws PilaException {
        double dato;
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
    public double push(double dato) throws PilaException {
        NodoNumbers nuevo = new NodoNumbers();
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
     * @return
     */
    public int size() {
        return tam;
    }

}
