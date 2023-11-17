package com.form;

import Class_DAO.NhanVien_DAO;
import Class_Model.NhanVien_Model;
import Class_Utils.Auth;
import Class_Utils.MsgBox;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormNhanVien extends javax.swing.JPanel {

    //List<NhanVien_Model> list = new ArrayList<>();
    NhanVien_DAO dao = new NhanVien_DAO();
    int index = -1;

    public FormNhanVien() {
        initComponents();
        init();
    }

    private void init() {
        this.fillToTable();
        //this.updateStatus();
    }

    private void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien_Model> list = dao.selectAll();
            for (NhanVien_Model nv : list) {
                Object[] row = {
                    nv.getMANV(),
                    nv.getTENNV(),
                    nv.getNGAYSINH(),
                    nv.getDIACHI(),
                    nv.getEMAIL(),
                    nv.getSODT(),
                    nv.getGIOITINH() ? "Nam" : "Nữ",
                    nv.getVITRICONGVIEC() ? "Quản Lý" : "Nhân Viên"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "LỖI TRUY VẤN DỮ LIỆU");
        }
    }

    public void fillToForm(int index) {
        List<NhanVien_Model> list = dao.selectAll();
        NhanVien_Model nv = list.get(index);
        txtTen.setText(nv.getTENNV());
        txtMaNV.setText(nv.getMANV());
        txtDiaChi.setText(nv.getDIACHI());
        txtEmail.setText(nv.getEMAIL());
        txtMatKhau.setText("***********");
        txtNgaySinh.setDate(nv.getNGAYSINH());
        txtSDT.setText(nv.getSODT());
        if (nv.isGIOITINH()) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        if (nv.isVITRICONGVIEC()) {
            rdiQLy.setSelected(true);
        } else {
            rdoNVien.setSelected(true);
        }
        tblNhanVien.setRowSelectionInterval(index, index);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgGioiTinh = new javax.swing.ButtonGroup();
        btgVaiTro = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        txtSDT = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        rdiQLy = new javax.swing.JRadioButton();
        rdoNVien = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN NHÂN VIÊN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel3.setText("Mã Nhân Viên");

        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên Nhân Viên");

        jLabel5.setText("Mật Khẩu");

        jLabel6.setText("Ngày Sinh");

        jLabel7.setText("Địa Chỉ");

        jLabel8.setText("Email");

        jLabel9.setText("Giới Tính");

        jLabel10.setText("Chức Vụ");

        jLabel12.setText("Số Điện Thoại");

        btgGioiTinh.add(rdoNam);
        rdoNam.setText("Nam");

        btgGioiTinh.add(rdoNu);
        rdoNu.setText("Nữ");

        btgVaiTro.add(rdiQLy);
        rdiQLy.setText("Quản Lý");

        btgVaiTro.add(rdoNVien);
        rdoNVien.setText("Nhân Viên");

        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("XOÁ");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnThem)
                        .addGap(45, 45, 45)
                        .addComponent(btnSua)
                        .addGap(37, 37, 37)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoi))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMaNV))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTen))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMatKhau))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoNam))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdiQLy)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoNu)
                            .addComponent(rdoNVien)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtDiaChi))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtEmail))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoNam)
                        .addComponent(rdoNu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdiQLy)
                    .addComponent(rdoNVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLamMoi))
                .addGap(36, 36, 36))
        );

        tblNhanVien.setBackground(new java.awt.Color(242, 242, 242));
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên NV", "Ngày Sinh", "Địa Chỉ", "Email", "Số ĐT", "Giới Tính", "Chức Vụ"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (!validates()) {
            return;
        } else if (check()) {
            insert();
            return;
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        reset();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int index = tblNhanVien.getSelectedRow();
        fillToForm(index);

    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (!validates()) {
            return;
        } else {
            update();
            return;
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete();
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgGioiTinh;
    private javax.swing.ButtonGroup btgVaiTro;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JRadioButton rdiQLy;
    private javax.swing.JRadioButton rdoNVien;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JPasswordField txtMatKhau;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables

    private NhanVien_Model getForm() {
        NhanVien_Model model = new NhanVien_Model();
        model.setMANV(txtMaNV.getText());
        model.setTENNV(txtTen.getText());
        model.setDIACHI(txtDiaChi.getText());
        model.setEMAIL(txtEmail.getText());
        model.setMATKHAU(new String(txtMatKhau.getPassword()));
        model.setNGAYSINH(txtNgaySinh.getDate());
        model.setSODT(txtSDT.getText());
        model.setVITRICONGVIEC(rdiQLy.isSelected());
        model.setGIOITINH(rdoNam.isSelected());
        return model;
    }

    public void reset() {
        txtMaNV.setText("");
        txtTen.setText("");
        txtNgaySinh.setDate(null);
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        txtMatKhau.setText("");
        btgGioiTinh.clearSelection();
        btgVaiTro.clearSelection();
    }

    private void insert() {
        NhanVien_Model model = getForm();
        String confirm = new String(txtMatKhau.getPassword());
        if (confirm.equals(model.getMATKHAU())) {
            try {
                dao.insert(model);
                this.fillToTable();
                this.reset();
                MsgBox.alert(this, "THÊM THÀNH CÔNG!");
            } catch (Exception e) {
                MsgBox.alert(this, "THÊM THẤT BẠI!");
            }
        } else {
            MsgBox.alert(this, "XÁC NHẬN MẬT KHẨU SAI!!!");
        }
    }

    private void update() {
        NhanVien_Model model = getForm();
        try {
            dao.update(model);
            this.fillToTable();
            this.reset();
            MsgBox.alert(this, "CẬP NHẬT THÀNH CÔNG!");
        } catch (Exception e) {
            MsgBox.alert(this, "CẬP NHẬT THẤT BẠI");
        }
    }

    private void delete() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "BẠN KHÔNG CÓ QUYỀN XOÁ NHÂN VIÊN");
        } else {
            if (MsgBox.confirm(this, "BẠN MUỐN XOÁ NHÂN VIÊN NÀY?")) {
                String maNV = txtMaNV.getText();
                try {
                    dao.delete(maNV);
                    this.fillToTable();
                    this.reset();
                    MsgBox.alert(this, "XOÁ THÀNH CÔNG");
                } catch (Exception e) {
                    MsgBox.alert(this, "XOÁ THẤT BẠI.");
                }
            }
        }
    }
