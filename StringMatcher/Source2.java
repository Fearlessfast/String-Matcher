import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Source2 {

	
	
	public static void main(String[] args) throws IOException
	{
		NaiveStringMatcher2 x = new NaiveStringMatcher2();
		FiniteAutomatonMatcher2 y = new FiniteAutomatonMatcher2();
		int i=1;
	
		Scanner sc = new Scanner(System.in);
		
        System.out.println("Enter the string you want to search in text file: ");
       
        String word = sc.nextLine();
        
        BufferedReader br = new BufferedReader(new FileReader("automata.txt"));
        
		String line = null;
		
		long startTime = System.currentTimeMillis();
		
		while ((line = br.readLine()) != null)
		{			
		System.out.println("Line " + i + ": " + x.Search(line, word) + " occurrence" );	
		i++;
		}
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Time for Naive-String-Matching: " + totalTime + " ms");
		
		br.close();		
	    sc.close();
	  
	    
	}

	
	
	
	
}
