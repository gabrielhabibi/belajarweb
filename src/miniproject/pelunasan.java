/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author dell
 */
public class pelunasan extends javax.swing.JFrame {
    koneksi k=new koneksi();
public void tampilTablee(){
    DefaultTableModel model=new DefaultTableModel();
        model.addColumn(("No. Pemesanan"));
        model.addColumn(("Total Pemmbayaran"));
        model.addColumn(("Kurang"));
        model.addColumn(("Status"));
        model.addColumn("Bayar Awal");
        
        try {
            int no=1;
            PreparedStatement pst=k.getCon().prepareStatement("Select no_transaksi,total_pembayaran, "
                    + "kurang,status,bayar_awal From "
                    + "transaksi where status = 'Belum lunas'");
            ResultSet rst=pst.executeQuery();
            
            while (rst.next()) {                
                model.addRow(new Object[] {
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)});
                
                tlunas.setModel(model);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
}
    /**
     * Creates new form pelunasan
     */
    public pelunasan() {
        initComponents();
        k.Connect();
        tampilTablee();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        tnotrans = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tkurang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tbayar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ttotalpmbyrn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tstts = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tkembali = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlunas = new javax.swing.JTable();
        bbyr = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("No. Transaski");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 70, 20));
        getContentPane().add(tnotrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 120, 20));

        jLabel5.setText("Kurang");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 60, 20));
        getContentPane().add(tkurang, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 120, 20));

        jLabel6.setText("Bayar");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 60, 20));

        tbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbayarActionPerformed(evt);
            }
        });
        getContentPane().add(tbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 120, 20));

        jLabel1.setText("Total Pembayaran");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 70, 20));
        getContentPane().add(ttotalpmbyrn, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 130, 20));

        jLabel2.setText("Status");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 80, 20));
        getContentPane().add(tstts, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 130, 20));

        jLabel3.setText("Kembali");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 70, 20));
        getContentPane().add(tkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 130, 20));

        tlunas.setModel(new javax.swing.table.DefaultTableModel(
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
        tlunas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlunasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tlunas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 360));

        bbyr.setText("Bayar");
        bbyr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbyrActionPerformed(evt);
            }
        });
        getContentPane().add(bbyr, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tlunasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlunasMouseClicked
        int i = tlunas.getSelectedRow();
        TableModel model = tlunas.getModel();
        String no = model.getValueAt(i, 0).toString();
        String tp = model.getValueAt(i, 1).toString();
        String k = model.getValueAt(i, 2).toString();
        String s = model.getValueAt(i, 3).toString();
        
        tnotrans.setText(no);
        ttotalpmbyrn.setText(tp);
        tkurang.setText(k);
        tstts.setText(s);
    }//GEN-LAST:event_tlunasMouseClicked

    private void tbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbayarActionPerformed
       int totalpembayaran,kurang,kembali;
       kurang=Integer.valueOf(tkurang.getText());
       totalpembayaran=Integer.valueOf(tbayar.getText());
       kembali=totalpembayaran-kurang;
       tkembali.setText(String.valueOf(kembali));
        if (totalpembayaran<kurang) {
            tstts.setText("Belum lunas");
            tkembali.setText("");
            JOptionPane.showMessageDialog(null, "Uang anda kurang RP."+kembali);
        } else {
            tstts.setText("Lunas");
            tkurang.setText("0");
        }
    }//GEN-LAST:event_tbayarActionPerformed

    private void bbyrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbyrActionPerformed
        try {
            String sql="update transaksi set bayar_awal ='"+ttotalpmbyrn.getText()+"', kurang ='"
                    +tkurang.getText()+"', status ='"+tstts.getText()+"', kembali='"+
                    tkembali.getText()+"' where no_transaksi ='"
                    +tnotrans.getText()+"'";
            Connection c=k.getCon();
            PreparedStatement p=c.prepareStatement(sql);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "Transaksi lunas!!!");
            tkembali.setText("");
            tbayar.setText("");
            tampilTablee();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_bbyrActionPerformed

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
            java.util.logging.Logger.getLogger(pelunasan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pelunasan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pelunasan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pelunasan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pelunasan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbyr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tbayar;
    private javax.swing.JTextField tkembali;
    private javax.swing.JTextField tkurang;
    private javax.swing.JTable tlunas;
    private javax.swing.JTextField tnotrans;
    private javax.swing.JTextField tstts;
    private javax.swing.JTextField ttotalpmbyrn;
    // End of variables declaration//GEN-END:variables
}
