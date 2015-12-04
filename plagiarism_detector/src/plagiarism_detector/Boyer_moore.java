package plagiarism_detector;

import java.util.HashMap;
import java.util.Map;


public class Boyer_moore 
{
	 public char[] text;
	 public char[] pattern; 
	 Map<Character,Integer> last = new HashMap<Character,Integer>();
	 public int[] match;
	 
	 public Boyer_moore(char[] txt,char[] pat)
	 {
		 this.text = txt;
		 this.pattern = pat;
	 }
	public void generatebadmatchTable()
	{	int k;
		for(k = 0; k < pattern.length - 1 ; k++ )
		{
			last.put(pattern[k],(pattern.length - k -1));
		}
		last.put(pattern[k], pattern.length );
		last.put('*',pattern.length );
		
		System.out.println(last);
	}
	
	public boolean searchtinp(char q)
	{
		boolean contains = false;
		for(char c : pattern)
		{
			if (c == q)
			{
				contains = true;
				break;
			}
		}
		return contains;
	}
	
	public void searchforString()
	{
		int ptp = pattern.length - 1;
		int txp = ptp;
		int temptxt = pattern.length -1;
		int jump;
		boolean match = false;
		boolean flag = true;;
		while(!match)
		{
			if(pattern[ptp] == text[txp])
			{
				if(flag == true)
				{
					temptxt = txp;
					flag = false;
				}
				txp--;
				ptp--;
				if(ptp == 0)
				{
					System.out.println("Matching Done at ::" + txp + " to " + (txp +pattern.length) );
					match = true;
				}
			}
			else 
			{
				if(searchtinp(text[temptxt]))
				{	
					jump = last.get(text[temptxt]);
					txp = temptxt + jump;
					temptxt = txp;
					flag = true;
				}
				else
				{
					jump = pattern.length -1;
					System.out.println("jump value :: " + jump);
					txp = txp + jump;
					temptxt = txp;
					flag = true ;
					System.out.println("element in text::" + text[txp]);
				}
				
				ptp = pattern.length - 1;
			}
		}
		
	}

	public static void main(String args[])
	{
		Boyer_moore bm = new Boyer_moore("My name is pooja pagal".toCharArray(),"pooja".toCharArray());
		bm.generatebadmatchTable();
		bm.searchforString();
	}
}


