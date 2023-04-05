/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jhonb
 */
public class Conexion {
private Connection conectar = null;
    
    public Connection conexion(){
        try {
Class.forName("com.mysql.jdbc.Driver");
conectar=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/taller","root","jhon2004");
            //JOptionPane.showMessageDialog(null, "conexion establecidad","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException|SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXION","MENSAJE ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return conectar;
    }    
}
