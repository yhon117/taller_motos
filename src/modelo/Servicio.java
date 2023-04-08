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
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author jhonb
 */
public class Servicio {
    
    private int idServicio;
    private String nombre;
    private String descripcion;
    private double precio;
    private int estado;
    
    public Servicio(){
        
    }

    public Servicio(int idServicio, String nombre, String descripcion, double precio, int estado) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public String toString(){
        return this.nombre;
    }
       public Vector<Servicio> nombreServicio() {
        String sql = "select * from servicios";
        Conexion conexion = new Conexion();

        PreparedStatement ps;
        ResultSet rs;
        Vector<Servicio> servicio = new Vector<Servicio>();
        Servicio ser = null;
        try {
            Connection con = conexion.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ser = new Servicio();
            ser.setIdServicio(0);
            ser.setNombre("seleciona un servicio");
            servicio.add(ser);

            while (rs.next()) {
                ser = new Servicio();
                ser.setIdServicio(rs.getInt("id_srevicio"));
                ser.setNombre(rs.getString("nombre"));
                servicio.add(ser);

            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return servicio;
    }
    
}
