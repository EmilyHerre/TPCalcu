/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;



/**
 *
 * @author alberto
 */
public class Pila {

    private Nodo cima;
    private int tamaño;
    private int elementos;

    //Si tamaño > 0 -> pila es finita 
    //Si tamaño <= 0 -> pila es infinita
    public Pila(int tamaño) {
        this.tamaño = tamaño;
    }

    public boolean empty() {
        return cima == null;
    }

    //Cima
    public char top() throws PilaException {
        if (cima == null) {
            throw new PilaException("La lista está vacía");
        }
        return cima.getDato();
    }

    //Desapilar
    public char pop() throws PilaException {
        char dato;
        if (cima == null) {
            throw new PilaException("La pila está vacía ");
        } else {
            dato = cima.getDato();
            cima = cima.getSiguiente();
            elementos--;
        }
        return dato;

    }

    //Apilar
    public char push(char dato) throws PilaException {
        if (tamaño > 0 && tamaño == elementos) {
            throw new PilaException("La pila está llena");
        } else {

            Nodo nuevo = new Nodo();
            nuevo.setDato(dato);

            if (cima == null) {
                cima = nuevo;
            } else {
                nuevo.setSiguiente(cima);
                cima = nuevo;
            }
            elementos++;

            return cima.getDato();
        }
    }

    public int search(char dato) throws PilaException {
        int contador = 0;
        if (cima == null) {
            throw new PilaException("La pila está vacía");
        } else {
            Nodo actual = cima;
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

    public int size() {
        return elementos;
    }

}
