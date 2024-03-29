
import java.util.ArrayList;
import java.util.ListIterator;
//import testmysql.LoanPortfolio;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ModifyLoanerInfoWindow.java
 *
 * Created on Jan 11, 2010, 8:47:06 PM
 */

/**
 *
 * @author nikos
 */
public class ModifyLoanerInfoWindow extends javax.swing.JFrame {
    String strings [] = new String[1000];
    private LoanManagerController c = new LoanManagerController();

    private void fillMLoanerList(){
        int i=1, j=0;
        int flag = 0;
        String TmpTxt = null;

        ArrayList<String> QueryResult = new ArrayList<String>();
        String sql = "SELECT * FROM Loaner";
        QueryResult =c.doViewArchive("Loaner",null,true);
        
        ListIterator<String> litr = QueryResult.listIterator();

        while (litr.hasNext()) {
           String element = litr.next();
           if (flag == 1) {
                   i = 1;
                   TmpTxt = null;
                   flag = 0;
           }
           if (i <= 4) {
                   if (TmpTxt != null){
                           TmpTxt = TmpTxt + "  " + element;
           }
                   else
                           TmpTxt = element;
                   i++;
           }
           if (i == 5) {
                   strings[j] = TmpTxt;
                   flag = 1;
           }
           j++;
        }
    }

    /** Creates new form ModifyLoanerInfoWindow */
    public ModifyLoanerInfoWindow() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jModifyLoanerContactTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jModifyLoanerList = new javax.swing.JList();
        jModifyLoanerPhoneTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jModifyLoanerApplyButton = new javax.swing.JButton();
        jModifyLoanerCancelButton = new javax.swing.JButton();
        jModifyLoanerContactTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jModifyLoanerPhoneTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Loaner Informations Window");

        jModifyLoanerContactTextField.setToolTipText("Modify Loaner Contact");
		
		fillMLoanerList();

        jModifyLoanerList.setModel(new javax.swing.AbstractListModel() {
            //String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jModifyLoanerList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jModifyLoanerListMouseClicked(evt);
            }
        });
        jModifyLoanerList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jModifyLoanerListFocusGained(evt);
            }
        });
        jScrollPane2.setViewportView(jModifyLoanerList);

        jLabel1.setText("Contact:");

        jLabel2.setText("Phone:");

        jModifyLoanerApplyButton.setText("Apply");
        jModifyLoanerApplyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jModifyLoanerApplyButtonMouseClicked(evt);
            }
        });

        jModifyLoanerCancelButton.setText("Cancel");
        jModifyLoanerCancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jModifyLoanerCancelButtonMouseClicked(evt);
            }
        });

        jModifyLoanerContactTextField1.setEditable(false);
        jModifyLoanerContactTextField1.setToolTipText("Modify Loaner Contact");

        jLabel3.setText("Name:");

        jLabel4.setText("ID:");

        jModifyLoanerPhoneTextField1.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jModifyLoanerCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jModifyLoanerApplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4))
                            .addComponent(jLabel3))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jModifyLoanerContactTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                            .addComponent(jModifyLoanerPhoneTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jModifyLoanerPhoneTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jModifyLoanerContactTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jModifyLoanerContactTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jModifyLoanerPhoneTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jModifyLoanerContactTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jModifyLoanerPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jModifyLoanerApplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jModifyLoanerCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
	java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void jModifyLoanerListFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jModifyLoanerListFocusGained
        // TODO add your handling code here:
        
}//GEN-LAST:event_jModifyLoanerListFocusGained


    private boolean Check_If_Arg_Is_Sring(String str)
       {

        //It can't contain only numbers if it's null or empty...
        if (str == null || str.length() == 0)
            return false;

        for (int i = 0; i < str.length(); i++) {

            //If we find a non-digit character we return false.
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }

        return true;
    }

    private void jModifyLoanerApplyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jModifyLoanerApplyButtonMouseClicked
        // TODO add your handling code here:
        //ki allh douleia edw
        String contact = jModifyLoanerContactTextField.getText();
        String phone = jModifyLoanerPhoneTextField.getText();
        int id;
        String tmp[];
        ExceptionWindow d;

        

        if(jModifyLoanerList.getSelectedIndex()==-1)
        {
            /*8a petaksei kai window*/
            d=new ExceptionWindow("No Loaner selected");
            d.setVisible(true);
            return;
        }
        String ListValue = jModifyLoanerList.getSelectedValue().toString();
        System.out.println(ListValue);
        tmp = ListValue.split(" ");
        id = Integer.parseInt(tmp[0]);

        

       
       if(contact.equals("")){
            d=new ExceptionWindow("Empty contact input");
            d.setVisible(true);
            return;
        }
        else if(phone.equals("")){
            d=new ExceptionWindow("Empty Phone input");
            d.setVisible(true);
            return;
        }
        else if(!Check_If_Arg_Is_Sring(phone)){
            d=new ExceptionWindow("Phone must contain only digits");
            d.setVisible(true);
            return;
        }
        else if(!contact.equals("") && !phone.equals("")){
            c.doModifyLoanerInfo(id, contact, phone);
        }
        fillMLoanerList();
        jModifyLoanerList.repaint();
        
}//GEN-LAST:event_jModifyLoanerApplyButtonMouseClicked

    private void jModifyLoanerCancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jModifyLoanerCancelButtonMouseClicked
        //this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jModifyLoanerCancelButtonMouseClicked

    private void jModifyLoanerListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jModifyLoanerListMouseClicked
        // TODO add your handling code here:
        String ListValue = jModifyLoanerList.getSelectedValue().toString();
        System.out.println(ListValue);
        String tmp[]=ListValue.split(" ");
        jModifyLoanerPhoneTextField1.setText(tmp[0]);
        jModifyLoanerContactTextField.setText("");
        if (!tmp[3].equals(" "))
            jModifyLoanerContactTextField1.setText(tmp[2]+" "+tmp[3]);
        else
            jModifyLoanerContactTextField1.setText(tmp[2]);
        System.out.println("tmp[0]:"+ tmp[0]+" tmp[1]:"+tmp[1]+" tmp[2]:"+tmp[2]+" tmp[3]:"+tmp[3]+" tmp[4]:"+tmp[4]);
             

    }//GEN-LAST:event_jModifyLoanerListMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyLoanerInfoWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jModifyLoanerApplyButton;
    private javax.swing.JButton jModifyLoanerCancelButton;
    private javax.swing.JTextField jModifyLoanerContactTextField;
    private javax.swing.JTextField jModifyLoanerContactTextField1;
    private javax.swing.JList jModifyLoanerList;
    private javax.swing.JTextField jModifyLoanerPhoneTextField;
    private javax.swing.JTextField jModifyLoanerPhoneTextField1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
