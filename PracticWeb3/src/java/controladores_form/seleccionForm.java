/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores_form;

import java.util.*;
import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;
//import org.apache.struts.action.ActionForm;

/**
 *
 * @author Carlos Caiza
 */
public class seleccionForm extends ActionForm {
    
    private String codigo_cat;

    public String getCodigo_cat() {
        return codigo_cat;
    }

    public void setCodigo_cat(String codigo_cat) {
        this.codigo_cat = codigo_cat;
    }
    
    
}
