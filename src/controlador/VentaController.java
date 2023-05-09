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

            String sql = "INSERT INTO venta(repuesto_idrepuesto, servicios_id_srevicio, moto_idmoto) VALUES (?,?,?)";
            ps = con.prepareStatement(sql);

            
            ps.setInt(1, venta.getIdRepuesto());
            ps.setInt(2, venta.getIdServicio());
            ps.setInt(3, venta.getIdMoto());

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
