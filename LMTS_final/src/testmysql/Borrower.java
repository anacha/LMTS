/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testmysql;


/**
 *
 * @author Nikos
 */
class Borrower {
    private int id;
    private String name;
    private int riskBorrower;

     public Borrower () {
        System.out.println("new class Borrowere object created\n");

    }
    public int getBorrowerID () {
        return id;
    }
    public String getName () {
       return name;
    }
    public int getRiskBorrower () {
        return riskBorrower;
    }
}



