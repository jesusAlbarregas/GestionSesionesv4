/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jesus
 */
public class Cliente implements Serializable {

    public enum TipoIdentificacion {
        NIF,
        NIE,
        Pasaporte;
        
        public TipoIdentificacion[] getValues() {
            return TipoIdentificacion.values();
        }
        
    } 
    
    private Integer idCliente;
    private String nombre;
    private Date fecha;
    private TipoIdentificacion tipoIdentificacion;
    private String identificacion;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer id) {
        this.idCliente = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    
}
