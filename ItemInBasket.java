/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteminbasket;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 *
 * @author KL
 */
public class ItemInBasket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        // TODO code application logic here
    Double totalcost=0.;
    //int listitem=0;
    boolean keepbuy = true;
    
    //Create shop stock list;  This is done by uploading data from the CSV file
    uploading[] stockname=new uploading[100];
    //Create basket list
    basket[] basketitem=new basket[100];
        for(int i = 1; i<100; i++) {
        stockname[i] = new uploading();
        basketitem[i]=new basket();
         }
        
    //PART 2: LOADING THE FILE IN THE MEMORE
        String fileName="/Users/KT/Desktop/Shareslong3.csv";
        Integer linenum=0;
        
    //String fileName="/Users/KT/NetBeansProjects/myShare/hello.csv";   
     Scanner MacScanner=new Scanner(new File(fileName));
        while(MacScanner.hasNext()){
         String data=MacScanner.next();
         linenum ++;
         //System.out.println(data);
         String[] shares=data.split(",");
        //check values of shares per line 
        //System.out.println(shares[2]);
        stockname[linenum].itemName=shares[0];
        stockname[linenum].stockValue=Double.parseDouble(shares[1]);
//        stockname[linenum].predictedvalue=Double.parseDouble(shares[2]);
        stockname[linenum].holding=Integer.parseInt(shares[2]);
//        stockname[linenum].sold=Integer.parseInt(shares[4]);
        stockname[linenum].shareSummary();

        }
        MacScanner.close();
    
    System.out.println("GREETINGS");
    System.out.println("File is uploaded; All variable in memory");
    System.out.println("Today the total number of tyes of stocks="+linenum);
    System.out.println("Proceeding for shopping");
    System.out.println("*********************************************");

//Part 3: Loading the share names and their values
  while(keepbuy){
    System.out.println("Enter the item to buy or enter 'n' to check out");
    Scanner scan=new Scanner(System.in);
    String buystock = scan.nextLine();
    
    if(!"n".equals(buystock)){
    System.out.println("How many?");
    Double buynumber=scan.nextDouble();
    System.out.println("Number to buy= "+buynumber);
    
        //System.out.println(stockname[1].company);
          //      System.out.println(stockname[2].company);



    //int ichoise = Integer.parseInt(scan.nextLine());
    //System.out.println("choise="+ichoise);
//parat 3:  find the item number and how much to be sold;
//  ask for the string and compare it with stockname[i];
//  get the stock value and calculate the cost.
    
        for(int j = 1; j<linenum+1; j++) {
        //System.out.println("j value="+j);
        //System.out.println(stockname[j].company);
        //System.out.println(buystock);
        
          if(buystock.equals(stockname[j].itemName)){
           basketitem[j].itemToBuy=buystock;
           basketitem[j].getbuynumber(buynumber);
        //   System.out.println("checkpoint3");

                   }
        } 
        
    }
    else {
    keepbuy=false;
    }
  }
for(int j = 1; j<linenum+1; j++){

basketitem[j].itemBuyValue=basketitem[j].numberOfItem*stockname[j].stockValue;
totalcost=totalcost+basketitem[j].itemBuyValue;
if(basketitem[j].numberOfItem!=0){
System.out.println(basketitem[j].numberOfItem+"  "+basketitem[j].itemToBuy+
        " costing "+basketitem[j].itemBuyValue);
}
}

    //    System.out.println("totalcost="+totalcost);
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("totalcost="+df.format(totalcost));

    
// end of public static void
    }
    
// end of public class ItemInBasket   
}
