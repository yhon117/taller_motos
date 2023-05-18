/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jhonb
 */
public class Factura {
  private int idFactura; 
  private String monto; 
  private String cliente; 
  private String apellido;
  private int venta_idventa; 
  
  public Factura(){
      
  }

    public Factura(int idFactura, String monto, String cliente, String apellido, int venta_idventa) {
        this.idFactura = idFactura;
        this.monto = monto;
        this.cliente = cliente;
        this.apellido = apellido;
        this.venta_idventa = venta_idventa;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getVenta_idventa() {
        return venta_idventa;
    }

    public void setVenta_idventa(int venta_idventa) {
        this.venta_idventa = venta_idventa;
    }
  
  
    
    
}
