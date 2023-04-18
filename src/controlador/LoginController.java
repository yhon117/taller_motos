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

    public boolean Login(String txtUse, String txtPass) {
        try {
            ResultSet rs = null;
            PreparedStatement ps = null;

            Conexion conectar = new Conexion();
            String consulta = "select * from cliente where cliente.usuario=(?) and cliente.contrasena=(?);";
            ps = conectar.conexion().prepareStatement(consulta);

            
            ps.setString(1, txtUse);
            ps.setString(2, txtPass);

            rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e);

        }
return false;
    }

    public ArrayList buscarDatosCliente(String usuario) {
        Conexion conexion = new Conexion();
        Connection cn = conexion.conexion();
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        String buscar = "select cedula, nombre, apellido, telefono, correo, usuario,contrasena from cliente WHERE usuario = ?";
        try {
            PreparedStatement ps = cn.prepareStatement(buscar);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCedula(rs.getString("cedula"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setUsuario(rs.getString("usuario"));
                cliente.setPaswoord(rs.getString("contrasena"));
                lista.add(cliente);
            }
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR:" + e);

        }
        return lista;
    }
}
