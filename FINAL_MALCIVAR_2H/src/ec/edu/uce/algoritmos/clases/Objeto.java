package ec.edu.uce.algoritmos.clases;

/**
 * Metodo objeto
 *
 * @author Marcos
 */

public class Objeto implements Comparable<Objeto> {

    int peso;
    int valor;
    double ratio;

    /**
     * Metodo objeto
     */
    public Objeto() {
        peso = 0;
        valor = 0;
        ratio = -1;
    }

    /**
     * metodo objeto
     *
     * @param peso valor de cantidad
     * @param valor valor de cantidad
     */
    public Objeto(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
        if (peso > 0) {
            ratio = this.valor / this.peso;
        } else {
            ratio = -1;
        }
    }

    /**
     * Metodo compare to
     *
     * @param o variable
     * @return resultado
     */
    @Override
    public int compareTo(Objeto o) {
        int res = 0;
        if ((this.ratio > o.ratio) || ((this.ratio == o.ratio) && (this.peso < o.peso))) {
            res = -1;
        } else if ((this.ratio <= o.ratio) || ((this.ratio == o.ratio) && (this.valor > o.valor)) || ((this.ratio == o.ratio) && (this.valor == o.valor) && (this.peso < o.peso))) {
            res = 1;
        }
        return res;
    }

    /**
     * Metodo String
     *
     * @return impresion del algoritmo
     */
    public String toString() {
        return "(" + peso + " , " + valor + " , " + ratio + ")";
    }
}
