/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testmysql;

import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikos
 */
public class LoanPortfolio {
    private ArrayList<Loan> collection;
    private Borrower borrower;
    private Loan loan;
    private Loaner loaner;
    private PackageLoan packageLoan;
    //dbms

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public void addLoan(){}

    public void removeLoan(){}

    public void modifyLoan(){}

    public ArrayList Do_DB_Query(String q){
        ArrayList<String> QueryResult = new ArrayList<String>();
        SQLWarning sw = null;

        try {
            stmt = this.conn.createStatement();
            rs = stmt.executeQuery(q);
            sw = stmt.getWarnings();
            System.out.println("Egine query"+ q);

            ResultSetMetaData metaData = rs.getMetaData();
            int columns = metaData.getColumnCount();

            while (rs.next()) {
                String record = null;
                for (int i = 1; i <= columns; i++) {
                    System.out.println(rs.getObject(i).toString());
                    record = rs.getObject(i).toString();
                    QueryResult.add(record);
                }
        }
        } catch (SQLException ex) {
            Logger.getLogger(LoanPortfolio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return QueryResult;
    }


    public void Do_DB_Update(String uq){
        try {
            stmt = this.conn.createStatement();
            int rowsAffected = stmt.executeUpdate(uq);
            System.out.println("Egine Update"+ uq);
            System.out.println("Rows affected: "+rowsAffected);
        } catch (SQLException ex) {
            Logger.getLogger(LoanPortfolio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList doCreateObject(int c, String sqlc){
        // auth kalei thn createQuery()
         ArrayList<String> QueryResult = new ArrayList<String>();

        QueryResult = createQuery(c, sqlc);

        return QueryResult;
    }

    public ArrayList createQuery(int c, String sqlc){
        // auth kalei eite DO_DB_Query() eite DO_DB_Update()
         ArrayList<String> QueryResult = new ArrayList<String>();
        switch(c){
            case 1: QueryResult = Do_DB_Query(sqlc);
                break;
            case 2: Do_DB_Update(sqlc);
                break;
            default :
                break;
        }

        return QueryResult;
    }

    public LoanPortfolio(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/mydb?" + "user=root&password=lalaki";
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("Connection to db established");
        } catch (SQLException ex) {
            Logger.getLogger(LoanPortfolio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoanPortfolio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
