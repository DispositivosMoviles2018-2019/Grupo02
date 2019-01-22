package com.example.andres.final_2h_g02.ec.edu.uce.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Usuario implements Serializable  {
    private String usuario;
    private String clave;


    public Usuario(){
    }

    public Usuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }



    @Override
    public String toString() {
        return "Usuario=" + usuario ;
               // ", Clave=" + clave+

    }

    public JSONObject getJSONObject() {

        String str;
        JSONObject obj = new JSONObject();
        try {
            //SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
            obj.put("usuario", this.getUsuario());
            obj.put("contraseña", this.getClave());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
