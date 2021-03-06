/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import entity.*;
import DAO.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author giap
 */
public class Form_QLTaiKhoan extends javax.swing.JInternalFrame {

    /**
     * Creates new form QLTaiKhoan
     */
    DefaultTableModel model;
    int index;
    List<Accounts> listAcc = new ArrayList<>();
    List<entity.Class> listClass = new ArrayList<>();

    public Form_QLTaiKhoan() {
        initComponents();
        model = (DefaultTableModel) tbl_list.getModel();
        this.getFulllist();
        this.filltotable();
        this.getcombobox();
        if (listAcc.size() > 0) {
            index = 0;
            tbl_list.setRowSelectionInterval(index, index);
            this.showDetail();
        }
    }

    public void getcombobox() {
        listClass = new ClassDAO().findAll();
        if (listClass != null) {
            for (entity.Class c : listClass) {
                cbo_class2.addItem(c.getId());
                cbo_class3.addItem(c.getId());
            }
            cbo_class2.addItem("");
            cbo_class3.addItem("");
        }
    }

    public void getFulllist() {
        if (listAcc != null) {
            listAcc.clear();
        }
        try {
            listAcc = new AccountDAO().findAll();
            if (listAcc == null) {
                JOptionPane.showMessageDialog(this, "LỖI LOAD DATA");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "LỖI LOAD DATA");
        }

    }

    public boolean validate1() {
        String username = txtUsername3.getText().trim();
        String password = new String(txtpass.getPassword()).trim();
        String passconfirm = new String(txtconfim.getPassword()).trim();
        String fullname = txtFullname3.getText().trim();
        if (username.length() < 1) {
            JOptionPane.showMessageDialog(this, "KHÔNG ĐƯỢC BỎ TRỐNG USERNAME");
            return false;
        }
        if (username.length() < 4 || username.length() > 20) {
            JOptionPane.showMessageDialog(this, "TÊN TÀI KHOẢN PHẢI TỪ 4 ĐẾN 20 KÝ TỰ");
            return false;
        }
        if (!username.matches("\\w+")) {
            JOptionPane.showMessageDialog(this, "TÊN TÀI KHOẢN CHỈ ĐƯỢC SỬ DỤNG CÁC KÝ TỰ ALPHABET, SỐ và _");
            return false;
        }
        if (password.length() < 1) {
            JOptionPane.showMessageDialog(this, "KHÔNG ĐƯỢC BỎ TRỐNG PASSWORD");
            return false;
        }
        if (password.length() < 6 || password.length() > 16) {
            JOptionPane.showMessageDialog(this, "MẬT KHẨU PHẢI TỪ 6 ĐẾN 16 KÝ TỰ");
            return false;
        }
        if (!password.matches("\\w+")) {
            JOptionPane.showMessageDialog(this, "TÊN TÀI KHOẢN CHỈ ĐƯỢC SỬ DỤNG CÁC KÝ TỰ ALPHABET, SỐ và _");
            return false;
        }
        if (!password.equals(passconfirm)) {
            JOptionPane.showMessageDialog(this, "PASSWORD VÀ CONFIRM PASSWORD CẦN TRÙNG KHỚP");
            return false;
        }
        if (fullname.length() < 1) {
            JOptionPane.showMessageDialog(this, "KHÔNG ĐỂ TRỐNG HỌ TÊN");
            return false;
        }
        if (fullname.length() > 30) {
            JOptionPane.showMessageDialog(this, "ĐỘ DÀI HỌ TÊN KHÔNG ĐƯỢC VƯỢT QUÁ 30 KÝ TỰ");
            return false;
        }
        if (!txtsdt3.getText().matches("^0\\d{9}")) {
            JOptionPane.showMessageDialog(this, "SỐ ĐIỆN THOẠI PHẢI CÓ 10 SỐ VÀ PHẢI BẮT ĐẦU BẰNG SỐ 0");
            return false;
        }
        if (txtemail3.getText().trim().length() > 30) {
            JOptionPane.showMessageDialog(this, "EMAIL PHẢI ÍT HƠN 30 KÝ TỰ");
            return false;
        }

        if (!txtemail3.getText().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            JOptionPane.showMessageDialog(this, "EMAIL PHẢI ĐÚNG ĐỊNH DẠNG");
            return false;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            String date = sdf.format(txtDate3.getDate());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "NGÀY SINH SAI ĐỊNH DẠNG, HÃY CHỌN NGÀY SINH TỪ LỊCH");
            return false;
        }

