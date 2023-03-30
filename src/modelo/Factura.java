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
public class Factura {
    private int idFactura;
    private double total;
    private Empleado idEmpleado;
    private ArrayList<Pago> pago;
    
    public Factura(){
        
    }

    public Factura(int idFactura, double total, Empleado idEmpleado, ArrayList<Pago> pago) {
        this.idFactura = idFactura;
        this.total = total;
        this.idEmpleado = idEmpleado;
        this.pago = pago;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public ArrayList<Pago> getPago() {
        return pago;
    }

    public void setPago(ArrayList<Pago> pago) {
        this.pago = pago;
    }
    
    
}
