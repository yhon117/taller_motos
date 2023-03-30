/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Mauricio
 */
public class Pago {
    private int idPago;
    private String fechaPago;
    private double montoPago;
    private TipoPago tipoPago;

    public Pago(){
        
    }
    
    public Pago(int idPago, String fechaPago, double montoPago, TipoPago tipoPago) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.montoPago = montoPago;
        this.tipoPago = tipoPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }
    
    
}
