package com.example.andres.final_2h_g02.ec.edu.uce.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva implements Serializable {

    private Integer  numero;
    private String email;
    private Date fecPrestamo;
    private Date fecEntrega;
    private Double valor;
    private String celular;
    private String placavh;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    public Reserva(){
    }

    public Reserva(Integer numero, String email, Date fecPrestamo, Date fecEntrega, Double valor, String celular, String placavh){
        this.numero=numero;
        this.email=email;
        this.fecPrestamo=fecPrestamo;
        this.fecEntrega=fecEntrega;
        this.valor=valor;
        this.celular=celular;
        this.placavh=placavh;
    }


    public String getPlacavh() {
        return placavh;
    }

    public void setPlacavh(String placavh) {
        this.placavh = placavh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecPrestamo() {
        return fecPrestamo;
    }

    public void setFecPrestamo(Date fecPrestamo) {
        this.fecPrestamo = fecPrestamo;
    }

    public Date getFecEntrega() {
        return fecEntrega;
    }

    public void setFecEntrega(Date fecEntrega) {
        this.fecEntrega = fecEntrega;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String str;
        return "Numero=" + numero +
                ", Email=" + email +
                ", FecPrestamo=" + formateador.format(fecPrestamo) +
                ", FecEntrega=" + formateador.format(fecEntrega) +
                ", Valor=" + valor +
                ", Celular=" + celular +
                ", Placa=" + placavh ;
    }

    public JSONObject getJSONObject() {

        String str;
        JSONObject obj = new JSONObject();
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
            obj.put("numero", this.numero);
            obj.put("email", this.email);
            obj.put("fecprestamo",formateador.format(this.getFecPrestamo()));
            obj.put("fecentrega",formateador.format(this.getFecEntrega()));
            obj.put("costo", this.valor);
            obj.put("celular", this.celular);
            obj.put("placavh", this.placavh);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

}

