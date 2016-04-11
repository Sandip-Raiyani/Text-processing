import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PartD
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
  
  //print anagrams
  public void printAnagram(HashMap<String,ArrayList<String>> anagram){
		for(Entry<String, ArrayList<String>> entry: anagram.entrySet())
		{
			String key=entry.getKey();
			ArrayList<String> value=entry.getValue();
			System.out.println(key+" -> "+value);
			
		}
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

   public static HashMap<String, ArrayList<String>> anagram(ArrayList<String> ip)
   {
    
    HashMap<String, ArrayList<String>> mapping = new HashMap<>();
            
    for(String s: ip){
        
        String s1= sort(s);
        ArrayList<String> anagList= mapping.get(s1);
        if(anagList==null){
        anagList=new ArrayList<>();
        }
        anagList.add(s);
        mapping.put(s1,anagList);
    }
        
    return(mapping);
}
 
private static String sort(String s){
    
    char[] c = s.toCharArray();
    Arrays.sort(c);
    String a = new String(c);
    return a;
       
}
public static HashMap<String, ArrayList<String>> detectAnagrams(ArrayList token) throws FileNotFoundException, IOException
{
   
    ArrayList al = tokenizeFile();
    HashMap<String, ArrayList<String>> words = anagram(al);
    
    HashMap<String, ArrayList<String>> tokens = new HashMap<>(); 
    
    for (int i=0; i < token.size(); i++){
        
        String word = (String) token.get(i);
        String sorted = sort(word);
        if (words.containsKey(sorted))
        {
            ArrayList list = words.get(sorted);
            
            tokens.put(word, list);
            if (tokens.get(word).contains(word))
            {
                tokens.get(word).remove(word);
               
            }
        }
        
    }
    return tokens;
}
}
