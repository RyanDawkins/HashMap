import java.util.Scanner;

public class Program4 extends Tokenizer
{

	private static int WORD_COUNT = 200159;
	private static String PATH_TO_WORDS = "/usr/share/dict/words";
	private static String NOT_FOUND = "***NOT FOUND***";

	private SetOfStrings words;
	private String[] keys, tokens;
	private int min, max, sum;

	public static void main(String[] args)
	{

		if(args.length == 0)
		{
			System.out.println("You must enter an argument designating a file to compare the dictionary to.");
			System.exit(0);
		}

		Program4 program = new Program4(PATH_TO_WORDS);
		program.runComparisons(args[0]);
		program.printComparisons();

	}

	public Program4(String fileName)
	{
		this.tokens = tokenize(fileName);
		this.words = new SetOfStrings(WORD_COUNT);
		this.min = Integer.MAX_VALUE;
		this.max = -1;
		this.sum = 0;
	}

	public void runComparisons(String keyFileName)
	{

		// This is the default tokens to be stored and adds the tokens
		// to the words HashMap
		this.keys = tokenize(keyFileName);
		for(int i = 0; i < tokens.length; i++)
		{
			words.add(tokens[i]);
		}

		for(int i = 0; i < keys.length; i++)
		{
			int contains = words.contains(keys[i]);
			System.out.print(keys[i]+" ");

			this.compare(contains);

			if(contains < 0)
			{
				System.out.println(""+(contains*-1)+" "+NOT_FOUND);
			}
			else
			{
				System.out.println(""+contains);
			}
		}
	}

	private void compare(int compare)
	{
		if(compare < 0)
			compare = -1*compare;
		this.sum += compare;

		if(compare < this.min)
			this.min = compare;
		else if(compare > this.max)
			this.max = compare;
	}

	public void printComparisons()
	{
		double average = (double)(this.sum / this.keys.length);

		System.out.print("\n");
		System.out.println("Size of set: "+this.words.count());
		System.out.println("Min comparisons: "+this.min);
		System.out.println("Max comparisons: "+this.max);
		System.out.println("Avg comparisons: "+average);
	}

}