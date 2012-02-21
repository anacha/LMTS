package view;

import LoanManagerController;

import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.table.DefaultTableModel;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SortWindow.java
 *
 * Created on Jan 11, 2010, 8:48:26 PM
 */

/**
 * @author   nikos
 */
@SuppressWarnings("serial")
public class SortWindow extends javax.swing.JFrame {

    /**
	 * @uml.property  name="c"
	 * @uml.associationEnd  
	 */
    private LoanManagerController c = new LoanManagerController();
    /** Creates new form SortWindow */
    public SortWindow() {
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

        jScrollPane4 = new javax.swing.JScrollPane();
        jSortCriteriaList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jSortDescendingCheckBox = new javax.swing.JCheckBox();
        jSortApplyButton = new javax.swing.JButton();
        jSortCancelButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jSortTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sort Window");

        jSortCriteriaList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Amount", "Rate", "Date", "Borrower", "Loaner", "Loan Type" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jSortCriteriaList);

        jLabel3.setText("Sort by:");

        jSortDescendingCheckBox.setText("Descending (default:ascending)");

        jSortApplyButton.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jSortApplyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/accept.png"))); // NOI18N
        jSortApplyButton.setText("Apply");
        jSortApplyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSortApplyButtonMouseClicked(evt);
            }
        });

        jSortCancelButton1.setFont(new java.awt.Font("DejaVu Sans", 0, 11)); // NOI18N
        jSortCancelButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancel.png"))); // NOI18N
        jSortCancelButton1.setText("Cancel");
        jSortCancelButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSortCancelButton1MouseClicked(evt);
            }
        });

        jSortTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Amount", "Rate", "Repayment Date", "Borrower", "Loaner", "Loan Type"
            }
        ) {
            @SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            @SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jSortTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jSortDescendingCheckBox)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSortCancelButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jSortApplyButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                        .addGap(35, 35, 35)
                        .addComponent(jSortDescendingCheckBox)
                        .addGap(183, 183, 183)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSortCancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSortApplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		java.awt.Dimension dialogSize = getSize();
		setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    public void Add_Row(int RowsAlloc) {

        DefaultTableModel model = new DefaultTableModel(new Object [][] {
                {null, null, null, null, null, null},{null, null, null, null, null, null}},
            new String [] {"Amount", "Rate", "Repayment Date", "Borrower", "Loaner", "Loan Type"})
                {
                    @SuppressWarnings("rawtypes")
					Class[] types = new Class [] {
                        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false, true, true
                    };

                    @SuppressWarnings({ "rawtypes", "unchecked" })
					@Override
                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    }

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                       return canEdit [columnIndex];
                    }
                };
        jSortTable.setModel(model);
        for (int k = 0; k < RowsAlloc; k++)
            model.addRow(new Object[][]{null,null,null});
       }
    
 
    private void jSortApplyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSortApplyButtonMouseClicked
        // TODO add your handling code here:
        ArrayList<String> QueryResult = new ArrayList<String>();
        String sort_choice= (String) jSortCriteriaList.getSelectedValue();
        @SuppressWarnings("unused")
		String asc = null,TmpTxt = null;
       
        @SuppressWarnings("unused")
		int mode=1,flag = 0,i = 1,j=0;

        if(jSortCriteriaList.getSelectedValue()==null)
        {
            /*8a petaksei kai window*/
            System.out.print("Exception handler");
            ExceptionWindow d=new ExceptionWindow("NO sort criteria selected!");
            d.setVisible(true);
            return;
        }



        if(jSortDescendingCheckBox.isSelected()==true)
                mode=2;

        if(sort_choice.equals("Borrower"))
            sort_choice = "b_name";
        if(sort_choice.equals("Loaner"))
            sort_choice = "l_name";
        if(sort_choice.equals("Loan Type"))
            sort_choice = "l_type";
        if(sort_choice.equals("Date"))
            sort_choice = "l_date";
        
        QueryResult = c.doSort(sort_choice,mode);
        ListIterator<String> litr = QueryResult.listIterator();

        int RowsAlloc = QueryResult.size()/6 - 2;
         if (QueryResult.size()/6 > 30) {
             Add_Row(RowsAlloc);
         }

        for(j=0; j < QueryResult.size()/6 ; j++)
        {            
            for(i=0;i<6;i++)
            {
                String element = litr.next();
                jSortTable.setValueAt((String)element, j,i);
            }
        }          

}//GEN-LAST:event_jSortApplyButtonMouseClicked

    private void jSortCancelButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSortCancelButton1MouseClicked
       this.setVisible(false);
}//GEN-LAST:event_jSortCancelButton1MouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SortWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jSortApplyButton;
    private javax.swing.JButton jSortCancelButton1;
    private javax.swing.JList jSortCriteriaList;
    private javax.swing.JCheckBox jSortDescendingCheckBox;
    private javax.swing.JTable jSortTable;
    // End of variables declaration//GEN-END:variables

}
