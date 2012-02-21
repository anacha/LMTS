/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testmysql;

/**
 *
 * @author Nikos
 */
class Loaner {

    private String loanerName;
    private int loanerID;
    private String phoneNumber;
    private String loanerContact;


   public String getLoanerName () {
        return loanerName;
    }

    public int getLoanerID () {
        return loanerID;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

  public String getLoanerContact () {
        return loanerContact;
    }

    public void modifyLoanerInfo (String pn, String lc) {
        phoneNumber=pn;
        loanerContact=lc;
    }
}
