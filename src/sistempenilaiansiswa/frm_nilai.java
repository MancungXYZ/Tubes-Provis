/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistempenilaiansiswa;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Reihan & Adhira
 */
public class frm_nilai extends javax.swing.JFrame {
    
    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;
    /**
     * Creates new form frm_nilai
     */
    public frm_nilai() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        TableNilai.setModel(tableModel);
        
        settableload();
        getDataComboBox();
        tampil_field();
        non_aktif_teks();
    }
    
    String data[] = new String [15];
    private void settableload(){
        String stat = "";
        
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "Select * From nilai";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
                data[6] = res.getString(7);
                data[7] = res.getString(8);
                data[8] = res.getString(9);
                data[9] = res.getString(10);
                data[10] = res.getString(11);
                data[11] = res.getString(12);
                data[12] = res.getString(13);
                data[13] = res.getString(14);
                data[14] = res.getString(15);
//                data[15] = res.getString(16);
                
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    private javax.swing.table.DefaultTableModel tableModel = getDefaultTableModel();
    private javax.swing.table.DefaultTableModel getDefaultTableModel () {
        
        //membuat judul header
        return new javax.swing.table.DefaultTableModel
                (
                        new Object[][] {},
                        new String [] {
                            "NAMA",
                            "Nama M.K",
                            "Absensi",
                            "Tgs 1",
                            "Tgs 2",
                            "Tgs 3",
                            "UTS",
                            "UAS",
                            "Nilai Absen",
                            "Nilai Tugas",
                            "Nilasi UTS",
                            "Nilai UAS",
                            "Nilai Akhir",
                            "Index",
                            "Keterangan"
                        }
                )
                        
                {
                    boolean[] canEdit = new boolean[] {
                        false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
                    };
                    
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                };
    }
    
    //Menampilkan data ke combobox
    int row = 0;
    public void getDataComboBox() {
        row = TableNilai.getSelectedRow();
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select nama from t_mahasiswa";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                String nama = res.getString(1);
                combo_nama.addItem(nama);
            }
            
            String sql = "Select nama_mk FROM t_mata_kuliah";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                String nama_mk = rs.getString(1);
                combo_mk.addItem(nama_mk);
            }
            res.close();
            stt.close();
            kon.close();
          } catch (Exception ex) {
              JOptionPane.showMessageDialog(null,
                        ex.getMessage(), "Error",
                        JOptionPane.INFORMATION_MESSAGE
                );
          }
    }
    
    
    public void tampil_field(){
        
    }
    
    public void reset () {
//        combo_nama.setSelectedIndex(0);
        txt_nim.setText("");
        txt_kehadiran.setText("");
        txt_tgs1.setText("");
        txt_tgs2.setText("");
        txt_tgs3.setText("");
        
//        combo_mk.setSelectedIndex(0);
        txt_kodeMk.setText("");
        txt_uts.setText("");
        text_uas.setText("");
        txt_angkatan.setText("");
    }
    
    public void non_aktif_teks () {
        combo_nama.setEnabled(false);
        txt_nim.setEnabled(false);
        txt_kehadiran.setEnabled(false);
        txt_tgs1.setEnabled(false);
        txt_tgs2.setEnabled(false);
        txt_tgs3.setEnabled(false);
        
        combo_mk.setEnabled(false);
        txt_kodeMk.setEnabled(false);
        txt_uts.setEnabled(false);
        text_uas.setEnabled(false);
        txt_angkatan.setEnabled(false);
    }
    
    public void aktif_teks () {
        combo_nama.setEnabled(true);
        txt_nim.setEnabled(true);
        txt_kehadiran.setEnabled(true);
        txt_tgs1.setEnabled(true);
        txt_tgs2.setEnabled(true);
        txt_tgs3.setEnabled(true);
        
        combo_mk.setEnabled(true);
        txt_kodeMk.setEnabled(true);
        txt_uts.setEnabled(true);
        text_uas.setEnabled(true);
        txt_angkatan.setEnabled(true);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        combo_nama = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_kehadiran = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_tgs1 = new javax.swing.JTextField();
        txt_tgs2 = new javax.swing.JTextField();
        txt_tgs3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        combo_mk = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txt_kodeMk = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_uts = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        text_uas = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_angkatan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableNilai = new javax.swing.JTable();
        btn_simpan = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Frame Nilai");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("FORM NILAI MAHASISWA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(234, 234, 234))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26))
        );

        jLabel2.setText("Pencarian Data");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Masukan Data");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel4.setText("Nama");

        combo_nama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        combo_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_namaActionPerformed(evt);
            }
        });

        jLabel5.setText("Nim");

        jLabel6.setText("Kehadiran");

        jLabel7.setText("Tugas 1");

        jLabel8.setText("Tugas 2");

        jLabel9.setText("Tugas 3");

        jLabel10.setText("Nama Mata Kuliah");

        combo_mk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        combo_mk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_mkActionPerformed(evt);
            }
        });

        jLabel11.setText("Kode MK");

        jLabel12.setText("UTS");

        jLabel13.setText("UAS");

        jLabel14.setText("Angkatan");

        TableNilai.setModel(new javax.swing.table.DefaultTableModel(
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
        TableNilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableNilaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableNilai);

        btn_simpan.setText("Tambah");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_ubah.setText("Ubah");

        btn_hapus.setText("Hapus");

        btn_save.setText("Simpan");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        jLabel15.setText("Pertemuan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(combo_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(18, 18, 18)
                                            .addComponent(txt_tgs2))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(txt_tgs1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(combo_mk, 0, 132, Short.MAX_VALUE)
                                        .addComponent(txt_kodeMk))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(text_uas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                                        .addComponent(txt_uts, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_angkatan, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txt_tgs3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_simpan)
                        .addGap(60, 60, 60)
                        .addComponent(btn_ubah)
                        .addGap(66, 66, 66)
                        .addComponent(btn_hapus)
                        .addGap(79, 79, 79)
                        .addComponent(btn_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_batal)
                        .addGap(66, 66, 66)
                        .addComponent(btn_keluar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combo_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(combo_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_kodeMk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_tgs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(text_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_tgs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txt_angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_tgs3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_ubah)
                    .addComponent(btn_hapus)
                    .addComponent(btn_save)
                    .addComponent(btn_batal)
                    .addComponent(btn_keluar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_namaActionPerformed
        // TODO add your handling code here:
        String nama = combo_nama.getSelectedItem().toString();
        
        if (nama == "Pilih") {
            JOptionPane.showMessageDialog(null, "Silahkan pilih nama terlebih dahulu");
        } else {
            try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select nim from t_mahasiswa "
                        + "where nama= '"+nama+"' ";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                txt_nim.setText(res.getString(1));  
            }
            
            res.close();
            stt.close();
            kon.close();
          } catch (Exception ex) {
              JOptionPane.showMessageDialog(null,
                        ex.getMessage(), "Error",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_combo_namaActionPerformed

    private void combo_mkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_mkActionPerformed
        // TODO add your handling code here:
        String nama_mk = combo_mk.getSelectedItem().toString();
        
        if (nama_mk == "Pilih") {
            JOptionPane.showMessageDialog(null, "Silahkan pilih nama terlebih dahulu");
        } else {
            try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select kd_mk from t_mata_kuliah "
                        + "where nama_mk= '"+nama_mk+"' ";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                txt_kodeMk.setText(res.getString(1));  
            }
            
            res.close();
            stt.close();
            kon.close();
          } catch (Exception ex) {
              JOptionPane.showMessageDialog(null,
                        ex.getMessage(), "Error",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_combo_mkActionPerformed

    private void TableNilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableNilaiMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()== 1) {
            tampil_field();
        }
    }//GEN-LAST:event_TableNilaiMouseClicked

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:
        frm_utama utm = new frm_utama();
        utm.setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        aktif_teks();
        
        combo_nama.requestFocus();
        btn_hapus.setEnabled(false);
        btn_ubah.setEnabled(false);
        
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        btn_hapus.setEnabled(true);
        btn_ubah.setEnabled(true);
        
        non_aktif_teks();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        String data[] = new String[15];
        
        if ((txt_kehadiran.getText().isEmpty()) || (txt_kodeMk.getText().isEmpty()) || (txt_tgs1.getText().isEmpty() || (txt_tgs2.getText().isEmpty() || (txt_tgs3.getText().isEmpty()) || (txt_nim.getText().isEmpty())))) {
            JOptionPane.showMessageDialog(null, "Data mata kuliah tidak boleh kosong, Harap isi !");
            combo_nama.requestFocus();
            
        }
        else {
            try {
                //menghitung nilai absen
                int absen = Integer.parseInt(txt_kehadiran.getText());
                int nilai_absen = ((absen/14)*100*5)/100;
                
                //menghitung nilai tugas
                Double tugas = Double.valueOf(txt_tgs1.getText());
                Double tugas2 = Double.valueOf(txt_tgs2.getText());
                Double tugas3 = Double.valueOf(txt_tgs3.getText());
                Double nilai_tugas = ((tugas+tugas2+tugas3)*0.25);
                
                //menghitung nilai uts
                int uts = Integer.parseInt(txt_uts.getText());
                int nilai_uts = (int) (uts*0.3);
                
                //menghitung nilai uas
                int uas = Integer.parseInt(text_uas.getText());
                int nilai_uas = (int) (uas*0.4);
                
                //menghitung nilai akhir dan menentukan index
                int nilai_akhir = (int) (nilai_absen + nilai_tugas + nilai_uts + nilai_uas);
                char indeks;
                String keterangan;
                
                if (nilai_akhir >= 80 && nilai_akhir <=100) {
                    indeks = 'A';
                    keterangan = "Lulus";
                } else if(nilai_akhir >= 68) {
                    indeks = 'B';
                    keterangan = "Lulus";
                } else if(nilai_akhir >= 56) {
                    indeks = 'C';
                    keterangan = "Lulus";
                } else if(nilai_akhir >= 45) {
                    indeks = 'D';
                    keterangan = "Tidak Lulus";
                } else {
                    indeks = 'E';
                    keterangan = "Tidak Lulus";
                }
                
                if (absen < 11) {
                    keterangan = "Tidak Lulus";
                }
                
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO nilai (nama,"
                        + "nama_mk,"
                        + "absensi,"
                        + "tugas1,"
                        + "tugas2,"
                        + "tugas3,"
                        + "uts,"
                        + "uas,"
                        + "nilai_absen,"
                        + "nilai_tugas,"
                        + "nilai_uts,"
                        + "nilai_uas,"
                        + "nilai_akhir,"
                        + "Indeks,"
                        + "keterangan) "
                        + "VALUES "
                        + "('"+combo_nama.getSelectedItem()+"',"
                        + "'"+combo_mk.getSelectedItem()+"',"
                        + "'"+absen+"',"
                        + "'"+tugas+"',"
                        + "'"+tugas2+"',"
                        + "'"+tugas3+"',"
                        + "'"+uts+"',"
                        + "'"+uas+"',"
                        + "'"+nilai_absen+"',"
                        + "'"+nilai_tugas+"',"
                        + "'"+nilai_uts+"',"
                        + "'"+nilai_uas+"',"
                        + "'"+nilai_akhir+"',"
                        + "'"+indeks+"',"
                        + "'"+keterangan+"') ";
                
                stt.executeUpdate(SQL);
                data[0] = combo_nama.getSelectedItem().toString();
                data[1] = combo_mk.getSelectedItem().toString();
                data[2] = String.valueOf(absen);
                data[3] = String.valueOf(tugas);
                data[4] = String.valueOf(tugas2);
                data[5] = String.valueOf(tugas3);
                data[6] = String.valueOf(uts);
                data[7] = String.valueOf(uas);
                data[8] = String.valueOf(nilai_absen);
                data[9] = String.valueOf(nilai_tugas);
                data[10] = String.valueOf(nilai_uts);
                data[11] = String.valueOf(nilai_uas);
                data[12] = String.valueOf(nilai_akhir);
                data[13] = String.valueOf(indeks);
                data[14] = keterangan;
                
                tableModel.insertRow(0, data);
                
                btn_ubah.setEnabled(true);
                btn_hapus.setEnabled(true);
                reset();
                
                stt.close();
                kon.close();
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_btn_saveActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        frm_utama utama = new frm_utama();
        utama.setVisible(true);
    }//GEN-LAST:event_formWindowClosed
        
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
            java.util.logging.Logger.getLogger(frm_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_nilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableNilai;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JComboBox<String> combo_mk;
    private javax.swing.JComboBox<String> combo_nama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField text_uas;
    private javax.swing.JTextField txt_angkatan;
    private javax.swing.JTextField txt_kehadiran;
    private javax.swing.JTextField txt_kodeMk;
    private javax.swing.JTextField txt_nim;
    private javax.swing.JTextField txt_tgs1;
    private javax.swing.JTextField txt_tgs2;
    private javax.swing.JTextField txt_tgs3;
    private javax.swing.JTextField txt_uts;
    // End of variables declaration//GEN-END:variables
}
