package sk.upjs.ics.todo;

import java.util.Date;
import java.util.List;

public class MainForm extends javax.swing.JFrame {
    
    private PamatovyUlohaDao pamatovyUlohaDao = new PamatovyUlohaDao();

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        List<Uloha> ulohy = pamatovyUlohaDao.dajVsetky();        
        ulohyList.setListData(ulohy.toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ulohyList = new javax.swing.JList();
        ulohaTextField = new javax.swing.JTextField();
        pridatButton = new javax.swing.JButton();
        vybratDatumButton = new javax.swing.JButton();
        terminLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ulohyList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ulohyList);

        pridatButton.setText("Pridať");
        pridatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatButtonActionPerformed(evt);
            }
        });

        vybratDatumButton.setText("Nastavit Datum");
        vybratDatumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vybratDatumButtonActionPerformed(evt);
            }
        });

        terminLabel.setText("(ziaden termin)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ulohaTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(terminLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vybratDatumButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pridatButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ulohaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pridatButton)
                    .addComponent(vybratDatumButton)
                    .addComponent(terminLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pridatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatButtonActionPerformed
        Uloha uloha = new Uloha();
        uloha.setNazov(ulohaTextField.getText());
        uloha.setDate(new Date());
        
        pamatovyUlohaDao.pridat(uloha);
        
        List<Uloha> ulohy = pamatovyUlohaDao.dajVsetky();
        ulohyList.setListData(ulohy.toArray());
    }//GEN-LAST:event_pridatButtonActionPerformed

    private void vybratDatumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vybratDatumButtonActionPerformed
        VyberTerminuDialog dialog = new VyberTerminuDialog(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_vybratDatumButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pridatButton;
    private javax.swing.JLabel terminLabel;
    private javax.swing.JTextField ulohaTextField;
    private javax.swing.JList ulohyList;
    private javax.swing.JButton vybratDatumButton;
    // End of variables declaration//GEN-END:variables
}
