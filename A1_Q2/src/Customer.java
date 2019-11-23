
import java.util.Scanner;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 33220079
 * @filename Customer
 */
public class Customer {
    
    Scanner kb = new Scanner(System.in);
    
    private String custName, custEmailA, PayOrAsso;
    private double Mcost = 10;
    
    Customer(){//constructor
        
    }
    
    Customer(String name, String email, String YN){//constructor with parameter
        custName = name;
        custEmailA = email;
        PayOrAsso = YN;
    }
    
    public void setCustName(String n) throws MagazineSerEx // set method for customer name
    {
        if(n.matches("[a-zA-Z]+"))
        {
            custName = n;
        }else{
            throw new MagazineSerEx("Please enter characters only.");
        }
    }
    
    public String getCustName(){// get method for customer name
        return custName;
    }
    
    public void setCustEmailA(String e) throws MagazineSerEx// set method for customer email address
    {
        if(e.matches("^(.+)@(.+)$"))
        {
            custEmailA = e;
        }else{
            throw new MagazineSerEx("Please enter an appropriate email address.");
        }
    }
    
    public String getCustEmailA(){// get method for customer email address
        return custEmailA;
    }
    
    public void setCustType(String i){// set method for customer type
        PayOrAsso = i ;
    }
    
    public String getCustType(){// get method for customer type
        return PayOrAsso;
    }
    
    public void setMcost(double m){// set method for megazine cost
        Mcost = m;
    }
    
    public double getMcost(){// get method for magazine cost
        return Mcost;
    }
}
