import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class M1 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc=new Scanner(System.in);
        Book b1[]=new Book[4];
        for(int i=0;i<b1.length;i++)
        {
            int id=sc.nextInt();
            sc.nextLine();
            String title=sc.nextLine();
            String auth=sc.nextLine();
            double price=sc.nextDouble();
            b1[i]=new Book(id,title,auth,price);
        }
        String search=sc.nextLine();
         Book answer[]=searchTitle(b1,search);

         for(Book ans:answer)
         {
             if(ans!=null)
             {
                 System.out.println(ans.getId());
             }
         }
    }

    public static Book[] searchTitle(Book[] b1,String search)
    {
         Book[] b2=new Book[4];
         int j=0;
        for(int i=0;i<b1.length;i++)
        {
          if(b1[i].getTitle().toLowerCase().contains(search.toLowerCase()))
          {
              //System.out.println(b1[i].getTitle());
              b2[j]=b1[i];
              j++;
          }
        }
        return b2;
    }
}

class Book
{
    private int id;
    private String title;
    private String auth;
    private double price;

    public Book(int id,String title,String auth,double price)
    {
        this.id=id;
        this.title=title;
        this.auth=auth;
        this.price=price;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    public String getAuth()
    {
        return auth;
    }
    public void setAuth(String auth)
    {
        this.auth=auth;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
}