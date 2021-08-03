/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistempenilaiansiswa;

import java.awt.event.KeyEvent;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Reihan & Adhira
 */
public class frm_simulasiNA extends javax.swing.JFrame {

    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;
    /**
     * Creates new form frm_simulasiNA
     */
    public frm_simulasiNA() {
        
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        TableNA.setModel(tableModel);
        
        settableload();
        getDataComboBox();
        
        
        
    }
        
        String data[] = new String [18];
        private void settableload(){
        String stat = "";
        
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "Select * From simulasi";
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
                data[15] = res.getString(16);
                data[16] = res.getString(17);
                data[17] = res.getString(18);
                
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
                            "NAMA MK",
                            "Presentase Absen",
                            "Presentase Tugas",
                            "Presentase UTS",
                            "Presentase UAS",
                            "Absensi",
                            "Tgs 1",
                            "Tgs 2",
                            "Tgs 3",
                            "UTS",
                            "UAS",
                            "Nilai Absen",
                            "Nilai Tugas",
                            "Nilai UTS",
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
    
    public void getDataComboBox() {
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            
            String sql = "Select nama_mk FROM t_mata_kuliah";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {
                String nama_mk = rs.getString(1);
                combo_mk.addItem(nama_mk);
            }
            rs.close();
            stt.close();
            kon.close();
          } catch (Exception ex) {
              JOptionPane.showMessageDialog(null,
                        ex.getMessage(), "Error",
                        JOptionPane.INFORMATION_MESSAGE
                );
          }
    }
    int row=0;
    public void tampil_field () {
        row = TableNA.getSelectedRow();
        
        aktif_teks();
        
        combo_mk.setSelectedItem(tableModel.getValueAt(row, 0).toString());
        p_absen.setText(tableModel.getValueAt(row, 1).toString());
        p_tugas.setText(tableModel.getValueAt(row, 2).toString());
        p_uts.setText(tableModel.getValueAt(row, 3).toString());
        p_uas.setText(tableModel.getValueAt(row, 4).toString());
        khdrn.setText(tableModel.getValueAt(row, 5).toString());
        txt_tgs1.setText(tableModel.getValueAt(row, 6).toString());
        txt_tgs2.setText(tableModel.getValueAt(row, 7).toString());
        txt_tgs3.setText(tableModel.getValueAt(row, 8).toString());
        txt_uts.setText(tableModel.getValueAt(row, 9).toString());
        txt_uas.setText(tableModel.getValueAt(row, 10).toString());
    }
    
    public void non_aktif_teks() {
        kode_mk.setEnabled(false);
        p_absen.setEnabled(false);
        p_tugas.setEnabled(false);
        p_uas.setEnabled(false);
        p_uts.setEnabled(false);
        khdrn.setEnabled(false);
        txt_tgs1.setEnabled(false);
        txt_tgs2.setEnabled(false);
        txt_tgs3.setEnabled(false);
        txt_uts.setEnabled(false);
        txt_uas.setEnabled(false);
    }
    
    public void aktif_teks () {
        kode_mk.setEnabled(true);
        p_absen.setEnabled(true);
        p_tugas.setEnabled(true);
        p_uas.setEnabled(true);
        p_uts.setEnabled(true);
        khdrn.setEnabled(true);
        txt_tgs1.setEnabled(true);
        txt_tgs2.setEnabled(true);
        txt_tgs3.setEnabled(true);
        txt_uts.setEnabled(true);
        txt_uas.setEnabled(true);
    }
    
