
package modelo;

import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.SQLException;


/**
 *
 * @author Carlos Caiza
 */
public class conexionDB {
    
    private String driver;
    private String cadenacon;
    
    public conexionDB(){
    }
    
    public conexionDB(String driver, String cadena_conexion){
        this.driver = driver;
        this.cadenacon = cadena_conexion;
    }
    
    public Connection getConexion(){
        Connection cn = null;
        try {            
            Class.forName(driver).newInstance();
            cn = DriverManager.getConnection(cadenacon,"root","admin");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }
    
    public void cierraConexion(Connection cn){
        try {
            if (cn!=null && !cn.isClosed()) {
                cn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
