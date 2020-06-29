/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;


/**
 *
 * @author Emily
 */
public class Cola {

    private Nodo primero, ultimo;
    private int tamaño, elementos;

    // tamaño <= 0 -> INFINITA
    // tamaño > 0 -> FINITA
    public Cola(int tamaño) {
        this.tamaño = tamaño;
        elementos = 0;

    }

    public int size() {
        return elementos;

    }

    //Encolar
    public char enqueue(char dato) throws ColaException {
        Nodo nuevo = new Nodo();
        nuevo.setDato(dato);

        if (tamaño > 0 && elementos == tamaño) {
            throw new ColaException("La cola está llena");
        } else {
            if (primero == null) {
                primero = ultimo = nuevo;
            } else {
                ultimo.setSiguiente(nuevo);
                ultimo = nuevo;
            }
            elementos++;
        }
        return ultimo.getDato();
    }
    

    //Desencolar
    public char dequeue() throws ColaException {
        if (primero == null) {
            throw new ColaException("La cola está vacía");
        }
        char dato = primero.getDato();
        primero = primero.getSiguiente();
        if (primero == null) {
            ultimo = null;
        }
        elementos--;
        return dato;
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public char front() throws ColaException {
        if (primero == null) {
            throw new ColaException("La cola está vacía");
        }
        return primero.getDato();
    }

    public int search(char dato) throws ColaException {
        if (primero == null) {
            throw new ColaException("La cola está vacía");
        }

        int contador = 0;
        for (Nodo actual = primero; actual != null; actual = actual.getSiguiente()) {
            if (actual.getDato() == dato) {
                return contador;
            }
            contador++;
        }
        return -1;
    }
}
