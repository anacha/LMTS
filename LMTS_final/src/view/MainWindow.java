package view;

import LoanManagerController;

import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.table.DefaultTableModel;
//import testmysql.LoanPortfolio;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainWindow.java
 *
 * Created on Jan 11, 2010, 8:09:08 PM
 */

/**
 * @author   nikos
 */
@SuppressWarnings("serial")
public class MainWindow extends javax.swing.JFrame {

    /**
	 * @uml.property  name="c"
	 * @uml.associationEnd  
	 */
    private  LoanManagerController c = new LoanManagerController();
    @SuppressWarnings("unchecked")
	private void Show_First(){
         int j,i;
         ArrayList<String> QueryResult = new ArrayList<String>();
        
        
         QueryResult = c.doViewArchive("Loaner", null, true);
         ListIterator<String> litr = QueryResult.listIterator();

         int RowsAlloc = QueryResult.size()/4 - 2;
         if (QueryResult.size()/4 > 18) {
             Add_Row(RowsAlloc, 3);
         }

         for(j=0; j < QueryResult.size()/4 ; j++) {
             for(i=0;i<4;i++) {
                 String element = litr.next();
                 jMainWindowLoanerTable3.setValueAt((String)element, j,i);
             }
         }
          QueryResult = c.doViewArchive("Loan", null, true);
         litr = QueryResult.listIterator();

         RowsAlloc = QueryResult.size()/11 - 2;
         if (QueryResult.size()/11 > 30) {
             Add_Row(RowsAlloc, 2);
         }

         for(j=0; j < QueryResult.size()/11 ; j++) {
             for(i=0;i<11;i++) {
                 String element = litr.next();
                 jMainWindowLoanTable2.setValueAt((String)element, j,i);
             }
         }
         QueryResult = c.doViewArchive("Borrower", null, true);
         litr = QueryResult.listIterator();

         RowsAlloc = QueryResult.size()/3 - 2;
         if (QueryResult.size()/3 > 18) {
            Add_Row(RowsAlloc, 1);
         }
             
         for(j=0; j < QueryResult.size()/3 ; j++) {
             for(i=0;i<3;i++) {
                 String element = litr.next();
                 jMainWindowBorrowerTable1.setValueAt((String)element, j,i);
             }
         }
    }


