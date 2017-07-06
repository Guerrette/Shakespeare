package Default;
/**
 * A version of the string class that uses a new Equals and HashCode method
 * @author Patrick
 *
 */
public class StringTwo
{
	private String _string;
	
	public StringTwo(String str)
	{
		_string = str;
	}
	
	/**
	 *  equals method compares the HashCodes of two strings
	 * @param s
	 * @return
	 */
	public boolean Equals(StringTwo str)
	{
		String str2 = str.getString();
		String str1 = this.getString();
		if(str2.length() == str1.length())
		{
			String string2 = str2.toLowerCase(); // made each string lower case to get rid of any possible error between cases.
			String string1 = str1.toLowerCase();
			
			for(int x=0;x<string1.length();x++)
			{
				
				char c2 = string2.charAt(x);
				char c1 = string1.charAt(x);
				
				// if the two characters at any point are not equal the strings are not equal
				if(c1 != c2)
				{
					return false;
				}
			}
			
			return true; // if the strings make it through the for loop then they are equal
		}
		else // strings are not the same length meaning they are not the same and don't need to be tested with a for loop
		{
			return false;
		}
	}
	
	/**
	 * Creates the HashCode of a string by using horners rule
	 * @param s
	 * @return
	 */
	@Override
	public int hashCode()
	{
		int hashcode = 0;
		String string = _string.toLowerCase();
		
		for(int x=0;x<string.length();x++)
		{
			
			hashcode = 31*hashcode + string.charAt(x);
		}
		if(hashcode < 0)
		{
			hashcode *= -1;
		}
		return hashcode;
	}
	/**
	 * The getString method returns the string associated with the instance
	 * @return
	 */
	public String getString()
	{
		return _string;
	}
}
