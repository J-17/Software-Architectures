
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

/**
 *
 * @author 33220079
 * @filename MagazineSer
 * @purpose this class is the class that contain all the methods and being call 
 * to client class.
 */
public class MagazineSer {
    
    // print welcome message
    public static void welcome(){
        System.out.println("");
        System.out.println("**********************************************************");
        System.out.println("* Welcome to The Jo Magazine Online Subscription System! *");
        System.out.println("**********************************************************");
        System.out.println("");
    }
    
    //print menu
    public static void printMenu(){
        System.out.println("Menu: ");
        System.out.println("Enter 'a' to display all the emails for all customers for four weeks of magazine. ");
        System.out.println("Enter 'b' to display the end of month emails for the paying customers. ");
        System.out.println("Enter 'c' to add a new customer to the magazine service.");
        System.out.println("Enter 'd' to remove an existing customer from the magazine service.");
        System.out.println("Enter 'e' to display all paying customers' details. ");
        System.out.println("Enter 'f' to display all associate customers's details. ");
        System.out.println("Enter 'q' to exit the program. ");
        System.out.print("Enter a character: ");
    }
    
    // hardcode paying customer arraylist
    public static void CreatePayingCustomers(ArrayList<PayingCustomer> payingcust){
        payingcust.add(new PayingCustomer("STEVE","steve@gmail.com","PAYING CUSTOMER", new ArrayList<>(Arrays.asList("karen@gmail.com", "daren@gmail.com")), 8, 20,10, 48, "CREDIT CARD","332200"));
        payingcust.add(new PayingCustomer("MARY","mary@gmail.com","PAYING CUSTOMER", new ArrayList<>(Arrays.asList("jason@gmail.com")),14,10, 4,38, "CREDIT CARD", "332201"));
        payingcust.add(new PayingCustomer("AMY","amy@gmail.com","PAYING CUSTOMER", new ArrayList<>(Arrays.asList("sara@gmail.com")),5, 10, 0,25, "DIRECT DEBIT", "332202"));
        payingcust.add(new PayingCustomer("WILLIAM","william@gmail.com","PAYING CUSTOMER", new ArrayList<>(Arrays.asList("martin@gmail.com")), 7, 10,10, 37, "DIRECT DEBIT","332203"));
        payingcust.add(new PayingCustomer("VIVIAN","vivian@gmail.com","PAYING CUSTOMER", new ArrayList<>(Arrays.asList("sam@gmail.com")), 9, 10, 4,33, "CREDIT CARD", "332204"));
    }
    
    // hardcode associate customer arraylist
    public static void CreateAssociateCustomers(ArrayList<AssociateCustomer> assoccust){
        assoccust.add(new AssociateCustomer("KAREN","karen@gmail.com","ASSOCIATE CUSTOMER", new ArrayList<>(Arrays.asList("STEVE")),5));
        assoccust.add(new AssociateCustomer("DAREN","daren@gmail.com","ASSOCIATE CUSTOMER", new ArrayList<>(Arrays.asList("STEVE")),5));
        assoccust.add(new AssociateCustomer("SARA","sara@gmail.com","ASSOCIATE CUSTOMER", new ArrayList<>(Arrays.asList("AMY")),0));
        assoccust.add(new AssociateCustomer("MARTIN","martin@gmail.com","ASSOCIATE CUSTOMER", new ArrayList<>(Arrays.asList("WILLIAM")),10));
        assoccust.add(new AssociateCustomer("SAM","sam@gmail.com","ASSOCIATE CUSTOMER", new ArrayList<>(Arrays.asList("VIVIAN")),4));
        assoccust.add(new AssociateCustomer("JASON","jason@gmail.com","ASSOCIATE CUSTOMER", new ArrayList<>(Arrays.asList("MARY")),4));
    }

