
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 33220079
 * @filename PayingCustomer
 */
public class PayingCustomer extends Customer{
    
    private ArrayList<String> associates;
    private String paym, accnum;
    private double supsum;
    private double assoMCost;
    private double assoSCost;
    private double totalcost;
    
    PayingCustomer(){//constructor
        
    }
    
    public PayingCustomer(String n, String e, String YN, ArrayList<String> assoc, double ss, double amc, double asc, double tc, String pm, String num)//constructor with parameter
    {
        super(n, e, YN);
        paym = pm;
        accnum = num;
        this.associates = assoc;
        supsum = ss;
        assoMCost = amc;
        assoSCost = asc;
        totalcost = tc;
    }
    
    public ArrayList<String> GetAssociates()// get method for associates array
    {
        return new ArrayList<>(associates);
    }
    
    public void SetAssociates(ArrayList<String> str){// set method for Associates array
        associates = str;
    }
    
    public double getAssoMCost(){// get method for associate customer magazine cost
        return assoMCost;
    }
    
    public void setAssoMCost(double sas){// set method for associate customer magazine cost
        assoMCost = sas;
    }
    
     public double getAssoSCost(){// get method for associate customer supplement cost
        return assoSCost;
    }
    
    public void setAssoSCost(double as){// set method for associate customer supplement cost
        assoSCost = as;
    }
    
    public double getSupSum(){// get method for supplement cost
        return supsum;
    }
    
    public void setSupSum(double sas){// set method for supplement cost
        supsum = sas;
    }
    
    public double getTotalCost(){// get method for total cost
        return totalcost;
    }
    
    public void setTotalCost(double sas){// set method for total cost
        totalcost = sas;
    }

    public String getPayMethod(){// get method for payment method
        return paym;
    }
    
    public void setPayMethod(String spm){// set method for payment method
        paym = spm;
    }
    
    public String getAccNum(){// get method for credit card number or account number
        return accnum;
    }
    
    public void setAccNum(String san){// set method for credit card number or account number
        accnum = san;
    }
}
