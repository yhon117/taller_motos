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
public class TipoPago {
    private int idTipoPago;
    private String nombre;

    public TipoPago(){
        
    }
    public TipoPago(int idTipoPago, String nombre) {
        this.idTipoPago = idTipoPago;
        this.nombre = nombre;
    }

    public int getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
