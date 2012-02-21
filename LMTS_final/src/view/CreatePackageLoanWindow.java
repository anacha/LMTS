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
 * CreatePackageLoanWindow.java
 *
 * Created on Jan 11, 2010, 8:57:08 PM
 */

/**
 *
 * @author nikos
 */
@SuppressWarnings("serial")
public class CreatePackageLoanWindow extends javax.swing.JFrame {
    private int k=0;
    private int flag = 1;


    private void LoadLoanList(){
        int j,i;
        ArrayList<String> QueryResult = new ArrayList<String>();

        LoanManagerController c = new LoanManagerController();
        QueryResult = c.packageLoadLoanList();
        ListIterator<String> litr = QueryResult.listIterator();

         int RowsAlloc = QueryResult.size()/11 - 2;
         if (QueryResult.size()/11 > 30) {
             Add_Row(RowsAlloc, 1);
         }

        for(j=0; j < QueryResult.size()/11 ; j++){
            for(i=0;i<11;i++){
                String element = litr.next();
                jLoanListTable1.setValueAt((String)element, j,i);
            }
        }
    }


     public void Add_Row(int RowsAlloc, int table_num) {
         if (table_num == 1) {
              DefaultTableModel model = new DefaultTableModel(new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Loan ID", "Amount", "Rate", "Rate Type", "Date", "Period", "Loan Type", "Sale Value", "Situation", "Risk", "Mortgage Prop."
            }){
                @SuppressWarnings("rawtypes")
				Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false, false, false, false
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
            jLoanListTable1.setModel(model);
            for (int k = 0; k < RowsAlloc; k++)
               model.addRow(new Object[][]{null, null, null, null, null, null, null, null, null, null, null});
         }
         else if (table_num == 2) {
            DefaultTableModel model = new DefaultTableModel(
                new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}},
                new String [] {"Loan ID", "Amount", "Rate", "Rate Type", "Date", "Period", "Loan Type", "Sale Value", "Situation", "Risk", "Mortgage Prop."
                }){
                    @SuppressWarnings("rawtypes")
					Class[] types = new Class [] {
                        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false, false, false, false, false, false, false, false
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
                jPackageLoanListTable2.setModel(model);
                for (int k = 0; k < RowsAlloc; k++)
                    model.addRow(new Object[][]{null, null, null, null, null, null, null, null, null, null, null});
            }
    }



    private void Clean_Table(javax.swing.JTable a){
      int i ,j;
      for(j=0;j<a.getColumnCount();j++)
      {
          for(i=0;i<a.getRowCount();i++)
          {
                 a.setValueAt((String)"",i,j);
          }
      }
    }




