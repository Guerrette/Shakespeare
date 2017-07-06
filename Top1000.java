package Default;
/**
 * This class represents the top 1000 most frequent words used by shakespeare
 * @author Patrick
 *
 */
@SuppressWarnings("unchecked")
public class Top1000 
{
	
	private static UnsortedTableMap<StringTwo,Integer>[] table;
	private static int counter;// current number the array is on
	
	// constructor
	public Top1000()
	{
		table =  new UnsortedTableMap[1000];
	}
	
	// adds a bucket into the array of the top 1000 most used words
	public void add(UnsortedTableMap<StringTwo,Integer> sample)
	{
		if(counter == 999) // array is full
		{
			int least = findLeast();
			if(table[least].size() >= sample.size()) // word frequency for bucket that is in the array is greater than the word frequency of the bucket being added
			{
				findLeast();
				table[least] = sample; // the least value gets replaced
			}
		}
		else
		{
			table[counter] = sample;
			counter++;
		}
	}
	
	/**
	 * This method finds the position of the bucket with the smallest size
	 */
	private int findLeast()
	{
		int position = 0; // represents the current position in the array
		int smallest = 10000; //represents the smallest size so far
		int Least = 0; // represents the position of the smallest size
		for(UnsortedTableMap<StringTwo,Integer> x : table)
		{
			if(x != null)
			{
				if(x.size() < smallest) // if the size of the bucket is smaller than the smallest size encountered so far
										// the position of it and the size are saved.
				{
					Least = position;
					smallest = x.size(); 				
				}
			}
			
			position++;
		}
		return Least;
	}
	/**
	 * Prints out the Top 1000 most frequent words and how often each one occurred.
	 * @return
	 */
	public String toString()
	{
		String str = "";
		
		for(UnsortedTableMap<StringTwo,Integer> x : table) // goes through the table prints out the string associated with the bucket
														   // and the size of the bucket which is how many encounters of the string have come up
		{
			if(x != null)
			{
				str += x.getKey().getString() + " " + x.size() + System.lineSeparator(); // keeps adding on to the string
			}
		}
		
		return str;
		
	}
	/**
	 * This method sorts the array by the size of each bucket
	 * This method should only be called once it is completely full and nothing its being added to it anymore.
	 * Basically it should be called after every word is read and every bucket has been tried in this array.
	 */
	public void sort()
	{
		UnsortedTableMap<StringTwo,Integer> temp;
		for(int x=0;x<table.length;x++)
		{
			for(int y=0;y<table.length;y++)
			{
				if( table[x] != null && table[y] != null) // if the two entries do not equal null
				{
					if (table[x].size() > table[y].size()) // if size x is bigger the size y swap them.
					{
					temp = table[x];
					table[x] = table[y];
					table[y] = temp;
					}
				}
				
			}
			
			
		}
	}
	

}
