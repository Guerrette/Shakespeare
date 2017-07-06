package Default;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
		ChainHashMap<StringTwo, Integer> map = new ChainHashMap<StringTwo, Integer>(10000000);
		map.createTable();
	
		
		StringTwo v = new StringTwo("midsummer");
		System.out.println(v.hashCode()%10934512);
		
		Scanner fileIn = new Scanner(new File("shakespeare.txt"));
		String next = "";
		
		// this loop reads the text file and finds every single word
		while(fileIn.hasNext())
		{
			next = fileIn.nextLine();
			String str = "";
			for(int x=0;x<next.length();x++) // gets the line of the text file
			{
				char current = next.charAt(x);
				
				// i the word is a , space quote semicolon quotations mark exclamation point color dash or bracket the string the chars where added to is created to string two
				if(current == ' '  || current == ',' ||  current == '"' || current == ':' || current == ';' || current == ',' || current == '?' || current == '!' || current == '-' || current == '.' || current == ']' || current == '[')
				{
					if(str != "")
					{
						//System.out.println(str);
						StringTwo sample = new StringTwo(str);
						map.bucketPut(sample.hashCode()%10000000, sample, 1); // stringtwo is added to a bucket if it already exists. 
																				// the hashcode represents the value of the bucket and the instance is the key
						
						str = "";
					}
					
				}
				
				else // add the char to the string
				{
					str += current;
				}
			}
		}
		
		
		
		Top1000 t = new Top1000();
		UnsortedTableMap<StringTwo,Integer>[] table = map.getTable(); // gets the table used in the chain hash map class
		
		for(UnsortedTableMap<StringTwo, Integer> x : table) // iterates through the table
		{
			if(x != null)
			{
				String s = x.compareKey(); // uses a compare method that compares all the strings with the same
											// This method is found in the unsorted table class
				if(s != null)
				{
					System.out.println("Collision for: " + s); // prints out the collision
				}
				t.add(x); // adds the word to the most frequent list.
			}
			
		}
		t.sort(); // sorts the list to show the most frequent in order
		System.out.println(t.toString());
		
		
	}

}
