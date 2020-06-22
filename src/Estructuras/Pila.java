/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;



/**
 *
 * @author Nosotras :D
 */
public class Pila {

    private Nodo cima;
    private int tam;

    public boolean empty() {
        return cima == null;
    }

    //Cima
    public String top() throws PilaException {
        if (cima == null) {
            throw new PilaException("La lista está vacía");
        }
        return cima.getDato();
    }

    //Desapilar
    public String pop() throws PilaException {
        String dato;
        if (cima == null) {
            throw new PilaException("La pila está vacía ");
        } else {
            dato = cima.getDato();
            cima = cima.getSiguiente();
        }
        return dato;

    }

    //Apilar
    public String push(String dato) throws PilaException {
            Nodo nuevo = new Nodo();
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
    

    public int search(String dato) throws PilaException {
        int contador = 0;
        if (cima == null) {
            throw new PilaException("La pila está vacía");
        } else {
            Nodo actual = cima;
            while (actual != null) {
                if (actual.getDato().equals(dato)) {
                    return contador;
                }
                contador++;
                actual = actual.getSiguiente();
            }
        }
        return -1;

    }
    
    public int size() {
        return tam;
    }
            

}