    //hardcode supplements arraylist
    public static void CreateSupplement(ArrayList<Supplement> supp){
        supp.add(new Supplement("steve@gmail.com","LIFESTYLE", 3));
        supp.add(new Supplement("steve@gmail.com","TRAVEL", 5));
        supp.add(new Supplement("mary@gmail.com","ENTERTAINMENT", 2));
        supp.add(new Supplement("mary@gmail.com","LIFESTYLE", 3));
        supp.add(new Supplement("mary@gmail.com","SPORT", 4));
        supp.add(new Supplement("mary@gmail.com","TRAVEL", 5));
        supp.add(new Supplement("amy@gmail.com","TRAVEL", 5));
        supp.add(new Supplement("william@gmail.com","LIFESTYLE", 3));
        supp.add(new Supplement("william@gmail.com","SPORT", 4));
        supp.add(new Supplement("vivian@gmail.com","ENTERTAINMENT", 2));
        supp.add(new Supplement("vivian@gmail.com","LIFESTYLE", 3));
        supp.add(new Supplement("vivian@gmail.com","SPORT", 4));
        supp.add(new Supplement("karen@gmail.com","TRAVEL", 5));
        supp.add(new Supplement("sara@gmail.com","None", 0));
        supp.add(new Supplement("daren@gmail.com","ENTERTAINMENT", 2));
        supp.add(new Supplement("daren@gmail.com","LIFESTYLE", 3));
        supp.add(new Supplement("martin@gmail.com","ENTERTAINMENT", 2));
        supp.add(new Supplement("martin@gmail.com","LIFESTYLE", 3));
        supp.add(new Supplement("martin@gmail.com","TRAVEL", 5));
        supp.add(new Supplement("sam@gmail.com","SPORT", 4));
    }
    
