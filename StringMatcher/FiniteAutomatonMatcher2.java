
public class FiniteAutomatonMatcher2 {

	
  
  public int FASearch(String text,String pattern)
  {
	  int m = pattern.length();
	  int n = text.length();
	  int[][] TFT = new int [m+1][256];//a transition function table that uses given pattern's length plus one as number of rows
	  int occurrence = 0;              //and  number of all valid unicode characters as number of columns
	  char T[] = new char [n];
		
	  for(int k=0; k<n;k++)//putting all characters in the pattern into an array
	  {
		 T[k]=text.charAt(k); 		  
	  }
	   	  
      CTF(pattern,TFT);//compute transition function
	   
	  int j=0;
	  for (int i = 0; i < n; i++)//transfer the text to transition table
	  {
	       j = TFT[j][T[i]];
	       if (j == m)//automata enters accepting state
	       {
	         occurrence++;
	       }
	  }
	  
       
       return occurrence;
  }


  public void CTF(String pattern, int[][] TFT)
  {	  	 	 
	  int y=0;
	  int x;	  	  	 	
	  int m = pattern.length();
	  char P[] = new char [m];  
	  	  	  
	  for(int j=0; j<m;j++)//putting all characters in the text into an array
	  {
		 P[j]=pattern.charAt(j); 		  
	  }
	  	    
	  for (x =0; x < 256; x++)//update all variables in first row as zero
	  {
	    TFT[0][x] = 0;	      
	  } 
	  
	  TFT[0][P[0]] = 1; //make first variable in first row equal to 1
	  
	  for (int i = 0; i<m; i++)//write in the rows of the transition table
	  {
	        for (x = 0; x < 256; x++) //make a copy of the transition table
	        {
	          TFT[i][x] = TFT[y][x];	                        
	        }
	       	        
	        TFT[i][P[i]] = i + 1;	  
	        
	        if (i < m) //if i variable is smaller than length of the pattern prepare next row for update
	        {
	          y = TFT[y][P[i]];//update all variables in all rows
	        }
	  }	  	  	  
  }
 
 
}
