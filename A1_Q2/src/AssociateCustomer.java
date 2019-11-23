
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 33220079
 * @filename AssociateCustomer
 */
public class AssociateCustomer extends Customer{
    
    private ArrayList<String> paying;
    private double suppcost;
    AssociateCustomer(){//constructor
        
    }
    
    AssociateCustomer(String n, String e, String YN,ArrayList<String> paycustname, double sc){//constructor with parameter
        super(n, e, YN);
        this.paying = paycustname;
        suppcost = sc;
    }

    public ArrayList<String> GetPayingCust()// get method for pyaing customer array
    {
        return new ArrayList<>(paying);
    }
    
    public void SetPayingCust(ArrayList<String> str) // set method for pyaing customer array
    {
        paying = str;
    }
    
    public double getSuppCost(){// get method for supplement cost
        return suppcost;
    }
    
    public void setSuppCost(double s){// set method for supplement cost
        suppcost = s;
    }
}
