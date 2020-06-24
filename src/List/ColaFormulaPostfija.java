/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

//Hola COMMITTT
import Exceptions.ColaException;
import Nodes.Nodo;
import java.util.ArrayList;

/**
 * CAMBIOS HECHOS Pordehetos
 *
 * @author Emily
 */
public class ColaFormulaPostfija {

    private Nodo primero, ultimo;
    private int tam = 0;

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
        tam++;
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
        tam--;
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

    public int getTam() {
        return tam;
    }

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
