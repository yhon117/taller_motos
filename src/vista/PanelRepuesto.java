/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.Conexion;
import controlador.ServicioController;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Repuesto;

/**
 *
 * @author jhonb
 */
public class PanelRepuesto extends javax.swing.JPanel {

    /**
     * Creates new form VistaRepuesto
     */
    Repuesto repuesto = new Repuesto();
    ServicioController servicioCon = new ServicioController();
    public PanelRepuesto() {
        initComponents();
        lbPrecioRepuesto.setText("");
        servicioCon.cosultaMotoServicio(cbRepuesto);
        DefaultComboBoxModel mostrarNombre = new DefaultComboBoxModel(repuesto.nombreRepuesto());
        cbRepuesto.setModel(mostrarNombre);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        cbElejirMoto = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbRepuesto = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lbPrecioRepuesto = new javax.swing.JLabel();

        jLabel2.setText("Elija la moto");

        jLabel1.setText("Nombre del repuesto");

        cbRepuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRepuestoItemStateChanged(evt);
            }
        });
        cbRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRepuestoActionPerformed(evt);
            }
        });

        jLabel3.setText("VALOR DEL REPUESTO");

        lbPrecioRepuesto.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbElejirMoto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbRepuesto, javax.swing.GroupLayout.Alignment.LEADING, 0, 171, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lbPrecioRepuesto)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbElejirMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(lbPrecioRepuesto))
                .addContainerGap(172, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbRepuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRepuestoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Repuesto repuestoCon = (Repuesto) cbRepuesto.getSelectedItem();
            try {
                PreparedStatement ps;
                ResultSet rs;
                Conexion conetar = new Conexion();
                Connection con = conetar.conexion();
                String sql = "select costo from repuesto where idrepuesto=" + repuestoCon.getIdRepuesto();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    lbPrecioRepuesto.setText(rs.getString("costo"));

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
       
        }
    }//GEN-LAST:event_cbRepuestoItemStateChanged

    private void cbRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRepuestoActionPerformed
        // TODO add your handling code here:
        //        mostrarPrecio();
        //        servicioControl.cosultaPrecioServicio(lbPrecioServicio);
    }//GEN-LAST:event_cbRepuestoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbElejirMoto;
    private javax.swing.JComboBox<String> cbRepuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbPrecioRepuesto;
    // End of variables declaration//GEN-END:variables
}