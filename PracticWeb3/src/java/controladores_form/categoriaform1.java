
package controladores_form;

import java.util.*;
import org.apache.struts.action.ActionForm;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Carlos Caiza
 */
public class categoriaform1 extends ActionForm{
    
    private String cate;
    private String bandera;
    
     public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
    
    
    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }
    
  
    
    
            
    
}
