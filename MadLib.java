//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException; //errors are exception
import java.util.Scanner; //Scan a file
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MadLib
{
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();
	private String story = "";

	public MadLib()
	{
		verbs.add("punched");
		nouns.add("Wal-mart");
		adjectives.add("Massive");
		story = "";
	}

	public MadLib(String fileName)
	{
		//load stuff
		loadNouns();
		loadAdjectives();
		loadVerbs();
		try
		{
			//Read the different parts of the story and concatenate the resulting
			//story using the symbols to tell you the parts of speech
			Scanner scanner = new Scanner(new File(fileName));

			String og = scanner.nextLine();

			//While there is more of the story, read in the word/symbol
			Scanner chopper = new Scanner(og);
				//If what was read in is one of the symbols, find a random
				//word to replace it.
			while(chopper.hasNext())
			{
				String nexty = chopper.next();

				if(new String(nexty).equals("#"))
				{
					story += " " + getRandomNoun();
				}

				else if(new String(nexty).equals("@"))
				{
					story += " " + getRandomVerb();
				}

				else if(new String(nexty).equals("&"))
				{
					story += " " + getRandomAdjective();
				}
				else
				{
					story += " " + nexty;
				}
			}


		}
		catch(Exception e)
		{
			System.out.println("Houston we have a problem!");
		}

	}

	public void loadNouns()
	{
		try
		{
			Scanner reader = new Scanner(new File("nouns.dat"));

			while(reader.hasNext())
			{
				nouns.add(reader.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("nouns.dat does not exist");
		}

	}

	public void loadVerbs()
	{
		try
		{
			Scanner reader = new Scanner(new File("verbs.dat"));

			while(reader.hasNext())
			{
				verbs.add(reader.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("verbs.dat does not exist");
		}
	}

	public void loadAdjectives()
	{
		try
		{
			Scanner reader = new Scanner(new File("adjectives.dat"));

			while(reader.hasNext())
			{
				adjectives.add(reader.next());
			}
		}
		catch(Exception e)
		{
			System.out.println("adjectives.dat does not exist");
		}
	}

	public String getRandomVerb()
	{
		String v = verbs.get((int)(Math.random()*verbs.size()));
		return "" + v;
	}

	public String getRandomNoun()
	{
		String n = nouns.get((int)(Math.random()*nouns.size()));
		return "" + n;
	}

	public String getRandomAdjective()
	{
		String a = adjectives.get((int)(Math.random()*adjectives.size()));
		return "" + a;
	}

	public String toString()
	{
		return "" + story;
	}
}