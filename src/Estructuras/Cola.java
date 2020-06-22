/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

//Hola COMMITTT
/**
 * CAMBIOS HECHOS Pordehetos
 * @author Emily
 */
public class Cola {

    private Nodo primero, ultimo;

    //Encolar encoladero
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

    public boolean isEmpty() {
        return primero == null;
    }

    public String front() throws ColaException {
        if (primero == null) {
            throw new ColaException("La cola está vacía");
        }
        return primero.getDato();
    }

    public int search(String dato) throws ColaException {
        if (primero == null) {
            throw new ColaException("La cola está vacía");
        }

        int contador = 0;
        for (Nodo actual = primero; actual != null; actual = actual.getSiguiente()) {
            if (actual.getDato().equals(dato)) {
                return contador;
            }
            contador++;
        }
        return -1;
    }
}
