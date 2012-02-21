/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import view.ExceptionWindow;
import view.MessageWindow;
import view.ValidateChangesWindow;

import model.LoanPortfolio;
/**
 * @author   Nikos
 */
public class LoanManagerController {

    /**
	 * @uml.property  name="lp"
	 * @uml.associationEnd  
	 */
    private LoanPortfolio lp = new LoanPortfolio();

    public LoanManagerController(){
        
    }
    public void doCreateLoaner(String i, String n, String p, String c){
       

        String str = "INSERT INTO Loaner "
                + "VALUES "
                + "("+ i +","
                + "'"+ n + "',"
                + "'"+ p + "',"
                + "'"+ c + "')";
       
        lp.doCreateObject(2, str);

    }

    @SuppressWarnings("unchecked")
	public void doDeleteLoaner(int id){

         ArrayList<String> QueryResult = new ArrayList<String>();
        String d_str="Select* from loan,loaner,l_provides_l where p_loanID=loanID and p_loanerID=loanerID and  loanerID =" + id ;
        System.out.print("d_str="+d_str);
        QueryResult=lp.Do_DB_Query(d_str);
        if(!QueryResult.isEmpty())
        {
            ExceptionWindow d=new ExceptionWindow("Cannot delete loaner that has active loans");
            d.setVisible(true);
            return;
        }
        else
        {
        String str = "Delete From Loaner Where loanerID = " + id +"";
        lp.doCreateObject(2, str);
        }
    }


    public void doModifyLoanerInfo(int id, String contact, String phone){

        String upstr = "UPDATE Loaner SET l_contact = "
                    + "'" + contact + "',"
                    + "phone_num = '" + phone + "'"
                    + "WHERE loanerID = " + id + "";

        if(!upstr.equals("")){
            lp.createQuery(2, upstr);
        }
    }

 @SuppressWarnings({ "unchecked", "rawtypes" })
    public ArrayList doViewArchive(String array, String value, boolean sf) {
         ArrayList<String> QueryResult = new ArrayList<String>();

        if (sf == true) {
            String str = null;
           if(array.equals("Loan"))
               str = "SELECT loanID, amount, rate, rate_type, l_date, l_period, l_type, sale_value, situation, l_risk, mortgage_prop FROM Loan;";
           else
                str="select * from " + array + ";";
           QueryResult = lp.Do_DB_Query (str);
        }
        else {
            if (array.equals("Borrower")) {
                String str = "SELECT * FROM Borrower WHERE b_name = '" + value + "';";
                QueryResult = lp.doCreateObject(1, str);
            }
            else if (array.equals("Loaner")) {
                String str = "SELECT * FROM Loaner WHERE l_name = '" + value + "';";
                QueryResult = lp.doCreateObject(1, str);
            }
            else if (array.equals("Loan")) {
                String str = "SELECT loanID, amount, rate, rate_type, l_date, l_period, l_type, sale_value, situation, l_risk, mortgage_prop FROM Loan WHERE loanID = '" + value + "';";
                QueryResult = lp.doCreateObject(1, str);
            }
        }

        return QueryResult;
    }



    @SuppressWarnings("unchecked")
	public ArrayList<String> doSort(String choice,int mode) {
        String str=null;
        ArrayList<String> QueryResult=new ArrayList<String>();
        str="SELECT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID ORDER BY ";

        str=str + choice ;
        if(mode==1 || mode==0)
            str+=" ASC";
        else
            str+=" DESC";
        System.out.println(str);

        QueryResult=lp.Do_DB_Query(str);
        return QueryResult;
    }
    
    

