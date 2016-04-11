import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PartC
{
  public static void main(String[] args)throws IOException
  {
   //Print tokenlist
   ArrayList<String> tokenizedList=new ArrayList<>();
   tokenizedList=tokenizeFile();
   printtoken(tokenizedList);
   
   //Print tokenfrequency
   HashMap<String,Integer> frequencyList=new HashMap<>();
   frequencyList=computeWordFrequencies(tokenizedList);
   printfreq(frequencyList);
   
   //Print 3-gram
   
   ArrayList<String> threeGram1 =threeGramGen(tokenizedList);
   printtoken(threeGram1);
   
   //Print 3-gram frequency
   HashMap<String, Integer> threeGramMapping= computeThreeGramFrequencies(threeGram1);
   printfreq(threeGramMapping);

  }
  
  //Method to print token
  public static void printtoken(ArrayList<String> str2)
  {
    System.out.println(str2);
  }
  
  //token to print frequency
  public static void printfreq(HashMap<String, Integer> frequencyList)
  {
    System.out.println(frequencyList);
  }
  
  //token function
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

  //method for finding token frequency
  public static HashMap<String,Integer> computeWordFrequencies(ArrayList<String> str)
	{
       HashMap<String, Integer> m = new HashMap<String, Integer>();

       
       for (String a : str) {
           Integer freq = m.get(a);
           m.put(a, (freq == null) ? 1 : freq + 1);
       } return m;

      
   }
  
    //method to find 3gram
    public static ArrayList<String> threeGramGen(ArrayList<String> tokenFile) {
    	ArrayList<String> threeGram = new ArrayList<>();
    	 for (int i = 0; i < tokenFile.size() - 3 + 1; i++) {
    	        StringBuilder sb = new StringBuilder();
    	        for (int j = i; j < i + 3; j++)
    	            sb.append((j > i ? " " : "") + tokenFile.get(j));



    	        threeGram.add(sb.toString());
    	 }
    	 return threeGram;
  }
    
    //method to find 3-gram frequency
    public static HashMap<String,Integer> computeThreeGramFrequencies(ArrayList<String> threeGram)
 	{
         HashMap<String, Integer> m = new HashMap<String, Integer>();

         
         for (String a : threeGram) {
             Integer freq = m.get(a);
             m.put(a, (freq == null) ? 1 : freq + 1);
         } return m;
 	}
    
 
}
