/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import DAO.ExamDAO;
import DAO.ExamResultDAO;
import entity.Accounts;
import entity.Exam;
import entity.ExamResult;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author giap
 */
public class Form_ChonDe extends javax.swing.JInternalFrame {

    /**
     * Creates new form Form_Exam
     */
    Accounts acc;
    List<ExamResult> listER = new ArrayList<>();
    List<Exam> listE = new ArrayList<>();
    public Form_ChonDe(Accounts acc) {
        initComponents();
        this.acc =acc;
        try {
            this.setMaximum(true);
        } catch (Exception e) {
        }
        this.loadCombo();
    }

    public void loadCombo() {
        listE.clear();
        listER.clear();
        listE = new ExamDAO().listLock(false);
        listER = new ExamResultDAO().search(acc);
        for(Exam e:listE){
            System.out.println(e.getId());
        }
        for(ExamResult er : listER){
            System.out.println(er.getExam().getId());
        }
        for(int i=0; i<listE.size();i++){
            for(int y=0; y < listER.size();y++){
                if(listE.get(i).getId().equalsIgnoreCase(listER.get(y).getExam().getId())){
                    listE.remove(i);
                    return;
                }
            }
        }
        for (Exam e : listE) {
            cbo_madethi.addItem(e.getId());
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
        ImageIcon icon = new ImageIcon(getClass().getResource("/image/jDesktopPane_BG.jpg"));
        Image img = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(img,0,0,getWidth(),getHeight(),this);
            }
        };
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbo_madethi = new javax.swing.JComboBox<>();
        btnBatdau = new javax.swing.JButton();

        setFocusable(false);
        setMinimumSize(new java.awt.Dimension(724, 431));

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit.png"))); // NOI18N
        jButton2.setText("Đóng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto Condensed Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐỀ THI");

        btnBatdau.setBackground(new java.awt.Color(0, 0, 255));
        btnBatdau.setFont(new java.awt.Font("Roboto Condensed Light", 1, 14)); // NOI18N
        btnBatdau.setForeground(new java.awt.Color(255, 255, 255));
        btnBatdau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Alarm.png"))); // NOI18N
        btnBatdau.setText("Bắt Đầu");
        btnBatdau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatdauActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(cbo_madethi, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(btnBatdau, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(cbo_madethi, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(btnBatdau, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(277, 277, 277))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_madethi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(btnBatdau, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatdauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatdauActionPerformed
        String examID = (String) cbo_madethi.getSelectedItem();
        if (examID != null) {
            ExamDAO examDAO = new ExamDAO();
            if(examDAO.getExamQuestion(examID)==null || examDAO.getExamQuestion(examID).size()==0 ){
                JOptionPane.showMessageDialog(this, "ĐỀ THI KHÔNG CÓ CÂU HỎI NÀO");
            }else{
                Form_LamDeThi form_LamDeThi = new Form_LamDeThi(examID,acc);
                jDesktopPane1.add(form_LamDeThi);
                form_LamDeThi.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "KHÔNG CÓ ĐỀ THI ĐỂ BẮT ĐẦU");
        }
    }//GEN-LAST:event_btnBatdauActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:f
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatdau;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_madethi;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