    // method for add new paying customer
    public static ArrayList<PayingCustomer> addPayCust(ArrayList<PayingCustomer> payingcust, ArrayList<Supplement> supp, ArrayList<AssociateCustomer> associatecust){
        Scanner kb = new Scanner(System.in);
        ArrayList<PayingCustomer> arraytemp = new ArrayList<>(); // create a temporary arraylist
        PayingCustomer objtemp = new PayingCustomer(); // create a temporary object
        boolean flag = true;
        
        while(flag){// Make sure user enter the name in chracters only characters 
            try{
                System.out.println("Enter name:");
                String name = kb.nextLine().trim().toUpperCase();
                objtemp.setCustName(name);
                flag = false;
            }
            catch(MagazineSerEx e){
                System.out.println(e.getMessage());
            }
        }
        flag = true;
        
        while(flag){// make sure user an appropiate email address
            try{
                System.out.println("Enter email address: ");
                 String email = kb.nextLine();
                 objtemp.setCustEmailA(email);
                 flag = false;
            }
            catch(MagazineSerEx e){
                System.out.println(e.getMessage());
            }
        }
        flag = true;
        
        objtemp.setCustType("PAYING CUSTOMER");
        
        while(flag){ // add on supplements
            System.out.println("Do you want to add on supplements for the magazine? (Y/N)");
            char ans = kb.nextLine().trim().toUpperCase().charAt(0);
            if(ans == 'Y'){
                printSupplementChoice();// print out supplements choice
                addSupp(objtemp.getCustEmailA(),supp);
                flag = false;
            }
            else if(ans == 'N'){
                  flag = false;      
            }
            else{
                System.out.println("Invalid input!");
            }
        }
        flag = true;
        
        while(flag){// let user enter payment method
            System.out.println("Please enter the paying method (enter 'CC' for credit card or 'DD' direct debit): ");
            String pm = kb.nextLine().trim().toUpperCase();
            if(pm.equalsIgnoreCase("CC") || pm.equalsIgnoreCase("DD")){
                if(pm.equalsIgnoreCase("CC")){
                    objtemp.setPayMethod("CREDIT CARD");
                }
                else{
                    objtemp.setPayMethod("DIRECT DEBIT");
                }
                System.out.println("Please enter credit card number or account number: ");
                String num = kb.nextLine();
                objtemp.setAccNum(num);
                flag = false;
            }
            else{
                System.out.println("Invalid input!");
            }
        }
        
        // default associate customer
        ArrayList<String> str = new ArrayList<String>(); 
        str.add("");
        objtemp.SetAssociates(str);
        
        // default Associate customer magazine cost
        double assoMsum = calcAssoMCost(objtemp.getCustEmailA(),objtemp.getMcost(),payingcust);
        objtemp.setAssoMCost(assoMsum);
        
        //calculate the supplement cost
        double supsum = calcSupCost(objtemp.getCustEmailA(), supp);
        objtemp.setSupSum(supsum);
        
        double assoSsum = calcAssoSCost(objtemp.getCustEmailA(),payingcust, supp, associatecust,0);
        objtemp.setAssoSCost(assoSsum);
        
        double totalcostw = calcTotalCost(objtemp.getMcost(), objtemp.getSupSum(),0,0);
        objtemp.setTotalCost(totalcostw);
        
        
        
        System.out.println("");
        System.out.println("Paying customer " + objtemp.getCustName() + " is created.");
        System.out.println("");
        
        //store the temporary arraylist into paying customer arraylist
        arraytemp.add(objtemp);
        payingcust.addAll(arraytemp);
        return payingcust;
    }
    
    
    //method to add associate customer 
    public static ArrayList<AssociateCustomer> addAssoCust(ArrayList<AssociateCustomer> associatecust , ArrayList<PayingCustomer> payingcust, ArrayList<Supplement> supp){
        Scanner kb = new Scanner(System.in);
        ArrayList<AssociateCustomer> arraytemp = new ArrayList<>();
        AssociateCustomer objtemp = new AssociateCustomer();
        boolean flag = true;
        
        while(flag){// Make sure user enter the name in chracters only characters 
            try{
                System.out.println("Enter name:");
                String name = kb.nextLine().trim().toUpperCase();
                objtemp.setCustName(name);
                flag = false;
            }
            catch(MagazineSerEx e){
                System.out.println(e.getMessage());
            }
        }
        flag = true;
        
        while(flag){// Make sure user enter the appropiate email address
            try{
                System.out.println("Enter email address: ");
                 String email = kb.nextLine();
                 objtemp.setCustEmailA(email);
                 flag = false;
            }
            catch(MagazineSerEx e){
                System.out.println(e.getMessage());
            }
        }
        
        objtemp.setCustType("ASSOCIATE CUSTOMER");
        
        flag = true;
        
        while(flag){// add on supplement
            System.out.println("Do you want to add on supplements for the magazine? (Y/N)");
            char ans = kb.nextLine().trim().toUpperCase().charAt(0);
            if(ans == 'Y'){
                printSupplementChoice();// print out supplements choice
                addSupp(objtemp.getCustEmailA(),supp);
                flag = false;
            }
            else if(ans == 'N'){
                  flag = false;      
            }
            else{
                System.out.println("Invalid input!");
            }
        }
        
        //calculate supplements cost
        double supsum = calcSupCost(objtemp.getCustEmailA(), supp);
        objtemp.setSuppCost(supsum);
        
        flag = true;
        
        while(flag){// let user to enter paying customer email address
            System.out.println("Enter the paying customer's email address: ");
            String paycustemail = kb.nextLine();

            boolean check = checkPayCustExist(payingcust, paycustemail); // check if paying customer exist
            if(check == true){
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(paycustemail); // add paying customer into associate customer arraylist
                objtemp.SetPayingCust(temp);
                
                updatePayCust(payingcust, paycustemail, objtemp.getCustEmailA(), supp, associatecust, objtemp.getSuppCost());// update the paying customer arraylist
                System.out.println("Associate customer " + objtemp.getCustName() + " is created.");
                System.out.println("");
                flag = false;
            }
            else{
                System.out.println("");
                System.out.println("Paying customer do not exist!");
                System.out.println("");
            }
        } 
        //store the temporaru arraylist into associate customer arraylist
        arraytemp.add(objtemp);
        associatecust.addAll(arraytemp);
        return associatecust;
    }
    
