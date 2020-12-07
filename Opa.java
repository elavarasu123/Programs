/*  TCS OPA SAMPLE */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Opa
{
public static void main(String[] args)
 {
    Mobile listOfMobiles[]=new Mobile[5];
    Scanner scan=new Scanner(System.in);
  //code to read values 
    for(int i=0;i<5;i++)
    {
        String iMEICode=scan.nextLine();
        boolean isSingleSIM=scan.nextBoolean();
        scan.nextLine();
        String processor=scan.nextLine();
        double price=scan.nextDouble();
        scan.nextLine();
        String manufacturer=scan.nextLine();
        listOfMobiles[i]=new Mobile(iMEICode,isSingleSIM,processor,price,manufacturer);
    }
    double discountPercentage=scan.nextDouble();
    scan.nextLine();
    String manufacturerName=scan.nextLine();
  //code to call required method
  int totalCount=getCountOfValidIMEIMobiles(listOfMobiles);
  Mobile maxMobile=findMobileWithMaxPrice(listOfMobiles, discountPercentage, manufacturerName);
  //code to display the result
  System.out.println(totalCount);
  if(maxMobile!=null)
  {
      System.out.println(maxMobile.getIMEICode()+"@"+maxMobile.getPrice());
  }
  else
  {
      System.out.println("No mobile found");
  }
 }

 public static int getCountOfValidIMEIMobiles(Mobile[] listOfMobiles)
  {
    int count=0;
   //method logic
   for(Mobile mobile:listOfMobiles)
   {
       if(mobile.getIsSingleSIM() && mobile.getIMEICode().length()==15)
       {
           count++;
       }
       
   }
    return count;
  }

public static Mobile findMobileWithMaxPrice(Mobile[] listOfMobiles,double discountPercentage,String manufacturerName)
  {
   Mobile maxMobile=null;
   double comparisonPrice=0;
   //method logic
   for(Mobile mobile:listOfMobiles)
   {
       if(mobile.getManufacturer().equalsIgnoreCase(manufacturerName))
       {
        double oldPrice=mobile.getPrice();
        double newPrice=oldPrice-((oldPrice*discountPercentage)/100);
        mobile.setPrice(newPrice);
       }
   }
   for(Mobile mobile:listOfMobiles)
   {
       if(mobile.getManufacturer().equalsIgnoreCase(manufacturerName) && comparisonPrice<mobile.getPrice())
       {
           comparisonPrice=mobile.getPrice();
           maxMobile=mobile;
       }
   }
   return maxMobile;
  }
}
class Mobile
{
  //code to build the class
    String iMEICode;
    boolean isSingleSIM;
    String processor;
    double price;
    String manufacturer;
    public Mobile(String iMEICode,boolean isSingleSIM,String processor,double price,String manufacturer)    {
        this.iMEICode=iMEICode;
        this.isSingleSIM=isSingleSIM;
        this.processor=processor;
        this.price=price;
        this.manufacturer=manufacturer;
    }
    public String getIMEICode()
    {
        return iMEICode;
    }
    public boolean getIsSingleSIM()
    {
        return isSingleSIM;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
    public String getManufacturer()
    {
        return manufacturer;
    }
}