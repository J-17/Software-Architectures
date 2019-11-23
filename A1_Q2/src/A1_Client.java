
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @title Software Architectures Assignment 1 Question 2
 * @author 33220079
 * @date 14/4/2019
 * @filename A1_Client
 * @purpose The main purpose of this class is act as the client class and control
 * the program, which is able to called methods from other classes.The program should construct a magazine with an array of 3-4 supplements
 * with made-up details built in to the program. The program should construct an 
 * array of 5-6 different customers of various types with made-up details built 
 * in to the program. Moreover, the program should at least able to print out
 * the text of all the email for all customers for four weeks of magazines, print 
 * out the text for the end of month email for the paying customers, add a new 
 * customer to the magazine service, and remove an existing customer from the 
 * magazine service.
 * @assumptions The assumptions for this program is assuming that the user will
 * input the correct data type, if it is incorrect the program will alert the user
 * and re-prompt the program. Also, the data entered should be store in the correct
 * variables. Furthermore, the user are assumed to subscribe every week of the magazine
 * until they want to remove themselves from the magazine service. However, they are
 * allowed to choose the supplements. Moreover, assuming that there is four weeks 
 * in a month.
 */
public class A1_Client {    
    
    public static void main(String[] args) 
    {
        ArrayList <PayingCustomer> payingcust = new ArrayList<>(); //declare paying customer arraylist
        ArrayList <AssociateCustomer> assoccust = new ArrayList<>(); //declare associate customer arraylist
        ArrayList <Supplement> supp = new ArrayList<>();//declare paying customer arraylist
        
        // call method for hardcode code
        MagazineSer.CreatePayingCustomers(payingcust);
        MagazineSer.CreateAssociateCustomers(assoccust);
        MagazineSer.CreateSupplement(supp);
        
        Scanner kb = new Scanner (System.in);
        String s = "";
        
        MagazineSer.welcome();//print out welcome message
        
        while(true)
        {
            MagazineSer.printMenu(); // print menu
            
            s = kb.nextLine().toLowerCase();
            
            switch(s)
            {
                case "a": 
                    System.out.println("");
                    System.out.println("You chose to display all the emails for all customers for four weeks of magazine. ");
                    System.out.println("");
                    MagazineSer.generateWeeklyEmail(payingcust, supp, assoccust);
                    break;
                    
                case "b":
                    System.out.println("");
                    System.out.println("You chose to display the end of month emails for the paying customers. ");
                    System.out.println("");
                    MagazineSer.generateMonthlyEmail(payingcust, supp, assoccust);
                    break;
                        
                case "c":
                    System.out.println("");
                    System.out.println("You chose to add a new customer to the magazine service. ");
                    System.out.println("");
                    boolean flag = true;
                    while(flag){
                        System.out.println("Do you want to add a new paying customer or associate customer? (P/A)");
                        char pa = kb.nextLine().trim().toUpperCase().charAt(0);
                        if(pa == 'P'){
                            MagazineSer.addPayCust(payingcust, supp, assoccust);
                            flag = false;
                        }// end if
                        else if( pa == 'A'){
                            MagazineSer.addAssoCust(assoccust, payingcust, supp);
                            flag = false;
                        }//end else if
                        else{
                            System.out.println("Invalid input!");
                        }//end else
                    }//end while
                    break;
                                                
                case "d": 
                    System.out.println("");
                    System.out.println("You chose to remove an existing customer from the magazine service. ");
                    MagazineSer.removeCust(payingcust, assoccust,supp);
                    break;
                
                case "e": 
                    System.out.println("");
                    System.out.println("You chose to display all paying customers' details.");
                    MagazineSer.printPayingCust(payingcust, supp);
                    break;
                    
                case "f": 
                    System.out.println("");
                    System.out.println("You chose to display all associate customers' details.");
                    MagazineSer.printAssociateCust(assoccust, supp);
                    break;
                    
                case "q":
                    System.out.println("");
                    System.out.println("You chose to quit the program. ");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("");
                    System.out.println("Please enter option 'a', 'b', 'c', 'd', 'e', 'f', 'g' or 'q' only. ");
                    System.out.println("");
                    break;
            }//end switch
        }//end while
    }//end main
}//end class