    //method to check if paying customer exist or not
    private static boolean checkPayCustExist(ArrayList<PayingCustomer> payingcust, String e){
        for(int i=0;i<payingcust.size();i++)
        {
            if(payingcust.get(i).getCustEmailA().equals(e))
            {                     
                return true;
            }
        }    
        return false;
    }
    
    //method to update paying customer arraylist when associate customer is added
    private static void updatePayCust(ArrayList<PayingCustomer> payingcust, String paycustemail, String newemail, ArrayList<Supplement> supp ,ArrayList<AssociateCustomer> assoccust, double sub){
        ArrayList<String> temp = new ArrayList<String>();
        for(int i=0; i<payingcust.size();i++){
            if(payingcust.get(i).getCustEmailA().equalsIgnoreCase(paycustemail)){
                for(int j=0; j<payingcust.get(i).GetAssociates().size(); j++){
                    String a = payingcust.get(i).GetAssociates().get(j);
                    temp.add(a);
                }
                temp.add(newemail);
                payingcust.get(i).SetAssociates(temp);
                payingcust.get(i).setAssoMCost(calcAssoMCost(payingcust.get(i).getCustEmailA(),payingcust.get(i).getMcost(),payingcust));
                payingcust.get(i).setAssoSCost(calcAssoSCost(payingcust.get(i).getCustEmailA(), payingcust, supp, assoccust, sub));
                payingcust.get(i).setTotalCost(calcTotalCost(payingcust.get(i).getMcost(),payingcust.get(i).getSupSum(),payingcust.get(i).getAssoMCost(),payingcust.get(i).getAssoSCost()));

            }
        }
    }
    
    //print out details for all paying customers
    public static void printPayingCust(ArrayList<PayingCustomer> payingcust, ArrayList<Supplement> supp){
        System.out.println("");
        System.out.println("---------------------------------------------------------------");
        System.out.println("-------------------Paying Customers' Details------------------- ");
        System.out.println("---------------------------------------------------------------");
        System.out.println("");
//        for(i = 0; i < payingcust.size(); i++)
        for(PayingCustomer payingcustlist : payingcust){
            System.out.println("---------------------------------------------------------------");
            System.out.println("Customer Name:                                      " + payingcustlist.getCustName());
            System.out.println("Customer Email:                                     " + payingcustlist.getCustEmailA());
            System.out.println("Customer Type:                                      " + payingcustlist.getCustType());
            System.out.print("Subscribed Supplement(s):                           ");
            for(Supplement supple : supp){
                if(payingcustlist.getCustEmailA().equalsIgnoreCase(supple.getEmailAdd())){
                    System.out.print(supple.getSupplement() +" ");
                }
            }
            System.out.println("");
            System.out.println("Associated Customer(s)' Email Address:              " + payingcustlist.GetAssociates());
            System.out.println("Weekly Magazine Cost:                               $" + payingcustlist.getMcost());
            System.out.println("Weekly Supplements Cost:                            $" + payingcustlist.getSupSum());
            System.out.println("Weekly Total Associated Customer's Magazine Cost:   $"+ payingcustlist.getAssoMCost());
            System.out.println("Weekly Total Associated Customer's Supplement Cost: $" + payingcustlist.getAssoSCost());
            System.out.println("Weekly Total Cost:                                  $" + payingcustlist.getTotalCost());
            System.out.println("Paying Method:                                      " + payingcustlist.getPayMethod());
            System.out.println("Credit Card or Account Number:                      " + payingcustlist.getAccNum());
            System.out.println("---------------------------------------------------------------");
            System.out.println("");
        }
    }
    
