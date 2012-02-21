/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package testmysql;

/**
 *
 * @author Nikos
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

    public float getLoanAmount()  {
        return loanAmount;
    }

    public float getLoanRate ()  {
        return loanRate;
    }

    public String getLoanRateType ()  {
        return loanRateType;
    }

    public String getDate ()  {
        return date;
    }

    public int getLoanPeriod ()  {
        return loanPeriod;
    }

    public int getLoanerID ()  {
        return loanerID;
    }

    public int getBorrowerID ()  {
        return borrowerID;
    }

    public String getLoanType ()  {
        return loanType;
    }

    public float getSaleValue ()  {
        return saleValue;
    }

    public float getLoanRisk ()  {
        return loanRisk;
    }

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

      public String getMortgageProperty () {
        return mortgageProperty;
    }

	public void CalculateLoanRisk(){
	loanRisk=(int)loanAmount*(int)(loanRate*(0.2+(0.005*(101-loanRisk))));
}


}
