import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartB
{
  public static void main(String[] args)throws IOException
  {
   ArrayList<String>tokenizedList=new ArrayList<>();
   tokenizedList=tokenizeFile();
   printtoken(tokenizedList);
   HashMap<String,Integer>frequencylist=new HashMap<>();
   frequencylist=computeWordFrequencies(tokenizedList);
   printfreq(frequencylist);
   
  }
  
  public static ArrayList<String> tokenizeFile()throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the path "); 
		String file = sc.nextLine();
		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<String> tokens= new ArrayList<String>() ; 
		String s1;
		String s2;
		while ((s1 = br.readLine()) != null) 
		{
		s2 = s1.toLowerCase();
		for(String s3: s2.split("[\\p{P}\\p{S}\\s]"))	
			{
			
			if(!s3.isEmpty()) 
				{
				tokens.add(s3) ; 
				}
			}
		
		}
		return tokens;
     
     
	
}
	
  
  
  public static void printtoken(ArrayList<String> str2)
  {
    System.out.println(str2);
  }
  
  public static void printfreq(HashMap fm)
  {
    System.out.println(fm);
  }
  
  public static HashMap<String,Integer> computeWordFrequencies(ArrayList<String> str)
 	{
         HashMap<String, Integer> m = new HashMap<String, Integer>();

         
         for (String a : str) {
             Integer freq = m.get(a);
             m.put(a, (freq == null) ? 1 : freq + 1);
         } return m;

        
     }
}
