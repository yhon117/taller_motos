/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mysql.cj.xdevapi.PreparableStatement;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import modelo.Venta;

/**
 *
 * @author jhonb
 */
public class VentaController {

    public boolean vebntaServicio(Venta venta) {
        try {
            Conexion conexion = new Conexion();
            PreparedStatement ps = null;
            Connection con = conexion.conexion();

            String sql = "call isertarventa(?,?,?,?,?)";
            ps = con.prepareStatement(sql);

            
            
            ps.setInt(1, venta.getIdMoto());
            ps.setString(2, venta.getNombreServicio());
            ps.setDouble(3, venta.getPrecioServicio());
            ps.setString(4, venta.getNombreRepuesto());
            ps.setDouble(5, venta.getPrecioRepuesto());

            ps.executeUpdate();

            con.close();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");

        }
        return false;
    }
}
