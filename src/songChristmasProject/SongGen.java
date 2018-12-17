package songChristmasProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class SongGen 
{
	Random r =  new Random();
	
	ArrayList<String> nouns = new ArrayList<>();
	ArrayList<String> verbs = new ArrayList<>();
	ArrayList<String> adjectives = new ArrayList<>();
	
	FileReader fr;
	BufferedReader br;
	String NOUNFILENAME = "Nouns.txt";
	String VERBFILENAME = "Verbs.txt";
	String ADJECTIVEFILENAME = "Adjectives.txt";
	String SONGFILENAME = "12Days.txt";
	//String SONGFILENAME = "AllIWantForChristmasIsYou.txt";
	//String SONGFILENAME = "JingleBells.txt";
	//String SONGFILENAME = "WhiteChristmas.txt";
	String FILEPATH = "C:/Users/Admin/Desktop/SongStuff/";
	
	public String generate12Days()
	{
		ArrayList<String> nounsWeNeed = new ArrayList<>();
		ArrayList<String> verbsWeNeed = new ArrayList<>();
		ArrayList<String> adjectivesWeNeed = new ArrayList<>();
		//solo noun 1
		//adjectives 2-5
		//verb 6-12
		
		for(int i = 0; i < 12; i++)
		{
			nounsWeNeed.add(getRandomNoun());
			verbsWeNeed.add(getRandomVerb());
			adjectivesWeNeed.add(getRandomAdjective());
		}
		
		String fullSong = "";
		try
		{
			fr = new FileReader(FILEPATH + SONGFILENAME);
			br = new BufferedReader(fr);
			do
			{
				String fileContent = br.readLine();
				if(fileContent == null)
				{
					break;
				}
				String[] contentInParts = fileContent.split(",");
			
				for(String s : contentInParts)
				{
					if(s.length() <=  0)
					{
						continue;
					}
					if(!Character.isDigit(s.charAt(0)))
					{
						fullSong = fullSong + s;
						continue;
					}
					
					int num = intReturner(s);
					
					if(num == 1)
					{
						if(stringStartsWithVowel(nounsWeNeed.get(0)))
						{
							fullSong = fullSong + "n";
						}
						fullSong = fullSong + "" + nounsWeNeed.get(0) + " in a pear tree.";
					}
					else if (2<= num && num <= 5)
					{
						fullSong = fullSong + "" + adjectivesWeNeed.get(num - 1) + "" + nounsWeNeed.get(num - 1) + "s";
					}
					else if (6 <= num && num <=12)
					{
						fullSong = fullSong + "" + nounsWeNeed.get(num - 1) + "s a-" + verbsWeNeed.get(num - 1);
					}
					
					else
					{
						fullSong = fullSong + s;
					}
					
				}
				fullSong = fullSong + "\n";
			} while(true);
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return fullSong;
	}
	
	public void loadNouns()
	{
		try
		{
			fr = new FileReader(FILEPATH + NOUNFILENAME);
			br = new BufferedReader(fr);
			
			String fileContent = br.readLine();
			String[] contentInParts = fileContent.split(",");
			
			for(String s : contentInParts)
			{
				nouns.add(s);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void loadVerbs()
	{
		try
		{
			fr = new FileReader(FILEPATH + VERBFILENAME);
			br = new BufferedReader(fr);
			
			String fileContent = br.readLine();
			String[] contentInParts = fileContent.split(",");
			
			for(String s : contentInParts)
			{
				verbs.add(s);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void loadAdjectives()
	{
		try
		{
			fr = new FileReader(FILEPATH + ADJECTIVEFILENAME);
			br = new BufferedReader(fr);
			
			String fileContent = br.readLine();
			String[] contentInParts = fileContent.split(",");
			
			for(String s : contentInParts)
			{
				adjectives.add(s);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getRandomAdjective()
	{
		int i = r.nextInt(adjectives.size());
		return adjectives.get(i);
	}
	
	public String getRandomVerb()
	{
		int i = r.nextInt(verbs.size());
		return verbs.get(i);
	}
	
	public String getRandomNoun()
	{
		int i = r.nextInt(nouns.size());
		return nouns.get(i);
	}
	
	public boolean stringStartsWithVowel(String toTest)
	{
		return toTest.matches("(?i)^[aeiou].*$");
	}
	
	public int intReturner(String input)
	{
		if(input.length() == 1)
		{
			return Character.getNumericValue(input.charAt(0));
		}
		
		if(input.charAt(1) == ' ')
		{
			return Character.getNumericValue(input.charAt(0));
		}
		else
		{
			return (Character.getNumericValue(input.charAt(0))*10)+Character.getNumericValue(input.charAt(1));
		}
	}
}