        return true;
    }

    public boolean validate2() {
        String password = new String(txtpass2.getPassword()).trim();
        
        String fullname = txtFullname2.getText().trim();
        if (password.length() < 1) {
            JOptionPane.showMessageDialog(this, "KHÔNG ĐƯỢC BỎ TRỐNG PASSWORD");
            return false;
        }
        if (password.length() < 6 || password.length() > 16) {
            JOptionPane.showMessageDialog(this, "MẬT KHẨU PHẢI TỪ 6 ĐẾN 16 KÝ TỰ");
            return false;
        }
        if (!password.matches("\\w+")) {
            JOptionPane.showMessageDialog(this, "TÊN TÀI KHOẢN CHỈ ĐƯỢC SỬ DỤNG CÁC KÝ TỰ ALPHABET, SỐ và _");
            return false;
        }
        
        if (fullname.length() < 1) {
            JOptionPane.showMessageDialog(this, "KHÔNG ĐỂ TRỐNG HỌ TÊN");
            return false;
        }
        if (fullname.length() > 30) {
            JOptionPane.showMessageDialog(this, "ĐỘ DÀI HỌ TÊN KHÔNG ĐƯỢC VƯỢT QUÁ 30 KÝ TỰ");
            return false;
        }
        if (!txtSdt2.getText().matches("^0\\d{9}")) {
            JOptionPane.showMessageDialog(this, "SỐ ĐIỆN THOẠI PHẢI CÓ 10 SỐ VÀ PHẢI BẮT ĐẦU BẰNG SỐ 0");
            return false;
        }
        if (txtEmail2.getText().trim().length() > 30) {
            JOptionPane.showMessageDialog(this, "EMAIL PHẢI ÍT HƠN 30 KÝ TỰ");
            return false;
        }

        if (!txtEmail2.getText().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            JOptionPane.showMessageDialog(this, "EMAIL PHẢI ĐÚNG ĐỊNH DẠNG");
            return false;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            String date = sdf.format(txtDate2.getDate());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "NGÀY SINH SAI ĐỊNH DẠNG, HÃY CHỌN NGÀY SINH TỪ LỊCH");
            return false;
        }

        return true;
    }

    public void filltotable() {
        model.setRowCount(0);
        for (Accounts x : listAcc) {
            model.addRow(new Object[]{x.getUsername(), x.isType() ? "Giáo Viên" : "Học Sinh", x.getFullname(), x.getClass_()});
        }
    }

    public void showDetail() {
        Accounts acc1 = listAcc.get(index);
        txtUsername2.setText(acc1.getUsername());
        txtpass2.setText(acc1.getPassword());
        if (acc1.isType()) {
            txtLoaiTk.setText("Giáo Viên");
            cbo_class2.setEnabled(false);
        } else {
            txtLoaiTk.setText("Học Sinh");
            cbo_class2.setEnabled(true);
        }
        cbo_class2.setSelectedItem(acc1.getClass_());
        txtSdt2.setText(acc1.getPhone());
        txtEmail2.setText(acc1.getEmail());
        txtFullname2.setText(acc1.getFullname());
        if (acc1.isGender()) {
            rb_nam2.setSelected(true);
        } else {
            rb_nu2.setSelected(true);
        }
        System.out.println("====>"+acc1.getBirthday());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            String dS = acc1.getBirthday();
            String MM = dS.substring(5, 7);
            String dd = dS.substring(8, 10);
            String yyyy = dS.substring(0, 4);
            dS = dd + "-" + MM + "-" + yyyy;
            Date date21 = sdf.parse(dS);
            txtDate2.setDate(date21);
        } catch (ParseException ex) {
            Logger.getLogger(Form_QLTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_list = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsername1 = new javax.swing.JTextField();
        txtFullname1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rb_hs1 = new javax.swing.JRadioButton();
        rb_gv1 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ckb = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lb = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFullname2 = new javax.swing.JTextField();
        txtSdt2 = new javax.swing.JTextField();
        txtDate2 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        txtEmail2 = new javax.swing.JTextField();
        rb_nam2 = new javax.swing.JRadioButton();
        rb_nu2 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbo_class2 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        txtLoaiTk = new javax.swing.JLabel();
        txtUsername2 = new javax.swing.JLabel();
        txtpass2 = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtDate3 = new com.toedter.calendar.JDateChooser();
        txtsdt3 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtemail3 = new javax.swing.JTextField();
        txtFullname3 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        rb_nam3 = new javax.swing.JRadioButton();
        rd_nu3 = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        txtUsername3 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        rb_hs3 = new javax.swing.JRadioButton();
        rb_gv3 = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        cbo_class3 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();
        txtconfim = new javax.swing.JPasswordField();
        jLabel25 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(724, 468));

        tbl_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Loại tài khoản", "Họ và tên", "Lớp học"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_list);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Username :");

        txtFullname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFullname1ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Họ tên :");

        buttonGroup1.add(rb_hs1);
        rb_hs1.setSelected(true);
        rb_hs1.setText("Học sinh");
        rb_hs1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_hs1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_gv1);
        rb_gv1.setText("Giáo viên");
        rb_gv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_gv1ActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Loại tài khoản :");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search.png"))); // NOI18N
        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ckb.setSelected(true);
        ckb.setText("Tất Cả");
        ckb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFullname1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rb_hs1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_gv1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ckb, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ckb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_hs1)
                    .addComponent(rb_gv1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullname1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/List.png"))); // NOI18N
        jButton2.setText("Chi Tiết");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 47, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách tất cả tài khoản", jPanel1);

        lb.setText("Username : ");

        jLabel7.setText("Password :");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Họ tên :");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Giới tính :");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ngày sinh :");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Số điện thoại :");

        txtDate2.setDateFormatString("dd-MM-yyyy");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Email :");

        buttonGroup2.add(rb_nam2);
        rb_nam2.setText("Nam");

        buttonGroup2.add(rb_nu2);
        rb_nu2.setText("Nữ");

        jLabel13.setText("Loại tài khoản :");

        jLabel14.setText("Lớp học :");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit.png"))); // NOI18N
        jButton3.setText("SỬA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtLoaiTk.setText("Loại tài khoản");

        txtUsername2.setText("jLabel5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbo_class2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(txtLoaiTk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(rb_nam2)
                                .addGap(18, 18, 18)
                                .addComponent(rb_nu2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFullname2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtUsername2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpass2)))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSdt2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtUsername2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpass2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSdt2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullname2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoaiTk, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_nam2)
                    .addComponent(rb_nu2)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_class2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Sửa tài khoản", jPanel2);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Ngày sinh :");

        txtDate3.setDateFormatString("dd-MM-yyyy");

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Số điện thoại :");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Email :");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Họ tên :");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Giới tính :");

        rb_nam3.setSelected(true);
        rb_nam3.setText("Nam");

        rd_nu3.setText("Nữ");

        jLabel21.setText("Password :");

        jLabel22.setText("Username :");

        jLabel23.setText("Loại tài khoản :");

        buttonGroup3.add(rb_hs3);
        rb_hs3.setSelected(true);
        rb_hs3.setText("Học sinh");
        rb_hs3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_hs3ActionPerformed(evt);
            }
        });

        buttonGroup3.add(rb_gv3);
        rb_gv3.setText("Giáo viên");
        rb_gv3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_gv3ActionPerformed(evt);
            }
        });

        jLabel24.setText("Lớp học :");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Accept.png"))); // NOI18N
        jButton4.setText("Thêm mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtconfim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconfimActionPerformed(evt);
            }
        });

        jLabel25.setText("Confirm :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cbo_class3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_hs3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(rb_gv3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtconfim))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtUsername3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtpass))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDate3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsdt3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(rb_nam3)
                                .addGap(18, 18, 18)
                                .addComponent(rd_nu3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFullname3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtemail3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtsdt3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtconfim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtemail3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullname3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_hs3)
                    .addComponent(rb_gv3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_nam3)
                    .addComponent(rd_nu3)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_class3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Thêm mới tài khoản", jPanel3);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ TÀI KHOẢN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFullname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFullname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFullname1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(jPanel2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_listMouseClicked
        // TODO add your handling code here:
        index = tbl_list.getSelectedRow();
        this.showDetail();
    }//GEN-LAST:event_tbl_listMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (validate2()) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            String date2 = sdf.format(txtDate2.getDate());
            
            Accounts acc2 = new AccountDAO().findOne(txtUsername2.getText());
            acc2.setBirthday(date2);
            acc2.setPassword(new String(txtpass2.getPassword()));
            acc2.setClass_((String) cbo_class2.getSelectedItem());
            acc2.setEmail(txtEmail2.getText());
            acc2.setPhone(txtSdt2.getText());
            acc2.setFullname(txtFullname2.getText());
            acc2.setGender(rb_nam2.isSelected());

            if (new AccountDAO().update(acc2)) {
                JOptionPane.showMessageDialog(this, "SỬA THÀNH CÔNG");
                acc2.setBirthday(date2.substring(6)+"-"+date2.substring(0, 2)+"-"+date2.substring(3, 5));
                System.out.println(listAcc.get(index).getBirthday());
                listAcc.set(index, acc2);
                model.setValueAt(acc2.getFullname(), index, 2);
                model.setValueAt(acc2.getClass_(), index, 3);
            } else {
                JOptionPane.showMessageDialog(this, "SỬA THẤT BẠI");
            }
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (validate1()) {
            if (new AccountDAO().findOne(txtUsername3.getText()) != null) {
                JOptionPane.showMessageDialog(this, "TÀI KHOẢN ĐÃ ĐƯỢC ĐĂNG KÝ TRƯỚC ĐÓ, HÃY THỬ LẠI VỚI 1 USERNAME KHÁC");
                return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            String date3 = sdf.format(txtDate3.getDate());
            Accounts acc3 = new Accounts();
            acc3.setBirthday(date3);
            acc3.setUsername(txtUsername3.getText());
            acc3.setPassword(txtpass.getText());
            acc3.setClass_((String) cbo_class3.getSelectedItem());
            acc3.setEmail(txtemail3.getText());
            acc3.setPhone(txtsdt3.getText());
            acc3.setFullname(txtFullname3.getText());
            acc3.setGender(rb_nam3.isSelected());
            acc3.setType(rb_gv3.isSelected());
            
            if (new AccountDAO().save(acc3)) {
                JOptionPane.showMessageDialog(this, "THÊM THÀNH CÔNG");
                listAcc.add(acc3);
                model.addRow(new Object[]{acc3.getUsername(), acc3.isType() ? "Giáo Viên" : "Học Sinh", acc3.getFullname(), acc3.getClass_()});
                index = listAcc.size() - 1;
                tbl_list.setRowSelectionInterval(index, index);
                this.showDetail();

            } else {
                JOptionPane.showMessageDialog(this, "THÊM THẤT BẠI");
            }

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void rb_hs1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_hs1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rb_hs1ActionPerformed

    private void rb_gv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_gv1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rb_gv1ActionPerformed

    private void rb_hs3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_hs3ActionPerformed
        // TODO add your handling code here:
        if (rb_gv3.isSelected()) {
            cbo_class3.setSelectedItem("");
            cbo_class3.setEnabled(false);
        } else {
            cbo_class3.setEnabled(true);
        }
    }//GEN-LAST:event_rb_hs3ActionPerformed

    private void rb_gv3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_gv3ActionPerformed
        // TODO add your handling code here:
        if (rb_gv3.isSelected()) {
            cbo_class3.setSelectedItem("");
            cbo_class3.setEnabled(false);
        } else {
            cbo_class3.setEnabled(true);
        }
    }//GEN-LAST:event_rb_gv3ActionPerformed

    private void txtconfimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconfimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconfimActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ckb.setSelected(false);
        String username = txtUsername1.getText().trim();
        String fullname = txtFullname1.getText().trim();
        boolean type = rb_gv1.isSelected();
        listAcc.clear();
        listAcc = new AccountDAO().search(username, fullname, type);
        this.filltotable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ckbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbActionPerformed
        // TODO add your handling code here:
        if(ckb.isSelected()){
            listAcc.clear();
            listAcc = new AccountDAO().findAll();
            this.filltotable();
        }
    }//GEN-LAST:event_ckbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbo_class2;
    private javax.swing.JComboBox<String> cbo_class3;
    private javax.swing.JCheckBox ckb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lb;
    private javax.swing.JRadioButton rb_gv1;
    private javax.swing.JRadioButton rb_gv3;
    private javax.swing.JRadioButton rb_hs1;
    private javax.swing.JRadioButton rb_hs3;
    private javax.swing.JRadioButton rb_nam2;
    private javax.swing.JRadioButton rb_nam3;
    private javax.swing.JRadioButton rb_nu2;
    private javax.swing.JRadioButton rd_nu3;
    private javax.swing.JTable tbl_list;
    private com.toedter.calendar.JDateChooser txtDate2;
    private com.toedter.calendar.JDateChooser txtDate3;
    private javax.swing.JTextField txtEmail2;
    private javax.swing.JTextField txtFullname1;
    private javax.swing.JTextField txtFullname2;
    private javax.swing.JTextField txtFullname3;
    private javax.swing.JLabel txtLoaiTk;
    private javax.swing.JTextField txtSdt2;
    private javax.swing.JTextField txtUsername1;
    private javax.swing.JLabel txtUsername2;
    private javax.swing.JTextField txtUsername3;
    private javax.swing.JPasswordField txtconfim;
    private javax.swing.JTextField txtemail3;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JPasswordField txtpass2;
    private javax.swing.JTextField txtsdt3;
    // End of variables declaration//GEN-END:variables
}
