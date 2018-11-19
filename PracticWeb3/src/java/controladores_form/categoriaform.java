
package controladores_form;

import java.util.*;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Carlos Caiza
 */
public class categoriaform extends ActionForm{
    
    private String bandera;
    
    private ArrayList<String> codigocategoria;
    
    public ArrayList<String> getCodigocategoria() {
        return codigocategoria;
    }

    public void setCodigocategoria(ArrayList<String> codigocategoria) {
        this.codigocategoria = codigocategoria;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
    
    
            
    
}
