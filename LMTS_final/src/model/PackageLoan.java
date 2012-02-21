/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 * @author   Nikos
 */
class PackageLoan {

    private ArrayList<Loan> collection;
    private float packageValue;
    private int remainingMonths;
    private float risk;
    private int packageProfit;
    private int num_of_loans;


    public PackageLoan () {
	    //collection=
    }

    /**
	 * @return
	 * @uml.property  name="packageValue"
	 */
    public float getPackageValue () {
        return packageValue;
    }

    /**
	 * @return
	 * @uml.property  name="remainingMonths"
	 */
    public int getRemainingMonths () {
        return remainingMonths;
    }

    /**
	 * @return
	 * @uml.property  name="risk"
	 */
    public float getRisk () {
        return risk;
    }

    /**
	 * @return
	 * @uml.property  name="packageProfit"
	 */
    public int getPackageProfit () {
        return packageProfit;
    }

    public void calculatePackageProfit () {
        packageProfit=1 ;
    }

    public float calculateRisk () {
	    int i;
            float sum1=0,sum2=0;
	    for(i=0;i<num_of_loans;i++)
	    {
		sum1 = sum1 + (collection.get(i)).getLoanRisk() * (collection.get(i)).getLoanAmount();
		sum2 = sum2 + collection.get(i).getLoanRisk();
  	    }
	    return (float)sum1/(float)sum2;
    }

    public void addLoan (Loan ln) {

	    //collection.[num_of_loans]=ln;
            collection.add(ln);
	    //num_of_loans++;
    }

    public void removeLoan (Loan ln) {
	int i;
	for(i=0;i<num_of_loans;i++)
	{
		if(collection.get(i).loanID==ln.loanID)
		{
			//collection[i]=NULL;
                        collection.remove(i);
			break;
		}
	}
	//collection[i]=collection[num_of_loans];
	//collection[num_of_loans]=NULL;
    }

    public void calculatePackageValue () {

    }

    public void calculateRemainingMonths () {
    }

}