    //print out details for all associate customers
    public static void printAssociateCust(ArrayList<AssociateCustomer> assoccust, ArrayList<Supplement> supp){
        System.out.println("");
        System.out.println("---------------------------------------------------------------");
        System.out.println("-----------------Associate Customers' Details------------------");
        System.out.println("---------------------------------------------------------------");
        System.out.println("");
        for(AssociateCustomer assoccustlist : assoccust){
            System.out.println("---------------------------------------------------------------");
            System.out.println("Customer Name:                                      " + assoccustlist.getCustName());
            System.out.println("Customer Email:                                     " + assoccustlist.getCustEmailA());
            System.out.println("Customer Type:                                      " + assoccustlist.getCustType());
            System.out.println("Paying Cuctomer's Name:                             " + assoccustlist.GetPayingCust());
            System.out.print("Subscribed supplement(s):                           ");
            for(Supplement supple : supp){
                if(assoccustlist.getCustEmailA().equalsIgnoreCase(supple.getEmailAdd())){
                    System.out.print(supple.getSupplement()+" ");
                }
            }
            System.out.println("");
            System.out.println("---------------------------------------------------------------");
            System.out.println("");
        }
    }
    
    //method to remove customer
    public static void removeCust(ArrayList<PayingCustomer> payingcust, ArrayList<AssociateCustomer> assocust, ArrayList<Supplement> supp){
        Scanner kb = new Scanner(System.in);
        String nn;
        boolean removed;
        System.out.println("");
        System.out.println("Do you want to remove a paying customer or associate customner? (P/A)");
        char aa = kb.nextLine().trim().toUpperCase().charAt(0);
        boolean flag = true;
        if( aa == 'P'){
            while(flag){
                System.out.println("Enter a paying customer's email that you want to remove: ");
                nn = kb.nextLine().trim();
                removed = removePayC(payingcust, nn);//call the method to remove paying customer
                if(!removed){
                    System.out.println("Paying customer does not exist.");
                    System.out.println("");
                }
                else{
                    
                    System.out.println( nn + " has been removed. ");
                    System.out.println("");
                    flag = false;
                }
            }
        }
        else if(aa == 'A'){
            while(flag){
                System.out.println("Enter a associate customer's email that you want to remove: ");
                nn = kb.nextLine().trim();
                removed = removeAssoC(assocust, nn);// call the method to remvoe associate customer
                if(!removed){
                    System.out.println("Associate customer does not exist.");
                    System.out.println("");
                }
                else{
                    System.out.println("");
                    System.out.println( nn + " has been removed. ");
                    System.out.println("");
                    flag = false;
                }
            }
        }
        else{
            System.out.println("");
            System.out.println("Invalid input!");
            System.out.println("");
        }
    }
    
    //mthod remove paying customer
    private static boolean removePayC(ArrayList<PayingCustomer> payingcust,String email)
    {
        for(int i=0;i<payingcust.size();i++)
        {
            if(payingcust.get(i).getCustEmailA().equals(email))
            {                     
                payingcust.remove(i);
                return true;
            }
        }      
        return false;
    }
    
    //mthod remove associate customer
    private static boolean removeAssoC(ArrayList<AssociateCustomer> assoccust,String email)
    {
        for(int i=0;i<assoccust.size();i++)
        {
            if(assoccust.get(i).getCustEmailA().equals(email))
            {                     
                assoccust.remove(i);
                return true;
            }
        }      
        return false;
    }
    
    //method to print out supplements choice
    private static void printSupplementChoice(){
        System.out.println("");
        System.out.println("Supplements: ");
        System.out.println("Enter 'S1' to subscribe ENTERTAINMENT ------$2pw ");
        System.out.println("Enter 'S2' to subscribe LIFESTYLE ----------$3pw ");
        System.out.println("Enter 'S3' to subscribe SPORT --------------$4pw ");
        System.out.println("Enter 'S4' to subscribe TRAVEL -------------$5pw ");
    }
    
