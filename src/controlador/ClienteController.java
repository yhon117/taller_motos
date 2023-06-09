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
import javax.swing.JOptionPane;
import modelo.Cliente;

/**
 *
 * @author jhonb
 */
public class ClienteController {

    public boolean insertarCliente(Cliente cliente) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;

            String sql = "call insertarcliente(?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getCedula());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getCorreo());
            ps.setString(6, cliente.getUsuario());
            ps.setString(7, cliente.getPaswoord());
            ps.setInt(8, cliente.getIdTipo());
            ps.executeUpdate();
            con.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");

        }
        return false;
    }

    public boolean existeCedula(String cedula) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;
            String sql = "call existecedula(?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return false;

    }

    public boolean existeUsuario(String usuario) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;
            String sql = "call existeusuario(?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return false;

    }

    public boolean existePaswoord(String paswoord) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;
            String sql = "call existecontrasena(?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, paswoord);
            rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return false;

    }

//    public boolean eliminarCliente(String cedula) {
//      try {
//            Conexion conexion = new Conexion();
//            Connection con = conexion.conexion();
//            PreparedStatement ps;
//            ResultSet rs;
//            String sql = "delete from cliente where cedula=?";
//            ps = con.prepareStatement(sql);
//            ps.setString(1, cedula);
//            ps.execute();
//            con.close();
//            ps.close();
//            return true;
//            
//
//        } catch (SQLException e) {
//
//            System.out.println(e);
//            JOptionPane.showMessageDialog(null, "ERROR");
//        }
//        return false;
//    }
    
    public boolean aptualizarCliente(Cliente cliente) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;

            String sql = "call aptucliente(?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getCedula());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getTelefono());
            ps.setString(5, cliente.getCorreo());
            ps.setString(6, cliente.getUsuario());
            ps.setString(7, cliente.getPaswoord());
            ps.setInt(8, cliente.getIdTipo());
            ps.setInt(9, cliente.getIdCliente());
            ps.execute();
            con.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");

        }
        return false;
    }

}
