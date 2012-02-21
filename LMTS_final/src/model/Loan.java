/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 * @author   Nikos
 */
class Loan {

    private int loanBalance;
    private int loanAmount;
    private float loanRate;
    private String loanRateType;
    private String date;
    private int loanPeriod;
    private int loanerID;
    private int borrowerID;
    private String loanType;
    private float saleValue;
    private int loanRisk;
    private String situation;
    private String mortgageProperty;
    public int loanID;



    public Loan (int la, float lr, String lrt, String d, int lp, Loaner l, Borrower b, String lt, float sv, String s) {

        loanAmount=la;
        loanRate=lr;
        loanRateType=lrt;
        date=d;
        loanPeriod=lp;
        loanerID=l.getLoanerID();
        borrowerID=b.getBorrowerID();
        loanType=lt;
        saleValue=sv;
        situation=s;


    }

    /**
	 * @return
	 * @uml.property  name="loanAmount"
	 */
    public float getLoanAmount()  {
        return loanAmount;
    }

    /**
	 * @return
	 * @uml.property  name="loanRate"
	 */
    public float getLoanRate ()  {
        return loanRate;
    }

    /**
	 * @return
	 * @uml.property  name="loanRateType"
	 */
    public String getLoanRateType ()  {
        return loanRateType;
    }

    /**
	 * @return
	 * @uml.property  name="date"
	 */
    public String getDate ()  {
        return date;
    }

    /**
	 * @return
	 * @uml.property  name="loanPeriod"
	 */
    public int getLoanPeriod ()  {
        return loanPeriod;
    }

    /**
	 * @return
	 * @uml.property  name="loanerID"
	 */
    public int getLoanerID ()  {
        return loanerID;
    }

    /**
	 * @return
	 * @uml.property  name="borrowerID"
	 */
    public int getBorrowerID ()  {
        return borrowerID;
    }

    /**
	 * @return
	 * @uml.property  name="loanType"
	 */
    public String getLoanType ()  {
        return loanType;
    }

    /**
	 * @return
	 * @uml.property  name="saleValue"
	 */
    public float getSaleValue ()  {
        return saleValue;
    }

    /**
	 * @return
	 * @uml.property  name="loanRisk"
	 */
    public float getLoanRisk ()  {
        return loanRisk;
    }

     /**
	 * @return
	 * @uml.property  name="situation"
	 */
    public String getSituation ()  {
        return situation;
    }

    public void modifyLoanInfo (int la, float lr, String lrt, String d, int lp, Loaner l, Borrower b, String lt, float sv, String s) {

        loanAmount=la;
        loanRate=lr;
        loanRateType=lrt;
        date=d;
        loanPeriod=lp;
        loanerID=l.getLoanerID();
        borrowerID=b.getBorrowerID();
        saleValue=sv;
        situation=s;

    }

    public void calculateSale () {
        saleValue = loanBalance*loanRate*(float)(0.2+(0.005*(101-loanRisk)));
    }

      /**
	 * @return
	 * @uml.property  name="mortgageProperty"
	 */
    public String getMortgageProperty () {
        return mortgageProperty;
    }

	public void CalculateLoanRisk(){
	loanRisk=(int)loanAmount*(int)(loanRate*(0.2+(0.005*(101-loanRisk))));
}


}
