/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Lexer;
import clases.Functions;
import clases.Token;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author charg
 */
public class Principal extends javax.swing.JFrame {

    public ArrayList<Token> object = new ArrayList<>();
    Lexer lexer;
    About about;
    Functions func;
    TableOfSimbols simbols;
    ResultSetTable rsTable;

    String lexico;
    int res;
    public boolean creoNuevo;
    public boolean abrioArchivo;
    public boolean guardado;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Akio");
        this.setIconImage(new ImageIcon(getClass().getResource("/icons/akio_icon.png")).getImage());
        lexer = new Lexer(this);
        about = new About(this);
        func = new Functions(this);
        simbols = new TableOfSimbols(this);
        txtPanCode.requestFocus();
    }

    private void Compile() {
        ClearOutput();
        lexico = lexer.compile(txtPanCode.getText());
        txtPanResul.setText(lexico);
        rsTable = new ResultSetTable(this);
        object.clear();
        this.setVisible(false);
        rsTable.setVisible(true);
    }

    private void ClearOutput() {
        txtPanResul.setText("");
        lexer.setParse("");
    }

    private void ClearInput() {
        txtPanCode.setText("");
    }

    //Manda llamar al metodo guardar/actualizar o crear archivo segun sea el caso
    public void SaveCurrentCode() {
        if (this.abrioArchivo | this.creoNuevo) {
            res = func.GuardarFichero(this.txtPanCode.getText(), "");
            if (res == 200) {
                this.guardado = true;
            }
        }
        else if (!this.creoNuevo) {
//            res = func.CrearFicheroNuevo(this.txtPanCode.getText(), "");
//            if (res == 200) {
//                this.creoNuevo = true;
//                this.abrioArchivo = true;
//                this.guardado = true;
//            }
NewFile();
        }
        btnSave.setEnabled(false);
    }

    // Setea los valores boleanos
    private void setBoleans(boolean creoNuevo, boolean guardado, boolean abrioArchivo) {
        this.creoNuevo = creoNuevo;
        this.guardado = guardado;
        this.abrioArchivo = abrioArchivo;
    }
    
    // Manda llamar al metodo crear archivo
    private void NewFile() {
        if (JOptionPane.showConfirmDialog(null, "Deseas guardar el archivo") == JOptionPane.YES_OPTION) {
            res = func.CrearFicheroNuevo(this.txtPanCode.getText(), "");
            if (res == 200) {
                setBoleans(true, true, true);
            }
        } else {
            this.setTitle("Akio");
            setBoleans(false, false, false);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPanResul = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPanCode = new javax.swing.JTextArea();
        btnOpen = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnRun = new javax.swing.JButton();
        btnAbout = new javax.swing.JButton();
        btnTableofSimbols = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        btnNew.setBackground(new java.awt.Color(0, 102, 102));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sharp_add_white_18dp 18x18.png"))); // NOI18N
        btnNew.setToolTipText("ADD");
        btnNew.setBorderPainted(false);
        btnNew.setContentAreaFilled(false);
        btnNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNew.setOpaque(true);
        btnNew.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sharp_add_white_18dp 36x36.png"))); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        txtPanResul.setEditable(false);
        txtPanResul.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(txtPanResul);

        jScrollPane3.setViewportView(jScrollPane2);

        txtPanCode.setBackground(new java.awt.Color(0, 130, 130));
        txtPanCode.setColumns(5);
        txtPanCode.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        txtPanCode.setForeground(new java.awt.Color(255, 255, 255));
        txtPanCode.setRows(5);
        txtPanCode.setTabSize(3);
        txtPanCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPanCodeKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtPanCode);

        jScrollPane4.setViewportView(jScrollPane1);

        btnOpen.setBackground(new java.awt.Color(0, 102, 102));
        btnOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sharp_folder_open_white_18dp 18x18.png"))); // NOI18N
        btnOpen.setToolTipText("OPEN");
        btnOpen.setBorderPainted(false);
        btnOpen.setContentAreaFilled(false);
        btnOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOpen.setOpaque(true);
        btnOpen.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sharp_folder_open_white_18dp 36x36.png"))); // NOI18N
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(0, 102, 102));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sharp_save_white_18dp 18x18.png"))); // NOI18N
        btnSave.setToolTipText("SAVE");
        btnSave.setBorderPainted(false);
        btnSave.setContentAreaFilled(false);
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sharp_save_white_18dp 36x36.png"))); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnRun.setBackground(new java.awt.Color(0, 102, 102));
        btnRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sharp_play_arrow_white_18dp 18x18.png"))); // NOI18N
        btnRun.setToolTipText("RUN");
        btnRun.setBorderPainted(false);
        btnRun.setContentAreaFilled(false);
        btnRun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRun.setOpaque(true);
        btnRun.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sharp_play_arrow_white_18dp 18x18.png"))); // NOI18N
        btnRun.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sharp_play_arrow_white_18dp 36x36.png"))); // NOI18N
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });

        btnAbout.setBackground(new java.awt.Color(0, 102, 102));
        btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sharp_help_white_18dp 18x18.png"))); // NOI18N
        btnAbout.setToolTipText("ACERCA DE");
        btnAbout.setBorderPainted(false);
        btnAbout.setContentAreaFilled(false);
        btnAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAbout.setOpaque(true);
        btnAbout.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sharp_help_white_18dp 18x18.png"))); // NOI18N
        btnAbout.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sharp_help_white_18dp 36x36.png"))); // NOI18N
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        btnTableofSimbols.setBackground(new java.awt.Color(0, 102, 102));
        btnTableofSimbols.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/outline_table_chart_white_18dp 18x18.png"))); // NOI18N
        btnTableofSimbols.setToolTipText("TABLA DE SIMBOLOS");
        btnTableofSimbols.setContentAreaFilled(false);
        btnTableofSimbols.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTableofSimbols.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/outline_table_chart_white_18dp 18x18.png"))); // NOI18N
        btnTableofSimbols.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/outline_table_chart_white_18dp 36x36.png"))); // NOI18N
        btnTableofSimbols.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTableofSimbolsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRun, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 829, Short.MAX_VALUE)
                        .addComponent(btnTableofSimbols, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAbout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTableofSimbols, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        Compile();
    }//GEN-LAST:event_btnRunActionPerformed

    private void txtPanCodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPanCodeKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_F6) {
            Compile();
        }
        setBoleans(false, false, false);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_txtPanCodeKeyReleased

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        NewFile();
        txtPanCode.requestFocus();
        ClearOutput();
        ClearInput();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        res = func.LeerFichero();
        if (res == 200) {
            setBoleans(false, true, true);
        }
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        SaveCurrentCode();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        about.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAboutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (!this.guardado) {
            int opcion = JOptionPane.showConfirmDialog(null, "No se guardaran los cambios hechos, ¿Deseas guardar?\n"
                    + "Perderas todo tu trabajo... y puede que sea mucho");
            switch (opcion) {
                case JOptionPane.YES_OPTION:
                    SaveCurrentCode();
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
                case JOptionPane.NO_OPTION:
                    System.exit(0);
                default:
                    break;
            }
        } else {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnTableofSimbolsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTableofSimbolsActionPerformed
        simbols.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTableofSimbolsActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnRun;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTableofSimbols;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTextArea txtPanCode;
    private javax.swing.JTextPane txtPanResul;
    // End of variables declaration//GEN-END:variables
}
