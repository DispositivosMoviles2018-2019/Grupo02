/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.*;
import java.sql.*;
import java.text.*;
import controladores_form.*;

/**
 *
 * @author Carlos Caiza
 */
public class gestionProductos {
    
    modelo.conexionDB con;

    public gestionProductos(String driver, String cadena_conexion) {
        con = new conexionDB(driver,cadena_conexion);
    }
    
    public ArrayList<String> consulta_categoria(){
        
        ArrayList<String> conjunto_categoria = new ArrayList<>();
        
        try {
            Connection cn = con.getConexion();
            Statement st = cn.createStatement();
            String cadenaSQL = "select categoria_id from categoria";
            ResultSet rs = st.executeQuery(cadenaSQL);
            
            while (rs.next()){
                conjunto_categoria.add(rs.getString("categoria_id"));
                //System.out.println(rs.getString("categoria_id"));
            }
            
            con.cierraConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return conjunto_categoria;
    }
    
       public ArrayList<String> consulta_idCategoria(String categoria){
        
        ArrayList<String> conjunto_categoriaId = new ArrayList<String>();
        
        try {
            Connection cn = con.getConexion();
            Statement st = cn.createStatement();
            String cadenaSQL = "select categoria_id from categoria where categoria_id like '"+ categoria +"%'";
            ResultSet rs = st.executeQuery(cadenaSQL);
            
            while (rs.next()){
                conjunto_categoriaId.add(rs.getString("categoria_id"));
                //conjunto_productoId.add(rs.getString("categoria_id"));
                //System.out.println(rs.getString("categoria_id"));
            }
            
            con.cierraConexion(cn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return conjunto_categoriaId;
    }
    
    
    public ArrayList<productosBean> consulta_producto(String categoria_codigo){
        
        ArrayList<productosBean> conjunto_productos = new ArrayList<productosBean>();
        
        try {
            Connection cn = con.getConexion();
            Statement st = cn.createStatement();
            String cadenaSQL = "select a.categoria_id, b.categoria_nombre, a.producto_id,"
                    + " a.producto_nombre, a.producto_precio, a.producto_stock from producto a, "
                    + "categoria b where a.categoria_id = '" + categoria_codigo + "' and a.categoria_id = b.categoria_id" ;
            
            ResultSet rs = st.executeQuery(cadenaSQL);
            
            while (rs.next()){
                productosBean prod = new productosBean();
                
                prod.setId_categoria(rs.getString("categoria_id"));
                prod.setNombre_categoria(rs.getString("categoria_nombre"));
                prod.setId_producto(rs.getString("producto_id"));
                prod.setNombre_producto(rs.getString("producto_nombre"));
                prod.setPrecio_producto(rs.getDouble("producto_precio"));
                prod.setStock_producto(rs.getInt("producto_stock"));
                
                conjunto_productos.add(prod);
            }
            
            con.cierraConexion(cn);
                   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conjunto_productos;
    }
    
    
    
}
