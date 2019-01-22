package com.example.andres.final_2h_g02.ec.edu.uce.modelo;

import android.database.Cursor;

/**
 * Esta interface nos permite manejar las operaciones básicas al momento de almacenar los datos del programa.
 * (Insertar, Editar, Eliminar, Buscar y Listar)
 * 
 * @author Ing. Giovanny Moncayo Unda. MSc. 
 * @version 2019-01-08
 */

public interface InterfazCRUD {
    
     /**
     * Metodo que permite crear un nuevo Objeto de cualquier clase.
     * @param vh Es el nuevo Objeto que se va a crear
     * @return Un mensaje para alertar al usuario
     */    
    public void ingresarVehiculo(Vehiculo vh);
    
    /**
     * Metodo que permite actualizar el estado de un Objeto.
     * @param codigo El id del Objeto a ser actualizado
     * @return Un mensaje para alertar al usuario
     */
    public void editarVh(String codigo, Vehiculo vh);
    
    /**
     * Metodo que permite eliminar un Objeto
     * @param codigo El id del Objeto a ser eliminado
     * @return Un mensaje para alertar al usuario
     */
    public void eliminarVH(String codigo);
    
    /**
     * Metodo que permite buscar un Objeto
     * @param vehiculos La coleccion donde se va a buscar
     * @param codigo El parametro del Objeto que se está buscando
     * @return El Objeto encontrado, si el objeto no existe, retorna null
     */
    public int buscarVh(Vehiculo vehiculos, String codigo);
        
    /**
     * Metodo que permita listar los Objetos
     * 
     * @return La colección con el resultado
     */
    public Cursor vista();
    
}
