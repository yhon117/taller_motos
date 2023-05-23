/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Repuesto;
import modelo.Servicio;

/**
 *
 * @author jhonb
 */
public class ReportesController {
    
    public Vector<Cliente> usuario(){
        String sql="call clientebox()";
        Conexion conexion = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        
        Vector<Cliente> cliente = new Vector<>();
        Cliente cli=null;
        
        try {
            Connection con =conexion.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            cli=new Cliente();
            cli.setIdCliente(0);
            cli.setUsuario("selecione un usuario");
            cliente.add(cli);
            
            while(rs.next()){
                cli = new Cliente();
                cli.setIdCliente(rs.getInt("id_cliente"));
                cli.setUsuario(rs.getString("usuario"));
                cliente.add(cli);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return cliente;
    }
    
    public boolean insertarServicio(Servicio servicio){
                try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;

            String sql = "call isertarservicio(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, servicio.getNombre());
            ps.setString(2, servicio.getDescripcion());
            ps.setDouble(3, servicio.getPrecio());
            ps.executeUpdate();
            con.close();
            return true;

        } catch (SQLException e) {
                    System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");

        }
        return false;
    }
    public boolean existeServicio(String nombre) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;
            String sql = "call existeservicio(?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            return rs.next();
            
            
        } catch (SQLException e) {
            
System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return false;

    }
      public boolean insertarRepuesto(Repuesto repuesto){
                try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;

            String sql = "call isertarrepuesto(?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, repuesto.getNombreRepuesto());
            ps.setDouble(2, repuesto.getCosto());
            ps.executeUpdate();
            con.close();
            return true;

        } catch (SQLException e) {
                    System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");

        }
        return false;
    }
       public boolean existeRepuesto(String nombre) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;
            String sql = "call existerepuesto(?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            return rs.next();
            
            
        } catch (SQLException e) {
            
System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return false;

    }
}
