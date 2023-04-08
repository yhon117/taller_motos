/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

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

    public int getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(int idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombreRepuesto() {
        return nombreRepuesto;
    }

    public void setNombreRepuesto(String nombreRepuesto) {
        this.nombreRepuesto = nombreRepuesto;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public ArrayList<Proveedor> getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(ArrayList<Proveedor> idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public String toString(){
        return this.nombreRepuesto;
    }
       public Vector<Repuesto> nombreRepuesto() {
        String sql = "select * from repuesto";
        Conexion conexion = new Conexion();

        PreparedStatement ps;
        ResultSet rs;
        Vector<Repuesto> repuesto = new Vector<Repuesto>();
        Repuesto res = null;
        try {
            Connection con = conexion.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            res = new Repuesto();
            res.setIdRepuesto(0);
            res.setNombreRepuesto("seleciona un repuesto");
            repuesto.add(res);

            while (rs.next()) {
                res = new Repuesto();
                res.setIdRepuesto(rs.getInt("idrepuesto"));
                res.setNombreRepuesto(rs.getString("nombreRepuesto"));
                repuesto.add(res);

            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return repuesto;
    }
    
    
}
