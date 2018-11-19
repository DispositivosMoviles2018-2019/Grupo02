/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores_action;

import javax.servlet.http.*;
import org.apache.struts.action.*;
import org.apache.struts.actions.*;
import controladores_form.*;
import modelo.*;
import java.util.*;

/**
 *
 * @author Carlos Caiza
 */
public class categoriaAction1 extends Action{
    
    public ActionForward execute (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        String driver = this.getServlet().getServletContext().getInitParameter("driver");
        String cadena_conexion = this.getServlet().getServletContext().getInitParameter("cadena_conexion");
        
        categoriaform cb = (categoriaform)form;
        gestionProductos gp = new gestionProductos(driver, cadena_conexion);
        
        cb.setCodigocategoria(gp.consulta_categoria());
        
        return mapping.findForward("categoriajsp");
    }
    
}
