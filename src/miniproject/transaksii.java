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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class transaksii extends javax.swing.JFrame {
    DefaultTableModel model=new DefaultTableModel();
    koneksi k=new koneksi();
    private PreparedStatement st;
    private void tampilIdUser(){
        tIdUser.setText(setergeter.getIdUser());
    }
    public void tampilNopes(){
        String nopesan=setergeter.getNoTrans();
        this.nopes.setText(nopesan);
    }
    
public void tampilTable() throws SQLException{
    DefaultTableModel model=new DefaultTableModel();
        
        
        model.addColumn(("No. Pemesanan"));
        model.addColumn(("Kode Produk"));
        model.addColumn(("Harga"));
        model.addColumn(("Jumlah"));
        model.addColumn("Total Harga");
        try {
            int no=1;
            PreparedStatement pst=k.getCon().prepareStatement("Select * From detail_transaksi where no_transaksi='"
                    +nopes.getText()+"'");
            ResultSet rst=pst.executeQuery();
            
            while (rst.next()) {                
                model.addRow(new Object[] {rst.getString(1),
                    rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5)});
                
                tableDetailPemesanan.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
}

    public void totalHarga(){
        int jumlahBaris=tableDetailPemesanan.getRowCount();
        int totalHarga=0;
        int hargaBarang;
        for(int i=0; i<jumlahBaris; i++) {
            hargaBarang = Integer.parseInt(tableDetailPemesanan.getValueAt(i, 4).toString());
            totalHarga = totalHarga + hargaBarang;
            //setergeter.setTotalHarga(totalHarga);
    }
        ttlpembayaran.setText(String.valueOf(totalHarga));
    }
    public void jumlahItem(){
        int jumlahBaris=tableDetailPemesanan.getRowCount();
        int jumlahitem=0;
        int jumlahBarang;
        for(int i=0; i<jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(tableDetailPemesanan.getValueAt(i, 3).toString());
            jumlahitem = jumlahitem + jumlahBarang;
            //setergeter.setTotalHarga(jumlahitem);
    }
        totalItem.setText(String.valueOf(jumlahitem));
    }
    public void persendiskon(){
        try {
         String sql="Select * From diskon";
            Connection kon=k.getCon();
            PreparedStatement pst=kon.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()) {                
                //combodiskon.addItem(rs.getString("kode_diskon"));
            }
            rs.last();
            int jumlahdata=rs.getRow();
            rs.first();
   
        } catch (Exception e) {
        }
    }
    public void ngitungdis(){
    /*try {
         String sql="Select besar_diskon From diskon where kode_diskon='"+combodiskon.getSelectedItem()+"'";
            Connection kon=k.getCon();
            PreparedStatement pst=kon.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()) {                
                setergeter.setJumldisk(Integer.parseInt((rs.getString("besar_diskon"))));
//                kurang.setText(""+setergeter.getJumldisk());
    int total=Integer.parseInt(ttlpembayaran.getText());
    int jmm=setergeter.getJumldisk();
    int kurangg=total*jmm/100;
    int totall=total-kurangg;
    kurang.setText(""+totall);
            }
            rs.last();
            int jumlahdata=rs.getRow();
            rs.first();
   
        } catch (Exception e) {
        }*/
    int total, dis, hasil,totall;
    total=Integer.valueOf(ttlpembayaran.getText());
    dis=Integer.valueOf(tdis.getText());
    hasil=total*dis/100;
    totall=total-hasil;
    kurang.setText(String.valueOf(totall));
    }
    public void tampilidUserr(){
        try {
            String sql="Select * From karyawan";
            Connection kon=k.getCon();
            PreparedStatement pst=kon.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()) {                
                //combouser.addItem(rs.getString("id_karywan"));
            }
            rs.last();
            int jumlahdata=rs.getRow();
            rs.first();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void tampildiskon(){
    try {
            String sql="Select * From diskon";
            Connection kon=k.getCon();
            PreparedStatement pst=kon.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()) {                
                //combodiskon.addItem(rs.getString("kode_diskon"));
            }
            rs.last();
            int jumlahdata=rs.getRow();
            rs.first();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
}
    
    private void tungdis(){
        int total, bagi, hasil;
        total=Integer.valueOf(ttlpembayaran.getText());
        bagi=20000000;
        hasil=total/bagi;
        tdis.setText(String.valueOf(hasil));
    }
    /**
     * Creates new form pemesanan
     */
    public transaksii() throws SQLException {
        initComponents();
        k.Connect();
        tampilNopes();
//        tampilTable();
//        totalHarga();
//        jumlahItem();
        tampildiskon();
        tampilIdUser();
        //tampilNopesBaru();
        Date date=new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        tanggal.setText(s.format(date));
        tanggal.requestFocus();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nopes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tanggal = new javax.swing.JTextField();
        totalItem = new javax.swing.JTextField();
        bayarAwal = new javax.swing.JTextField();
        kurang = new javax.swing.JTextField();
        ttlpembayaran = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDetailPemesanan = new javax.swing.JTable();
        bayar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tIdUser = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tstatus = new javax.swing.JTextField();
        tdis = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("No. Pemesanan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        nopes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nopesActionPerformed(evt);
            }
        });
        getContentPane().add(nopes, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 80, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tanggal Pemesanan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Id User");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Total Item");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Bayar Awal");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Kurang");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Diskon");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));
        getContentPane().add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 80, 20));

        totalItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalItemActionPerformed(evt);
            }
        });
        getContentPane().add(totalItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 80, -1));

        bayarAwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarAwalActionPerformed(evt);
            }
        });
        getContentPane().add(bayarAwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 80, 20));
        getContentPane().add(kurang, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 110, 20));
        getContentPane().add(ttlpembayaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 110, 20));

        tableDetailPemesanan.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDetailPemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDetailPemesananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDetailPemesanan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        bayar.setText("bayar");
        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });
        getContentPane().add(bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, -1, -1));

        jButton2.setText("ubah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, -1, -1));
        getContentPane().add(tIdUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 80, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Total Pembayaran");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Status");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));
        getContentPane().add(tstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 110, 20));

        tdis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdisActionPerformed(evt);
            }
        });
        getContentPane().add(tdis, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 110, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bayarAwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarAwalActionPerformed
        int bayarawal, totalpmbyrn, kurang;
        bayarawal = Integer.valueOf(bayarAwal.getText());
        totalpmbyrn = Integer.valueOf(this.ttlpembayaran.getText());
        kurang = totalpmbyrn-bayarawal;
        this.kurang.setText(String.valueOf(kurang));
        tstatus.setText("Belum lunas");
        
    }//GEN-LAST:event_bayarAwalActionPerformed

    private void totalItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalItemActionPerformed

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        try {
            String sql="update transaksi set total_item ='"+totalItem.getText()+"', bayar_awal ='"
                    +bayarAwal.getText()+"', kurang ='"+kurang.getText()+"', total_pembayaran ='"
                    +ttlpembayaran.getText()+"', kode_diskon ='"
                    +tdis.getText()+"', id_karywan ='"+tIdUser.getText()
                    +"', status='"+tstatus.getText()+"' where no_transaksi ='"+nopes.getText()+"'";
            Connection con=k.getCon();
            PreparedStatement stm=con.prepareStatement(sql);
            stm.executeUpdate();
            /*st.executeUpdate("update transaksi set total_item ='"+totalItem.getText()+"', bayar_awal ='"
                    +bayarAwal.getText()+"', kurang ='"+kurang.getText()+"', total_pembayaran ='"
                    +ttlpembayaran.getText()+"', tanggal_selesai ='"+tanggal+"', kode_diskon ='"
                    +combodiskon.getSelectedItem()+"', id_karywan ='"+combouser.getSelectedItem()
                    +"' where no_transaksi ='"+nopes.getText()+"'");*/
            JOptionPane.showMessageDialog(null, "Pembayaran DP berhasil!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal melakukan DP!!!");
        }
    }//GEN-LAST:event_bayarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new ubahtransaksi().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nopesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nopesActionPerformed
        try {
            //tampilNopes();
            tampilTable();
            totalHarga();
            jumlahItem();
            tungdis();
            ngitungdis();
            //tampildiskon();
            //tampilIdUser();
        } catch (SQLException ex) {
            Logger.getLogger(transaksii.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_nopesActionPerformed

    private void tableDetailPemesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDetailPemesananMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableDetailPemesananMouseClicked

    private void tdisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tdisActionPerformed

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
            java.util.logging.Logger.getLogger(transaksii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksii.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new transaksii().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(transaksii.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bayar;
    private javax.swing.JTextField bayarAwal;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kurang;
    public static javax.swing.JTextField nopes;
    private javax.swing.JTextField tIdUser;
    private javax.swing.JTable tableDetailPemesanan;
    private javax.swing.JTextField tanggal;
    private javax.swing.JTextField tdis;
    private javax.swing.JTextField totalItem;
    private javax.swing.JTextField tstatus;
    private javax.swing.JTextField ttlpembayaran;
    // End of variables declaration//GEN-END:variables
}
