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

//    public void cosultaNombreServicio(JComboBox nombreServicio) {
//        String sql = "select nombre from servicios";
//        Conexion conexion = new Conexion();
//
//        PreparedStatement ps;
//        ResultSet rs;
//        try {
//            Connection con = conexion.conexion();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            nombreServicio.addItem("selecione un servicio");
//            while (rs.next()) {
//                nombreServicio.addItem(rs.getString("nombre"));
//
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e.toString());
//        }
//    }

//    public Vector<Servicio> nombreServicio() {
//        String sql = "select * from servicios";
//        Conexion conexion = new Conexion();
//
//        PreparedStatement ps;
//        ResultSet rs;
//        Vector<Servicio> servicio = new Vector<Servicio>();
//        Servicio ser = null;
//        try {
//            Connection con = conexion.conexion();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            ser = new Servicio();
//            ser.setIdServicio(0);
//            ser.setNombre("seleciona un servicio");
//            servicio.add(ser);
//
//            while (rs.next()) {
//                ser = new Servicio();
//                ser.setIdServicio(rs.getInt("id_srevicio"));
//                ser.setNombre(rs.getString("nombre"));
//                servicio.add(ser);
//
//            }
//            rs.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e.toString());
//        }
//        return servicio;
//    }

    public void cosultaMotoServicio(JComboBox motoServicio) {
        String sql = "select placa from moto";
        Conexion conexion = new Conexion();

        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection con = conexion.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            motoServicio.addItem("selecione una moto para el servicio");

            while (rs.next()) {
                motoServicio.addItem(rs.getString("placa"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    public void cosultaPrecioServicio(JLabel precioServicio) {
        String sql = "select precio from servicios";
        Conexion conexion = new Conexion();

        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection con = conexion.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                precioServicio.setText(rs.getString("precio"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

//    public void cosultaDescripcionServicio(JTextArea descripcioServicio) {
//        String sql = "select descripcion from servicios";
//        Conexion conexion = new Conexion();
//
//        PreparedStatement ps;
//        ResultSet rs;
//        try {
//            Connection con = conexion.conexion();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                descripcioServicio.append(rs.getString("descripcion"));
//
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, e.toString());
//        }
//    }

}
