/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class DashboardKa extends javax.swing.JFrame {
    koneksi k=new koneksi();
private void tampilPesanMasuk (){
    try {
        String sql="SELECT sum(jumlah) as jml FROM detail_transaksi WHERE keterangan='Pesanan masuk'";
        Connection c=k.getCon();
        PreparedStatement p=c.prepareStatement(sql);
        ResultSet rs=p.executeQuery();
        if (rs.next()) {
            jTextField1.setText(rs.getString("jml"));
        }
    } catch (Exception e) {
    }
}
private void tampilpsnpss(){
    try {
        String sql="SELECT sum(jumlah) as jml FROM detail_transaksi WHERE keterangan='Sedang diproses'";
        Connection c=k.getCon();
        PreparedStatement p=c.prepareStatement(sql);
        ResultSet rs=p.executeQuery();
        if (rs.next()) {
            jTextField2.setText(rs.getString("jml"));
        }
    } catch (Exception e) {
    }
}
private void tampilpsnsls(){
    try {
        String sql="SELECT sum(jumlah) as jml FROM detail_transaksi WHERE keterangan='Selesai'";
        Connection c=k.getCon();
        PreparedStatement p=c.prepareStatement(sql);
        ResultSet rs=p.executeQuery();
        if (rs.next()) {
            jTextField3.setText(rs.getString("jml"));
        }
    } catch (Exception e) {
    }
}
private void tablepsnbsk(){
    DefaultTableModel d=new DefaultTableModel();
    d.addColumn("No. Transaksi");
    d.addColumn("Nama Barang");
    d.addColumn("Jumlah item");
    d.addColumn("Tanggal Ambil");
    d.addColumn("Keterangan");
    try {
        int no=1;
        String sql="SELECT no_transaksi,kode_barang,jumlah,tanggal_ambil,keterangan FROM `detail_transaksi` WHERE tanggal_ambil= curdate() + INTERVAL 1 day";
        Connection c=k.getCon();
        PreparedStatement p=c.prepareStatement(sql);
        ResultSet rs=p.executeQuery();
        while (rs.next()) { 
            d.addRow(new Object[]{
            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5)});
        }
        jTable1.setModel(d);
    } catch (Exception e) {
    }
}
private void tablepesminggu(){
    DefaultTableModel d=new DefaultTableModel();
    d.addColumn("No. Transaksi");
    d.addColumn("Nama Barang");
    d.addColumn("Jumlah item");
    d.addColumn("Tanggal Ambil");
    d.addColumn("Keterangan");
    try {
        int no=1;
        String sql="SELECT no_transaksi,kode_barang,jumlah,tanggal_ambil,keterangan FROM `detail_transaksi` WHERE tanggal_ambil= curdate() + INTERVAL 6 day";
        Connection c=k.getCon();
        PreparedStatement p=c.prepareStatement(sql);
        ResultSet rs=p.executeQuery();
        while (rs.next()) { 
            d.addRow(new Object[]{
            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5)});
        }
        jTable2.setModel(d);
    } catch (Exception e) {
    }
}
/*private void tablepsmsk(){
    DefaultTableModel m=new DefaultTableModel();
    m.addColumn("No.Transaksi");
    m.addColumn("Kode Produk");
    m.addColumn("Jumlah");
    m.addColumn("Tanggal Ambil");
    m.addColumn("Keterangan");
    try {
        int no=1;
        String sql="select no_transaksi,kode_barang,jumlah,tanggal_ambil,keterangan from detail_transaksi where keterangan='Pesanan masuk'";
        Connection con=k.getCon();
        PreparedStatement p=con.prepareStatement(sql);
        ResultSet rs=p.executeQuery();
        while (rs.next()) {            
            m.addRow(new Object[]{
            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5)});
        }
        pesmasuk.setModel(m);
    } catch (SQLException ex){
        System.out.println("tampiltable GAGAL!!!!");
    }
}
    /**
     * Creates new form DashboardKa
     */
    public DashboardKa() {
        initComponents();
        k.Connect();
        tampilPesanMasuk();
        tampilpsnpss();
        tampilpsnsls();
        tablepsnbsk();
        tablepesminggu();
        //tablepsmsk();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 180, 100));

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 210, 100));

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 200, 100));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 650, 130));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 650, 130));

        jLabel1.setText("Pesanan Masuk");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 20));

        jLabel2.setText("Sedang diproses");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 210, 20));

        jLabel3.setText("Telah selesai");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 200, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        new tblpsnmsk().setVisible(true);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        new tblpsnmsk().setVisible(true);
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        new tblpsnprs().setVisible(true);
    }//GEN-LAST:event_jTextField2MouseClicked

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
            java.util.logging.Logger.getLogger(DashboardKa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardKa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardKa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardKa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardKa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