    @SuppressWarnings("unchecked")
	public ArrayList<String> doAskReport(String Value, String ListValue, String FunctionValue, String IncFrom, String IncTo, String ExFrom, String ExTo, String Txt) {
        ArrayList<String> QueryResult=new ArrayList<String>();
        String str = null;
        System.out.println(Value);

        if (Value.equals("Loaner")) {
            if (ListValue.equals("ID")) {
                if (ExFrom.equals("") || ExTo.equals("")) {
                    str = "SELECT * FROM " + Value + " WHERE loanerID BETWEEN "
                    + IncFrom + " AND " + IncTo + ";";
                }
                else if (IncFrom.equals("") || IncTo.equals("")) {
                    str = "SELECT * FROM " + Value + " WHERE loanerID NOT BETWEEN "
                    + ExFrom + " AND " + ExTo + ";";
                }
                else {
                    str = "SELECT * FROM " + Value + " WHERE loanerID BETWEEN "
                    + IncFrom + " AND " + IncTo + " AND loanerID NOT BETWEEN "
                    + ExFrom + " AND " + ExTo + ";";
                }
            }
            else if(ListValue.equals("Name")) {
               str = "SELECT * FROM " + Value + " WHERE l_name LIKE '" + Txt + "';";
            }
            else if(ListValue.equals("Phone Number")) {
                str = "SELECT * FROM " + Value + " WHERE phone_num LIKE " + Txt + ";";
            }
            else {
                str = "SELECT * FROM " + Value + " WHERE l_contact LIKE '" + Txt + "';";
            }
        }
        else if (Value.equals("Borrower")) {
           if (ListValue.equals("ID")) {
                if (IncFrom.equals("") || IncTo.equals("")) {
                    str = "SELECT * FROM " + Value + " WHERE b_ID NOT BETWEEN "
                    + ExFrom + " AND " + ExTo + ";";
                }
                else if (ExFrom.equals("") || ExTo.equals("")) {
                    str = "SELECT * FROM " + Value + " WHERE b_ID BETWEEN "
                    + IncFrom + " AND " + IncTo+ ";";
                }
                else {
                    str = "SELECT * FROM " + Value + " WHERE b_ID BETWEEN "
                    + IncFrom + " AND " + IncTo + " AND b_ID NOT BETWEEN "
                    + ExFrom + " AND " + ExTo + ";";
                }
           }
           else if (ListValue.equals("Risk")) {
               if (FunctionValue.equals("Average")) {
                   if (ExFrom.equals("") || ExTo.equals("")) {
                       str = "SELECT avg(b_risk) FROM " + Value + " WHERE b_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                        str = "SELECT avg(b_risk) FROM " + Value + " WHERE b_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                   }
                   else {
                        str = "SELECT avg(b_risk) FROM " + Value + " WHERE b_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND b_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                   }
               }
               else if(FunctionValue.equals("Standard Deviation")) {
                   if (ExFrom.equals("") || ExTo.equals("")) {
                        str = "SELECT std(b_risk) FROM " + Value + " WHERE b_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                        str = "SELECT std(b_risk) FROM " + Value + " WHERE b_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                   }
                   else {
                        str = "SELECT std(b_risk) FROM " + Value + " WHERE b_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND b_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                   }
               }
               else if(FunctionValue.equals("Dispersion")) {
                   if (ExFrom.equals("") || ExTo.equals("")) {
                        str = "SELECT sqrt(std(b_risk)) FROM " + Value + " WHERE b_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                        str = "SELECT sqrt(std(b_risk)) FROM " + Value + " WHERE b_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                   }
                   else {
                        str = "SELECT sqrt(std(b_risk)) FROM " + Value + " WHERE b_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND b_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                   }
               }
               else {
                   if (ExFrom.equals("") || ExTo.equals("")) {
                       str = "SELECT * FROM " + Value + " WHERE b_risk BETWEEN "
                      + IncFrom + " AND " + IncTo + ";";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                       str = "SELECT * FROM " + Value + " WHERE b_risk NOT BETWEEN "
                      + ExFrom + " AND " + ExTo + ";";
                   }
                   else {
                      str = "SELECT * FROM " + Value + " WHERE b_risk BETWEEN "
                      + IncFrom + " AND " + IncTo + " AND b_risk NOT BETWEEN "
                      + ExFrom + " AND " + ExTo + ";";
                   }
               }
           }
           if (ListValue.equals("Name")) {
                str = "SELECT * FROM " + Value + " WHERE b_name LIKE '" + Txt + "';";
           }
        }
        else {
            if (ListValue.equals("Loan ID")) {
                if (ExFrom.equals("") || ExTo.equals("")) {
                    str = "SELECT * FROM " + Value + " WHERE loanID BETWEEN "
                    + IncFrom + " AND " + IncTo + ";";
                }
                else if (IncFrom.equals("") || IncTo.equals("")) {
                    str = "SELECT * FROM " + Value + " WHERE loanID NOT BETWEEN "
                    + ExFrom + " AND " + ExTo + ";";
                }
                else {
                    str = "SELECT * FROM " + Value + " WHERE loanID BETWEEN "
                    + IncFrom + " AND " + IncTo + " AND loanID NOT BETWEEN "
                    + ExFrom + " AND " + ExTo + ";";
                }
            }
            else if (ListValue.equals("Amount")) {
                if (FunctionValue.equals("Average")) {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                       str = "SELECT avg(amount) FROM " + Value + " WHERE amount BETWEEN "
                       + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                        str = "SELECT avg(amount) FROM " + Value + " WHERE amount NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                    else {
                       str = "SELECT avg(amount) FROM " + Value + " WHERE amount BETWEEN "
                       + IncFrom + " AND " + IncTo + " AND amount NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                }
                else if (FunctionValue.equals("Standard Deviation")) {
                     if (ExFrom.equals("") || ExTo.equals("")) {
                         str = "SELECT std(amount) FROM " + Value + " WHERE amount BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                     }
                     else  if (IncFrom.equals("") || IncTo.equals("")) {
                        str = "SELECT std(amount) FROM " + Value + " WHERE amount NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                     }
                     else {
                        str = "SELECT std(amount) FROM " + Value + " WHERE amount BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND amount NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                     }
                }
                else if (FunctionValue.equals("Dispersion")) {
                     if (ExFrom.equals("") || ExTo.equals("")) {
                         str = "SELECT sqrt(std(amount)) FROM " + Value + " WHERE amount BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                     }
                     else  if (IncFrom.equals("") || IncTo.equals("")) {
                        str = "SELECT sqrt(std(amount)) FROM " + Value + " WHERE amount NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                     }
                     else {
                        str = "SELECT sqrt(std(amount)) FROM " + Value + " WHERE amount BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND amount NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                     }
                }
                else {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                        str = "SELECT * FROM " + Value + " WHERE amount BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                        str = "SELECT * FROM " + Value + " WHERE amount NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                    else {
                        str = "SELECT * FROM " + Value + " WHERE amount BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND amount NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                }
           }
           else if (ListValue.equals("Rate")) {
                if (FunctionValue.equals("Average")) {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                        str = "SELECT avg(rate) FROM " + Value + " WHERE rate BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                        str = "SELECT avg(rate) FROM " + Value + " WHERE rate NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                    else {
                        str = "SELECT avg(rate) FROM " + Value + " WHERE rate BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND rate NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                }
                else if (FunctionValue.equals("Standard Deviation")) {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                        str = "SELECT std(rate) FROM " + Value + " WHERE rate BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                        str = "SELECT std(rate) FROM " + Value + " WHERE rate NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                    else {
                        str = "SELECT std(rate) FROM " + Value + " WHERE rate BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND rate NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                }
                else if (FunctionValue.equals("Dispersion")) {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                        str = "SELECT sqrt(std(rate)) FROM " + Value + " WHERE rate BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                        str = "SELECT sqrt(std(rate)) FROM " + Value + " WHERE rate NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                    else {
                        str = "SELECT sqrt(std(rate)) FROM " + Value + " WHERE rate BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND rate NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                }
                else {
                   if (ExFrom.equals("") || ExTo.equals("")) {
                       str = "SELECT * FROM " + Value + " WHERE rate BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                       str = "SELECT * FROM " + Value + " WHERE rate NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                   }
                   else {
                        str = "SELECT * FROM " + Value + " WHERE rate BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND rate NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                   }
                }
           }
           else if (ListValue.equals("Risk")) {
                if (FunctionValue.equals("Average")) {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                         str = "SELECT avg(l_risk) FROM " + Value + " WHERE l_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                         str = "SELECT avg(l_risk) FROM " + Value + " WHERE l_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                    else {
                        str = "SELECT avg(l_risk) FROM " + Value + " WHERE l_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND l_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                }
                else if (FunctionValue.equals("Standard Deviation")) {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                         str = "SELECT std(l_risk) FROM " + Value + " WHERE l_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                         str = "SELECT std(l_risk) FROM " + Value + " WHERE l_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                    else {
                        str = "SELECT std(l_risk) FROM " + Value + " WHERE l_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND l_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                }
                else if (FunctionValue.equals("Dispersion")) {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                         str = "SELECT sqrt(std(l_risk)) FROM " + Value + " WHERE l_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                         str = "SELECT sqrt(std(l_risk) FROM " + Value + " WHERE l_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                    else {
                        str = "SELECT sqrt(std(l_risk)) FROM " + Value + " WHERE l_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND l_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                }
                else {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                        str = "SELECT * FROM " + Value + " WHERE l_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                        str = "SELECT * FROM " + Value + " WHERE l_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                    else {
                        str = "SELECT * FROM " + Value + " WHERE l_risk BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND l_risk NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                }
           }
           else if (ListValue.equals("Period")) {
                if (ExFrom.equals("") || ExTo.equals("")) {
                    str = "SELECT * FROM " + Value + " WHERE l_period BETWEEN "
                    + IncFrom + " AND " + IncTo + ";";
                }
                else if (IncFrom.equals("") || IncTo.equals("")) {
                    str = "SELECT * FROM " + Value + " WHERE l_period NOT BETWEEN "
                    + ExFrom + " AND " + ExTo + ";";
                }
                else {
                    str = "SELECT * FROM " + Value + " WHERE l_period BETWEEN "
                    + IncFrom + " AND " + IncTo + " AND l_period NOT BETWEEN "
                    + ExFrom + " AND " + ExTo + ";";
                }
           }
           else if (ListValue.equals("Date")) {
                if (ExFrom.equals("") || ExTo.equals("")) {
                   str = "SELECT * FROM " + Value + " WHERE l_date BETWEEN '"
                    + IncFrom + "' AND '" + IncTo + "';";
                }
                else if (IncFrom.equals("") || IncTo.equals("")) {
                    str = "SELECT * FROM " + Value + " WHERE l_date NOT BETWEEN '"
                    + ExFrom + "' AND '" + ExTo + "';";
                }
                else {
                    str = "SELECT * FROM " + Value + " WHERE l_date BETWEEN '"
                    + IncFrom + "' AND '" + IncTo + "' AND l_date NOT BETWEEN '"
                    + ExFrom + "' AND '" + ExTo + "';";
                }
           }
           else if (ListValue.equals("Sale Value")) {
                if (FunctionValue.equals("Average")) {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                        str = "SELECT avg(sale_value) FROM " + Value + " WHERE sale_value BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                        str = "SELECT avg(sale_value) FROM " + Value + " WHERE sale_value NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                    else {
                        str = "SELECT avg(sale_value) FROM " + Value + " WHERE sale_value BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND sale_value NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                }
                else if (FunctionValue.equals("Standard Deviation")) {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                         str = "SELECT std(sale_value) FROM " + Value + " WHERE sale_value BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                         str = "SELECT std(sale_value) FROM " + Value + " WHERE sale_value NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                    else {
                        str = "SELECT std(sale_value) FROM " + Value + " WHERE sale_value BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND sale_value NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                }
                else if (FunctionValue.equals("Dispersion")) {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                         str = "SELECT sqrt(std(sale_value)) FROM " + Value + " WHERE sale_value BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                         str = "SELECT sqrt(std(sale_value)) FROM " + Value + " WHERE sale_value NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                    else {
                        str = "SELECT sqrt(std(sale_value)) FROM " + Value + " WHERE sale_value BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND sale_value NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                }
                else {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                         str = "SELECT * FROM " + Value + " WHERE sale_value BETWEEN "
                        + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                         str = "SELECT * FROM " + Value + " WHERE sale_value NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                    else {
                        str = "SELECT * FROM " + Value + " WHERE sale_value BETWEEN "
                        + IncFrom + " AND " + IncTo + " AND sale_value NOT BETWEEN "
                        + ExFrom + " AND " + ExTo + ";";
                    }
                }
           }
           else if (ListValue.equals("Rate Type")) {
                str = "SELECT * FROM " + Value + " WHERE rate_type LIKE '" + Txt + "';";
           }
           else if (ListValue.equals("Situation")) {
                str = "SELECT * FROM " + Value + " WHERE situation LIKE '" + Txt + "';";
           }
           else if (ListValue.equals("Loan Type")) {
                str = "SELECT * FROM " + Value + " WHERE l_type LIKE '" + Txt + "';";
           }
           else {
                str = "SELECT * FROM " + Value + " WHERE mortgage_prop LIKE '" + Txt + "';";
           }
        }



        System.out.print("to query einai"+str);

        QueryResult=lp.Do_DB_Query(str);
        return QueryResult;
    }


    @SuppressWarnings("unchecked")
	public ArrayList<String> doOrganize(String ListValue, String IncFrom, String IncTo, String ExFrom, String ExTo, String selection) {
        ArrayList<String> QueryResult=new ArrayList<String>();
        String str = null;

        if(IncFrom.length()==0 && IncTo.length()==0 && ExFrom.length()==0 && ExTo.length()==0){
            if(selection.equals("All"))
                str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID order by "+ListValue;
            else if (selection.equals("Preselected Loans"))
                str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and preselected = true order by " +ListValue;
            else
                str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and preselected = false order by " +ListValue;
        }
        else{

        if (ListValue.equals("Amount")) {
               if (selection.equals("All")) {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                       str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and amount BETWEEN "
                       + IncFrom + " AND " + IncTo + ";";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                       str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and amount NOT BETWEEN "
                       + ExFrom + " AND " + ExTo + ";";
                    }

                    else {
                       str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and amount BETWEEN "
                       + IncFrom + " AND " + IncTo + " AND amount NOT BETWEEN "
                       + ExFrom + " AND " + ExTo + ";";
                    }
              }
              else if (selection.equals("Preselected Loans")) {
                   if (ExFrom.equals("") || ExTo.equals("")) {
                       str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and amount BETWEEN "
                       + IncFrom + " AND " + IncTo + " AND Preselected = true ;";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                       str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and amount NOT BETWEEN "
                       + ExFrom + " AND " + ExTo +  " AND Preselected = true ;";
                    }

                    else {
                       str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and amount BETWEEN "
                       + IncFrom + " AND " + IncTo + " AND amount NOT BETWEEN "
                       + ExFrom + " AND " + ExTo +  " AND Preselected = true ;";
                    }
              }
              else {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                       str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and amount BETWEEN "
                       + IncFrom + " AND " + IncTo + " AND Preselected = false ;";
                    }
                    else if (IncFrom.equals("") || IncTo.equals("")) {
                       str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and amount NOT BETWEEN "
                       + ExFrom + " AND " + ExTo +  " AND Preselected = false ;";
                    }

                    else {
                       str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and amount BETWEEN "
                       + IncFrom + " AND " + IncTo + " AND amount NOT BETWEEN "
                       + ExFrom + " AND " + ExTo +  " AND Preselected = false ;";
                    }
              }
        }
        if (ListValue.equals("Rate")){
               if (selection.equals("All")) {
                   if (ExFrom.equals("") || ExTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and rate BETWEEN "
                      + IncFrom + " AND " + IncTo + ";";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and rate NOT BETWEEN "
                      + ExFrom + " AND " + ExTo + ";";
                   }
                   else {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and rate BETWEEN "
                      + IncFrom + " AND " + IncTo + " AND rate NOT BETWEEN "
                      + ExFrom + " AND " + ExTo + ";";
                   }
               }
               else if (selection.equals("Preselected Loans")) {
                   if (ExFrom.equals("") || ExTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and rate BETWEEN "
                      + IncFrom + " AND " + IncTo + " AND Preselected = true ;";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and rate NOT BETWEEN "
                      + ExFrom + " AND " + ExTo + " AND Preselected = true ;";
                   }
                   else {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and rate BETWEEN "
                      + IncFrom + " AND " + IncTo + " AND rate NOT BETWEEN "
                      + ExFrom + " AND " + ExTo + " AND Preselected = true ;";
                   }
               }
               else {
                   if (ExFrom.equals("") || ExTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and rate BETWEEN "
                      + IncFrom + " AND " + IncTo + " AND Preselected = false ;";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and rate NOT BETWEEN "
                      + ExFrom + " AND " + ExTo + " AND Preselected = false ;";
                   }
                   else {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and rate BETWEEN "
                      + IncFrom + " AND " + IncTo + " AND rate NOT BETWEEN "
                      + ExFrom + " AND " + ExTo + " AND Preselected = false ;";
                   }
               }
         }
         if (ListValue.equals("Date")){
             if (selection.equals("All")) {
                   if (ExFrom.equals("") || ExTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_date BETWEEN "
                     +"'"+ IncFrom +"'"+ " AND " + "'"+ IncTo +"'"+ ";";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_date NOT BETWEEN "
                     +"'" + ExFrom +"'"+ " AND " + "'"+ ExTo +"'"+ ";";
                   }
                   else {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_date BETWEEN "
                      +"'"+ IncFrom +"'"+ " AND " +"'"+ IncTo +"'"+ " AND l_date NOT BETWEEN "
                      +"'"+ ExFrom  +"'"+ " AND " +"'"+ ExTo + "'"+";";
                   }
              }
             else if (selection.equals("Preselected Loans")) {
                  if (ExFrom.equals("") || ExTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_date BETWEEN "
                     +"'"+ IncFrom +"'"+ " AND " + "'"+ IncTo +"'"+ " AND Preselected = true ;";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_date NOT BETWEEN "
                     +"'" + ExFrom +"'"+ " AND " + "'"+ ExTo +"'"+ " AND Preselected = true ;";
                   }
                   else {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_date BETWEEN "
                      +"'"+ IncFrom +"'"+ " AND " +"'"+ IncTo +"'"+ " AND l_date NOT BETWEEN "
                      +"'"+ ExFrom  +"'"+ " AND " +"'"+ ExTo + "'"+" AND Preselected = true ;";
                   }
              }
             else {
                if (ExFrom.equals("") || ExTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_date BETWEEN "
                     +"'"+ IncFrom +"'"+ " AND " + "'"+ IncTo +"'"+ " AND Preselected = false ;";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_date NOT BETWEEN "
                     +"'" + ExFrom +"'"+ " AND " + "'"+ ExTo +"'"+ " AND Preselected = false ;";
                   }
                   else {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_date BETWEEN "
                      +"'"+ IncFrom +"'"+ " AND " +"'"+ IncTo +"'"+ " AND l_date NOT BETWEEN "
                      +"'"+ ExFrom  +"'"+ " AND " +"'"+ ExTo + "'"+" AND Preselected = false ;";
                   }
              }
        }
        if (ListValue.equals("Borrower")){
            if (selection.equals("All")) {
                   if (ExFrom.equals("") || ExTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and b_name BETWEEN "
                     +"'"+ IncFrom +"'"+ " AND " + "'"+ IncTo +"'"+ ";";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and b_name NOT BETWEEN "
                     +"'" + ExFrom +"'"+ " AND " + "'"+ ExTo +"'"+ ";";
                   }
                   else {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and b_name BETWEEN "
                      +"'"+ IncFrom +"'"+ " AND " +"'"+ IncTo +"'"+ " AND b_name NOT BETWEEN "
                      +"'"+ ExFrom  +"'"+ " AND " +"'"+ ExTo + "'"+";";
                   }
             }
            else if (selection.equals("Preselected Loans")) {
                if (ExFrom.equals("") || ExTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and b_name BETWEEN "
                     +"'"+ IncFrom +"'"+ " AND " + "'"+ IncTo +"'"+ " AND Preselected = true ;";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and b_name NOT BETWEEN "
                     +"'" + ExFrom +"'"+ " AND " + "'"+ ExTo +"'"+ " AND Preselected = true ;";
                   }
                   else {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and b_name BETWEEN "
                      +"'"+ IncFrom +"'"+ " AND " +"'"+ IncTo +"'"+ " AND b_name NOT BETWEEN "
                      +"'"+ ExFrom  +"'"+ " AND " +"'"+ ExTo + "'"+" AND Preselected = true ;";
                   }
            }
            else {
                if (ExFrom.equals("") || ExTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and b_name BETWEEN "
                     +"'"+ IncFrom +"'"+ " AND " + "'"+ IncTo +"'"+ " AND Preselected = false ;";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and b_name NOT BETWEEN "
                     +"'" + ExFrom +"'"+ " AND " + "'"+ ExTo +"'"+ " AND Preselected = false ;";
                   }
                   else {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and b_name BETWEEN "
                      +"'"+ IncFrom +"'"+ " AND " +"'"+ IncTo +"'"+ " AND b_name NOT BETWEEN "
                      +"'"+ ExFrom  +"'"+ " AND " +"'"+ ExTo + "'"+" AND Preselected = false ;";
                   }
            }
        }
        if (ListValue.equals("Loaner")){
               if (selection.equals("All")) {
                   if (ExFrom.equals("") || ExTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_name BETWEEN "
                     +"'"+ IncFrom +"'"+ " AND " + "'"+ IncTo +"'"+ ";";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_name NOT BETWEEN "
                     +"'" + ExFrom +"'"+ " AND " + "'"+ ExTo +"'"+ ";";
                   }
                   else {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_name BETWEEN "
                      +"'"+ IncFrom +"'"+ " AND " +"'"+ IncTo +"'"+ " AND l_name NOT BETWEEN "
                      +"'"+ ExFrom  +"'"+ " AND " +"'"+ ExTo + "'"+";";
                   }
               }
               else if (selection.equals("Preselected Loans")) {
                   if (ExFrom.equals("") || ExTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_name BETWEEN "
                     +"'"+ IncFrom +"'"+ " AND " + "'"+ IncTo +"'"+ " AND Preselected = true ;";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_name NOT BETWEEN "
                     +"'" + ExFrom +"'"+ " AND " + "'"+ ExTo +"'"+ " AND Preselected = true ;";
                   }
                   else {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_name BETWEEN "
                      +"'"+ IncFrom +"'"+ " AND " +"'"+ IncTo +"'"+ " AND l_name NOT BETWEEN "
                      +"'"+ ExFrom  +"'"+ " AND " +"'"+ ExTo + "'"+" AND Preselected = true ;";
                   }
               }
               else {
                    if (ExFrom.equals("") || ExTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_name BETWEEN "
                     +"'"+ IncFrom +"'"+ " AND " + "'"+ IncTo +"'"+ " AND Preselected = false ;";
                   }
                   else if (IncFrom.equals("") || IncTo.equals("")) {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_name NOT BETWEEN "
                     +"'" + ExFrom +"'"+ " AND " + "'"+ ExTo +"'"+ " AND Preselected = false ;";
                   }
                   else {
                      str = "SELECT DISTINCT Amount,Rate,l_date,B_name,L_name,L_type FROM LOAN,l_has_b,l_provides_l,Borrower,Loaner where loanid=h_loanID and h_bID=b_ID and loanID=p_loanID and p_loanerID=loanerID and l_name BETWEEN "
                      +"'"+ IncFrom +"'"+ " AND " +"'"+ IncTo +"'"+ " AND l_name NOT BETWEEN "
                      +"'"+ ExFrom  +"'"+ " AND " +"'"+ ExTo + "'"+" AND Preselected = false ;";
                  }
             }
        }
        }
        System.out.println(str);
        QueryResult=lp.Do_DB_Query(str);
        return QueryResult;
   }


    @SuppressWarnings("unchecked")
	public ArrayList<String> doSearch(String A,String R,String RD,String B,String L,String LT) {
        int i=0,f1=0,f2=0;
        ArrayList<String> query_args = new ArrayList<String>();
        ArrayList<String> QueryResult=new ArrayList<String>();
        String str=null;

        if(B.length()!=0 && L.length()!=0 && f1==0 && f2==0){

            f1=1;
            f2=1;
            str="SELECT loanID,amount,rate,rate_type,l_date,l_period,l_type,sale_value,situation,l_risk,mortgage_prop FROM loan,l_has_b,l_provides_l,Borrower,Loaner where ";
            if(A.length()!=0)
            {
                query_args.add(i,"Amount = "+A);
                i++;
            }
            if(R.length()!=0)
            {
                query_args.add(i," Rate >= "+R +"and Rate <=" +R +"+0.1");
                i++;
            }
            if(B.length()!=0)
            {
                query_args.add(i,"loanID=h_loanID and h_bID= b_ID and loanID=p_loanID and b_name =" + "'" + B + "'");
                i++;
            }
            if(L.length()!=0)
            {
                query_args.add(i," l_name =" + "'" + L + "'");
                i++;

            }
            if(RD.length()!=0)
            {
                query_args.add(i," l_date = "+ "'" +RD +"'");
                i++;
            }
            if(LT.length()!=0)
            {
                query_args.add(i," l_type = "+ "'" +LT+ "'");
                i++;
            }
        }
      //  SELECT * FROM loan,l_provides_l,Loaner where
        if(B.length()==0 && L.length()!=0){
            i=0;
            f1=1;
            str="SELECT loanID,amount,rate,rate_type,l_date,l_period,l_type,sale_value,situation,l_risk,mortgage_prop FROM loan,l_provides_l,Loaner where ";
            if(A.length()!=0)
            {
                query_args.add(i,"Amount = "+A);
                i++;
            }
            if(R.length()!=0)
            {
                query_args.add(i," Rate >= "+R +"and Rate <=" +R +"+0.1");
                i++;
            }
            if(L.length()!=0)
            {
                query_args.add(i,"loanID=p_loanID and loanerID= p_loanerID and l_name= " + "'" + L + "'");
                i++;
            }
            if(RD.length()!=0)
            {
                query_args.add(i," l_date = "+ "'" +RD +"'");
                i++;
            }
            if(LT.length()!=0)
            {
                query_args.add(i," l_type = "+ "'" +LT+ "'");
                i++;
            }
        }

        if(B.length()!=0 && L.length()==0){
            i=0;
            f2=1;
            str="SELECT loanID,amount,rate,rate_type,l_date,l_period,l_type,sale_value,situation,l_risk,mortgage_prop FROM loan,l_has_b,Borrower where ";
            if(A.length()!=0)
            {
                query_args.add(i,"Amount = "+A);
                i++;
            }
            if(R.length()!=0)
            {
                query_args.add(i," Rate >= "+R +"and Rate <=" +R +"+0.1");
                i++;
            }
            if(B.length()!=0)
            {
                query_args.add(i,"loanID=h_loanID and h_bID= b_ID and b_name= " + "'" + B + "'");
                i++;
            }
            if(RD.length()!=0)
            {
                query_args.add(i," l_date = "+ "'" +RD +"'");
                i++;
            }
            if(LT.length()!=0)
            {
                query_args.add(i," l_type = "+ "'" +LT+ "'");
                i++;
            }
        }
        if(B.length()==0 && L.length()==0){
             i=0;
            str="SELECT loanID,amount,rate,rate_type,l_date,l_period,l_type,sale_value,situation,l_risk,mortgage_prop FROM loan where ";
            if(A.length()!=0)
            {
                query_args.add(i,"Amount = "+A);
                i++;
            }
            if(R.length()!=0)
            {
                query_args.add(i," Rate >= "+R +"and Rate <=" +R +"+0.1");
                i++;
            }
            if(RD.length()!=0)
            {
                query_args.add(i," l_date = "+ "'" +RD +"'");
                i++;
            }
            if(LT.length()!=0)
            {
                query_args.add(i," l_type = "+ "'" +LT+ "'");
                i++;
            }
        }


        ListIterator<String> litr =query_args.listIterator();
        while(litr.hasNext()){
            String element = litr.next();
            str=str+element;
            System.out.println(element);
            if(litr.hasNext())
                str=str+" and";
        }
        System.out.println(str);
      QueryResult=lp.Do_DB_Query(str);

        return QueryResult;
    }

    @SuppressWarnings("unchecked")
	public void doUpdatePortfolio(File selectedFile, BufferedReader reader) throws IOException{
        String fileName = selectedFile.getName().toString();
        String SearchQuery = null,s_borrower=null,s_loan=null ;
        ArrayList<String> QueryResult = new ArrayList<String>();
        String Screen_str=null;
        String FinalQueries[]=new String[1500];
        int FQ_count=0,danger=0;
        int length = fileName.length();
        String name = fileName.substring(0, (length - 4));
        String extension = fileName.substring(name.length(), length);

        if (!extension.equals(".bnk"))
        {
            ExceptionWindow d=new ExceptionWindow("Unsupported file extension");
            d.setVisible(true);
            return;
        }

        SearchQuery = "SELECT loanerID FROM Loaner WHERE l_name like '" + name + "';";
        QueryResult = lp.Do_DB_Query(SearchQuery);
        if(QueryResult.size() == 0)
        {
            ExceptionWindow d=new ExceptionWindow("Loaner doesn't exist");
            d.setVisible(true);
            return;
        }
       
        String inLine = reader.readLine();
        //System.out.print("inLIne"+inLine);
         String l_id=QueryResult.get(0);
        if (!inLine.equals("NEW LOANS") ||inLine.equals(null))
        {
            ExceptionWindow d=new ExceptionWindow("Wrong file format");
            d.setVisible(true);
            return;
        }
        
        Screen_str="\n";
        inLine = reader.readLine();
        while (!inLine.equals("END"))
        {
            String tmp=null;
            @SuppressWarnings("unused")
			String b[]= new String[11];
            String a[]= new String[3];
            int num_of_ok_loans = 0,num_of_d_loans = 0,num_of_fd_loans=0;
            //int danger=50;
            if (inLine.substring(0,14).equals("\t<LOAN RECORD>"))
            {
                inLine = reader.readLine(); /*will read "BORROWER"*/
                if(inLine.substring(2,10).equals("BORROWER"))
                {
                    s_borrower=inLine.substring(11,inLine.length());
                    a=s_borrower.split(",");
                }
                inLine = reader.readLine(); /*Will read "LOAN"*/
                if(inLine.substring(2,6).equals("LOAN"))
                {
                    s_loan= inLine.substring(7,inLine.length());
                    b=s_loan.split(",");
                }
                inLine = reader.readLine(); /*WILL READ "<LOAN RECORD END>"*/
                inLine =reader.readLine();  /*will consume "<LOAN RECORD END>"*/
            }
            String str="select EXTRACT(YEAR FROM CURDATE())-EXTRACT(YEAR FROM l_date) AS Years_Passed from loan,l_has_b where loanID=h_loanID and h_bID = "+ a[0] +" and situation = 'UpToDate';";
            QueryResult=lp.Do_DB_Query(str);
            if(!QueryResult.isEmpty())
            {
                tmp=QueryResult.get(0);
                num_of_ok_loans=Integer.parseInt(tmp);
            }
            str="select EXTRACT(YEAR FROM CURDATE())-EXTRACT(YEAR FROM l_date) AS Years_Passed from loan,l_has_b where loanID=h_loanID and h_bID = "+ a[0] +" and situation = 'Delayed';";
            QueryResult=lp.Do_DB_Query(str);
            if(!QueryResult.isEmpty())
            {
                tmp=QueryResult.get(0);
                num_of_d_loans=Integer.parseInt(tmp);
            }
            str="select EXTRACT(YEAR FROM CURDATE())-EXTRACT(YEAR FROM l_date) AS Years_Passed from loan,l_has_b where loanID=h_loanID and h_bID = "+ a[0] +" and situation = 'Full_Delayed';";
            QueryResult=lp.Do_DB_Query(str);
            if(!QueryResult.isEmpty())
            {
                tmp=QueryResult.get(0);
                num_of_fd_loans=Integer.parseInt(tmp);
            }
            danger=50 - (num_of_ok_loans*10) + (20*num_of_d_loans) + (30*num_of_fd_loans);
            str="UPDATE BORROWER SET b_risk = " +danger+ " where b_ID = "+a[0]+";" ;
            FinalQueries[FQ_count]=str;FQ_count++;
            Screen_str=Screen_str+"Will change risk of borrower id "+a[0]+ " to " +danger +"\n";
        }

        /*Final lquery must be updated*/
        inLine=reader.readLine();
        if (!inLine.equals("UPDATE LOANS"))
        {
            ExceptionWindow d=new ExceptionWindow("Unsupported file extension");
            d.setVisible(true);
            return;
        }
        inLine=reader.readLine();
        while (!inLine.equals("END"))
        {
            if (!inLine.substring(0,21).equals("\t<LOAN UPDATE RECORD>"))
            {
                ExceptionWindow d=new ExceptionWindow("Unsupported file extension");
                d.setVisible(true);
                return;
            }
            if (inLine.substring(0,21).equals("\t<LOAN UPDATE RECORD>"))
            {
                    String b[]= new String[11];
                    inLine = reader.readLine(); /*will read "LOAN"*/
                    if(inLine.substring(2,6).equals("LOAN"))
                    {
                        s_loan= inLine.substring(7,inLine.length());
                        b=s_loan.split(",");
                        if(b[3].equals("floating"));
                            String str="UPDATE Loan SET rate = "+b[2]+ " where rate_type = 'floating' and loanID in (SELECT p_loanID from  l_provides_l WHERE p_loanerID = " + l_id + ");";
                            FinalQueries[FQ_count]=str; FQ_count++;
                            Screen_str=Screen_str+" Will change the rate of loan(floating rate_type)  with l_ID "+b[0]+" to "+ b[2] +"\n";
                            str="UPDATE Loan SET Situation ="+ "'"+b[8]+"'" + " where loanID = "+b[0];
                            FinalQueries[FQ_count]=str; FQ_count++;
                            Screen_str=Screen_str+"Will change the situation of loan with l_ID " +b[0] +" to " + b[8] +"\n";
                    }
                    inLine = reader.readLine(); /*WILL READ "<LOAN RECORD END>"*/
                    inLine =reader.readLine();  /*will consume "<LOAN RECORD END>"*/
            }
          

        }
        inLine = reader.readLine();
        if (!inLine.equals("BOUGHT LOANS"))
        {
                ExceptionWindow d=new ExceptionWindow("Unsupported file format");
                d.setVisible(true);
                return;
        }
        inLine = reader.readLine();
        while (!inLine.equals("END"))
        {
                if (!inLine.substring(0,21).equals("\t<LOAN BOUGHT RECORD>"))
                {
                ExceptionWindow d=new ExceptionWindow("Unsupported file format");
                d.setVisible(true);
                return;
                }
                if (inLine.substring(0,21).equals("\t<LOAN BOUGHT RECORD>"))
                {
                    String str;
                    inLine = reader.readLine(); /*will read "BORROWER"*/
                    String b[]= new String[11];
                    String a[]= new String[3];
                    if (!(inLine.substring(2,10).equals("BORROWER")))
                    {
                        ExceptionWindow d=new ExceptionWindow("Unsupported file format");
                        d.setVisible(true);
                        return;
                    }
                    if(inLine.substring(2,10).equals("BORROWER"))
                    {
                           s_borrower=inLine.substring(11,inLine.length());
                           a=s_borrower.split(",");
                           str="Select * from borrower where b_ID ="+a[0];
                           QueryResult = lp.Do_DB_Query(str);
                           if(QueryResult.size()==0)
                           {
                                str="Insert into Borrower values " +"(" +  a[0]  + ","+ "'"+a[1]+"'" + ","+a[2] + ")"+ ";" ;
                                FinalQueries[FQ_count]=str; FQ_count++;
                                Screen_str=Screen_str+"Will Insert new Borrower with id:" +a[0] +", name:"+a[1]+",and borower risk:"+a[2] +"\n";
                           }

                     }
                     inLine = reader.readLine(); /*Will read "LOAN"*/
                     if(!inLine.substring(2,6).equals("LOAN"))
                     {
                          ExceptionWindow d=new ExceptionWindow("Unsupported file format");
                          d.setVisible(true);
                          return;
                     }
                     if(inLine.substring(2,6).equals("LOAN"))
                     {
                           s_loan= inLine.substring(7,inLine.length());
                           b=s_loan.split(",");
                           str="Select * from loan where loanID ="+b[0];
                           QueryResult = lp.Do_DB_Query(str);
                           if(QueryResult.size()==0)
                           {
                                str="Insert into loan values " +"("
                                + b[0] +"," + b[1] + "," + b[2] + "," +"'"+ b[3]+"'"
                                + "," +"'"+ b[4]+"'" + "," + b[5] + "," +"'"+ b[6]+"'" + "," + b[7]
                                + "," +"'"+ b[8]+"'" + "," + b[9] + "," +"'"+ b[10]+"'" +","+ "'"+b[11]+"'" +")"+";" ;
                                FinalQueries[FQ_count]=str; FQ_count++;
                                Screen_str=Screen_str+"Will Insert new loan with id:" +b[0]  +"\n";
                           }
                     }
                     str="insert into l_has_b values"+"("+b[0]+","+a[0]+")" +";" ;
                     FinalQueries[FQ_count]=str; FQ_count++;
                     str="insert into l_provides_l values" +"("+b[0]+","+l_id +")" +";" ;
                     FinalQueries[FQ_count]=str; FQ_count++;//p.Do_DB_Update(str);
                     inLine = reader.readLine(); /*WILL READ "<LOAN RECORD END>"*/
                     inLine =reader.readLine();  /*will consume "<LOAN RECORD END>"*/
               }
       }
       ValidateChangesWindow a=new ValidateChangesWindow(FinalQueries,FQ_count,Screen_str);
       a.setVisible(true);
   }

   public void doUpdate(String b[],int count) throws IOException{
       int i;
       String a[]=b;
       for(i=0;i<count;i++)
       {
           System.out.println(a[i]);
           lp.Do_DB_Update(a[i]);
           //System.in.read();
           
       }

       MessageWindow d= new MessageWindow("System Update","Update Successfull");
       d.setVisible(true);

       return;
   }


    public void doPackageLoan(String s, boolean b){
        String str = null;

        if(b == true)
            str = "UPDATE Loan SET preselected = true WHERE loanID = "+s+";";
        else if(b == false)
            str = "UPDATE Loan SET preselected = false WHERE loanID = "+s+";";

        lp.Do_DB_Update(str);

    }


    @SuppressWarnings("unchecked")
	public ArrayList<String> packageLoanAutoSearch(String q){
        ArrayList<String> QueryResult = new ArrayList<String>();

        QueryResult = lp.Do_DB_Query(q);
        return QueryResult;
    }


    @SuppressWarnings("unchecked")
	public ArrayList<String> packageLoadLoanList(){
//        int j=0,i=0;
        ArrayList<String> QueryResult = new ArrayList<String>();

        String str="SELECT loanID,amount,rate,rate_type,l_date,l_period,l_type,sale_value,situation,l_risk,mortgage_prop FROM Loan WHERE preselected = false";
        QueryResult = lp.Do_DB_Query (str);

        return QueryResult;

    }

    @SuppressWarnings("unchecked")
	public ArrayList<String> doOptimization(String minProfit, String maxRisk, String repPeriod,boolean emptyTable2,String tmpArr[]) {
        ArrayList<String> QueryResult = new ArrayList<String>();
        String str = null;
        if(emptyTable2 == true)
            str = "select loanID,amount,rate,rate_type,l_date,l_period,l_type,sale_value,situation, sum((amount - ((EXTRACT(YEAR FROM CURDATE())-EXTRACT(YEAR FROM l_date))* amount/l_period))*l_risk)/sum(amount - ((EXTRACT(YEAR FROM CURDATE())-EXTRACT(YEAR FROM l_date))* amount/l_period)) AS packRisk,mortgage_prop from loan where l_period < "+repPeriod+" and preselected = false group by loanID having packRisk<"+maxRisk+" and sum(amount)>sum(amount)*"+minProfit+"/100;";
        else if(emptyTable2 == false){
            str = "select loanID,amount,rate,rate_type,l_date,l_period,l_type,sale_value,situation, sum((amount - ((EXTRACT(YEAR FROM CURDATE())-EXTRACT(YEAR FROM l_date))* amount/l_period))*l_risk)/sum(amount - ((EXTRACT(YEAR FROM CURDATE())-EXTRACT(YEAR FROM l_date))* amount/l_period)) AS packRisk,mortgage_prop from loan where l_period < "+repPeriod+" and preselected = true and loanID in (";
            int j=0;
            for(j=0; j<tmpArr.length; j++){
                if(j+1 < tmpArr.length)
                    str = str+tmpArr[j]+",";
                else
                    str = str+tmpArr[j]+") ";
            }
            str = str+ "group by loanID having packRisk<"+maxRisk+" and sum(amount)>sum(amount)*"+minProfit+"/100;";
        }
        QueryResult = lp.Do_DB_Query(str);

        return QueryResult;
    }

    void doAccept(String[] tempArr) {
        String str = null;
        
        for(int i=0; i<tempArr.length; i++){
           str = "Delete from Loan Where LoanID = "+tempArr[i]+";";
           
           lp.Do_DB_Update(str);
           String str2 = "Delete from l_has_b Where h_loanID = "+tempArr[i]+";";
           lp.Do_DB_Update(str2);
        }

    }

}