    //method to add supplements
    private static void addSupp(String e, ArrayList<Supplement> supp){
        Scanner kb = new Scanner(System.in);
        boolean flag = true;
        while(flag){// make sure that user enter valid supplement
            System.out.println("Enter supplement(s) that you want to subscribe or enter 'q' to quit: ");
            String entry = kb.nextLine().trim().toUpperCase();
            if(entry.equalsIgnoreCase("S1") || entry.equalsIgnoreCase("S2") || entry.equalsIgnoreCase("S3") || entry.equalsIgnoreCase("S4")){
                if(entry.equalsIgnoreCase("S1")){
                    supp.add(new Supplement(e,"ENTERTAINMENT", 2));
                }
                else if(entry.equalsIgnoreCase("S2")){
                    supp.add(new Supplement(e,"LIFESTYLE", 3));
                }
                else if(entry.equalsIgnoreCase("S3")){
                    supp.add(new Supplement(e,"SPORT", 4));
                }
                else if(entry.equalsIgnoreCase("S4")){
                    supp.add(new Supplement(e,"TRAVEL", 5));
                }
            }
            else if(entry.equalsIgnoreCase("q")){
                flag = false;
            }
            else{
                System.out.println("Supplement do not exist!");
            }
        }
    }
    
    //method to calcuate the supplement cost
    private static double calcSupCost(String eee, ArrayList<Supplement> supp){
        double suppsum = 0;
        for(Supplement supple : supp){
            if(eee.equalsIgnoreCase(supple.getEmailAdd())){
                 suppsum += supple.getSCost();
            }
        }
        return suppsum;
    }
    
    //method to calculate the associated customer's magazine cost
    private static double calcAssoMCost(String eee, double m, ArrayList<PayingCustomer> payingcust){
        double assoMsum = 0;
        double size = 0;
        for(int i=0; i < payingcust.size(); i++){
            if(eee.equalsIgnoreCase(payingcust.get(i).getCustEmailA())){
                size = payingcust.get(i).GetAssociates().size();
            }
        }
        assoMsum = m*size;
        return assoMsum;
    }
    
    //method to calculate the associated customer's supplements cost
    private static double calcAssoSCost(String eee,ArrayList<PayingCustomer> payingcust, ArrayList<Supplement> supp , ArrayList<AssociateCustomer> assoccust ,double sub){
        double assoSsum =  0;
        for(int i=0; i<payingcust.size(); i++){
            if(payingcust.get(i).getCustEmailA().equalsIgnoreCase(eee)){
                for(int j=0;j<payingcust.get(i).GetAssociates().size();j++){
                    String e = payingcust.get(i).GetAssociates().get(j);
                    for(int n=0;n < assoccust.size(); n++){
                        if(assoccust.get(n).getCustEmailA().equalsIgnoreCase(e)){
                            assoSsum = assoSsum + assoccust.get(n).getSuppCost();
                            System.out.println(assoSsum);
                        }
                    }
                }
            }
        }
        assoSsum += sub;
        return assoSsum;
    }

    //method to calculate total cost
    private static double calcTotalCost(double m, double s, double am, double as){
        double totalcost = m + s + am + as;
        return totalcost;
    }
    
    //method to calculate the monthly total cost for paying customer
    private static double calcMonthlyBill(double totalcost){
        LocalDate localdate = LocalDate.of(2019, Month.APRIL, 1);
        double monthlyBill = totalcost * 4;
        return monthlyBill;
    }
    
