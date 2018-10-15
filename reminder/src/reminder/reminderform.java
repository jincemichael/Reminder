/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reminder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Driver;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author jince michael
 */
public class reminderform extends javax.swing.JFrame {

    /**
     * Creates new form reminderform
     */
    public reminderform() {
        initComponents();
        jtable(REMINDER);
    }
    private static final int REMINDER = 0x11;
    private static final int TODAY = 0x12;
    private static final int OVERDUE = 0x13;
    private static final int COMPLETED = 0x14;
    private static final int PRIORITY = 0x15;
    long millis = System.currentTimeMillis();
    java.sql.Date date = new java.sql.Date(millis);

    private String fetchQuery(int opt) {
        switch (opt) {
            case REMINDER:
                return "select * from reminders_table";
            case TODAY:
                return "select * from reminders_table where date=date";
            case OVERDUE:
                return "SELECT * FROM `reminders_table` WHERE time < CURRENT_TIME AND date < CURRENT_DATE AND completed=0";
            case COMPLETED:
                return "select * from reminders_table where completed='1'";

            case PRIORITY:
                return "select * from reminders_table where priority='1'";
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelwelcome = new javax.swing.JLabel();
        addbutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        viewbutton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstsort = new javax.swing.JList<>();
        calender = new com.toedter.calendar.JCalendar();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        labelwelcome.setForeground(new java.awt.Color(255, 0, 0));
        labelwelcome.setText("Welcome to Reminders!!!!");

        addbutton.setText("New ");
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });

        updatebutton.setText("update");
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });

        viewbutton.setText("Delete");
        viewbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewbuttonActionPerformed(evt);
            }
        });

        lstsort.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Reminders", "Today", "Overdue", "Completed ", "Priority" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstsort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstsortMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstsort);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Date", "Time ", "Priority", "Completed"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(calender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addbutton)
                        .addGap(30, 30, 30)
                        .addComponent(updatebutton)
                        .addGap(18, 18, 18)
                        .addComponent(viewbutton))
                    .addComponent(labelwelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addbutton)
                            .addComponent(updatebutton)
                            .addComponent(viewbutton))
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelwelcome)))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void jtable(int opt) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reminder", "root", "root");
            String sql = fetchQuery(opt);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                String name = rs.getString("name");
                String date = rs.getString("date");
                String time = rs.getString("time");
                Boolean priority = rs.getBoolean("priority");
                Boolean completed = rs.getBoolean("completed");
                String priotiyStr = priority ? "Yes" : "No", completedStr = completed ? "Yes" : "No";
                model.addRow(new Object[]{name, date, time, priotiyStr, completedStr});
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

//    private void UpdateTable() throws ClassNotFoundException, SQLException {
//        String sql = "select * from reminders_table";
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn;
//        conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reminder", "root", "root");
//        PreparedStatement pst = conn.prepareStatement(sql);
//        ResultSet rs = pst.executeQuery();
//        try {
//            DbUtils.table.setModel(DbUtils.resultSetToTableModel(rs));
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//
//        } finally {
//            try {
//                rs.close();
//                pst.close();
//            } catch (Exception e) {
//            }
//        }
//    }
    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
        // TODO add your handling code here:
        //create object
        newreminder newr = new newreminder();
        newr.setVisible(true);
        dispose();
    }//GEN-LAST:event_addbuttonActionPerformed

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
        // TODO add your handling code here:
        //create object
        reminderupdate rupdate = new reminderupdate();
        rupdate.setVisible(true);
        dispose();
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void lstsortMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstsortMouseClicked
        // TODO add your handling code here:
//        System.out.println(String.valueOf());

        switch (lstsort.getSelectedIndex()) {
            case 0:
                jtable(REMINDER);
                break;
            case 1:
                jtable(TODAY);
                break;
            case 2:
                jtable(OVERDUE);
                break;
            case 3:
                jtable(COMPLETED);
                break;
            case 4:
                jtable(PRIORITY);
                break;
        }

    }//GEN-LAST:event_lstsortMouseClicked

    private void viewbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewbuttonActionPerformed
        // TODO add your handling code here:
        int row = table.getSelectedRow();
        String cell = table.getModel().getValueAt(row, 0).toString();
        String sql = "delete from reminders_table where name=?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reminder", "root", "root");
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cell);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
            jtable(REMINDER);

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_viewbuttonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            runReminderService();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
          try {
            runReminderService();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formWindowActivated

        private  ArrayList arryList = new ArrayList<>();
    

    private  void runReminderService() throws ClassNotFoundException, SQLException, ParseException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn;
        conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/reminder", "root", "root");
        String sql = "SELECT * FROM `reminders_table` WHERE time > CURRENT_TIME AND date = CURRENT_DATE AND completed=0";
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String i = rs.getString("time");
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            java.util.Date date = (java.util.Date) sdf.parse(i);
//            System.out.println(date.toString());
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
//            System.out.println(cal.get(Calendar.HOUR_OF_DAY));
            Schedul s = new Schedul(cal);
          //  arryList.add(s);
            s.start();
        }

    }
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
            java.util.logging.Logger.getLogger(reminderform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reminderform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reminderform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reminderform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reminderform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbutton;
    private com.toedter.calendar.JCalendar calender;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelwelcome;
    private javax.swing.JList<String> lstsort;
    private javax.swing.JTable table;
    private javax.swing.JButton updatebutton;
    private javax.swing.JButton viewbutton;
    // End of variables declaration//GEN-END:variables
}