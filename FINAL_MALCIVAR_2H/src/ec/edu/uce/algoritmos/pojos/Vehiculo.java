package ec.edu.uce.algoritmos.pojos;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *Implementacion de variables
 * @author Marcos
 */

public class Vehiculo implements Comparable<Vehiculo>{

    private String placa;
  //  private String marca;
    //private Integer año;
    private Date fechaFabricacion;
    private Double precio;

    public Vehiculo() {
    }
    private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
/**
 * Variables que se van a usar
 * @param placa en String
 * @param fec_fabricacion en Date
 * @param precio en double
 */
    public Vehiculo(String placa, Date fec_fabricacion, Double precio) {
        this.placa = placa;
      //  this.marca = marca;
       // this.año = año;
        this.fechaFabricacion = fec_fabricacion;
        this.precio = precio;
    }
/**
 * Metodo get placa
 * @return variable placa
 */
    public String getPlaca() {
        return placa;
    }
/**
 * Metodo set placa
 * @param placa recibe valor de placa
 */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
/*
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
*/
    /*
    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }
*/
    /**
     * Metodo get Fecha de fabricacion
     * @return variable fecha de fabricacion
     */
    public Date getFec_fabricacion() {
        return fechaFabricacion;
    }
/**
 * Metodo set Fecha de fabricacion
 * @param fec_fabricacion valor de fecha de fabricacion
 */
    public void setFec_fabricacion(Date fec_fabricacion) {
        this.fechaFabricacion = fec_fabricacion;
    }
/**
 * Metodo get Precio
 * @return variable precio
 */
    public Double getPrecio() {
        return precio;
    }
/**
 * Metodo set precio
 * @param precio recibe valor precio
 */
    public void setPrecio(Double precio) {
        this.precio = precio;
        
    }
    
    
//comparar String
/**
 * Metodo de Comparacion entre fecha de fabricacion
 * @param arreglo estructura que se va a ordenar
 * @return comparacion entre fechas de fabricacion
 */
    public int compararf_fabric(Vehiculo arreglo) {
        int resultado;
        if (this.fechaFabricacion.compareTo(arreglo.getFec_fabricacion()) < 0) {
            resultado = -1;
        } else if (this.fechaFabricacion.compareTo(arreglo.getFec_fabricacion()) > 0) {
            resultado = 1;
        } else {

            resultado = 0;
        }
        return resultado;
    }

    //comparar placa 
    /**
     * Metodo para comparar placas
     * @param arreglo estructura que se va a ordenar
     * @return comparacion entre placas
     */
    public int compararplaca(Vehiculo arreglo) {
        int resultado;
        if (this.placa.compareTo(arreglo.getPlaca()) < 0) {
            resultado = -1;
        } else if (this.placa.compareTo(arreglo.getPlaca()) > 0) {
            resultado = 1;
        } else {
            resultado = 0;
        }
        return resultado;

    }

    //comparar Numeros
    /**
     * Metodo para comparar precios
     * @param arreglo estructura que se va a ordenar
     * @return comparacion entre precios
     */
    public int compararprecio(Vehiculo arreglo) {
        int resultado;
        if (this.precio<(arreglo.getPrecio())) {
            resultado = -1;
        } else if (this.precio > (arreglo.getPrecio())) {
            resultado = 1;
        } else {
                resultado = 0;
            }
        
        return resultado;
    }
    /**
     * Metodo CompareTo
     * @param t variable que sirve para comparar variables
     * @return valor comparado
     */
@Override

    public int compareTo(Vehiculo t) {
        if (t == null) {
            throw new NullPointerException();
        }
       // int r = getPrecio().compareTo(t.getPrecio()); 
        int r = t.getFec_fabricacion().compareTo(getFec_fabricacion());
        return r;
        
    }
   /**
    * Metodo hashcode
    * @return devuelve valor de hashcode de un objeto
    */  /*
      @Override
    public int hashCode() {
        return 31*getPrecio().hashCode() + getPrecio().hashCode();
    }*/
    /**
     * Metodo equals
     * @param o variable que servirar para comparar
     * @return verificacion si dos objetos son de dos mismas clases o no
     */
    /*
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vehiculo))
            return false;
        Vehiculo n = (Vehiculo) o;
        return n.getPrecio().equals(getPrecio());
    }*/
    /**
     * Metodo toString
     * @return impresion de variables
     */
    @Override
    public String toString() {
        return "\t\t" + precio + "\t\t" + placa + "\t\t" + fechaFabricacion;
    
    }
    
    



}
