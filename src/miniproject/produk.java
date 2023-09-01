package miniproject;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class produk extends javax.swing.JFrame {
    private PreparedStatement statement;
    private ResultSet result;
    private String filename;
    koneksi k=new koneksi();
    
    private void autoCode(){
    try {
      Connection c=k.getCon();
      Statement s=c.createStatement();
      String sql= "select * from barang order by kode_barang desc";
      result=s.executeQuery(sql);
        if (result.next()) {
            String NoTrans= result.getString("kode_barang").substring(2);
            String BR="" + (Integer.parseInt(NoTrans)+1);
            String Nol="";
            
            if (BR.length()==1) {
                Nol= "00";
            } else if (BR.length()==2){
                Nol= "0";
            } else if (BR.length()==3){
                Nol= "";}
                kode_barang.setText("BR" + Nol + BR);
            } else {
                kode_barang.setText("BR001");
            }
            result.close();
        } catch (Exception e) {
            System.out.println("autonumber error");    
    }
    }
    public produk() {
        initComponents();
        k.Connect();
        autoCode();
    }
    class product extends produk{
        String namaBarang="",kodeBarang="",hargaBarang="",fotoBarang="";
        public product(){
            namaBarang= nama_barang.getText();
            kodeBarang= kode_barang.getText();
            hargaBarang= harga_barang.getText();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tambah_Produk = new javax.swing.JButton();
        detail_Produk = new javax.swing.JButton();
        keranjang = new javax.swing.JButton();
        laporan = new javax.swing.JButton();
        backtambahproduk = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        namaBarang = new javax.swing.JLabel();
        kodeBarang = new javax.swing.JLabel();
        fotoBarang = new javax.swing.JLabel();
        hargaBarang = new javax.swing.JLabel();
        nama_barang = new javax.swing.JTextField();
        kode_barang = new javax.swing.JTextField();
        harga_barang = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        label_foto = new javax.swing.JLabel();
        tambah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("produk");

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 102, 0), new java.awt.Color(0, 51, 0), null, new java.awt.Color(51, 204, 0)));

        tambah_Produk.setBackground(new java.awt.Color(208, 208, 151));
        tambah_Produk.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        tambah_Produk.setForeground(new java.awt.Color(0, 102, 0));
        tambah_Produk.setText("Tambah Produk");
        tambah_Produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_ProdukActionPerformed(evt);
            }
        });

        detail_Produk.setBackground(new java.awt.Color(208, 208, 151));
        detail_Produk.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        detail_Produk.setForeground(new java.awt.Color(0, 51, 19));
        detail_Produk.setText("Detail Produk");
        detail_Produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detail_ProdukMouseClicked(evt);
            }
        });

        keranjang.setBackground(new java.awt.Color(208, 208, 151));
        keranjang.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        keranjang.setForeground(new java.awt.Color(0, 51, 19));
        keranjang.setText("Keranjang");
        keranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keranjangMouseClicked(evt);
            }
        });
        keranjang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keranjangActionPerformed(evt);
            }
        });

        laporan.setBackground(new java.awt.Color(208, 208, 151));
        laporan.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        laporan.setForeground(new java.awt.Color(0, 51, 19));
        laporan.setText("Laporan");
        laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laporanMouseClicked(evt);
            }
        });

        backtambahproduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miniproject/back.jpeg"))); // NOI18N
        backtambahproduk.setText("jLabel1");
        backtambahproduk.setPreferredSize(new java.awt.Dimension(38, 26));
        backtambahproduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backtambahprodukMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(backtambahproduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(tambah_Produk)
                .addGap(55, 55, 55)
                .addComponent(detail_Produk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(keranjang)
                .addGap(68, 68, 68)
                .addComponent(laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(keranjang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambah_Produk, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backtambahproduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(detail_Produk, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 102, 0), new java.awt.Color(0, 51, 0), null, new java.awt.Color(51, 204, 0)));

        namaBarang.setBackground(new java.awt.Color(208, 208, 151));
        namaBarang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        namaBarang.setForeground(new java.awt.Color(208, 208, 151));
        namaBarang.setText("Nama Barang");
        namaBarang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 102, 0), new java.awt.Color(0, 51, 0), null, new java.awt.Color(51, 204, 0)));

        kodeBarang.setBackground(new java.awt.Color(208, 208, 151));
        kodeBarang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kodeBarang.setForeground(new java.awt.Color(208, 208, 151));
        kodeBarang.setText("Kode Barang");
        kodeBarang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 102, 0), new java.awt.Color(0, 51, 0), null, new java.awt.Color(51, 204, 0)));

        fotoBarang.setBackground(new java.awt.Color(208, 208, 151));
        fotoBarang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fotoBarang.setForeground(new java.awt.Color(208, 208, 151));
        fotoBarang.setText("Foto Barang");
        fotoBarang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 102, 0), new java.awt.Color(0, 51, 0), null, new java.awt.Color(51, 204, 0)));

        hargaBarang.setBackground(new java.awt.Color(208, 208, 151));
        hargaBarang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hargaBarang.setForeground(new java.awt.Color(208, 208, 151));
        hargaBarang.setText("Harga Barang");
        hargaBarang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 102, 0), new java.awt.Color(0, 51, 0), null, new java.awt.Color(51, 204, 0)));

        kode_barang.setEditable(false);

        jButton1.setBackground(new java.awt.Color(208, 208, 151));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 19));
        jButton1.setText("Pilih Foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        label_foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 19), 5));

        tambah.setBackground(new java.awt.Color(208, 208, 151));
        tambah.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tambah.setForeground(new java.awt.Color(0, 51, 19));
        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        hapus.setBackground(new java.awt.Color(208, 208, 151));
        hapus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        hapus.setForeground(new java.awt.Color(0, 51, 19));
        hapus.setText("Clear");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fotoBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kode_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(harga_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nama_barang)
                    .addComponent(namaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kode_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(harga_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fotoBarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tambah_ProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_ProdukActionPerformed
        
    }//GEN-LAST:event_tambah_ProdukActionPerformed

    private void backtambahprodukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtambahprodukMouseClicked
        // TODO add your handling code here:
        new dashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backtambahprodukMouseClicked

    private void detail_ProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detail_ProdukMouseClicked
        // TODO add your handling code here:
        new detail_produk().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_detail_ProdukMouseClicked

    private void keranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keranjangMouseClicked
        // TODO add your handling code here:
        new detail_produk().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_keranjangMouseClicked

    private void laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanMouseClicked
        // TODO add your handling code here:
        new laporan().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_laporanMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        product p=new product();
        try {
            JFileChooser pilih=new JFileChooser();
            pilih.showOpenDialog(null);
            File f=pilih.getSelectedFile();
            ImageIcon ikon=new ImageIcon(f.toString());
            Image img=ikon.getImage().getScaledInstance(label_foto.getWidth()
                    , label_foto.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon icon=new ImageIcon(img);
            label_foto.setIcon(icon);
            this.filename=f.getAbsolutePath();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        try {
            //tempat nyimpen foto di database
            String newpath="src/saladmoy";
            File directory=new File(newpath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            File fileawal=null;
            File fileakhir=null;
            String ext=this.filename.substring(filename.lastIndexOf('.')+1);
            fileawal=new File(filename);
            fileakhir=new File(newpath+"/"+nama_barang.getText()+"."+ext);
            System.out.println(fileakhir);
            product a=new product();
            this.statement=k.getCon().prepareStatement("insert into barang values(?,?,?,?)");
            statement.setString(1, a.namaBarang);
            statement.setString(2, a.kodeBarang);
            statement.setString(3, a.hargaBarang);
            statement.setString(4, fileakhir.toString());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil menambahkan produk");
            Files.copy(fileawal.toPath(), fileakhir.toPath());
            new detail_produk().setVisible(true);
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        nama_barang.setText(null);
        kode_barang.setText(null);
        harga_barang.setText(null);
        label_foto.setIcon(null);
    }//GEN-LAST:event_hapusActionPerformed

    private void keranjangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keranjangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keranjangActionPerformed

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
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backtambahproduk;
    private javax.swing.JButton detail_Produk;
    private javax.swing.JLabel fotoBarang;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel hargaBarang;
    private javax.swing.JTextField harga_barang;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton keranjang;
    private javax.swing.JLabel kodeBarang;
    private javax.swing.JTextField kode_barang;
    private javax.swing.JLabel label_foto;
    private javax.swing.JButton laporan;
    private javax.swing.JLabel namaBarang;
    private javax.swing.JTextField nama_barang;
    private javax.swing.JButton tambah;
    private javax.swing.JButton tambah_Produk;
    // End of variables declaration//GEN-END:variables
}