    public void reset_teks() {
        kode_mk.setText("");
        p_absen.setText("");
        p_tugas.setText("");
        p_uas.setText("");
        p_uts.setText("");
        khdrn.setText("");
        txt_tgs1.setText("");
        txt_tgs2.setText("");
        txt_tgs3.setText("");
        txt_uts.setText("");
        txt_uas.setText("");
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
        combo_mk = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        kode_mk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        p_absen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        p_tugas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        p_uts = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        p_uas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        khdrn = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_tgs1 = new javax.swing.JTextField();
        txt_tgs2 = new javax.swing.JTextField();
        txt_tgs3 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_uts = new javax.swing.JTextField();
        txt_uas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableNA = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_ubh = new javax.swing.JButton();
        btn_hps = new javax.swing.JButton();
        btn_spmn = new javax.swing.JButton();
        btn_btl = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulasi Nilai Akhir");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("FORM SIMULASI NILAI AKHIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(201, 201, 201))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel2.setText("Nama Mata Kuliah");

        combo_mk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-=Pilih=-" }));
        combo_mk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_mkActionPerformed(evt);
            }
        });

        jLabel3.setText("Kode MK");

        kode_mk.setEditable(false);

        jLabel4.setText("Persentase Absen");

        jLabel5.setText("Persentase Tugas");

        p_tugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_tugasActionPerformed(evt);
            }
        });

        jLabel6.setText("Persentase UTS");

        jLabel7.setText("Persebtase UAS");

        jLabel8.setText("%");

        jLabel9.setText("%");

        jLabel10.setText("%");

        jLabel11.setText("%");

        jLabel12.setText("Kehadiran");

        jLabel13.setText("Tugas 1");

        jLabel14.setText("Tugas 2");

        jLabel15.setText("Tugas 3");

        jLabel16.setText("Pertemuan");

        jLabel17.setText("UTS");

        jLabel18.setText("UAS");

        txt_uas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_uasActionPerformed(evt);
            }
        });

        TableNA.setModel(new javax.swing.table.DefaultTableModel(
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
        TableNA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableNAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableNA);

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_ubh.setText("Ubah");
        btn_ubh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ubhActionPerformed(evt);
            }
        });

        btn_hps.setText("Hapus");
        btn_hps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hpsActionPerformed(evt);
            }
        });

        btn_spmn.setText("Simpan");
        btn_spmn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_spmnActionPerformed(evt);
            }
        });

        btn_btl.setText("Batal");
        btn_btl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_btlActionPerformed(evt);
            }
        });

        jButton6.setText("Keluar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(combo_mk, 0, 160, Short.MAX_VALUE)
                                            .addComponent(kode_mk)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(151, 151, 151)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(p_tugas)
                                                            .addComponent(p_absen)
                                                            .addComponent(p_uts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(p_uas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addComponent(jLabel7))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))))
                                        .addGap(57, 57, 57)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel15)
                                                    .addComponent(jLabel17)
                                                    .addComponent(jLabel18))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_uts, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_tgs3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_uas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(khdrn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel16))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_tgs1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_tgs2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 9, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)
                        .addGap(50, 50, 50)
                        .addComponent(btn_ubh, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btn_hps, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btn_spmn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_btl, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kode_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(p_absen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(khdrn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(p_tugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(txt_tgs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(p_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(txt_tgs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(p_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel15)
                        .addComponent(txt_tgs3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btn_ubh)
                    .addComponent(btn_hps)
                    .addComponent(btn_spmn)
                    .addComponent(btn_btl)
                    .addComponent(jButton6))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void p_tugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_tugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_tugasActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        frm_utama utm = new frm_utama();
        utm.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void combo_mkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_mkActionPerformed
        // TODO add your handling code here:
        String mata_kuliah = combo_mk.getSelectedItem().toString();
        
        if (mata_kuliah == "-=Pilih=-") {
            JOptionPane.showMessageDialog(null, "Silahkan pilih nama terlebih dahulu");
        } else {
            try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "select kd_mk from t_mata_kuliah "
                        + "where nama_mk= '"+mata_kuliah+"' ";
            ResultSet res = stt.executeQuery(SQL);
            while (res.next()) {
                kode_mk.setText(res.getString(1));  
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        aktif_teks();
        combo_mk.requestFocus();
        
        btn_hps.setEnabled(false);
        btn_ubh.setEnabled(false);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_btlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_btlActionPerformed
        // TODO add your handling code here:
        btn_hps.setEnabled(true);
        btn_ubh.setEnabled(true);
    }//GEN-LAST:event_btn_btlActionPerformed

    private void btn_spmnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_spmnActionPerformed
        // Ambil semua value pada textfield
        String data[] = new String [18];
        
        if ((kode_mk.getText().isEmpty()) || (p_absen.getText().isEmpty()) || (txt_tgs1.getText().isEmpty() || (txt_tgs2.getText().isEmpty() || (txt_tgs3.getText().isEmpty()) || (p_tugas.getText().isEmpty() || (p_uas.getText().isEmpty() || (p_uts.getText().isEmpty()) ))))) {
            JOptionPane.showMessageDialog(null, "Data untuk simulasi tidak boleh kosong, Harap isi !");
            p_absen.requestFocus();
            
        }
        else {
            try {
                //menghitung nilai absen
                Double absen = Double.valueOf(p_absen.getText());
                Double kehadiran = Double.valueOf(khdrn.getText());
                Double nilai_absen = (((kehadiran/14)*100*absen)/100);
                
                //menghitung nilai tugas
                Double pr_tugas = Double.valueOf(p_tugas.getText());
                Double tugas = Double.valueOf(txt_tgs1.getText());
                Double tugas2 = Double.valueOf(txt_tgs2.getText());
                Double tugas3 = Double.valueOf(txt_tgs3.getText());
                Double nilai_tugas = (((tugas+tugas2+tugas3)/3)*(pr_tugas/100));
                
                //menghitung nilai uts
                Double pr_uts = Double.valueOf(p_uts.getText());
                Double uts = Double.valueOf(txt_uts.getText());
                Double nilai_uts = uts * (pr_uts/100);
                
                //menghitung nilai uas
                Double pr_uas = Double.valueOf(p_uas.getText());
                Double uas = Double.valueOf(txt_uas.getText());
                Double nilai_uas = uas * (pr_uas/100);
                
                //menghitung nilai akhir dan menentukan index
                Double nilai_akhir = nilai_absen + nilai_tugas + nilai_uts + nilai_uas;
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
                
                if (kehadiran < 11) {
                    keterangan = "Tidak Lulus";
                }
                
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO simulasi (nama_mk,"
                        + "p_absen,"
                        + "p_tugas,"
                        + "p_uts,"
                        + "p_uas,"
                        + "absensi,"
                        + "tgs1,"
                        + "tgs2,"
                        + "tgs3,"
                        + "uts,"
                        + "uas,"
                        + "nilai_absen,"
                        + "nilai_tugas,"
                        + "nilai_uts,"
                        + "nilai_uas,"
                        + "nilai_akhir,"
                        + "indeks,"
                        + "keterangan) "
                        + "VALUES "
                        + "('"+combo_mk.getSelectedItem()+"',"
                        + "'"+absen+"',"
                        + "'"+pr_tugas+"',"
                        + "'"+pr_uts+"',"
                        + "'"+pr_uas+"',"
                        + "'"+kehadiran+"',"
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
                data[0] = combo_mk.getSelectedItem().toString();
                data[1] = String.valueOf(absen);
                data[2] = String.valueOf(pr_tugas);
                data[3] = String.valueOf(pr_uts);
                data[4] = String.valueOf(pr_uas);
                data[5] = String.valueOf(kehadiran);
                data[6] = String.valueOf(tugas);
                data[7] = String.valueOf(tugas2);
                data[8] = String.valueOf(tugas3);
                data[9] = String.valueOf(uts);
                data[10] = String.valueOf(uas);
                data[11] = String.valueOf(nilai_absen);
                data[12] = String.valueOf(nilai_tugas);
                data[13] = String.valueOf(nilai_uts);
                data[14] = String.valueOf(nilai_uas);
                data[15] = String.valueOf(nilai_akhir);
                data[16] = String.valueOf(indeks);
                data[17] = String.valueOf(keterangan);
                
                tableModel.insertRow(0, data);
                
                btn_hps.setEnabled(true);
                btn_ubh.setEnabled(true);
                
                
                stt.close();
                kon.close();
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        
    }//GEN-LAST:event_btn_spmnActionPerformed

    private void txt_uasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_uasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_uasActionPerformed

    private void TableNAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableNAMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            tampil_field();
        }
    }//GEN-LAST:event_TableNAMouseClicked

    private void btn_ubhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubhActionPerformed
        // TODO add your handling code here:
        String nama_mk = combo_mk.getSelectedItem().toString();
        String pabsen = p_absen.getText();
        String ptugas = p_tugas.getText();
        String puts = p_uts.getText();
        String puas = p_uas.getText();
        String kehadiran = khdrn.getText();
        String tugas1 = txt_tgs1.getText();
        String tugas2 = txt_tgs2.getText();
        String tugas3 = txt_tgs3.getText();
        String uts = txt_uts.getText();
        String uas = txt_uas.getText();
        
        if ((kode_mk.getText().isEmpty()) || (p_absen.getText().isEmpty()) || (txt_tgs1.getText().isEmpty() || (txt_tgs2.getText().isEmpty() || (txt_tgs3.getText().isEmpty()) || (p_tugas.getText().isEmpty() || (p_uas.getText().isEmpty() || (p_uts.getText().isEmpty()) ))))) {
            
        } else {
            try {
            Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE simulasi "
                        + "SET "
                        + "nama_mk = '"+nama_mk +"',"
                        + "p_absen = '"+pabsen+"',"
                        + "p_tugas = '"+ptugas+"',"
                        + "p_uts = '"+puts+"',"
                        + "p_uas = '"+puas+"',"
                        + "absensi = '"+kehadiran+"',"
                        + "tgs1 = '"+tugas1+"',"
                        + "tgs2 = '"+tugas2+"',"
                        + "tgs3 = '"+tugas3+"',"
                        + "uts = '"+uts+"',"
                        + "uas = '"+uas+"'"
                        + "WHERE nama_mk= '" + tableModel.getValueAt(row, 0).toString() + "'";
                
                stt.executeUpdate(SQL);
                
                
                data[0] = nama_mk;
                data[1] = pabsen;
                data[2] = ptugas;
                data[3] = puts;
                data[4] = puas;
                data[5] = kehadiran;
                data[6] = tugas1;
                data[7] = tugas2;
                data[8] = tugas3;
                data[9] = uts;
                data[10] = uas;
                
                tableModel.removeRow(row);
                tableModel.insertRow(row, data);
                stt.close();
                kon.close();
                
                reset_teks();
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_ubhActionPerformed

    private void btn_hpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hpsActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "DELETE from simulasi "
                         + "where "
                         + "nama_mk='"+tableModel.getValueAt(row, 0).toString()+"'";
            
            stt.executeUpdate(SQL);
            tableModel.removeRow(row);
            stt.close();
            kon.close();
            reset_teks();
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_hpsActionPerformed

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
            java.util.logging.Logger.getLogger(frm_simulasiNA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_simulasiNA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_simulasiNA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_simulasiNA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_simulasiNA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableNA;
    private javax.swing.JButton btn_btl;
    private javax.swing.JButton btn_hps;
    private javax.swing.JButton btn_spmn;
    private javax.swing.JButton btn_ubh;
    private javax.swing.JComboBox<String> combo_mk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField khdrn;
    private javax.swing.JTextField kode_mk;
    private javax.swing.JTextField p_absen;
    private javax.swing.JTextField p_tugas;
    private javax.swing.JTextField p_uas;
    private javax.swing.JTextField p_uts;
    private javax.swing.JTextField txt_tgs1;
    private javax.swing.JTextField txt_tgs2;
    private javax.swing.JTextField txt_tgs3;
    private javax.swing.JTextField txt_uas;
    private javax.swing.JTextField txt_uts;
    // End of variables declaration//GEN-END:variables
}
