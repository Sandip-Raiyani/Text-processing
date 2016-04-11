import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartA 
{
	public static void main(String[] args)throws IOException 
	{
	tokenize();
	}
	
	public static void tokenize()throws IOException
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
	print(tokens);
	}

	public static void print(ArrayList<String> str1)
	{
		System.out.println(str1); 
	}
}
