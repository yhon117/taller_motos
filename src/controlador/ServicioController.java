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
        String sql = "select * from servicios";
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
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return servicio;
    }

    public Vector<Moto> nombreMoto(){
        String sql="select*from moto";
        Conexion conexion = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        Vector<Moto> moto = new Vector<>();
        Moto mot=null;
        try {
            Connection con = conexion.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            mot = new Moto();
            mot.setIdMoto(0);
            mot.setPlaca("selecione una placa");
            moto.add(mot);
            
            while(rs.next()){
                mot=new Moto();
                mot.setIdMoto(rs.getInt("idmoto"));
                mot.setPlaca(rs.getString("placa"));
                moto.add(mot);
            }
            rs.close();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.toString());

        }
        return moto;
    }
    

 

}
