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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import modelo.Moto;
import modelo.Servicio;

/**
 *
 * @author jhonb
 */
public class ServicioController {

    public Vector<Servicio> nombreServicio() {
        String sql = "call servicocom()";
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
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return servicio;
    }

    public Vector<Moto> nombreMoto(int id) {
        String sql = "call motocom(?)";
        Conexion conexion = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        Vector<Moto> moto = new Vector<>();
        Moto mot = null;
        try {
            Connection con = conexion.conexion();
            ps = con.prepareStatement(sql);
            

            mot = new Moto();
            mot.setIdMoto(0);
            ps.setInt(1, id);
            mot.setPlaca("selecione una placa");
            moto.add(mot);
            rs = ps.executeQuery();
            while (rs.next()) {
                mot = new Moto();
                mot.setIdMoto(rs.getInt("idmoto"));
                mot.setPlaca(rs.getString("placa"));
                mot.setIdCliente(rs.getInt("cliente_id_cliente"));

                moto.add(mot);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return moto;
    }
    
     public boolean aptuServicio(Servicio servicio){
                try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;

            String sql = "call aptuservicio(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, servicio.getNombre());
            ps.setString(2, servicio.getDescripcion());
            ps.setDouble(3, servicio.getPrecio());
            ps.setInt(4, servicio.getIdServicio());
            ps.execute();
            con.close();
            return true;

        } catch (SQLException e) {
                    System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");

        }
        return false;
    }
     
           public boolean eliminarServicio(int id) {
      try {
            Conexion conexion = new Conexion();
            Connection con = conexion.conexion();
            PreparedStatement ps;
            ResultSet rs;
            String sql = "call elimnarservicio(?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            con.close();
            ps.close();
            return true;
            

        } catch (SQLException e) {

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return false;
    }

}
