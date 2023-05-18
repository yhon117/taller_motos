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
import modelo.Factura;

/**
 *
 * @author jhonb
 */
public class FacturaController {
    
    public boolean registrarFactura(Factura factura){
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;

            String sql = "call registrarfactura(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, factura.getMonto());
            ps.setString(2, factura.getCliente());
            ps.setInt(3, factura.getIdFactura());
            ps.setString(4, factura.getApellido());
          
            ps.executeUpdate();
            con.close();
            return true;

        } catch (SQLException e) {
                    System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");

        }
        return false;
    }
    
}
