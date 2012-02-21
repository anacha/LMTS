package view;

import LoanManagerController;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FileExplorerWindow.java
 *
 * Created on Jan 11, 2010, 8:36:20 PM
 */

/**
 * @author   nikos
 */
@SuppressWarnings("serial")
public class FileExplorerWindow extends javax.swing.JFrame {

    /**
	 * @uml.property  name="c"
	 * @uml.associationEnd  
	 */
    private  LoanManagerController c = new LoanManagerController();
    /** Creates new form FileExplorerWindow */
    public FileExplorerWindow() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileExplorerWindow = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Browse");
        setResizable(false);

        jFileExplorerWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileExplorerWindowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileExplorerWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jFileExplorerWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		java.awt.Dimension dialogSize = getSize();
		setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents
    public void ViewfileSaver(ArrayList<String> Q, String V, String F) {
        SaveButton = 1;
        QueryResult = Q;
        Value = V;
        FunctionValue = F;
        returnVal = jFileExplorerWindow.showSaveDialog(this);
    }


    public void reason(int r) {
        rvalue = r;
    }


    private void jFileExplorerWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileExplorerWindowActionPerformed
        @SuppressWarnings("unused")
		String KeyPressed = null, TmpTxt = null,S=null;
        String inLine = null;
        int i = 1, flag = 0, j = 0;

        //KeyPressedCode = evt.getKeyCode();
        KeyPressed = evt.getActionCommand();
        if (KeyPressed.equals("ApproveSelection")) {
            if (SaveButton == 1)/*Save button pressed in Ask_Report*/
            {
                BufferedWriter out = null;
                try {
                    System.out.println(returnVal);
                    File selectedFile = jFileExplorerWindow.getSelectedFile();
                    selectedFile.delete();
                    out = new BufferedWriter(new FileWriter(selectedFile, true));
                    PrintWriter out2= new PrintWriter(out);
                    ListIterator<String> litr = QueryResult.listIterator();
                    
                    out2.write("RESULTS ON REPORT FOR:");
                    out2.write(Value);
                    out2.write("\n");
                    out2.write("-------------------------------------------------");
                    out2.write("\n");
                    System.out.print(S);
                    if (Value.equals("Loaner")) {
                    out2.printf("|%15s |%20s |%15s |%15s","LoanerID","Loaner Name","Loaner Phone","Contact");
                    out2.write("\n");

                        while (litr.hasNext()) {
                            String element = litr.next();

                            if (flag == 1) {
                                i = 1;
                                TmpTxt = null;
                                flag = 0;
                            }

                            i++;
                            if(i==2)
                                out2.printf("|%20s ", element);
                            else
                                out2.printf("|%15s ", element);
                            if (i == 5) {
                                try {
                                    out.write( "\n");
                                    flag = 1;
                                } catch (IOException ex) {
                                    Logger.getLogger(FileExplorerWindow.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        
                        }
                    }

                    else if (Value.equals("Borrower")) {
                    out2.printf("|%20s |%20s |%20s","BorrowerID","Borrower Name","Borrower Risk");
                    out2.write("\n");

                        if (FunctionValue.equals("Average") || FunctionValue.equals("Dispersion") || FunctionValue.equals("Standard Deviation")) {
                            String element = litr.next();
                            if (FunctionValue.equals("Average"))
                                out.write("Average\n");
                            else if (FunctionValue.equals("Dispersion"))
                                out.write("Dispersion\n");
                            else
                                out.write("Standard Deviation\n");
                            out.write("-----------------------------\n");
                            out.write(element + "\n");
                        }
                        else {

                            while (litr.hasNext()) {
                                String element = litr.next();
                                if (flag == 1) {
                                    i = 1;
                                    TmpTxt = null;
                                    flag = 0;
                                }
                                 i++;
                                 out2.printf("|%20s ", element);
                                if (i == 4) {
                                    out.write("\n");
                                    flag = 1;
                                }
                            }
                        }
                    }
                    else {
                        String row_name[]={"LoanID :","Amount:","Rate:","Rate Type:","Loan Date:","Loan Period:","Loan Type:",
                            "Sale Value:","Situation:","Loan Risk:","Mortgage Property:", "Preselected:"};
                    out2.write("\n");

                        if (FunctionValue.equals("Average") || FunctionValue.equals("Dispersion") || FunctionValue.equals("Standard Deviation")) {
                            String element = litr.next();
                            if (FunctionValue.equals("Average"))
                                out.write("Average\n");
                            else if (FunctionValue.equals("Dispersion"))
                                out.write("Dispersion\n");
                            else
                                out.write("Standard Deviation\n");
                            out.write("-----------------------------\n");
                            out.write(element + "\n");
                        }
                        else {

                         String element=null;
                         int s=QueryResult.size() / 12;
                         System.out.print("s"+s);

                           for(i=0;i<s;i++) {
                              // System.out.print("QueryResult.size()12"+QueryResult.size()%12)

                               out.write("-----------------------------\n");
                               for(j=0;j<12;j++)
                               {
                               element = litr.next();
                                System.out.print("row name[]="+row_name[j]);
                                System.out.print("element="+element);
                                out2.write(row_name[j]);
                                out2.write(element);
                                out2.write("\n");
                               

                               // i++;
                               // System.in.read();
                               }
                            }
                        }
                    }
                    SaveButton = 0;
                } catch (IOException ex) {
                    Logger.getLogger(FileExplorerWindow.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        out.close();
                    } catch (IOException ex) {
                        Logger.getLogger(FileExplorerWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }/*investment request/insert report*/
            else {
                System.out.print("");
            try {
                File selectedFile = jFileExplorerWindow.getSelectedFile();
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                ViewWindow a = new ViewWindow();
                if (rvalue == 0)
                    a.setVisible(true);
                try {
                    if (rvalue == 0) {
                        while ((inLine = reader.readLine()) != null) {
                            j++;
                            a.copytext(inLine);
                            a.copytext("\n");
                        }
                    }
                    else {
                       
                        c.doUpdatePortfolio(selectedFile, reader);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(FileExplorerWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
             } catch (FileNotFoundException ex) {
                Logger.getLogger(FileExplorerWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        this.dispose();
    }//GEN-LAST:event_jFileExplorerWindowActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileExplorerWindow().setVisible(true);
            }
        });
    }

    private int SaveButton = 0;
    private ArrayList<String> QueryResult = new ArrayList<String>();
    private String Value;
	private String FunctionValue;
    private int returnVal = 0;
    private int rvalue = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileExplorerWindow;
    // End of variables declaration//GEN-END:variables

 /*   private boolean Check_file_extension(File selectedFile) {

        int length = fileName.length();
        String temp2 = fileName.substring(temp.length(), length);
        if (!temp2.equals(".bnk")) {
            System.out.print("Exception handler1");
            return;
        }

    }
*/
}
