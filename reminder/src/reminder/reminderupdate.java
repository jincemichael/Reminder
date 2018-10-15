/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Driver;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author jince michael
 */
public class reminderupdate extends javax.swing.JFrame {

    /**
     * Creates new form reminderupdate
     */
    public reminderupdate() {
        initComponents();
        fillcombo();
        datepicker.setDateFormatString("dd_MMM_yyyy");
        
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
        checkboxcompleted = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareanotes = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        datepicker = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        checkboxpriority = new javax.swing.JCheckBox();
        okbtn = new javax.swing.JButton();
        timepicker = new lu.tudor.santec.jtimechooser.JTimeChooser();
        comboname = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        checkboxcompleted.setText("completed");

        txtareanotes.setColumns(20);
        txtareanotes.setRows(5);
        jScrollPane1.setViewportView(txtareanotes);

        jLabel2.setText("Notes (upto 200 characters)");

        jLabel4.setText("Date");

        jLabel3.setText("Time");

        checkboxpriority.setText("Priority");
        checkboxpriority.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxpriorityActionPerformed(evt);
            }
        });

        okbtn.setText("Ok");
        okbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okbtnActionPerformed(evt);
            }
        });

        comboname.setName(""); // NOI18N
        comboname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combonameActionPerformed(evt);
            }
        });

        jLabel1.setText("Reminder Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(timepicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(checkboxcompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(143, 143, 143)
                                .addComponent(okbtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datepicker, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(comboname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(checkboxpriority, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxpriority)
                    .addComponent(comboname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datepicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(timepicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxcompleted)
                    .addComponent(okbtn))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkboxpriorityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxpriorityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxpriorityActionPerformed
private void fillcombo(){
try{
Class.forName("com.mysql.jdbc.Driver");
Connection conn;
conn = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/reminder","root","root");    
String sql="select * from reminders_table";
PreparedStatement pst=conn.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();

while(rs.next()){
    String name=rs.getString("name");
    
    comboname.addItem(name);
}
while(rs.next()){
String notes=rs.getString("notes");

        //setText(notes);
}
}
catch(Exception e){
JOptionPane.showMessageDialog(null, e);}}
    
    private void combonameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combonameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combonameActionPerformed

    private void okbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okbtnActionPerformed
        // TODO add your handling code here:
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = (com.mysql.jdbc.Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/reminder","root","root");
            String sql="update reminders_table set notes=?,date=?,time=?,priority=?,completed=? where name=? and date=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
           // int result=pstmt.executeUpdate();
           /** <<----  refer
            update reminders_table set notes='dfdfdfdf',date='lkkkkkkkkk',time='2018-10-02',
                        priority='00:00:00',completed=0 where name=0 and date=**
             **/
            String combovalue = (String)comboname.getSelectedItem();
            String combovaluestr = comboname.getSelectedItem().toString();
            
            pstmt.setString(1,txtareanotes.getText());
            
            
            System.out.println(datepicker.getDate().toString());
            java.sql.Date da=new Date( datepicker.getCalendar().getTimeInMillis());
           /// System.out.println(da.toString());
            
            pstmt.setDate(2, da);
            //String ampm;
//           // ampm=" AM";
//            if(rdbtnam.isSelected()){
//            ampm=rdbtnam.getText();
//                    }
//            if(rdbtnpm.isSelected()){
//                ampm=rdbtnpm.getText();
//            }
            String time;
            time=timepicker.getFormatedTime();
            String timeampm;
            timeampm=time;
//                    .concat(ampm);
                    pstmt.setString(3,timeampm);
            boolean isSelected = checkboxpriority.isSelected();

if(isSelected ){
  checkboxpriority.setSelected(false);
} else {
   checkboxpriority.setSelected(true);
}

  pstmt.setBoolean(4, isSelected);
if(isSelected ){
  checkboxpriority.setSelected(false);
} else {
   checkboxpriority.setSelected(true);
}
  pstmt.setBoolean(5,isSelected);
  pstmt.setString(6, comboname.getItemAt(comboname.getSelectedIndex()));
pstmt.setDate(7,da);
              //pstmt.executeQuery();
              System.out.println(pstmt);
              int k=pstmt.executeUpdate();
            
//            System.out.println(String.valueOf(k));


             JOptionPane.showMessageDialog(null, "updation successful");
  conn.close();
            
            
        }catch(Exception e){
          //  JOptionPane.showMessageDialog(null,"Please enter valid values");
          e.printStackTrace();
        
    }//GEN-LAST:event_okbtnActionPerformed
    reminderform r=new reminderform();
    r.setVisible(true);
    dispose();
            }        /**
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
            java.util.logging.Logger.getLogger(reminderupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reminderupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reminderupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reminderupdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reminderupdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkboxcompleted;
    private javax.swing.JCheckBox checkboxpriority;
    private javax.swing.JComboBox<String> comboname;
    private com.toedter.calendar.JDateChooser datepicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okbtn;
    private lu.tudor.santec.jtimechooser.JTimeChooser timepicker;
    private javax.swing.JTextArea txtareanotes;
    // End of variables declaration//GEN-END:variables
}