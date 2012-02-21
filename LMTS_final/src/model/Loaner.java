/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 * @author   Nikos
 */
class Loaner {

    private String loanerName;
    private int loanerID;
    private String phoneNumber;
    private String loanerContact;


   /**
 * @return
 * @uml.property  name="loanerName"
 */
public String getLoanerName () {
        return loanerName;
    }

    /**
	 * @return
	 * @uml.property  name="loanerID"
	 */
    public int getLoanerID () {
        return loanerID;
    }

    /**
	 * @return
	 * @uml.property  name="phoneNumber"
	 */
    public String getPhoneNumber () {
        return phoneNumber;
    }

  /**
 * @return
 * @uml.property  name="loanerContact"
 */
public String getLoanerContact () {
        return loanerContact;
    }

    public void modifyLoanerInfo (String pn, String lc) {
        phoneNumber=pn;
        loanerContact=lc;
    }
}
