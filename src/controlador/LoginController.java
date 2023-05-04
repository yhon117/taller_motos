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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.Cliente;
import vista.VistaLogin;
import vista.VistaPrincipal;

/**
 *
 * @author jhonb
 */
public class LoginController {

    public boolean Login(Cliente cliente) {
        try {
            ResultSet rs = null;
            PreparedStatement ps = null;

            Conexion conectar = new Conexion();
            String consulta = "select id_cliente, cedula, nombre, apellido, telefono, correo, usuario,contrasena, tipo_idtipo from cliente where usuario=(?) and contrasena=(?);";
            ps = conectar.conexion().prepareStatement(consulta);

             
            ps.setString(1, cliente.getUsuario());
            ps.setString(2, cliente.getPaswoord());

            rs = ps.executeQuery();
            
            if(rs.next()){
                cliente.setIdCliente(rs.getInt(1));
                cliente.setCedula(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                cliente.setApellido(rs.getString(4));
                cliente.setTelefono(rs.getString(5));
                cliente.setCorreo(rs.getString(6));
                cliente.setIdTipo(rs.getInt(9));
                  ps.close();
            rs.close();
                return true;

            }else{
                return false;
            }            

        } catch (SQLException e) {
           System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");

        }
return false;
    }

//    public ArrayList buscarDatosCliente(String usuario) {
//        Conexion conexion = new Conexion();
//        Connection cn = conexion.conexion();
//        ArrayList<Cliente> lista = new ArrayList<Cliente>();
//        String buscar = "select cedula, nombre, apellido, telefono, correo, usuario,contrasena, tipo_idtipo from cliente WHERE usuario = ?";
//        try {
//            PreparedStatement ps = cn.prepareStatement(buscar);
//            ps.setString(1, usuario);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                Cliente cliente = new Cliente();
//                cliente.setCedula(rs.getString("cedula"));
//                cliente.setNombre(rs.getString("nombre"));
//                cliente.setApellido(rs.getString("apellido"));
//                cliente.setTelefono(rs.getString("telefono"));
//                cliente.setCorreo(rs.getString("correo"));
//                cliente.setUsuario(rs.getString("usuario"));
//                cliente.setPaswoord(rs.getString("contrasena"));
//                cliente.setIdTipo(rs.getInt(8));
//                lista.add(cliente);
//            }
//            cn.close();
//
//        } catch (SQLException e) {
//System.out.println(e);
//            JOptionPane.showMessageDialog(null, "ERROR");
//        }
//        return lista;
//    }
}
