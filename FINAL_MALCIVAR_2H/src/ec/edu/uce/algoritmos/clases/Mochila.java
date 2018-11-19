package ec.edu.uce.algoritmos.clases;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Metodo Mochila
 *
 * @author Marcos
 */
public class Mochila {

    private List<Objeto> listaObjetos;
    private int pesoMáximo;

    /**
     * Metodo mochila donde se declara el tamaño de la lista
     */
    public Mochila() {
        listaObjetos = new LinkedList<Objeto>();
        pesoMáximo = 0;
    }

    /**
     * Metodo mochila
     *
     * @param listaObjetos variables
     * @param pesoMáximo tamaño permitido
     */
    public Mochila(List<Objeto> listaObjetos, int pesoMáximo) {
        this.listaObjetos = new LinkedList<Objeto>(listaObjetos);
        this.pesoMáximo = pesoMáximo;
    }

    /**
     * Metodo resolver
     *
     * @return devuelve respuesta del algoritmo
     */
    public List<Objeto> resolver() {
        List<Objeto> res = new LinkedList<Objeto>();
        Collections.sort(listaObjetos);
        System.out.println("lista oprdenada");
        System.out.println(listaObjetos);
        int totalPeso = 0;
        while (!listaObjetos.isEmpty() && totalPeso < pesoMáximo) {
            Objeto o = listaObjetos.get(0);
            if (totalPeso + o.peso <= pesoMáximo) {
                res.add(o);
                listaObjetos.remove(0);
                totalPeso += o.peso;
            } else {
                listaObjetos.remove(0);
            }
        }

        return res;
    }

    /**
     * Metodo tostring
     *
     * @return impresion del algoritmo
     */
    public String toString() {
        String res = "Peso máximo: " + pesoMáximo + "\nLista de objetos: ";
        res += listaObjetos.toString();
        return res;
    }
}