    /** Creates new form CreatePackageLoanWindow */
    public CreatePackageLoanWindow() {
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

        jSeparator3 = new javax.swing.JSeparator();
        jLoanerLabel1 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLoanerLabel2 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jCreatePackageRiskTextField = new javax.swing.JTextField();
        jCreatePackageProfitTextField = new javax.swing.JTextField();
        jCreatePackageRepaymentTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jCreatePackageOptimitazionButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLoanerLabel3 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jCreatePackageLoanSearchButton = new javax.swing.JButton();
        jCreatePackageRangeFromTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLoanerLabel4 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jCreatePackageLoanCancelButton = new javax.swing.JButton();
        jCreatePackageLoanSellButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jCreatePackageLoanClearButton = new javax.swing.JButton();
        jCreatePackageLoanFeatureComboBox = new javax.swing.JComboBox();
        jCreatePackageRangeToTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLoanListTable1 = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPackageLoanListTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jValueTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Package Loan Window");

        jLoanerLabel1.setText("Investment Request Criteria");
        jLoanerLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLoanerLabel1.setIconTextGap(10);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLoanerLabel2.setText("Loan List");
        jLoanerLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLoanerLabel2.setIconTextGap(10);

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel13.setText("Risk:");

        jLabel14.setText("Min Profit:");

        jLabel15.setText("Date:");

        jCreatePackageOptimitazionButton1.setFont(new java.awt.Font("DejaVu Sans", 0, 11));
        jCreatePackageOptimitazionButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/applications.png"))); // NOI18N
        jCreatePackageOptimitazionButton1.setText("Optimization");
        jCreatePackageOptimitazionButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jCreatePackageOptimitazionButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCreatePackageOptimitazionButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCreatePackageOptimitazionButton1MouseClicked(evt);
            }
        });

        jLoanerLabel3.setText("Loan Features");
        jLoanerLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLoanerLabel3.setIconTextGap(10);

        jCreatePackageLoanSearchButton.setFont(new java.awt.Font("DejaVu Sans", 0, 11));
        jCreatePackageLoanSearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/box_open.png"))); // NOI18N
        jCreatePackageLoanSearchButton.setText("Search");
        jCreatePackageLoanSearchButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jCreatePackageLoanSearchButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCreatePackageLoanSearchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCreatePackageLoanSearchButtonMouseClicked(evt);
            }
        });

        jLabel16.setText("Feature:");

        jLabel17.setText("From:");

        jLoanerLabel4.setText("Package Loan List");
        jLoanerLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLoanerLabel4.setIconTextGap(10);

        jCreatePackageLoanCancelButton.setFont(new java.awt.Font("DejaVu Sans", 0, 11));
        jCreatePackageLoanCancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancel.png"))); // NOI18N
        jCreatePackageLoanCancelButton.setText("Cancel");
        jCreatePackageLoanCancelButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jCreatePackageLoanCancelButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCreatePackageLoanCancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCreatePackageLoanCancelButtonMouseClicked(evt);
            }
        });

        jCreatePackageLoanSellButton.setFont(new java.awt.Font("DejaVu Sans", 0, 11));
        jCreatePackageLoanSellButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/finance.png"))); // NOI18N
        jCreatePackageLoanSellButton.setText("Sell");
        jCreatePackageLoanSellButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jCreatePackageLoanSellButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCreatePackageLoanSellButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCreatePackageLoanSellButtonMouseClicked(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jCreatePackageLoanClearButton.setFont(new java.awt.Font("DejaVu Sans", 0, 11));
        jCreatePackageLoanClearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/undo.png"))); // NOI18N
        jCreatePackageLoanClearButton.setText("Clear");
        jCreatePackageLoanClearButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jCreatePackageLoanClearButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCreatePackageLoanClearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCreatePackageLoanClearButtonMouseClicked(evt);
            }
        });
        jCreatePackageLoanClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreatePackageLoanClearButtonActionPerformed(evt);
            }
        });

        jCreatePackageLoanFeatureComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Amount", "Rate", "Rate Type", "Risk", "Morgage Property", "Loaner ID", "Loan ID", "Borrower ID", "Loan Type", "Date", "Period", "Sale Value", "Situation" }));
        jCreatePackageLoanFeatureComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreatePackageLoanFeatureComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("To:");

        jLoanListTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Loan ID", "Amount", "Rate", "Rate Type", "Date", "Period", "Loan Type", "Sale Value", "Situation", "Risk", "Mortgage Prop."
            }
        ) {
            @SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            @SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jLoanListTable1.getTableHeader().setReorderingAllowed(false);
        jLoanListTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLoanListTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jLoanListTable1);
        jLoanListTable1.getColumnModel().getColumn(0).setResizable(false);
        jLoanListTable1.getColumnModel().getColumn(1).setResizable(false);
        jLoanListTable1.getColumnModel().getColumn(2).setResizable(false);
        jLoanListTable1.getColumnModel().getColumn(3).setResizable(false);
        jLoanListTable1.getColumnModel().getColumn(4).setResizable(false);
        jLoanListTable1.getColumnModel().getColumn(5).setResizable(false);
        jLoanListTable1.getColumnModel().getColumn(6).setResizable(false);
        jLoanListTable1.getColumnModel().getColumn(7).setResizable(false);
        jLoanListTable1.getColumnModel().getColumn(8).setResizable(false);
        jLoanListTable1.getColumnModel().getColumn(9).setResizable(false);
        jLoanListTable1.getColumnModel().getColumn(10).setResizable(false);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPackageLoanListTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Loan ID", "Amount", "Rate", "Rate Type", "Date", "Period", "Loan Type", "Sale Value", "Situation", "Risk", "Mortgage Prop."
            }
        ) {
            @SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            @SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jPackageLoanListTable2.getTableHeader().setReorderingAllowed(false);
        jPackageLoanListTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPackageLoanListTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jPackageLoanListTable2);
        jPackageLoanListTable2.getColumnModel().getColumn(0).setResizable(false);
        jPackageLoanListTable2.getColumnModel().getColumn(1).setResizable(false);
        jPackageLoanListTable2.getColumnModel().getColumn(2).setResizable(false);
        jPackageLoanListTable2.getColumnModel().getColumn(3).setResizable(false);
        jPackageLoanListTable2.getColumnModel().getColumn(4).setResizable(false);
        jPackageLoanListTable2.getColumnModel().getColumn(5).setResizable(false);
        jPackageLoanListTable2.getColumnModel().getColumn(6).setResizable(false);
        jPackageLoanListTable2.getColumnModel().getColumn(7).setResizable(false);
        jPackageLoanListTable2.getColumnModel().getColumn(8).setResizable(false);
        jPackageLoanListTable2.getColumnModel().getColumn(9).setResizable(false);
        jPackageLoanListTable2.getColumnModel().getColumn(10).setResizable(false);

        jLabel2.setText("Value:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLoanerLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator6, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCreatePackageRepaymentTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jCreatePackageProfitTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jCreatePackageRiskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(200, 200, 200)
                        .addComponent(jCreatePackageOptimitazionButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLoanerLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCreatePackageLoanFeatureComboBox, 0, 267, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jValueTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jCreatePackageRangeFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jCreatePackageRangeToTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(99, 99, 99)
                        .addComponent(jCreatePackageLoanSearchButton)
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLoanerLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(421, 421, 421))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLoanerLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jCreatePackageLoanCancelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                                .addComponent(jCreatePackageLoanClearButton)
                                .addGap(18, 18, 18)
                                .addComponent(jCreatePackageLoanSellButton))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
                        .addGap(24, 24, 24))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCreatePackageLoanCancelButton, jCreatePackageLoanSearchButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCreatePackageProfitTextField, jCreatePackageRepaymentTextField, jCreatePackageRiskTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLoanerLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLoanerLabel4))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCreatePackageLoanCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCreatePackageLoanSellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCreatePackageLoanClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLoanerLabel1)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                    .addComponent(jLabel13)
                                    .addComponent(jCreatePackageRiskTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                    .addComponent(jLabel14)
                                    .addComponent(jCreatePackageProfitTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCreatePackageOptimitazionButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                    .addComponent(jLabel15)
                                    .addComponent(jCreatePackageRepaymentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLoanerLabel3)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                                    .addComponent(jCreatePackageLoanFeatureComboBox))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jCreatePackageRangeFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                                        .addComponent(jCreatePackageRangeToTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jValueTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jCreatePackageLoanSearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))))
                .addGap(42, 42, 42))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jCreatePackageLoanCancelButton, jCreatePackageLoanSearchButton});

        pack();
		LoadLoanList();
		jValueTextField1.setEditable(false);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		java.awt.Dimension dialogSize = getSize();
		setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents



    private void jCreatePackageOptimitazionButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreatePackageOptimitazionButton1MouseClicked

        // TODO add your handling code here:
        String minProfit = null, maxRisk = null, repPeriod = null;
        ArrayList<String> QueryResult = new ArrayList<String>();


        minProfit = jCreatePackageProfitTextField.getText();
        maxRisk = jCreatePackageRiskTextField.getText();
        repPeriod = jCreatePackageRepaymentTextField.getText();

       
        if(minProfit.equals("") || maxRisk.equals("") || repPeriod.equals("")){
            ExceptionWindow d = new ExceptionWindow("Insert optimization fields");
            d.setVisible(true);
            return;
        }
        if(Integer.parseInt(minProfit)<0 || Integer.parseInt(minProfit)>500 || Integer.parseInt(maxRisk)>100){
            ExceptionWindow d = new ExceptionWindow("Insert values: Profit 0~500 and Risk 0~100");
            d.setVisible(true);
            return;
        }
        else{
            LoanManagerController c = new LoanManagerController();
            if(k==0){
                String temp[]=null;
                QueryResult = c.doOptimization(minProfit, maxRisk, repPeriod,true,temp);
                ListIterator<String> litr = QueryResult.listIterator();

               int RowsAlloc = QueryResult.size()/11 - 2;
                if (QueryResult.size()/11 > 30) {
                    Add_Row(RowsAlloc, 2);
                }

                for(int i=0; i<QueryResult.size()/11; i++){
                    for(int j=0; j<11; j++){
                        String element = litr.next();
                        jPackageLoanListTable2.setValueAt((String)element, i, j);
                    }
                    k++;
                }
                String tmp [] = new String[QueryResult.size()/11];
                for(int i=0; i<QueryResult.size()/11; i++){
                    tmp[i] = (String)jPackageLoanListTable2.getValueAt(i, 0);
                    c.doPackageLoan(tmp[i],true);
                }
                Clean_Table(jLoanListTable1);
                LoadLoanList();
            }
            else if (k!=0){
                String tmpArr[] = new String[k];
                int j;
                for(j=0; j<k; j++){
                    tmpArr[j] = (String) jPackageLoanListTable2.getValueAt(j,0);
                }
                QueryResult = c.doOptimization(minProfit, maxRisk, repPeriod, false,tmpArr);

                ListIterator<String> litr = QueryResult.listIterator();

                for(int i=0; i<k; i++){
                    String s = (String)jPackageLoanListTable2.getValueAt(i, 0);
                    if(!s.equals(""))
                        c.doPackageLoan(s, false);
                    for(int m=0; m<11; m++)
                        jPackageLoanListTable2.setValueAt("",i,m);

                }
                k = 0;

                String temp [] = new String [QueryResult.size()/11];
                for(int i=0; i<QueryResult.size()/11; i++){
                    for(int l=0; l<11; l++){
                        String element = litr.next();
                        jPackageLoanListTable2.setValueAt((String)element, i, l);
                        temp[i] = (String)jPackageLoanListTable2.getValueAt(i, 0);
                        c.doPackageLoan(temp[i],true);
                    }
                    k++;
                }
                Clean_Table(jLoanListTable1);
                LoadLoanList();
            }
        }
}//GEN-LAST:event_jCreatePackageOptimitazionButton1MouseClicked

    private void jCreatePackageLoanSearchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreatePackageLoanSearchButtonMouseClicked
        // TODO add your handling code here:
        String from = jCreatePackageRangeFromTextField.getText();
        String to = jCreatePackageRangeToTextField1.getText();
        Object obj = jCreatePackageLoanFeatureComboBox.getSelectedItem();
        String cmbValue = obj.toString();

        String value0 = jValueTextField1.getText();
        String table = null;
        String column = null;

        if(cmbValue.equals("Risk")){
            cmbValue = "l_risk";
        }
        else if(cmbValue.equals("Rate Type")){
            cmbValue = "rate_type";
        }
        else if(cmbValue.equals("Morgage Property")){
            cmbValue = "mortgage_prop";
        }
        else if(cmbValue.equals("Loaner ID")){
            table = "l_provides_l";
            column = "p_loanID";
            cmbValue = "p_loanerID";
        }
        else if(cmbValue.equals("Loan ID")){
            cmbValue = "loanID";
        }
        else if(cmbValue.equals("Borrower ID")){
            table = "l_has_b";
            column = "h_loanID";
            cmbValue = "h_bID";
        }
        else if(cmbValue.equals("Loan Type")){
            cmbValue = "l_type";
        }
        else if(cmbValue.equals("Date")){
            cmbValue = "l_date";
            from = "'"+from+"'";
            to = "'"+to+"'";
        }
        else if(cmbValue.equals("Period")){
            cmbValue = "l_period";
        }
        else if(cmbValue.equals("Sale Value")){
            cmbValue = "sale_value";
        }
        else if(cmbValue.equals("Situation")){
            cmbValue = "situation";
        }


        String searchQ = null;
        if(flag == 1)
            searchQ = "Select loanID,amount,rate,rate_type,l_date,l_period,l_type,sale_value,situation,l_risk,mortgage_prop from Loan Where "+cmbValue+" Between "+from+" and "+to+" and preselected = false";
        else if(flag == 0)
            searchQ = "Select loanID,amount,rate,rate_type,l_date,l_period,l_type,sale_value,situation,l_risk,mortgage_prop from Loan Where "+cmbValue+" = '"+ value0+"' and preselected = false";
        else if(flag == -1)
            searchQ = "Select DISTINCT loanID,amount,rate,rate_type,l_date,l_period,l_type,sale_value,situation,l_risk,mortgage_prop from Loan,"+table+" Where loanID="+column+" and "+cmbValue+" Between "+from+" and "+to+" and preselected = false";

        LoanManagerController c = new LoanManagerController();
        ArrayList<String> qResult = new ArrayList<String>();
        
        if(!from.equals("") || !to.equals("") || !value0.equals("")){
            qResult = c.packageLoanAutoSearch(searchQ);
            ListIterator<String> litr = qResult.listIterator();

            k = qResult.size()/11;

            int RowsAlloc = qResult.size()/11 - 2;
                 if (qResult.size()/11 > 30) {
                 Add_Row(RowsAlloc, 2);
             }

            for(int i=0; i<qResult.size()/11; i++){
                for(int j=0; j<11; j++){
                    String element = litr.next();
                    jPackageLoanListTable2.setValueAt((String)element, i, j);
                }                
            }
            String tmp [] = new String[qResult.size()/11];
            for(int i=0; i<qResult.size()/11; i++){
                tmp[i] = (String)jPackageLoanListTable2.getValueAt(i, 0);
                c.doPackageLoan(tmp[i],true);
            }
            Clean_Table(jLoanListTable1);
            LoadLoanList();
        }
}//GEN-LAST:event_jCreatePackageLoanSearchButtonMouseClicked

    private void jCreatePackageLoanCancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreatePackageLoanCancelButtonMouseClicked
        //this.setVisible(false);
        if(k != 0){
            LoanManagerController c = new LoanManagerController();
            for(int i=0; i<k; i++){
                String s = (String)jPackageLoanListTable2.getValueAt(i, 0);
                if(!s.equals(""))
                    c.doPackageLoan(s, false);
                for(int j=0; j<11; j++)
                    jPackageLoanListTable2.setValueAt("",i,j);
            }
        }
        this.dispose();
    }//GEN-LAST:event_jCreatePackageLoanCancelButtonMouseClicked

    private void jCreatePackageLoanSellButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreatePackageLoanSellButtonMouseClicked
        // TODO add your handling code here:
        if(k!=0){
             LoanManagerController c = new LoanManagerController();
            String tempArr[] = new String[k];
            for(int i=0;i<k; i++)
                tempArr[i] = (String)jPackageLoanListTable2.getValueAt(i, 0);
            c.doAccept(tempArr);
        }

    }//GEN-LAST:event_jCreatePackageLoanSellButtonMouseClicked

    private void jCreatePackageLoanClearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCreatePackageLoanClearButtonMouseClicked
        // TODO add your handling code here:
        if(k != 0){
            LoanManagerController c = new LoanManagerController();
            for(int i=0; i<k; i++){
                String s = (String)jPackageLoanListTable2.getValueAt(i, 0);
                if(!s.equals(""))
                    c.doPackageLoan(s, false);
                for(int j=0; j<11; j++)
                    jPackageLoanListTable2.setValueAt("",i,j);
            }
            k = 0;
        }
        LoadLoanList();
    }//GEN-LAST:event_jCreatePackageLoanClearButtonMouseClicked

    private void jCreatePackageLoanClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreatePackageLoanClearButtonActionPerformed
        // TODO add your handling code here:  
    }//GEN-LAST:event_jCreatePackageLoanClearButtonActionPerformed

    private void jLoanListTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoanListTable1MouseClicked
        // TODO add your handling code here:
        LoanManagerController c = new LoanManagerController();
        ArrayList<String> tmp = new ArrayList<String>();

        if(evt.getClickCount() == 2){
            int rowSelection = jLoanListTable1.getSelectedRow();

            for(int i=0; i<11; i++){
                Object selCol = jLoanListTable1.getValueAt(rowSelection, i);
                if(!selCol.equals("")){
                    jPackageLoanListTable2.setValueAt(selCol, k , i);
                    tmp.add(selCol.toString());
                }
            }
            k++;
            c.doPackageLoan(tmp.get(0),true);
            Clean_Table(jLoanListTable1);
            LoadLoanList();
         }
    }//GEN-LAST:event_jLoanListTable1MouseClicked

    private void jPackageLoanListTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPackageLoanListTable2MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            int rowSelection = jPackageLoanListTable2.getSelectedRow();
            String s = (String)jPackageLoanListTable2.getValueAt(rowSelection, 0);
            LoanManagerController c = new LoanManagerController();
            c.doPackageLoan(s,false);
            for(int i=0; i<11; i++){
                jPackageLoanListTable2.setValueAt("", rowSelection, i);
            }
            for(int j=rowSelection+1; j<k+1; j++){
                for(int n=0; n<11; n++)
                jPackageLoanListTable2.setValueAt(jPackageLoanListTable2.getValueAt(j, n), j-1, n);
            }
            k--;
        }
        LoadLoanList();
    }//GEN-LAST:event_jPackageLoanListTable2MouseClicked

    private void jCreatePackageLoanFeatureComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreatePackageLoanFeatureComboBoxActionPerformed
        // TODO add your handling code here:
        String tmp = jCreatePackageLoanFeatureComboBox.getSelectedItem().toString();
        if(tmp.equals("Rate Type") || tmp.equals("Loan Type") || tmp.equals("Situation") || tmp.equals("Morgage Property")){
            flag = 0;
            jCreatePackageRangeToTextField1.setEditable(false);
            jCreatePackageRangeFromTextField.setEditable(false);
            jCreatePackageRangeToTextField1.setText("");
            jCreatePackageRangeFromTextField.setText("");
            jValueTextField1.setEditable(true);
        }
        else if(tmp.equals("Loaner ID") || tmp.equals("Borrower ID")){
            flag = -1;
            jCreatePackageRangeToTextField1.setEditable(true);
            jCreatePackageRangeFromTextField.setEditable(true);
            jValueTextField1.setEditable(false);
            jValueTextField1.setText("");
        }
        else{
            flag = 1;
            jCreatePackageRangeToTextField1.setEditable(true);
            jCreatePackageRangeFromTextField.setEditable(true);
            jValueTextField1.setEditable(false);
            jValueTextField1.setText("");
        }
    }//GEN-LAST:event_jCreatePackageLoanFeatureComboBoxActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreatePackageLoanWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCreatePackageLoanCancelButton;
    private javax.swing.JButton jCreatePackageLoanClearButton;
    private javax.swing.JComboBox jCreatePackageLoanFeatureComboBox;
    private javax.swing.JButton jCreatePackageLoanSearchButton;
    private javax.swing.JButton jCreatePackageLoanSellButton;
    private javax.swing.JButton jCreatePackageOptimitazionButton1;
    private javax.swing.JTextField jCreatePackageProfitTextField;
    private javax.swing.JTextField jCreatePackageRangeFromTextField;
    private javax.swing.JTextField jCreatePackageRangeToTextField1;
    private javax.swing.JTextField jCreatePackageRepaymentTextField;
    private javax.swing.JTextField jCreatePackageRiskTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTable jLoanListTable1;
    private javax.swing.JLabel jLoanerLabel1;
    private javax.swing.JLabel jLoanerLabel2;
    private javax.swing.JLabel jLoanerLabel3;
    private javax.swing.JLabel jLoanerLabel4;
    private javax.swing.JTable jPackageLoanListTable2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField jValueTextField1;
    // End of variables declaration//GEN-END:variables

}