    public void Add_Row(int RowsAlloc, int table_num) {

       if (table_num == 1) {
            DefaultTableModel model = new DefaultTableModel(new Object [][] {
                     {null, null, null},
                     {null, null, null}}, new String [] {"BorrowerID", "Borrower Name", "Borrower Risk"})
                     {
                        boolean[] canEdit = new boolean [] {
                            false, false, false
                        };

                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                     };
             jMainWindowBorrowerTable1.setModel(model);
             for (int k = 0; k < RowsAlloc; k++)
                model.addRow(new Object[][]{null,null,null});
       }
       else if (table_num == 2) {
           DefaultTableModel model = new DefaultTableModel(new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}},
                new String [] {"LoanID", "Amount", "Rate", "Rate_Type", "Loan Date", "Loan Period", "Loan Type", "Sale Value", "Situation", "Loan Risk", "Mortgage Property"})
                     {
                        @SuppressWarnings("rawtypes")
						Class[] types = new Class [] {
                            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                        };
                        boolean[] canEdit = new boolean [] {
                            false, false, false, false, false, false, false, false, false, false, false
                        };

                        @SuppressWarnings({ "unchecked", "rawtypes" })
						@Override
                        public Class getColumnClass(int columnIndex) {
                            return types [columnIndex];
                        }

                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return canEdit [columnIndex];
                        }
                    };
                    jMainWindowLoanTable2.setModel(model);
                    for (int k = 0; k < RowsAlloc; k++)
                        model.addRow(new Object[][]{null, null, null, null, null, null, null, null, null, null, null});
       }
       else {
            DefaultTableModel model = new DefaultTableModel(new Object [][] {
                {null, null, null, null},
                {null, null, null, null}},
                new String [] {
                    "LoanerID", "Loaner Name", "Loaner Phone number", "Contact"})
                {
                    @SuppressWarnings("rawtypes")
					Class[] types = new Class [] {
                        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                    };
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false
                    };

                    @SuppressWarnings({ "rawtypes", "unchecked" })
					@Override
                    public Class getColumnClass(int columnIndex) {
                        return types [columnIndex];
                    };

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
               };
               jMainWindowLoanerTable3.setModel(model);
               for (int k = 0; k < RowsAlloc; k++)
                    model.addRow(new Object[][]{null, null, null, null});
       }
    }

    /** Creates new form MainWindow */
    public MainWindow() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jMainWindowBorrowerTextField = new javax.swing.JTextField();
        Loanlabel = new java.awt.Label();
        Loanerlabel = new java.awt.Label();
        jMainWindowLoanTextField = new javax.swing.JTextField();
        jMainWindowLoanerTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMainWindowBorrowerTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jMainWindowLoanTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jMainWindowLoanerTable3 = new javax.swing.JTable();
        jMainWindowRefreshButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        InsertReport = new javax.swing.JMenuItem();
        jInsertInvestReqMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        jLoanerMenu = new javax.swing.JMenu();
        jAddLoanerMenuItem = new javax.swing.JMenuItem();
        jRemoveLoanerMenuItem = new javax.swing.JMenuItem();
        jModifyLoanerMenuItem = new javax.swing.JMenuItem();
        jViewMenu = new javax.swing.JMenu();
        jSortMenuItem = new javax.swing.JMenuItem();
        jSearchMenuItem = new javax.swing.JMenuItem();
        jOrganiseMenuItem = new javax.swing.JMenuItem();
        jReportMenuItem = new javax.swing.JMenuItem();
        jMainWindowToolsMenu = new javax.swing.JMenu();
        jCreatePackageMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LMTS Main Window");
        setBackground(new java.awt.Color(230, 220, 213));

        jMainWindowBorrowerTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMainWindowBorrowerTextFieldKeyPressed(evt);
            }
        });

        Loanlabel.setText("Loan");

        Loanerlabel.setText("Loaner:");

        jMainWindowLoanTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMainWindowLoanTextFieldKeyPressed(evt);
            }
        });

        jMainWindowLoanerTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMainWindowLoanerTextFieldKeyPressed(evt);
            }
        });

        jLabel1.setText("Borrower:");

        jMainWindowBorrowerTable1.setAutoCreateRowSorter(true);
        jMainWindowBorrowerTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "BorrowerID", "Borrower Name", "Borrower Risk"
            }
        ));
        jMainWindowBorrowerTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jMainWindowBorrowerTable1);

        jMainWindowLoanTable2.setModel(new javax.swing.table.DefaultTableModel(
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
                "LoanID", "Amount", "Rate", "Rate_Type", "Loan Date", "Loan Period", "Loan Type", "Sale Value", "Situation", "Loan Risk", "Mortgage Property"
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
        jScrollPane2.setViewportView(jMainWindowLoanTable2);

        jMainWindowLoanerTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "LoanerID", "Loaner Name", "Loaner Phone number", "Contact"
            }
        ) {
            @SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            @SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jMainWindowLoanerTable3);

        jMainWindowRefreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh.png"))); // NOI18N
        jMainWindowRefreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMainWindowRefreshButtonMouseClicked(evt);
            }
        });

        fileMenu.setText("File");
        fileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });

        InsertReport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        InsertReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/import.png"))); // NOI18N
        InsertReport.setText("Insert Report");
        InsertReport.setToolTipText("Open a File");
        InsertReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertReportActionPerformed(evt);
            }
        });
        fileMenu.add(InsertReport);

        jInsertInvestReqMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jInsertInvestReqMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/documents.png"))); // NOI18N
        jInsertInvestReqMenuItem.setText("Insert Investment Request");
        jInsertInvestReqMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInsertInvestReqMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(jInsertInvestReqMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/close.png"))); // NOI18N
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jLoanerMenu.setText("Loaner");

        jAddLoanerMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add.png"))); // NOI18N
        jAddLoanerMenuItem.setText("Add New");
        jAddLoanerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddLoanerMenuItemActionPerformed(evt);
            }
        });
        jLoanerMenu.add(jAddLoanerMenuItem);

        jRemoveLoanerMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/remove.png"))); // NOI18N
        jRemoveLoanerMenuItem.setText("Remove");
        jRemoveLoanerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoveLoanerMenuItemActionPerformed(evt);
            }
        });
        jLoanerMenu.add(jRemoveLoanerMenuItem);

        jModifyLoanerMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit.png"))); // NOI18N
        jModifyLoanerMenuItem.setText("Modify");
        jModifyLoanerMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModifyLoanerMenuItemActionPerformed(evt);
            }
        });
        jLoanerMenu.add(jModifyLoanerMenuItem);

        menuBar.add(jLoanerMenu);

        jViewMenu.setText("Portfolio Management");

        jSortMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jSortMenuItem.setText("Sort");
        jSortMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSortMenuItemActionPerformed(evt);
            }
        });
        jViewMenu.add(jSortMenuItem);

        jSearchMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jSearchMenuItem.setText("Search");
        jSearchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchMenuItemActionPerformed(evt);
            }
        });
        jViewMenu.add(jSearchMenuItem);

        jOrganiseMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jOrganiseMenuItem.setText("Organise");
        jOrganiseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOrganiseMenuItemActionPerformed(evt);
            }
        });
        jViewMenu.add(jOrganiseMenuItem);

        jReportMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jReportMenuItem.setText("Report");
        jReportMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jReportMenuItemActionPerformed(evt);
            }
        });
        jViewMenu.add(jReportMenuItem);

        menuBar.add(jViewMenu);

        jMainWindowToolsMenu.setText("Package Loan");

        jCreatePackageMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jCreatePackageMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/box_closed.png"))); // NOI18N
        jCreatePackageMenuItem.setText("Create");
        jCreatePackageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreatePackageMenuItemActionPerformed(evt);
            }
        });
        jMainWindowToolsMenu.add(jCreatePackageMenuItem);

        menuBar.add(jMainWindowToolsMenu);

        helpMenu.setText("Help");

        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/about.png"))); // NOI18N
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Loanlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMainWindowLoanTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                                .addGap(54, 54, 54))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jMainWindowRefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMainWindowBorrowerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Loanerlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jMainWindowLoanerTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jMainWindowBorrowerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jMainWindowLoanerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                            .addComponent(jMainWindowRefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Loanerlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Loanlabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMainWindowLoanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        Show_First();
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		java.awt.Dimension dialogSize = getSize();
		setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

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


    @SuppressWarnings({ "static-access", "unchecked" })
	private void jMainWindowLoanTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMainWindowLoanTextFieldKeyPressed
        @SuppressWarnings("unused")
		String KeyPressed = null, ln = null, TmpTxt = null;
        @SuppressWarnings("unused")
		int KeyPressedCode, flag = 0, i = 1;
        ArrayList<String> QueryResult = new ArrayList<String>();
        

        KeyPressedCode = evt.getKeyCode();
        KeyPressed = evt.getKeyText(KeyPressedCode);
        int j;

        if(KeyPressed.equals("Enter")) {
            Clean_Table(jMainWindowLoanTable2);
            ln = jMainWindowLoanTextField.getText();
            if(ln.equals("")){
                Show_First();
            }
            else{
               
                QueryResult = c.doViewArchive("Loan", ln, false);
                ListIterator<String> litr = QueryResult.listIterator();


                for(j=0; j < QueryResult.size()/11 ; j++)
                {
                    for(i=0;i<11;i++)
                    {
                        String element = litr.next();
                        jMainWindowLoanTable2.setValueAt((String)element, j,i);
                    }
                }
            }
        }
}//GEN-LAST:event_jMainWindowLoanTextFieldKeyPressed

    @SuppressWarnings({ "static-access", "unchecked" })
    private void jMainWindowLoanerTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMainWindowLoanerTextFieldKeyPressed
        @SuppressWarnings("unused")
		String KeyPressed = null, l = null, TmpTxt = null;
        @SuppressWarnings("unused")
		int KeyPressedCode, flag = 0, i = 1,j;
        ArrayList<String> QueryResult = new ArrayList<String>();


        KeyPressedCode = evt.getKeyCode();
        KeyPressed = evt.getKeyText(KeyPressedCode);
        if(KeyPressed.equals("Enter")) {
            Clean_Table(jMainWindowLoanerTable3);

            l = jMainWindowLoanerTextField.getText();
            if(l.equals("")){
                Show_First();
            }
            else{
                
                QueryResult = c.doViewArchive("Loaner", l, false);

                ListIterator<String> litr = QueryResult.listIterator();
                for(j=0; j < QueryResult.size()/4 ; j++)
                {

                    for(i=0;i<4;i++)
                    {
                        String element = litr.next();
                        jMainWindowLoanerTable3.setValueAt((String)element, j,i);
                    }
                }
            }
        }
        
}//GEN-LAST:event_jMainWindowLoanerTextFieldKeyPressed

    private void jAddLoanerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddLoanerMenuItemActionPerformed
        // TODO add your handling code here:
        new MultInputWindow().setVisible(true);
    }//GEN-LAST:event_jAddLoanerMenuItemActionPerformed

    private void InsertReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertReportActionPerformed
        FileExplorerWindow f = new FileExplorerWindow();
        f.reason(1);
        f.setVisible(true);
    }//GEN-LAST:event_InsertReportActionPerformed

    private void jInsertInvestReqMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInsertInvestReqMenuItemActionPerformed
        FileExplorerWindow f = new FileExplorerWindow();
        f.reason(0);
        f.setVisible(true);
    }//GEN-LAST:event_jInsertInvestReqMenuItemActionPerformed

    private void jRemoveLoanerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoveLoanerMenuItemActionPerformed
        new RemoveLoanerWindow().setVisible(true);
    }//GEN-LAST:event_jRemoveLoanerMenuItemActionPerformed

    private void jModifyLoanerMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModifyLoanerMenuItemActionPerformed
        new ModifyLoanerInfoWindow().setVisible(true);
    }//GEN-LAST:event_jModifyLoanerMenuItemActionPerformed

    private void jSortMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSortMenuItemActionPerformed
        new SortWindow().setVisible(true);
    }//GEN-LAST:event_jSortMenuItemActionPerformed

    private void jSearchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchMenuItemActionPerformed
        new SearchWindow().setVisible(true);
    }//GEN-LAST:event_jSearchMenuItemActionPerformed

    private void jOrganiseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOrganiseMenuItemActionPerformed
        new OrganiseWindow().setVisible(true);
    }//GEN-LAST:event_jOrganiseMenuItemActionPerformed

    private void jReportMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jReportMenuItemActionPerformed
        new AskReportWindow().setVisible(true);
    }//GEN-LAST:event_jReportMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        new AboutWindow().setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void jCreatePackageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreatePackageMenuItemActionPerformed
        new CreatePackageLoanWindow().setVisible(true);
    }//GEN-LAST:event_jCreatePackageMenuItemActionPerformed

    private void fileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuActionPerformed
       
    }//GEN-LAST:event_fileMenuActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(1);// TODO add your handling code here:
    }//GEN-LAST:event_exitMenuItemActionPerformed

    @SuppressWarnings({ "static-access", "unchecked" })
	private void jMainWindowBorrowerTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMainWindowBorrowerTextFieldKeyPressed
        @SuppressWarnings("unused")
		String KeyPressed = null, b = null, TmpTxt = null;
        @SuppressWarnings("unused")
		int KeyPressedCode, flag = 0, i = 1,j;
        ArrayList<String> QueryResult = new ArrayList<String>();

        KeyPressedCode = evt.getKeyCode();
        KeyPressed = evt.getKeyText(KeyPressedCode);
        if(KeyPressed.equals("Enter")) {
            Clean_Table(jMainWindowBorrowerTable1);
            b = jMainWindowBorrowerTextField.getText();
            if(b.equals("")){
                Show_First();
            }
            else{
               
                QueryResult = c.doViewArchive("Borrower", b, false);

                ListIterator<String> litr = QueryResult.listIterator();
                for(j=0; j < QueryResult.size()/3 ; j++)
                {
                    for(i=0;i<3;i++)
                    {
                    String element = litr.next();
                    jMainWindowBorrowerTable1.setValueAt((String)element, j,i);
                    }

                }
            }
        }
    }//GEN-LAST:event_jMainWindowBorrowerTextFieldKeyPressed

    private void jMainWindowRefreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Clean_Table(jMainWindowLoanTable2);
        Clean_Table(jMainWindowLoanerTable3);
        Clean_Table(jMainWindowBorrowerTable1);
        Show_First();
    }//GEN-LAST:event_jButton1MouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem InsertReport;
    private java.awt.Label Loanerlabel;
    private java.awt.Label Loanlabel;
    private javax.swing.JMenuItem jAddLoanerMenuItem;
    private javax.swing.JMenuItem jCreatePackageMenuItem;
    private javax.swing.JMenuItem jInsertInvestReqMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jLoanerMenu;
    private javax.swing.JTable jMainWindowBorrowerTable1;
    private javax.swing.JTextField jMainWindowBorrowerTextField;
    private javax.swing.JTable jMainWindowLoanTable2;
    private javax.swing.JTextField jMainWindowLoanTextField;
    private javax.swing.JTable jMainWindowLoanerTable3;
    private javax.swing.JTextField jMainWindowLoanerTextField;
    private javax.swing.JButton jMainWindowRefreshButton;
    private javax.swing.JMenu jMainWindowToolsMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jModifyLoanerMenuItem;
    private javax.swing.JMenuItem jOrganiseMenuItem;
    private javax.swing.JMenuItem jRemoveLoanerMenuItem;
    private javax.swing.JMenuItem jReportMenuItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem jSearchMenuItem;
    private javax.swing.JMenuItem jSortMenuItem;
    private javax.swing.JMenu jViewMenu;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
