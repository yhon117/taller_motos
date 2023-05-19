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
import java.util.Vector;
import javax.swing.JOptionPane;
import modelo.Cliente;

/**
 *
 * @author jhonb
 */
public class ReportesController {
    
    public Vector<Cliente> cedula(){
        String sql="select * from cliente";
        Conexion conexion = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        
        Vector<Cliente> cliente = new Vector<>();
        Cliente cli=null;
        
        try {
            Connection con =conexion.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            cli=new Cliente();
            cli.setIdCliente(0);
            cli.setCedula("selecione una cedula");
            cliente.add(cli);
            
            while(rs.next()){
                cli = new Cliente();
                cli.setIdCliente(rs.getInt("id_cliente"));
                cli.setCedula(rs.getString("cedula"));
                cliente.add(cli);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return cliente;
    }
}