    //method to print out email for all customer for four weeks of magazine
    public static void generateWeeklyEmail(ArrayList<PayingCustomer> payingcust, ArrayList<Supplement> supp, ArrayList<AssociateCustomer> assoccust){
        int numberofweeks = 4;
        System.out.println("--------------------------------------------------------");
        System.out.println("-------ALL WEEKLY EMAILS FOR ALL PAYING CUSTOMERS-------");
        System.out.println("--------------------------------------------------------");
        System.out.println("");
        for(PayingCustomer payingcustlist : payingcust){
            LocalDate localdate = LocalDate.of(2019, Month.APRIL, 1);
            System.out.println("------------------------EMAIL---------------------------");
            for(int j=0; j < numberofweeks; j++){
                localdate = localdate.plusDays(7);
                System.out.println("Hi " + payingcustlist.getCustName() + "," + "\t" + "\t"  + "\t"+ "\t" +"Date: " + localdate);
                System.out.println("");
                System.out.println("Your weekly The Jo Magazine is ready!");
                System.out.println("Your subscribed supplement(s) are as followed: ");
                for(Supplement supple : supp){
                    if(payingcustlist.getCustEmailA().equalsIgnoreCase(supple.getEmailAdd())){
                        System.out.println(supple.getSupplement());
                    }
                }
                System.out.println("");
                System.out.println("Enjoy Reading! :)"); 
                System.out.println("Your Sincerely, The Jo Magazine");
                System.out.println("");
            }
            System.out.println("--------------------------------------------------------");
            System.out.println("");
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("-----ALL WEEKLY EMAILS FOR ALL ASSOCIATED CUSTOMERS-----");
        System.out.println("--------------------------------------------------------");
        System.out.println("");
        for(AssociateCustomer assoccustlist : assoccust){
            LocalDate localdate = LocalDate.of(2019, Month.APRIL, 1);
            System.out.println("------------------------EMAIL---------------------------");
            for(int j=0; j < numberofweeks; j++){
                localdate = localdate.plusDays(7);
                System.out.println("Hi " + assoccustlist.getCustName() + ","+ "\t" + "\t"  + "\t"+ "\t" +"Date: " + localdate);
                System.out.println("");
                System.out.println("Your weekly The Jo Magazine is ready!");
                System.out.println("Your subscribed supplement(s) are as followed: ");
                for(Supplement supple : supp){
                    if(assoccustlist.getCustEmailA().equalsIgnoreCase(supple.getEmailAdd())){
                        System.out.println(supple.getSupplement());
                    }
                
                }
                System.out.println("");
                System.out.println("Enjoy Reading! :)"); 
                System.out.println("Your Sincerely, The Jo Magazine");
                System.out.println("");
            }
            System.out.println("--------------------------------------------------------");
        }
    }

    //method to print out the end of month email for the paying customer
    public static void generateMonthlyEmail(ArrayList<PayingCustomer> payingcust, ArrayList<Supplement> supp, ArrayList<AssociateCustomer> assoccust){
        int noOfMonth =1;
        for(PayingCustomer payingcustlist : payingcust){
            LocalDate localdate = LocalDate.of(2019, Month.APRIL, 1);
            for(int j=0; j < noOfMonth; j++){
                System.out.println("-------------------------------------------------------------------");
                System.out.println("-----------Monthly Email for The Jo Magazine Subscription----------");
                System.out.println("-------------------------------------------------------------------");
                System.out.println("Hi " + payingcustlist.getCustName() + "," + '\t' +'\t' +'\t' +'\t' +'\t' +"Date: " + localdate.withDayOfMonth(localdate.lengthOfMonth()));
                System.out.println("");
                System.out.println("This is your payment details for The Jo Magazine Subscription:");
                System.out.println("Customer Name:   " + payingcustlist.getCustName());
                System.out.println("Customer Email:  " + payingcustlist.getCustEmailA());
                System.out.println("");
                System.out.println("Weekly Magazine Cost:     $" + payingcustlist.getMcost());
                System.out.println("Weekly Supplements Cost:  $" + payingcustlist.getSupSum());
                System.out.println("");
                System.out.println("Associated Customer(s)' Email Address: " + payingcustlist.GetAssociates());
                System.out.println("");
                System.out.println("Weekly Total Associated Customer's Magazine Cost:    $"+ payingcustlist.getAssoMCost());
                System.out.println("Weekly Total Associated Customer's Supplement Cost:  $" + payingcustlist.getAssoSCost());
                System.out.println("");
                System.out.println("Weekly Total Cost:   $" + payingcustlist.getTotalCost());
                System.out.println("MONTHLY TOTAL COST:  $" + calcMonthlyBill(payingcustlist.getTotalCost()));
                System.out.println("");
                System.out.println("Paying Method: " + payingcustlist.getPayMethod());
                System.out.println("Credit Card or Account Number: " + payingcustlist.getAccNum());
                System.out.println("");
                System.out.println("Thank you for subscribing The Jo Magazine!");
                System.out.println("");
                System.out.println("Your Sincerely, The Jo Magazine");
                System.out.println("");
                System.out.println("-------------------------------------------------------------------");
                System.out.println("");
                System.out.println("");
            }
        }   
    }
}
