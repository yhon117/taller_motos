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
public class DetalleFactura {
    private int idDetalleFactura;
    private ArrayList<Servicio> idServicio;
    private ArrayList<Repuesto> idRepusto;
    private ArrayList<Factura> idFactura;
    private ArrayList<Ingresos> idIngreso;
    private String fecha;
    
    public DetalleFactura(){
        
    }

    public DetalleFactura(int idDetalleFactura, ArrayList<Servicio> idServicio, ArrayList<Repuesto> idRepusto, ArrayList<Factura> idFactura, ArrayList<Ingresos> idIngreso) {
        this.idDetalleFactura = idDetalleFactura;
        this.idServicio = idServicio;
        this.idRepusto = idRepusto;
        this.idFactura = idFactura;
        this.idIngreso = idIngreso;
    }

    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public ArrayList<Servicio> getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(ArrayList<Servicio> idServicio) {
        this.idServicio = idServicio;
    }

    public ArrayList<Repuesto> getIdRepusto() {
        return idRepusto;
    }

    public void setIdRepusto(ArrayList<Repuesto> idRepusto) {
        this.idRepusto = idRepusto;
    }

    public ArrayList<Factura> getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(ArrayList<Factura> idFactura) {
        this.idFactura = idFactura;
    }

    public ArrayList<Ingresos> getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(ArrayList<Ingresos> idIngreso) {
        this.idIngreso = idIngreso;
    }
    
    
    
}
