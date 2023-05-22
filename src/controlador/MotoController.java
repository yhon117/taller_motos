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

            String sql = "INSERT INTO moto(placa, marca, modelo, kilometraje, numeroChasis, cliente_id_cliente) VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, moto.getPlaca());
            ps.setString(2, moto.getMarca());
            ps.setString(3, moto.getModelo());
            ps.setString(4, moto.getKilometraje());
            ps.setString(5, moto.getNumeroChasis());
            ps.setInt(6,moto.getIdCliente());
            ps.executeUpdate();
            con.close();
            return true;

        } catch (SQLException e) {
System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return false;

    }

    public int existePlaca(String placa) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;
            String sql = "select count(idmoto) from moto where placa=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, placa);
            rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            con.close(); 
            return 0;

        } catch (SQLException e) {
            
System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return 0;

    }

public boolean aptuMoto(Moto moto) {

        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;

            String sql = "UPDATE moto SET placa=?, marca=?, modelo=?, kilometraje=?, numeroChasis=? WHERE idmoto=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, moto.getPlaca());
            ps.setString(2, moto.getMarca());
            ps.setString(3, moto.getModelo());
            ps.setString(4, moto.getKilometraje());
            ps.setString(5, moto.getNumeroChasis());
            ps.setInt(6,moto.getIdMoto());
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
