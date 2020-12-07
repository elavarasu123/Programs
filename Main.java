/* JAVA SIMPLE PROGRAM */

import java.util.*;
class Main {
  public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     int s1,s2;
     System.out.println("Enter size1");
     s1=sc.nextInt();

     String[] sent=new String[s1];
     System.out.println("Enter sent");
     sc.nextLine();
     for(int i=0;i<s1;i++)
        sent[i]=sc.nextLine();
      
      System.out.println("Enter size2");
      s2=sc.nextInt();
      String[] quer=new String[s2];
      System.out.println("Enter queries");
      sc.nextLine();
      for(int j=0;j<s2;j++)
        quer[j]=sc.nextLine();

    /*for(int i=0;i<s1;i++)
      System.out.println(sent[i]);

    for(int j=0;j<s2;j++)
      System.out.println(quer[j]);*/

    for(int i=0;i<s2;i++)
    {
      for(int j=0;j<s1;j++)
      {
        int count=0;
        String[] one=quer[i].split(" ");
        for(int m=0;m<one.length;m++)
        { 
        if(sent[j].contains(one[m]))
        {
           count=count+1;
        }
        if(count == one.length)
        System.out.print(j+" ");
        }
           
      }
       System.out.println("");
    }
  }
}