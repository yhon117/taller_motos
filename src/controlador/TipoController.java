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
import modelo.Servicio;
import modelo.TipoRol;

/**
 *
 * @author jhonb
 */
public class TipoController {
    public Vector<TipoRol> nombreTipo() {
        String sql = "call tipocom()";
        Conexion conexion = new Conexion();

        PreparedStatement ps;
        ResultSet rs;
        Vector<TipoRol> servicio = new Vector<TipoRol>();
        TipoRol ser = null;
        try {
            Connection con = conexion.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ser = new TipoRol();
            ser.setIdTipo(0);
            ser.setNombrePerfil("seleciona un rol");
            servicio.add(ser);

            while (rs.next()) {
                ser = new TipoRol();
                ser.setIdTipo(rs.getInt("idtipo"));
                ser.setNombrePerfil(rs.getString("tipoperfiles"));
                servicio.add(ser);

            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return servicio;
    }
}