//BẮT LỖI

    boolean validates() {
        if (txtMaNV.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "MÃ NHÂN VIÊN KHÔNG ĐƯỢC TRỐNG!! ", "CHÚ Ý!!!", 1);
            txtMaNV.requestFocus();
            return false;
        }
        if (txtTen.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "TÊN NHÂN VIÊN KHÔNG ĐƯỢC TRỐNG!! ", "CHÚ Ý!!!", 1);
            txtTen.requestFocus();
            return false;
        }
        if (txtMatKhau.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "MẬT KHẨU KHÔNG ĐƯỢC TRỐNG!! ", "CHÚ Ý!!!", 1);
            txtMatKhau.requestFocus();
            return false;
        }
        if (txtNgaySinh.getDate() == null) {
            JOptionPane.showMessageDialog(this, "NGÀY SINH KHÔNG ĐƯỢC TRỐNG!! ", "CHÚ Ý!!!", 1);
            txtNgaySinh.requestFocus();
            return false;
        }
        if (txtDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "MẬT KHẨU KHÔNG ĐƯỢC TRỐNG!! ", "CHÚ Ý!!!", 1);
            txtMatKhau.requestFocus();
            return false;
        }
        if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "MẬT KHẨU KHÔNG ĐƯỢC TRỐNG!! ", "CHÚ Ý!!!", 1);
            txtMatKhau.requestFocus();
            return false;
        }
        if (txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "MẬT KHẨU KHÔNG ĐƯỢC TRỐNG!! ", "CHÚ Ý!!!", 1);
            txtMatKhau.requestFocus();
            return false;
        }
        boolean isRoleSelectedgt = false;
        boolean isRoleSelectedVt = false;
        if (rdoNam.isSelected()) {
            isRoleSelectedgt = true;
        } else if (rdoNu.isSelected()) {
            isRoleSelectedgt = true;
        }
        if (!isRoleSelectedgt) {
            JOptionPane.showMessageDialog(this, "GIỚI TÍNH KHÔNG ĐƯỢC TRỐNG!", "CHÚ Ý!!!", 1);
            rdoNam.requestFocus(); // hoặc rdoTruongPhong.requestFocus();
            return false;
        }
        if (rdoNVien.isSelected()) {
            isRoleSelectedVt = true;
        } else if (rdiQLy.isSelected()) {
            isRoleSelectedVt = true;
        }
        if (!isRoleSelectedVt) {
            JOptionPane.showMessageDialog(this, "VAI TRÒ KHÔNG ĐƯỢC TRỐNG!", "CHÚ Ý!!!", 1);
            rdoNVien.requestFocus(); // hoặc rdoTruongPhong.requestFocus();
            return false;
        }

        return true;
    }

    boolean check() {
        String pName = txtMaNV.getText().trim();
// Thực hiện truy vấn để kiểm tra mã khách hàng
        String sql = "SELECT COUNT(*) FROM NHANVIEN WHERE MANV = ?";
        try {
            Connection con = Class_DBHelder.DBHelder_SQL.getDbConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, pName);
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                JOptionPane.showMessageDialog(this, "MÃ NHÂN VIÊN ĐÃ TỒN TẠI!");
                txtMaNV.grabFocus();
                return false;
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
