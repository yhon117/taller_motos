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
import modelo.Repuesto;

/**
 *
 * @author jhonb
 */
public class RepuestoController {
    
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
System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");        }
        return repuesto;
    }
    
}
