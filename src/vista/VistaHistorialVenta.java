/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.Conexion;
import controlador.ReportesController;
import controlador.RepuestoController;
import controlador.ServicioController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Repuesto;
import modelo.Servicio;

/**
 *
 * @author jhonb
 */
public class VistaHistorialVenta extends javax.swing.JFrame {

    /**
     * Creates new form VistaHistorialVenta
     */
        ReportesController reporteCon = new ReportesController();
        ServicioController servicioCon = new ServicioController();
        RepuestoController repuestoCon = new RepuestoController();

    Cliente mod;

    public VistaHistorialVenta() {
        initComponents();
    }

    public VistaHistorialVenta(Cliente mod) {
        initComponents();
        this.mod = mod;
        lbAdmin.setText(mod.getUsuario());
        this.setLocationRelativeTo(null);
        lbTotalServicio.setText("");
        lbTotalRepuesto.setText("");
        DefaultComboBoxModel mostrarNombre = new DefaultComboBoxModel(servicioCon.nombreServicio());
        cbServicio.setModel(mostrarNombre);
        DefaultComboBoxModel cedula = new DefaultComboBoxModel(reporteCon.usuario());
        cbCedula.setModel(cedula);
        DefaultComboBoxModel nombreRpuesto = new DefaultComboBoxModel(repuestoCon.nombreRepuesto());
        cbRepuesto.setModel(nombreRpuesto);
        DefaultComboBoxModel cedulaRe = new DefaultComboBoxModel(reporteCon.usuario());
        cbCedulaRepuesto.setModel(cedulaRe);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgServicio = new javax.swing.ButtonGroup();
        bgRepuesto = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRepuesto = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaServicio = new javax.swing.JTable();
        rbServicioVendido = new javax.swing.JRadioButton();
        rbServioMenosVendido = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbAdmin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbTotalServicio = new javax.swing.JLabel();
        rbRepuestoMasVendido = new javax.swing.JRadioButton();
        rbRepuestoMenosVendido = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbTotalRepuesto = new javax.swing.JLabel();
        cbServicio = new javax.swing.JComboBox<>();
        cbCedula = new javax.swing.JComboBox<>();
        cbRepuesto = new javax.swing.JComboBox<>();
        cbCedulaRepuesto = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaRepuesto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaRepuesto);

        tablaServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaServicio);

        bgServicio.add(rbServicioVendido);
        rbServicioVendido.setText("servicio mas vendido");

        bgServicio.add(rbServioMenosVendido);
        rbServioMenosVendido.setText("servicio menos vendido");

        jButton1.setText("todos los servicios ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Administrador");

        lbAdmin.setText("jLabel2");

        jLabel2.setText("TOTAL DE SEVICIOS");

        lbTotalServicio.setText("jLabel3");

        bgRepuesto.add(rbRepuestoMasVendido);
        rbRepuestoMasVendido.setText("Repuesto mas vendio");

        bgRepuesto.add(rbRepuestoMenosVendido);
        rbRepuestoMenosVendido.setText("Rpuesto menos vendido");
        rbRepuestoMenosVendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRepuestoMenosVendidoActionPerformed(evt);
            }
        });

        jButton3.setText("todos los repuesto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("TOTAL DE REPUESTO");

        lbTotalRepuesto.setText("jLabel4");

        cbServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbServicioItemStateChanged(evt);
            }
        });

        cbCedula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCedula.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCedulaItemStateChanged(evt);
            }
        });

        cbRepuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRepuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRepuestoItemStateChanged(evt);
            }
        });

        cbCedulaRepuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCedulaRepuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCedulaRepuestoItemStateChanged(evt);
            }
        });

        jMenu1.setText("Salir");

        jMenuItem1.setText("volver al menu pricipal");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar))
                            .addComponent(rbRepuestoMasVendido)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbCedulaRepuesto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbRepuesto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbRepuestoMenosVendido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbTotalServicio))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbTotalRepuesto)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rbServicioVendido)
                            .addComponent(rbServioMenosVendido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbAdmin))
                            .addComponent(cbServicio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbCedula, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(274, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(7, 7, 7)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbAdmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbServicioVendido)
                .addGap(18, 18, 18)
                .addComponent(rbServioMenosVendido)
                .addGap(18, 18, 18)
                .addComponent(cbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbRepuestoMasVendido)
                                .addGap(18, 18, 18)
                                .addComponent(rbRepuestoMenosVendido)
                                .addGap(18, 18, 18)
                                .addComponent(cbRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(cbCedulaRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbTotalRepuesto)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbTotalServicio))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(331, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        double total = 0;
        try {
            DefaultTableModel model = new DefaultTableModel();
            tablaServicio.setModel(model);
            Conexion conetar = new Conexion();
            Connection con = conetar.conexion();
            PreparedStatement ps = con.prepareStatement("call historialservicio()");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = ps.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                model.addColumn(metaData.getColumnLabel(i));
            }
            while (rs.next()) {

                Object[] filas = new Object[metaData.getColumnCount()];
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    filas[i] = rs.getObject(i + 1);
                    if (i == 5) {
                        total += Double.parseDouble(filas[i].toString());
                    }
                }
                model.addRow(filas);
            }

            ps.close();
            ps.close();
            con.close();
            lbTotalServicio.setText("" + total);
            

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        double total = 0;
        try {
            DefaultTableModel model = new DefaultTableModel();
            tablaRepuesto.setModel(model);
            Conexion conetar = new Conexion();
            Connection con = conetar.conexion();
            PreparedStatement ps = con.prepareStatement("call historialrepuesto()");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = ps.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                model.addColumn(metaData.getColumnLabel(i));
            }
            while (rs.next()) {

                Object[] filas = new Object[metaData.getColumnCount()];
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    filas[i] = rs.getObject(i + 1);
                    if (i == 5) {
                        total += Double.parseDouble(filas[i].toString());
                    }
                }
                model.addRow(filas);
            }

            ps.close();
            ps.close();
            con.close();
            lbTotalRepuesto.setText("" + total);

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        filtro();
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cbServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbServicioItemStateChanged
        // TODO add your handling code here:
        filtroCombo();
    }//GEN-LAST:event_cbServicioItemStateChanged

    private void cbCedulaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCedulaItemStateChanged
        // TODO add your handling code here:
        
        filtraCeula();
    }//GEN-LAST:event_cbCedulaItemStateChanged

    private void rbRepuestoMenosVendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRepuestoMenosVendidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbRepuestoMenosVendidoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        filtroRepueto();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbRepuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRepuestoItemStateChanged
        // TODO add your handling code here:
        filttoRepuestoCombo();
    }//GEN-LAST:event_cbRepuestoItemStateChanged

    private void cbCedulaRepuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCedulaRepuestoItemStateChanged
        // TODO add your handling code here:
        filtraComboCedula();
    }//GEN-LAST:event_cbCedulaRepuestoItemStateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        VistaPrincipal salir = new VistaPrincipal(mod);
        salir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void filtro() {

        try {
            if (!rbServicioVendido.isSelected() && !rbServioMenosVendido.isSelected()) {
                JOptionPane.showMessageDialog(rootPane, "elija una opcion");
            } else {
                if (rbServicioVendido.isSelected()) {
                    try {
                        DefaultTableModel model = new DefaultTableModel();
                        tablaServicio.setModel(model);
                        Conexion conetar = new Conexion();
                        Connection con = conetar.conexion();
                        PreparedStatement ps = con.prepareStatement("call serviciomasvendido()");
                        ResultSet rs = ps.executeQuery();
                        ResultSetMetaData metaData = ps.getMetaData();

                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                            model.addColumn(metaData.getColumnLabel(i));
                        }
                        while (rs.next()) {

                            Object[] filas = new Object[metaData.getColumnCount()];
                            for (int i = 0; i < metaData.getColumnCount(); i++) {
                                filas[i] = rs.getObject(i + 1);

                            }
                            model.addRow(filas);
                        }

                        ps.close();
                        ps.close();
                        con.close();
                        lbTotalServicio.setText("");


                    } catch (SQLException e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(null, "ERROR");
                    }
                }

                if (rbServioMenosVendido.isSelected()) {
                    try {
                        DefaultTableModel model = new DefaultTableModel();
                        tablaServicio.setModel(model);
                        Conexion conetar = new Conexion();
                        Connection con = conetar.conexion();
                        PreparedStatement ps = con.prepareStatement("call serviciomenosvendido()");
                        ResultSet rs = ps.executeQuery();
                        ResultSetMetaData metaData = ps.getMetaData();

                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                            model.addColumn(metaData.getColumnLabel(i));
                        }
                        while (rs.next()) {

                            Object[] filas = new Object[metaData.getColumnCount()];
                            for (int i = 0; i < metaData.getColumnCount(); i++) {
                                filas[i] = rs.getObject(i + 1);

                            }
                            model.addRow(filas);
                        }

                        ps.close();
                        ps.close();
                        con.close();
                        lbTotalServicio.setText("");


                    } catch (SQLException e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(null, "ERROR");
                    }
                }
            }


        } catch (Exception e) {
        }
    }

    
    private void filtroCombo(){
        double total=0;
                Servicio serCon = (Servicio)cbServicio.getSelectedItem();

               String valorSeleccionadoSer = cbServicio.getSelectedItem().toString();

        try {
              if(valorSeleccionadoSer.equals("seleciona un servicio")){

              JOptionPane.showMessageDialog(null, "selecione el servicio");
            }else{
                try {
            DefaultTableModel model = new DefaultTableModel();
            tablaServicio.setModel(model);
            Conexion conetar = new Conexion();
            Connection con = conetar.conexion();
            PreparedStatement ps = con.prepareStatement("call reporteservicioid(?)");
            ps.setString(1, serCon.getNombre());
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = ps.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                model.addColumn(metaData.getColumnLabel(i));
            }
            while (rs.next()) {

                Object[] filas = new Object[metaData.getColumnCount()];
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    filas[i] = rs.getObject(i + 1);
                   if (i == 6) {
                        total += Double.parseDouble(filas[i].toString());
                    }
                }
                model.addRow(filas);
            }

            ps.close();
            ps.close();
            con.close();
            lbTotalServicio.setText(""+total);
            bgServicio.clearSelection();

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
            }
        } catch (Exception e) {
        }
    }
    
    private void filtraCeula(){
        double total=0;
        Cliente cli =(Cliente) cbCedula.getSelectedItem();
              String valorSeleccionadoSer = cbCedula.getSelectedItem().toString();

        try {
              if(valorSeleccionadoSer.equals("selecione un usuario")){

              JOptionPane.showMessageDialog(null, "selecione un usuario");
            }else{
                try {
            DefaultTableModel model = new DefaultTableModel();
            tablaServicio.setModel(model);
            Conexion conetar = new Conexion();
            Connection con = conetar.conexion();
            PreparedStatement ps = con.prepareCall("call reporteserviciousuario(?)");
            ps.setString(1, cli.getUsuario());
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = ps.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                model.addColumn(metaData.getColumnLabel(i));
            }
            while (rs.next()) {

                Object[] filas = new Object[metaData.getColumnCount()];
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    filas[i] = rs.getObject(i + 1);
                   if (i == 6) {
                        total += Double.parseDouble(filas[i].toString());
                    }
                }
                model.addRow(filas);
            }

            ps.close();
            ps.close();
            con.close();
            lbTotalServicio.setText(""+total);
            bgServicio.clearSelection();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
            }
        } catch (Exception e) {
        }
    }
    
     private void filtroRepueto() {

        try {
            if (!rbRepuestoMasVendido.isSelected() && !rbRepuestoMenosVendido.isSelected()) {
                JOptionPane.showMessageDialog(rootPane, "elija una opcion");
            } else {
                if (rbRepuestoMasVendido.isSelected()) {
                    try {
                        DefaultTableModel model = new DefaultTableModel();
                        tablaRepuesto.setModel(model);
                        Conexion conetar = new Conexion();
                        Connection con = conetar.conexion();
                        PreparedStatement ps = con.prepareStatement("call repuestomasvendido()");
                        ResultSet rs = ps.executeQuery();
                        ResultSetMetaData metaData = ps.getMetaData();

                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                            model.addColumn(metaData.getColumnLabel(i));
                        }
                        while (rs.next()) {

                            Object[] filas = new Object[metaData.getColumnCount()];
                            for (int i = 0; i < metaData.getColumnCount(); i++) {
                                filas[i] = rs.getObject(i + 1);

                            }
                            model.addRow(filas);
                        }

                        ps.close();
                        ps.close();
                        con.close();
                        lbTotalRepuesto.setText("");
                        


                    } catch (SQLException e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(null, "ERROR");
                    }
                }

                if (rbRepuestoMenosVendido.isSelected()) {
                    try {
                        DefaultTableModel model = new DefaultTableModel();
                        tablaRepuesto.setModel(model);
                        Conexion conetar = new Conexion();
                        Connection con = conetar.conexion();
                        PreparedStatement ps = con.prepareStatement("call repuestomenosvendido()");
                        ResultSet rs = ps.executeQuery();
                        ResultSetMetaData metaData = ps.getMetaData();

                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                            model.addColumn(metaData.getColumnLabel(i));
                        }
                        while (rs.next()) {

                            Object[] filas = new Object[metaData.getColumnCount()];
                            for (int i = 0; i < metaData.getColumnCount(); i++) {
                                filas[i] = rs.getObject(i + 1);

                            }
                            model.addRow(filas);
                        }

                        ps.close();
                        ps.close();
                        con.close();
                        lbTotalServicio.setText("");

                    } catch (SQLException e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(null, "ERROR");
                    }
                }
            }


        } catch (Exception e) {
        }
    }

     private void filttoRepuestoCombo(){
         double total=0;
                 Repuesto reCon = (Repuesto) cbRepuesto.getSelectedItem();

      String valorSeleccionadoSer = cbRepuesto.getSelectedItem().toString();

         try {
              if(valorSeleccionadoSer.equals("seleciona un repuesto")){

              JOptionPane.showMessageDialog(null, "selecione el repuesto");
            }else{
                try {
            DefaultTableModel model = new DefaultTableModel();
            tablaRepuesto.setModel(model);
            Conexion conetar = new Conexion();
            Connection con = conetar.conexion();
            PreparedStatement ps = con.prepareStatement("call reporterepuestoid(?)");
            ps.setString(1, reCon.getNombreRepuesto());
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = ps.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                model.addColumn(metaData.getColumnLabel(i));
            }
            while (rs.next()) {

                Object[] filas = new Object[metaData.getColumnCount()];
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    filas[i] = rs.getObject(i + 1);
                   if (i == 6) {
                        total += Double.parseDouble(filas[i].toString());
                    }
                }
                model.addRow(filas);
            }

            ps.close();
            ps.close();
            con.close();
            lbTotalRepuesto.setText(""+total);

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
            }
        } catch (Exception e) {
        }
     }
     
     private void filtraComboCedula(){
         double total=0;
        Cliente cli =(Cliente) cbCedulaRepuesto.getSelectedItem();
              String valorSeleccionadoSer = cbCedulaRepuesto.getSelectedItem().toString();

        try {
              if(valorSeleccionadoSer.equals("selecione un usuario")){

              JOptionPane.showMessageDialog(null, "selecione un usuario");
            }else{
                try {
            DefaultTableModel model = new DefaultTableModel();
            tablaRepuesto.setModel(model);
            Conexion conetar = new Conexion();
            Connection con = conetar.conexion();
            PreparedStatement ps = con.prepareCall("call reporterepuestousuario(?)");
            ps.setString(1, cli.getUsuario());
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData metaData = ps.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                model.addColumn(metaData.getColumnLabel(i));
            }
            while (rs.next()) {

                Object[] filas = new Object[metaData.getColumnCount()];
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    filas[i] = rs.getObject(i + 1);
                   if (i == 6) {
                        total += Double.parseDouble(filas[i].toString());
                    }
                }
                model.addRow(filas);
            }

            ps.close();
            ps.close();
            con.close();
            lbTotalRepuesto.setText(""+total);
          

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERROR");
        }
            }
        } catch (Exception e) {
        }
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaHistorialVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaHistorialVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaHistorialVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaHistorialVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaHistorialVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgRepuesto;
    private javax.swing.ButtonGroup bgServicio;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cbCedula;
    private javax.swing.JComboBox<String> cbCedulaRepuesto;
    private javax.swing.JComboBox<String> cbRepuesto;
    private javax.swing.JComboBox<String> cbServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAdmin;
    private javax.swing.JLabel lbTotalRepuesto;
    private javax.swing.JLabel lbTotalServicio;
    private javax.swing.JRadioButton rbRepuestoMasVendido;
    private javax.swing.JRadioButton rbRepuestoMenosVendido;
    private javax.swing.JRadioButton rbServicioVendido;
    private javax.swing.JRadioButton rbServioMenosVendido;
    private javax.swing.JTable tablaRepuesto;
    private javax.swing.JTable tablaServicio;
    // End of variables declaration//GEN-END:variables
}
