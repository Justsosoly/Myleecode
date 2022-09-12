package Mytest;
import java.io.*;
import java.util.*;
import java.util.stream.*;
public class CamelCase {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
          Scanner scanner = new Scanner(System.in);
        
        while(scanner.hasNext()){
        String myString = scanner.nextLine();
      //  System.out.println("The Input String is: " + myString);
        String result = CamelCase.camelCase(myString);
        }
        scanner.close();
        
     
    }
    
      public static String camelCase(String str)
    {
     String dealing="";
     
      String camelcase[]=str.split(";");
      
       
        dealing=camelcase[2];//the string need to combine or split 
  
       if(dealing.contains("("))
       
         dealing=dealing.substring(0, dealing.length()-2);
       
       
       if(camelcase[0].contentEquals("S"))//split
       {
           
           if(camelcase[1].contentEquals("M"))//split method
           {
        	   CamelCase.splitUpperCase(dealing);
              
           }
           if(camelcase[1].contentEquals("V"))//split Variable
           {
        	   CamelCase.splitUpperCase(dealing);
           }
           if(camelcase[1].contentEquals("C"))//split Class
           {
        	   CamelCase.splitUpperCase(dealing);
           }
           
       }

       
       if(camelcase[0].contentEquals("C"))//combine
       {
           
           if(camelcase[1].contentEquals("M"))//combine method
           {
        	   CamelCase.combineMethod(dealing);
           }
           if(camelcase[1].contentEquals("V"))//combine Variable
           {
        	   CamelCase.combineVirable(dealing);
           }
           if(camelcase[1].contentEquals("C"))//combine Class
           {
        	   CamelCase.combineClass(dealing);
           }
           
       }
       
     return  dealing;
        
    }
    
      static void splitUpperCase(String str)
    {
       
        List<String> dealist=new ArrayList<String>();
        List<Integer> count=new ArrayList<Integer>();//count words number
       
        count.add(0);//the first word
     
       //System.out.println("the input words is:"+str);
        for(int i=1;i<str.length();i++)
        {
            if(Character.isUpperCase(str.charAt(i)))//is capital letter
            {
            //  System.out.println("the uppercase index is: "+i);
               count.add(i);
            }
          
        }
        count.add(str.length());//the last word
        
        //dealing the words
        for(int j=0;j<count.size()-1;j++)
        {
            String dealing="";
            str=str.toLowerCase();
            dealing=str.substring(count.get(j), count.get(j+1));
            System.out.print(dealing+" ");
            dealist.add(dealing);
        }
        System.out.println();

    }// end dealingUpperCase()
    
   
   static void combineVirable(String str)
   {
       String []dealing=str.split(" ");
       for(int i=1;i<dealing.length;i++)
       {
           
    	   String word=dealing[i];
           String firstword= String.valueOf(word.toUpperCase().charAt(0));
           word=firstword+word.substring(1,word.length());           
           dealing[i]=word;
       }
       
       for(int i=0;i<dealing.length;i++)
           System.out.print( dealing[i]);
          System.out.println();
   }
   
   static void combineClass(String str)
   {
       String []dealing=str.split(" ");
       for(int i=0;i<dealing.length;i++)//
       {
           String word=dealing[i];
           String firstword= String.valueOf(word.toUpperCase().charAt(0));
           word=firstword+word.substring(1,word.length());           
           System.out.print(word);
       }
       System.out.println();
       
   }
   
   static void combineMethod(String str)
   
   {
       String []dealing=str.split(" ");
       for(int i=1;i<dealing.length;i++)//
       {
           String word=dealing[i];
           String firstword= String.valueOf(word.toUpperCase().charAt(0));
           word=firstword+word.substring(1,word.length());           
          dealing[i]=word;
           
       }
       for(int i=0;i<dealing.length;i++)
       System.out.print( dealing[i]);
       
    
       System.out.print("()");
       System.out.println();
       
   }
    
    
    
    
}
