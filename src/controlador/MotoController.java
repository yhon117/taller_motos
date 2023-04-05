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
import modelo.Moto;

/**
 *
 * @author jhonb
 */
public class MotoController {

    public boolean insertarMoto(Moto moto) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;

            String sql = "INSERT INTO moto(placa, marca, modelo, kilometraje, numeroChasis) VALUES(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, moto.getPlaca());
            ps.setString(2, moto.getMarca());
            ps.setString(3, moto.getModelo());
            ps.setString(4, moto.getKilometraje());
            ps.setString(5, moto.getNumeroChasis());
            ps.executeUpdate();
            con.close();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());

        }
        return false;

    }

    public boolean existePlaca(String placa) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;
            String sql = "select * from moto where placa=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, placa);
            rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, e.toString());

        }
        return false;

    }

}
