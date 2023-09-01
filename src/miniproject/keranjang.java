package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class keranjang extends javax.swing.JFrame {
    String Tanggal;
    private DefaultTableModel tabel;
    koneksi k=new koneksi();
    private PreparedStatement statement;
    private ResultSet result;
    private Statement state;
    
    public void totalHarga(){
        int jumlahBaris=jTable1.getRowCount();
        int totalHarga=0;
        int jumlahBarang,hargaBarang;
        for(int i=0; i<jumlahBaris; i++) {
            hargaBarang = Integer.parseInt(jTable1.getValueAt(i, 4).toString());
            totalHarga = totalHarga + hargaBarang;
            setergeter.setTotalHarga(totalHarga);
        }
        //total_pembayaran.setText(String.valueOf(totalHarga));
    }
private void autoNumber(){
    try {
      Connection c=k.getCon();
      Statement s=c.createStatement();
      String sql= "select * from transaksi order by no_transaksi desc";
      result=s.executeQuery(sql);
        if (result.next()) {
            String NoTrans= result.getString("no_transaksi").substring(2);
            String TR="" + (Integer.parseInt(NoTrans)+1);
            String Nol="";
            
            if (TR.length()==1) {
                Nol= "000";
            } else if (TR.length()==2){
                Nol= "00";
            } else if (TR.length()==3){
                Nol= "0";
            } else if (TR.length()==4){
                Nol="";}
                no_transaksi.setText("TR" + Nol + TR);
                String noTrans=no_transaksi.getText();
                //setergeter.getNoTrans();
            } else {
                no_transaksi.setText("TR0001");
                String noTrans=no_transaksi.getText();
                //setergeter.getNoTrans();
            }
            result.close();
        } catch (Exception e) {
            System.out.println("autonumber error");
    }
}

    public void loadData(){
        String getDate = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(getDate);
        String tanggal = String.valueOf(fm.format(tanggalAmbil.getDate()));
        tabel= (DefaultTableModel) jTable1.getModel();
        tabel.addRow(new Object[]{
        no_transaksi.getText(),
        combonama.getSelectedItem(),
        harga.getText(),
        jumlah.getText(),
        total_harga.getText(),
        tanggal,
        tketerangan.getText()
        });
    }
    public void kosong(){
        this.tabel= (DefaultTableModel) jTable1.getModel();
        while (tabel.getRowCount()>0) {            
            tabel.removeRow(0);
        }
    }
    public void utama(){
        no_transaksi.setText("");
        harga.setText("");
        jumlah.setText("");
        total_harga.setText("");
        autoNumber();
    }
    public void clear(){
        //tanggal.setText("");
        //total_pembayaran.setText("0");
        }
    public void clear1(){
        
    }
    
    public void tambahTransaksi(){
        int jmlh, hrg, total;
        jmlh = Integer.valueOf(jumlah.getText());
        hrg = Integer.valueOf(harga.getText());
        total = jmlh*hrg;
        
        total_harga.setText(String.valueOf(total));
        
        loadData();//ini untuk menampilkan di table interface
        totalHarga();
        clear();
    }
    public void tampilcombo (){
        try {
            String sql="Select * From barang";
            Connection kon=k.getCon();
            PreparedStatement pst=kon.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()) {                
                combonama.addItem(rs.getString("kode_barang"));
            }
            rs.last();
            int jumlahdata=rs.getRow();
            rs.first();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /**
     * Creates new form keranjang
     */
    public keranjang() {
        initComponents();
        k.Connect();
        tampilcombo();
        tabel=new DefaultTableModel();
        
        jTable1.setModel(tabel);
        
        tabel.addColumn("No.Transaksi");
        //tabel.addColumn("Tanggal");
        tabel.addColumn("Kode Barang");
        tabel.addColumn("Harga Barang");
        tabel.addColumn("Jumlah Item");
        tabel.addColumn("Total Harga");
        tabel.addColumn("Tanggal Pengambilan");
        tabel.addColumn("Keterangan");
        utama();
        Date date=new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        tanggal.setText(s.format(date));
        //total_pembayaran.setText("0");
        no_transaksi.requestFocus();
        tanggal.requestFocus();
        //ubahpesan();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        backKerajang = new javax.swing.JLabel();
        tambahProduk = new javax.swing.JButton();
        detailProduk = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        laporan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        notrans = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        no_transaksi = new javax.swing.JTextField();
        tanggal = new javax.swing.JTextField();
        nama = new javax.swing.JLabel();
        hrg = new javax.swing.JLabel();
        jml = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        tambah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        bayar = new javax.swing.JButton();
        totalharga = new javax.swing.JLabel();
        total_harga = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        combonama = new javax.swing.JComboBox<>();
        tanggalAmbil = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        tketerangan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("keranjang");

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 102, 0), new java.awt.Color(0, 51, 0), null, new java.awt.Color(51, 204, 0)));

        backKerajang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/miniproject/back.jpeg"))); // NOI18N
        backKerajang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backKerajangMouseClicked(evt);
            }
        });

        tambahProduk.setBackground(new java.awt.Color(208, 208, 151));
        tambahProduk.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        tambahProduk.setForeground(new java.awt.Color(0, 51, 19));
        tambahProduk.setText("Tambah Produk");
        tambahProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahProdukMouseClicked(evt);
            }
        });

        detailProduk.setBackground(new java.awt.Color(208, 208, 151));
        detailProduk.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        detailProduk.setForeground(new java.awt.Color(0, 51, 19));
        detailProduk.setText("Detail Produk");
        detailProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detailProdukMouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(208, 208, 151));
        jButton3.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 0));
        jButton3.setText("Keranjang");

        laporan.setBackground(new java.awt.Color(208, 208, 151));
        laporan.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        laporan.setForeground(new java.awt.Color(0, 51, 19));
        laporan.setText("Laporan");
        laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laporanMouseClicked(evt);
            }
        });
        laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(backKerajang)
                .addGap(33, 33, 33)
                .addComponent(tambahProduk)
                .addGap(85, 85, 85)
                .addComponent(detailProduk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(85, 85, 85)
                .addComponent(laporan)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(detailProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tambahProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backKerajang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 102, 0), new java.awt.Color(0, 51, 0), null, new java.awt.Color(51, 204, 0)));

        notrans.setText("No.Transaksi");

        tgl.setText("Tanggal");

        no_transaksi.setEditable(false);
        no_transaksi.setEnabled(false);

        tanggal.setEditable(false);

        nama.setText("Nama Barang");

        hrg.setText("Harga");

        jml.setText("Jumlah Item");

        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });

        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahActionPerformed(evt);
            }
        });

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
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        bayar.setBackground(new java.awt.Color(208, 208, 151));
        bayar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bayar.setForeground(new java.awt.Color(0, 51, 19));
        bayar.setText("Bayar");
        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });

        totalharga.setText("Total Harga");

        jButton1.setBackground(new java.awt.Color(208, 208, 151));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 19));
        jButton1.setText("Cetak");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        combonama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combonamaActionPerformed(evt);
            }
        });

        jLabel1.setText("Tanggal Pengambilan");

        jLabel2.setText("Keterangan");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tgl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(notrans, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tanggalAmbil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(no_transaksi, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(totalharga, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(total_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(combonama, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tambah))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(hrg, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jml, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bayar))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tketerangan)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(notrans, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(no_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tambah)
                                    .addComponent(combonama, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(hrg)
                                .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hapus)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jml)
                                    .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(tanggalAmbil, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalharga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(total_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tketerangan, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bayar)
                            .addComponent(jButton1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tambahProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahProdukMouseClicked
        // TODO add your handling code here:
        new produk().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tambahProdukMouseClicked

    private void backKerajangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backKerajangMouseClicked
        // TODO add your handling code here:
        new dashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backKerajangMouseClicked

    private void detailProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detailProdukMouseClicked
        // TODO add your handling code here:
        new detail_produk().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_detailProdukMouseClicked

    private void laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laporanMouseClicked
        // TODO add your handling code here:
        new laporan().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_laporanMouseClicked

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
        // TODO add your handling code here:
        //tambahTransaksi();
        int jmlh, hrg, total;
        jmlh = Integer.valueOf(jumlah.getText());
        hrg = Integer.valueOf(harga.getText());
        total = jmlh*hrg;
        
        total_harga.setText(String.valueOf(total));
        tketerangan.setText("Pesanan masuk");
    }//GEN-LAST:event_jumlahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tabel= (DefaultTableModel) jTable1.getModel();
        int row= jTable1.getSelectedRow();
        tabel.removeRow(row);
        totalHarga();
    }//GEN-LAST:event_hapusActionPerformed

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        setergeter.setNoTrans(no_transaksi.getText().toString());
        try {                                      
            // TODO add your handling code here:
            DefaultTableModel tabel=(DefaultTableModel) jTable1.getModel();
            try {
                int jumlahbaris = jTable1.getRowCount();
                for(int i=0; i<=jumlahbaris; i++){
                    String sql = "INSERT INTO detail_transaksi VALUES('"
                            +jTable1.getValueAt(i, 0)+"','"+jTable1.getValueAt(i, 1)+
                            "','"+jTable1.getValueAt(i,2)+"','"+jTable1.getValueAt(i, 3)+"','"+jTable1.getValueAt(i, 4)
                            +"','"+jTable1.getValueAt(i, 5)+"')";
                    Connection conn = k.getCon();
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.execute();
                    pst.close();}
                JOptionPane.showMessageDialog(null, "Tersimpan");
                jTable1.setModel(tabel);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Berhasil menambahkan barang" );
            }
            try {
                String sql = "INSERT INTO transaksi VALUES"
                        + "('"+no_transaksi.getText()+"',now(),'0','0','0','0','0','','','')";
                //+total_pembayaran.getText()+"')
                Connection conn = k.getCon();
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                pst.close();
                new transaksii().setVisible(true);
                this.dispose();
                String a = no_transaksi.getText();
                transaksii.nopes.setText(setergeter.getNoTrans());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            this.dispose();
            new transaksii().setVisible(true);
            //String a = no_transaksi.getText();
            //transaksii.nopes.setText(a);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(keranjang.class.getName()).log(Level.SEVERE,null, ex);
        }
    }//GEN-LAST:event_bayarActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
        totalHarga();
        jumlah.setText("");
        harga.setText("");
        total_harga.setText("");
    }//GEN-LAST:event_tambahActionPerformed

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_hargaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
     
            try {
                java.sql.Connection con = k.getCon();
                java.sql.Statement st = con.createStatement();
                String report=("E:\\netbeans\\miniproject\\src\\miniproject\\report2.jrxml");
                HashMap hash=new HashMap();
                
                //Mengambil parameter dari jreport
                hash.put("no", jTextField1.getText());
                JasperReport JRpt=JasperCompileManager.compileReport(report);
                JasperPrint JPrint=JasperFillManager.fillReport(JRpt, hash, con);
                JasperViewer.viewReport(JPrint,false);
                } catch (Exception rptexcpt) {
                    System.out.println("Report Can't view because : "+rptexcpt);
            }
            
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_laporanActionPerformed

    private void combonamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combonamaActionPerformed
        try {
        String sql = "SELECT * FROM barang where kode_barang='"+combonama.getSelectedItem()+"'";
        java.sql.Connection con = k.getCon();
        java.sql.PreparedStatement pst = con.prepareStatement(sql);
        java.sql.ResultSet rst = pst.executeQuery();
        while(rst.next()){
            harga.setText(rst.getString("harga_barang"));
        }
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_combonamaActionPerformed

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
            java.util.logging.Logger.getLogger(keranjang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(keranjang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(keranjang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(keranjang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new keranjang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backKerajang;
    private javax.swing.JButton bayar;
    private javax.swing.JComboBox<String> combonama;
    private javax.swing.JButton detailProduk;
    private javax.swing.JButton hapus;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel hrg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jml;
    private javax.swing.JTextField jumlah;
    private javax.swing.JButton laporan;
    private javax.swing.JLabel nama;
    public static javax.swing.JTextField no_transaksi;
    private javax.swing.JLabel notrans;
    private javax.swing.JButton tambah;
    private javax.swing.JButton tambahProduk;
    private javax.swing.JTextField tanggal;
    private com.toedter.calendar.JDateChooser tanggalAmbil;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField tketerangan;
    private javax.swing.JTextField total_harga;
    private javax.swing.JLabel totalharga;
    // End of variables declaration//GEN-END:variables
}
