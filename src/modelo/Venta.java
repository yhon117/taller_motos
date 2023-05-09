/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author jhonb
 */
public class Venta {
    private int idVenta;
    private int idMoto;
    private int idServicio;
    private int idRepuesto;
    
    public Venta(){
        
    }

    public Venta(int idVenta, int idMoto, int idServicio, int idRepuesto) {
        this.idVenta = idVenta;
        this.idMoto=idMoto;
        this.idServicio = idServicio;
        this.idRepuesto = idRepuesto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(int idMoto) {
        this.idMoto = idMoto;
    }

    

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(int idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    
    
    

    
    
    
    
}
