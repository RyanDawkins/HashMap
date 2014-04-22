import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Tokenizer
{
	
	public static String[] tokenize(String fileName)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		BufferedReader bf;
		try
		{
			 bf = new BufferedReader(new FileReader(fileName));
			 String line = "";
			 while((line = bf.readLine()) != null)
			 {
			 	// Breaks up the tokens for each line
			 	String[] t = line.toLowerCase().split(" ");
			 	for(int i = 0; i < t.length; i++){
			 		String token = t[i].replaceFirst("^[^a-zA-Z]+", "").replaceAll("[^a-zA-Z]+$", "").trim();
			 		if(token.length() > 0)
			 		{
			 			tokens.add(token);
			 		}
			 	}
			 }
			bf.close();
		}
		catch(IOException e) // Checking for file not found exception
		{
			e.printStackTrace();
		}

		// Returns null if no tokens exist
		if(tokens.size() > 0)
			return tokens.toArray(new String[tokens.size()]);
		return null;
	}
}