/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
* @author 33220079
* @filename Supplement
 */
public class Supplement{
    
    private String emailAdd, supplements;
    double scost;
    
    Supplement(){//constructor
        
    }
    
    Supplement(String e, String s, double cost){//constructor with parameter
        emailAdd = e;
        supplements = s;
        scost = cost;
    }
    
    public void setSupplement(String ss){// set method for supplement
        supplements = ss;
    }
    
    public String getSupplement(){// get method for supplement
        return supplements;
    }
    
    public void setEmail(String ee){// set method for email address
        emailAdd = ee;
    }
    
    public  String getEmailAdd(){// get method for email address
        return emailAdd;
    }
    
    public void setSCost(double cc){// set method for supplement cost
        scost = cc;
    }
    
    public double getSCost(){// get method for supplement cost
        return scost;
    }
}

