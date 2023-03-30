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
public class Repuesto {
    
    private int idRepuesto;
    private String nombreRepuesto;
    private double costo;
    private ArrayList<Proveedor> idProveedor;
    
    public Repuesto(){
       this.idProveedor = new ArrayList<Proveedor>(); 
    }

    
    public Repuesto(int idRepuesto, String nombreRepuesto, double costo) {
        this.idRepuesto = idRepuesto;
        this.nombreRepuesto = nombreRepuesto;
        this.costo = costo;
        this.idProveedor = new ArrayList<Proveedor>();
    }

    public Repuesto(int idRepuesto, String nombreRepuesto, double costo, ArrayList<Proveedor> idProveedor) {
        this.idRepuesto = idRepuesto;
        this.nombreRepuesto = nombreRepuesto;
        this.costo = costo;
        this.idProveedor = idProveedor;
    }
    
    
    
    
}
